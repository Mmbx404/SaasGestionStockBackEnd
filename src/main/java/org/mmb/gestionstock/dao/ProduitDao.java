package org.mmb.gestionstock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.mmb.gestionstock.bean.Produit;


@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {

    Produit findByReference(String reference);

    int deleteByReference(String reference);

    List<Produit> findByUserUsername(String reference);

    int deleteByUserUsername(String reference);

    List<Produit> findByUserId(Long id);

    int deleteByUserId(Long id);

}
