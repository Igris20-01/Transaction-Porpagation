package uz.booker.transact.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.booker.transact.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

}
