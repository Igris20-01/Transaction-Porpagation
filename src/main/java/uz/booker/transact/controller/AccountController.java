package uz.booker.transact.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.booker.transact.dto.AccountDto;
import uz.booker.transact.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        List<AccountDto> account = accountService.getAllAccount();
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAccount(@RequestBody AccountDto accountDto) {
        accountService.updateAccount(accountDto);
        return ResponseEntity.ok("Account updated successfully");
    }



}
