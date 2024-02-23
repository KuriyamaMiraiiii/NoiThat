package online.noithat.be.controller;

import online.noithat.be.Entity.Quotation;
import online.noithat.be.dto.OrderRequestDTO;
import online.noithat.be.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/order")
    public ResponseEntity createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        Quotation createOrder = orderService.createNewOrder(orderRequestDTO);
        return ResponseEntity.ok(createOrder);
    }
}
