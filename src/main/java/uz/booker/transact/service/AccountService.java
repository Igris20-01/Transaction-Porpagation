package uz.booker.transact.service;

import uz.booker.transact.dto.AccountDto;

import java.util.List;

public interface AccountService {

    void createAccount(AccountDto accountDto);

    void updateAccount(AccountDto accountDto);

    List<AccountDto> getAllAccount();
}
