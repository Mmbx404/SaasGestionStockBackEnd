package org.mmb.gestionstock.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.mmb.gestionstock.bean.User;
import org.mmb.gestionstock.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import org.mmb.gestionstock.bean.Produit;
import org.mmb.gestionstock.bean.Compte;
import org.mmb.gestionstock.dao.ProduitDao;
import org.mmb.gestionstock.service.facade.ProduitService;
import org.mmb.gestionstock.service.facade.CompteService;

import org.mmb.gestionstock.ws.rest.provided.vo.ProduitVo;
import org.mmb.gestionstock.service.util.*;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitDao produitDao;

    @Autowired
    private CompteService compteService;

    @Autowired
    private UserService userService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    @Override
    public List<Produit> findByUserUsername(String reference) {
        return produitDao.findByUserUsername(reference);
    }

    @Override
    @Transactional
    public int deleteByUserUsername(String reference) {
        return produitDao.deleteByUserUsername(reference);
    }

    @Override
    public List<Produit> findByUserId(Long id) {
        return produitDao.findByUserId(id);
    }

    @Override
    @Transactional
    public int deleteByUserId(Long id) {
        return produitDao.deleteByUserId(id);
    }

    @Override
    public Produit findByReference(String reference) {
        if (reference == null) return null;
        return produitDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return produitDao.deleteByReference(reference);
    }

    @Override
    public Produit findById(Long id) {
        if (id == null) return null;
        return produitDao.getOne(id);
    }

    @Transactional
    public int deleteById(Long id) {
        if (produitDao.findById(id) == null) return 0;
        produitDao.deleteById(id);
        return 1;
    }

    @Override
    public Produit save(Produit produit) {
        Produit foundedProduit = findByReference(produit.getReference());
        if (foundedProduit != null) return null;

        if (produit.getUser() != null) {
            User user = userService.findByUsername(produit.getUser().getUsername());
            if (user == null)
                produit.setUser(userService.save(produit.getUser()));
            else produit.setUser(user);
        }

        Produit savedProduit = produitDao.save(produit);
        return savedProduit;
    }

    @Override
    public List<Produit> save(List<Produit> produits) {
        List<Produit> list = new ArrayList<Produit>();
        for (Produit produit : produits) {
            list.add(save(produit));
        }
        return list;
    }


    @Override
    public Produit update(Produit produit) {
        Produit foundedProduit = findById(produit.getId());
        if (foundedProduit == null) return null;
        return produitDao.save(produit);
    }

    @Override
    @Transactional
    public int delete(Produit produit) {
        if (produit.getReference() == null) return -1;

        Produit foundedProduit = findByReference(produit.getReference());
        if (foundedProduit == null) return -1;
        produitDao.delete(foundedProduit);
        return 1;
    }


    public List<Produit> findByCriteria(ProduitVo produitVo) {
        String query = "SELECT o FROM Produit o where 1=1 ";
        query += SearchUtil.addConstraint("o", "id", "=", produitVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", produitVo.getReference());
        query += SearchUtil.addConstraint("o", "prix", "=", produitVo.getPrix());
        query += SearchUtil.addConstraint("o", "qteStock", "=", produitVo.getQteStock());
        query += SearchUtil.addConstraintDate("o", "dateAjout", "=", produitVo.getDateAjout());
        query += SearchUtil.addConstraint("o", "prixUnitaire", "=", produitVo.getPrixUnitaire());
        query += SearchUtil.addConstraintMinMax("o", "prix", produitVo.getPrixMin(), produitVo.getPrixMax());
        query += SearchUtil.addConstraintMinMax("o", "qteStock", produitVo.getQteStockMin(), produitVo.getQteStockMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateAjout", produitVo.getDateAjoutMin(), produitVo.getDateAjoutMax());
        query += SearchUtil.addConstraintMinMax("o", "prixUnitaire", produitVo.getPrixUnitaireMin(), produitVo.getPrixUnitaireMax());
        if (produitVo.getUser() != null) {
            query += SearchUtil.addConstraint("o", "user.id", "=", produitVo.getUser().getId());
            query += SearchUtil.addConstraint("o", "user.username", "LIKE", produitVo.getUser().getUsername());
        }

        return entityManager.createQuery(query).getResultList();
    }

}
