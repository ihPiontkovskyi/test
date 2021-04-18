package ua.knu.microservices.basic.service;


import ua.knu.microservices.basic.domains.Account;
import ua.knu.microservices.basic.domains.User;

import java.util.List;

public interface AccountService {

    Account findByUserName(String username);

    Account findByEmail(String email);

    Account create(User user);

    List<Account> findAll();
}
