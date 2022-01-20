package org.mmb.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.mmb.gestionstock.bean.Compte;


@Repository
public interface CompteDao extends JpaRepository<Compte, Long> {

    Compte findByReference(String reference);

    int deleteByReference(String reference);


}
