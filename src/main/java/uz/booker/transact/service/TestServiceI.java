package uz.booker.transact.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uz.booker.transact.dto.CustomerDto;
import uz.booker.transact.dto.PurchaseDto;
import uz.booker.transact.entity.Customer;
import uz.booker.transact.entity.Purchase;
import uz.booker.transact.repo.CustomerRepo;
import uz.booker.transact.repo.PurchaseRepo;

@Service
@RequiredArgsConstructor
public class TestServiceI implements TestService {

    private final CustomerRepo customerRepo;

    private final PurchaseRepo purchaseRepo;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFio(customerDto.getFio());
        customer.setMoney(customerDto.getMoney());
        this.saveCustomer(customer);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void createPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        purchase.setCustomerId(purchaseDto.getCustomerId());
        purchase.setPrice(purchaseDto.getPrice());
        this.savePurchase(purchase);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void writeOffMoney(PurchaseDto purchaseDto) {
        Customer customer = customerRepo.findById(purchaseDto.getCustomerId())
                .orElseThrow(EntityNotFoundException::new);
        Double newMoney = customer.getMoney() - purchaseDto.getPrice();
        customer.setMoney(newMoney);
        this.saveCustomer(customer);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePurchase(Purchase purchase) {
        purchaseRepo.save(purchase);
    }

}

