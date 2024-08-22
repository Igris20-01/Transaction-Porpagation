package uz.booker.transact.service;

import uz.booker.transact.dto.CustomerDto;
import uz.booker.transact.dto.PurchaseDto;

public interface TestService {

    void createCustomer(CustomerDto customerDto);

    void createPurchase(PurchaseDto purchaseDto);

    void writeOffMoney(PurchaseDto purchaseDto);

}
