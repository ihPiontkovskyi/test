package ua.knu.microservices.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.knu.microservices.basic.domain.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
