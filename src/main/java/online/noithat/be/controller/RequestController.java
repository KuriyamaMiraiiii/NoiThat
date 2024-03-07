package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Product;
import online.noithat.be.Entity.ProductDetail;
import online.noithat.be.Entity.Request;
import online.noithat.be.dto.response.CreateProductDetailResponseDTO;
import online.noithat.be.dto.response.CreateRequestDTO;
import online.noithat.be.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class RequestController {

    @Autowired
    RequestService requestService;
    @GetMapping("/request")
    public ResponseEntity getAllRequest() {
        List<Request> requests = requestService.getAllRequest();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/request/{id}")
    public ResponseEntity getRequestById(@PathVariable long id) {
        Request request = requestService.getRequestById(id);
        return ResponseEntity.ok(request);
    }

    @PostMapping("/request")
    public ResponseEntity createRequest(@RequestBody CreateRequestDTO createRequestDTO) {
        Request request = requestService.createRequest(createRequestDTO);
        return ResponseEntity.ok(request);
    }

    @PutMapping("/request/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody CreateRequestDTO createRequestDTO) {

        return ResponseEntity.ok(requestService.update(createRequestDTO, id));
    }

    @DeleteMapping("/request/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(requestService.delete(id));
    }

    @PatchMapping("/receive-request/{requestId}")
    public ResponseEntity receiveRequest(@PathVariable long requestId) {
        Request request = requestService.receiveRequest(requestId);
        return ResponseEntity.ok(request);
    }

    @GetMapping("/request-customer")
    public ResponseEntity getRequestByaccountId() {
        List<Request> requests = requestService.getRequestByAccountId();
        return ResponseEntity.ok(requests);
    }
}
