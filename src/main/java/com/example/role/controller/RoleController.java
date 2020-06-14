package com.example.role.controller;

import com.example.role.model.Role;
import com.example.role.repository.RoleRepo;
import com.example.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepo roleRep;

    //Create a role
    @PostMapping("addRole")
    public String addNewRole(@RequestBody Role roles) {
        roleService.create(roles);
        return roles.getId();
    }

    //Get all roles
    @GetMapping("getRole")
    public List<Role> getAllRoles() {
        return roleService.getRoles();
    }

    //delete from id
    @DeleteMapping("deleteRole/{id}")
    public void deleteRole(@PathVariable("id") String id) {
        roleService.delete(id);
    }

    //update
    @PutMapping(value = "updateRole/{id}")
    public Role updateRole(@PathVariable String id, @RequestBody Role updatedRole) {
        return roleService.update(id, updatedRole);
    }

    //search by nic
    @GetMapping("/searchByNic")
    public Role searchRoleByNic(@RequestParam(name = "nic") String nic) {
        return roleService.getRoleByNic(nic);
    }

    //get by organization and type
    @GetMapping("/filterBy")
    public List<Role> searchRoleByOrgType(@RequestParam(name = "org") String org, @RequestParam(name = "type") String type) {
        List<Role> result = new ArrayList<>();
        result = roleService.findByOrgAndType(org, type);
        return result;
    }
}