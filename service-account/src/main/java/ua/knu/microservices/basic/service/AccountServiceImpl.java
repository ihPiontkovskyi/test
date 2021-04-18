package ua.knu.microservices.basic.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.knu.microservices.basic.client.AuthServiceClient;
import ua.knu.microservices.basic.domains.Account;
import ua.knu.microservices.basic.domains.User;
import ua.knu.microservices.basic.repositories.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AuthServiceClient authClient;

    @Override
    public Account findByUserName(String username) {
        Assert.hasLength(username);
        return repository.findByUsername(username);
    }

    @Override
    public Account findByEmail(String email) {
        Assert.hasLength(email);
        return repository.findByEmail(email);
    }

    @Override
    public Account create(User user) {
        Account existing = repository.findByUsername(user.getUsername());
        Assert.isNull(existing, "account already exist: " + user.getUsername());

        log.info("Trying to create user: " + user.getUsername() + " -> " + user.getPassword());

        Account account = new Account();
        account.setUsername(user.getUsername());
        account.setFirstName(user.getFirstName());
        account.setLastName(user.getLastName());
        account.setEmail(user.getEmail());
        account.setAddress(user.getAddress());
        account.setPhoneNumber(user.getPhoneNumber());

        account = repository.save(account);
        authClient.createUser(user);

        log.info("New account has been created:" + account.getEmail());

        return account;
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }
}
