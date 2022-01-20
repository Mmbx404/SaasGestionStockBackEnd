package org.mmb.gestionstock.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import org.mmb.gestionstock.bean.Compte;
import org.mmb.gestionstock.dao.CompteDao;
import org.mmb.gestionstock.service.facade.CompteService;

import org.mmb.gestionstock.ws.rest.provided.vo.CompteVo;
import org.mmb.gestionstock.service.util.*;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteDao compteDao;


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Compte> findAll() {
        return compteDao.findAll();
    }

    @Override
    public Compte findByReference(String reference) {
        if (reference == null) return null;
        return compteDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return compteDao.deleteByReference(reference);
    }

    @Override
    public Compte findById(Long id) {
        if (id == null) return null;
        return compteDao.getOne(id);
    }

    @Transactional
    public int deleteById(Long id) {
        if (compteDao.findById(id) == null) return 0;
        compteDao.deleteById(id);
        return 1;
    }

    @Override
    public Compte save(Compte compte) {
        Compte foundedCompte = findByReference(compte.getReference());
        if (foundedCompte != null) return null;

        Compte savedCompte = compteDao.save(compte);
        return savedCompte;
    }

    @Override
    public List<Compte> save(List<Compte> comptes) {
        List<Compte> list = new ArrayList<Compte>();
        for (Compte compte : comptes) {
            list.add(save(compte));
        }
        return list;
    }


    @Override
    public Compte update(Compte compte) {
        Compte foundedCompte = findById(compte.getId());
        if (foundedCompte == null) return null;
        return compteDao.save(compte);
    }

    @Override
    @Transactional
    public int delete(Compte compte) {
        if (compte.getReference() == null) return -1;

        Compte foundedCompte = findByReference(compte.getReference());
        if (foundedCompte == null) return -1;
        compteDao.delete(foundedCompte);
        return 1;
    }


    public List<Compte> findByCriteria(CompteVo compteVo) {
        String query = "SELECT o FROM Compte o where 1=1 ";
        query += SearchUtil.addConstraint("o", "id", "=", compteVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", compteVo.getReference());
        query += SearchUtil.addConstraint("o", "email", "LIKE", compteVo.getEmail());
        query += SearchUtil.addConstraint("o", "mdp", "LIKE", compteVo.getMdp());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", compteVo.getDateCreation());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", compteVo.getDateCreationMin(), compteVo.getDateCreationMax());
        return entityManager.createQuery(query).getResultList();
    }

}
