package com.example.role.repository;

import com.example.role.model.Role;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepo extends CrudRepository<Role, Integer> {
    Optional<Role> findByNic(String nic);

    @Query(fields="{fName : 1, id : 0, lName : 1, nic : 1}")
    List<Role> findByOrganizationAndType(String organization, String type);
}

