package org.mmb.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.mmb.gestionstock.bean.Commande;


@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {

    Commande findByReference(String reference);

    int deleteByReference(String reference);

    List<Commande> findByUserUsername(String reference);

    int deleteByUserUsername(String reference);

    List<Commande> findByUserId(Long id);

    int deleteByUserId(Long id);

}
