package org.mmb.gestionstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import org.mmb.gestionstock.common.AuthoritiesConstants;
import org.mmb.gestionstock.bean.User;
import org.mmb.gestionstock.bean.Permission;
import org.mmb.gestionstock.bean.Role;
import org.mmb.gestionstock.service.facade.UserService;
import org.mmb.gestionstock.service.facade.RoleService;


@SpringBootApplication
public class GestionstockApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(GestionstockApplication.class, args);
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
        return (args) -> {
            Role role;
            List<Permission> permissions;
            List<Role> roles = new ArrayList<>();

            // Role ADMINISTRATEUR
            role = new Role();
            role.setAuthority("ROLE_ADMINISTRATEUR");
            permissions = new ArrayList<>();
            role.setPermissions(permissions);
            roles.add(role);

            roles.forEach(roleService::save);

            Role adminRole = new Role();
            adminRole.setAuthority(AuthoritiesConstants.super_admin);
            User SuperAdmin = new User();
            SuperAdmin.setFirstName("Super");
            SuperAdmin.setLastName("Admin");
            SuperAdmin.setEmail("admin@admin.com");
            SuperAdmin.setUsername("admin");
            SuperAdmin.setPassword("admin");
            SuperAdmin.setRoles(Arrays.asList(adminRole));
            userService.save(SuperAdmin);
        };
    }

}
