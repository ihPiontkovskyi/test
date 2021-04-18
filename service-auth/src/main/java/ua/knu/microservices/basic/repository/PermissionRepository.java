package ua.knu.microservices.basic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.knu.microservices.basic.domain.Permission;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {
    Permission findByName(String name);
}
