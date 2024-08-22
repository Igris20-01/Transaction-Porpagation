package uz.booker.transact.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.booker.transact.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
