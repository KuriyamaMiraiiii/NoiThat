package online.noithat.be.service;

import online.noithat.be.Entity.Account;
import online.noithat.be.Entity.Quotation;
import online.noithat.be.Entity.QuotationDetail;
import online.noithat.be.Entity.Product;
import online.noithat.be.dto.OrderRequestDTO;
import online.noithat.be.repository.AccountRepository;
import online.noithat.be.repository.OrderRepository;
import online.noithat.be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AccountRepository accountRepository;
    public Quotation createNewOrder(OrderRequestDTO orderRequestDTO){
        Account account = accountRepository.findAccountById(orderRequestDTO.getAccountId());
        Quotation order = new Quotation();
        ArrayList<QuotationDetail> quotationDetails = new ArrayList<>();
        for(Long productId : orderRequestDTO.getProductGetId()){
            Product product = productRepository.findProductByProductId(productId);
            QuotationDetail quotationDetail = new QuotationDetail();
            quotationDetail.setProduct(product);
            quotationDetail.setOrder(order);
            quotationDetails.add(quotationDetail);
        }
        order.setQuotationDetails(quotationDetails);
        order.setAccount(account);
        order.setCreated(new Date());

        return orderRepository.save(order);
    }
}
