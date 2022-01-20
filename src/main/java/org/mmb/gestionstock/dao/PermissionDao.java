package org.mmb.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.mmb.gestionstock.bean.Permission;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}