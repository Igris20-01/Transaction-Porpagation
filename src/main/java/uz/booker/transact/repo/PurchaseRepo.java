package uz.booker.transact.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.booker.transact.entity.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
}
