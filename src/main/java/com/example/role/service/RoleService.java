package com.example.role.service;


import com.example.role.exception.ResourceNotFoundException;
import com.example.role.model.Role;
import com.example.role.repository.RoleRepo;
import com.example.role.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepository;
    @Autowired
    UserRepo userRepository;

    //get all roles
    public List<Role> getRoles() {
        List<Role> role = new ArrayList<Role>();
        roleRepository.findAll().forEach(role1 -> role.add(role1));
        return role;
    }

    //get role by id
    public Role getRoleByNic(String nic) {
        return roleRepository.findByNic(nic).orElseThrow(() -> new ResourceNotFoundException());
    }

    //filter role by organization and type
    public List<Role> findByOrgAndType(String organization, String type) {
        return roleRepository.findByOrganizationAndType(organization, type);
    }

    //create new role
    public void create(Role role) {
        roleRepository.save(role);
    }

    //delete
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    //updating a record
    public Role update(String id, Role role) {
        role.setId(id);
        roleRepository.save(role);
        return role;
    }
}