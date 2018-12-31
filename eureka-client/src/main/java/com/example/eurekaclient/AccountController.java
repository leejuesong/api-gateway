package com.example.eurekaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private List<Account> accounts;
//    @Autowired
//    Logger logger = LoggerFactory.getLogger(AccountController.class);

    public AccountController() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(1, "test01", 18));
        accounts.add(new Account(2, "test02", 17));
        accounts.add(new Account(3, "test03", 22));
        accounts.add(new Account(4, "test04", 32));
        accounts.add(new Account(5, "test05", 28));
        accounts.add(new Account(6, "test06", 10));
    }

    /**
     * todo : remove this dummy data.
     */


    @GetMapping("/")
    public List<Account> getAccountList() {
        List<Account> result = new ArrayList<>();

        return result;
    }


}
