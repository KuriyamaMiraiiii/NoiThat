package online.noithat.be.dto;

import java.util.List;

public class OrderRequestDTO {
    List<Long> productGetId;
    Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public List<Long> getProductGetId() {
        return productGetId;
    }
}
