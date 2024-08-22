package uz.booker.transact.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.booker.transact.dto.CustomerDto;
import uz.booker.transact.dto.PurchaseDto;
import uz.booker.transact.service.TestService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto) {
        testService.createCustomer(customerDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/order")
    public ResponseEntity<Void> makeOrder(@RequestBody PurchaseDto purchaseDto) {
        testService.createPurchase(purchaseDto);
        this.method();
        testService.writeOffMoney(purchaseDto);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    private void method(){
        Thread.sleep(10000);
    }

}
