package ua.knu.microservices.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ua.knu.microservices.basic.domain.User;
import ua.knu.microservices.basic.domain.UserRole;
import ua.knu.microservices.basic.repository.UserRepository;
import ua.knu.microservices.basic.repository.UserRoleRepository;
import ua.knu.microservices.basic.utils.UserUtility;

@Service
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public void create(User user) {

        User existing = userRepository.findByUsername(user.getUsername());
        Assert.isNull(existing, "user already exist: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setEnabled(true);

        user = userRepository.save(user);

        UserRole userRole = new UserRole(user.getId(), UserUtility.ROLE_USER);

        userRoleRepository.save(userRole);

        logger.info("new user has been created {}", user.getUsername());

    }
}
