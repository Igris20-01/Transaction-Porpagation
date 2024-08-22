package uz.booker.transact.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.booker.transact.dto.AccountDto;
import uz.booker.transact.entity.Account;
import uz.booker.transact.repo.AccountRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceI implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceI.class);

    private final AccountRepo accountRepo;

    @Override
    @Transactional
    public void createAccount(AccountDto accountDto) {
        LOGGER.info("TX IN >>>>>>>");
        Account account = new Account();
        account.setBalance(accountDto.getBalance());
        accountRepo.save(account);
        LOGGER.info("TX ON <<<<<<<<");
    }


    @Override
    @Transactional
    public void updateAccount(AccountDto accountDto) {
        LOGGER.info("TX IN >>>>>");
        Account account = accountRepo.findById(accountDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        account.setBalance(accountDto.getBalance());
        accountRepo.save(account);
        LOGGER.info("TX ON <<<<<");
    }


    @Override
    @Transactional(readOnly = true)
    public List<AccountDto> getAllAccount(){
        LOGGER.info("TX IN >>>>>>");
        List<Account> accounts = accountRepo.findAll();
        LOGGER.info("TX IN <<<<<<");
        return accounts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    private AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }




}
