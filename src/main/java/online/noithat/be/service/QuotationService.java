package online.noithat.be.service;

import jakarta.servlet.http.HttpServletResponse;
import online.noithat.be.Entity.*;
import online.noithat.be.dto.request.QuotationAcceptDTO;
import online.noithat.be.dto.request.QuotationDetailDTO;
import online.noithat.be.dto.request.QuotationRejectDTO;
import online.noithat.be.dto.request.QuotationRequestDTO;
import online.noithat.be.dto.response.CreateRequestDTO;
import online.noithat.be.enums.QuotationType;
import online.noithat.be.enums.RequestType;
import online.noithat.be.repository.ProductDetailRepository;
import online.noithat.be.repository.ProductRepository;
import online.noithat.be.repository.QuotationRepository;
import online.noithat.be.repository.RequestRepository;
import online.noithat.be.utils.AccountUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuotationService {
    @Autowired
    QuotationRepository quotationRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AccountUtils accountUtils;

    public List<Quotation> getAllQuotation() {
        List<Quotation> quotations = quotationRepository.findQuotationsByIdNotNull();
        return quotations;
    }

    public Quotation getQuotationById(long id) {
        Quotation quotation = quotationRepository.findQuotationById(id);
        return quotation;
    }
//    public ProductDetail getProductDetailById(long id){
//        ProductDetail productDetail = productDetailRepository.findProductDetailById(id);
//        return productDetail;
//    }

    public Quotation createQuotation(QuotationRequestDTO quotationRequestDTO) {
        Request request = requestRepository.findRequestById(quotationRequestDTO.getRequestId());
        Quotation quotation = new Quotation();
        quotation.setRequest(request);
        quotation.setType(quotationRequestDTO.getType());
        quotation.setCreated(new Date());
        List<QuotationDetail> quotationDetails = new ArrayList<>();
        for (QuotationDetailDTO quotationDetailDTO : quotationRequestDTO.getQuotationDetailDTOS()) {
            QuotationDetail quotationDetail = new QuotationDetail();
            ProductDetail productDetail = productDetailRepository.findProductDetailById(quotationDetailDTO.getProductDetailId());
            quotationDetail.setProductDetail(productDetail);
            quotationDetail.setQuotation(quotation);
            quotationDetail.setQuantity(quotationDetailDTO.getQuantity());
            quotationDetail.setHeight(quotationDetail.getHeight());
            quotationDetail.setLength(quotationDetailDTO.getLength());
            quotationDetail.setWidth(quotationDetailDTO.getWidth());
            quotationDetail.setPricePerUnit(quotationDetailDTO.getPricePerUnit());
            quotationDetail.setTotal(quotationDetailDTO.getTotal());
            quotationDetail.setUnit(quotationDetailDTO.getUnit());
            if (quotationDetailDTO.getProductId() != 0) {
                Product product = productRepository.findProductById(quotationDetailDTO.getProductId());
                product.getQuotationDetails().add(quotationDetail);
                quotationDetail.setProduct(product);
            }

            quotationDetails.add(quotationDetail);
        }

        quotation.setQuotationDetails(quotationDetails);

        return quotationRepository.save(quotation);
    }

    public Quotation updateQuotation(long id, QuotationRequestDTO quotationRequestDTO) {

        Request request = requestRepository.findRequestById(quotationRequestDTO.getRequestId());
        Quotation quotation = quotationRepository.findQuotationById(id);
        quotation.setRequest(request);
        quotation.setType(quotationRequestDTO.getType());
        return quotationRepository.save(quotation);
    }

    public List<Quotation> getQuotationByRequestId(long id) {
        Request request = requestRepository.findRequestById(id);
        return request.getQuotations();
    }

    public Quotation rejectQuotation(QuotationRejectDTO quotationRejectDTO) {
        Quotation quotation = quotationRepository.findQuotationById(quotationRejectDTO.getQuotationId());
        quotation.setType(QuotationType.REJECTED);
        quotation.setReasonReject(quotation.getReasonReject());
        return quotationRepository.save(quotation);
    }

    public Quotation acceptQuotation(QuotationAcceptDTO quotationAcceptDTO) {
        Quotation quotation = quotationRepository.findQuotationById(quotationAcceptDTO.getQuotationId());

        for (Quotation q : quotation.getRequest().getQuotations()) {
            q.setType(QuotationType.REJECTED);
            quotationRepository.save(q);
        }
        quotation.setType(QuotationType.ACCEPTED);
        return quotationRepository.save(quotation);
    }

    public void exportToExcel(long quotationId, HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Quotation");
        Quotation quotation = quotationRepository.findQuotationById(quotationId);
        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Product Name");
        headerRow.createCell(1).setCellValue("Length");
        headerRow.createCell(2).setCellValue("Width");
        headerRow.createCell(3).setCellValue("Height");
        headerRow.createCell(4).setCellValue("Unit");
        headerRow.createCell(5).setCellValue("Weight");
        headerRow.createCell(6).setCellValue("Quantity");
        headerRow.createCell(7).setCellValue("Price Per Unit");
        headerRow.createCell(8).setCellValue("Price");
        // Add more columns if necessary

        // Create data rows
        int rowNum = 1;
        for (QuotationDetail quotationDetail : quotation.getQuotationDetails()) {
            Row row = sheet.createRow(rowNum++);
            float totalPrice = quotationDetail.getLength() * quotationDetail.getWidth() * quotationDetail.getPricePerUnit() * quotationDetail.getQuantity();
            if (quotationDetail.getProduct() != null)
                row.createCell(0).setCellValue(quotationDetail.getProduct().getName());
            row.createCell(1).setCellValue(quotationDetail.getLength());
            row.createCell(2).setCellValue(quotationDetail.getWidth());
            row.createCell(3).setCellValue(quotationDetail.getHeight());
            if (quotationDetail.getUnit() != null) row.createCell(4).setCellValue(quotationDetail.getUnit().toString());
            row.createCell(5).setCellValue(quotationDetail.getLength() * quotationDetail.getWidth());
            row.createCell(6).setCellValue(quotationDetail.getQuantity());
            row.createCell(7).setCellValue(formatAmount((int) quotationDetail.getPricePerUnit()));
            row.createCell(8).setCellValue(formatAmount((int) totalPrice));
        }

        // Set response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=data.xlsx");

        // Write to output stream
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    public static String formatAmount(int amount) {
        StringBuilder formattedAmount = new StringBuilder();
        String amountStr = String.valueOf(amount);

        int len = amountStr.length();
        int commaCount = (len - 1) / 3;

        for (int i = 0; i < len; i++) {
            formattedAmount.append(amountStr.charAt(i));
            int remainingDigits = len - i - 1;
            if (remainingDigits > 0 && remainingDigits % 3 == 0) {
                formattedAmount.append(".");
            }
        }

        formattedAmount.append(" VND");
        return formattedAmount.toString();
    }

    public Quotation buyAvailable(QuotationRequestDTO quotationRequestDTO) {
        Request request = new Request();
        request.setType(RequestType.QUOTATION_AVAILABLE);
        request.setAccount(accountUtils.getCurrentAccount());
        request = requestRepository.save(request);
        Quotation quotation = new Quotation();
        quotation.setRequest(request);
        quotation.setType(QuotationType.ACCEPTED);
        quotation.setCreated(new Date());
        List<QuotationDetail> quotationDetails = new ArrayList<>();
        for (QuotationDetailDTO quotationDetailDTO : quotationRequestDTO.getQuotationDetailDTOS()) {
            QuotationDetail quotationDetail = new QuotationDetail();
            ProductDetail productDetail = productDetailRepository.findProductDetailById(quotationDetailDTO.getProductDetailId());
            quotationDetail.setProductDetail(productDetail);
            quotationDetail.setTotal(productDetail.getPrice());
            quotationDetail.setQuotation(quotation);
            quotationDetails.add(quotationDetail);
        }

        quotation.setQuotationDetails(quotationDetails);

        return quotationRepository.save(quotation);
    }

    public List<Request> getAvailableHistory() {
        Account account = accountUtils.getCurrentAccount();
        return requestRepository.findRequestsByAccountAndType(account, RequestType.QUOTATION_AVAILABLE);
    }

}
