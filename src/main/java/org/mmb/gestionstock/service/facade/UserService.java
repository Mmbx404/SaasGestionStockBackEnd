package org.mmb.gestionstock.service.facade;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import org.mmb.gestionstock.bean.User;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);

    void deleteById(Long id);

    User save(User user);

    User update(User user);

    int delete(Long id);

    User findByUsernameWithRoles(String username);

    int deleteByUsername(String username);

    UserDetails loadUserByUsername(String username);

}
