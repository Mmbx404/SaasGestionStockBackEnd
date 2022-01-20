package org.mmb.gestionstock.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.mmb.gestionstock.bean.User;
import org.mmb.gestionstock.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import org.mmb.gestionstock.bean.Commande;
import org.mmb.gestionstock.bean.Compte;
import org.mmb.gestionstock.dao.CommandeDao;
import org.mmb.gestionstock.service.facade.CommandeService;
import org.mmb.gestionstock.service.facade.CompteService;

import org.mmb.gestionstock.ws.rest.provided.vo.CommandeVo;
import org.mmb.gestionstock.service.util.*;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;

    @Autowired
    private CompteService compteService;

    @Autowired
    private UserService userService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public List<Commande> findByUserUsername(String reference) {
        return commandeDao.findByUserUsername(reference);
    }

    @Override
    @Transactional
    public int deleteByUserUsername(String reference) {
        return commandeDao.deleteByUserUsername(reference);
    }

    @Override
    public List<Commande> findByUserId(Long id) {
        return commandeDao.findByUserId(id);
    }

    @Override
    @Transactional
    public int deleteByUserId(Long id) {
        return commandeDao.deleteByUserId(id);
    }

    @Override
    public Commande findByReference(String reference) {
        if (reference == null) return null;
        return commandeDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

    @Override
    public Commande findById(Long id) {
        if (id == null) return null;
        return commandeDao.getOne(id);
    }

    @Transactional
    public int deleteById(Long id) {
        if (commandeDao.findById(id) == null) return 0;
        commandeDao.deleteById(id);
        return 1;
    }

    @Override
    public Commande save(Commande commande) {
        Commande foundedCommande = findByReference(commande.getReference());
        if (foundedCommande != null) return null;

        if (commande.getUser() != null) {
            User user = userService.findByUsername(commande.getUser().getUsername());
            if (user == null)
                commande.setUser(userService.save(commande.getUser()));
            else commande.setUser(user);
        }

        Commande savedCommande = commandeDao.save(commande);
        return savedCommande;
    }

    @Override
    public List<Commande> save(List<Commande> commandes) {
        List<Commande> list = new ArrayList<Commande>();
        for (Commande commande : commandes) {
            list.add(save(commande));
        }
        return list;
    }


    @Override
    public Commande update(Commande commande) {
        Commande foundedCommande = findById(commande.getId());
        if (foundedCommande == null) return null;
        return commandeDao.save(commande);
    }

    @Override
    @Transactional
    public int delete(Commande commande) {
        if (commande.getReference() == null) return -1;

        Commande foundedCommande = findByReference(commande.getReference());
        if (foundedCommande == null) return -1;
        commandeDao.delete(foundedCommande);
        return 1;
    }


    public List<Commande> findByCriteria(CommandeVo commandeVo) {
        String query = "SELECT o FROM Commande o where 1=1 ";
        query += SearchUtil.addConstraint("o", "id", "=", commandeVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", commandeVo.getReference());
        query += SearchUtil.addConstraint("o", "prixTotal", "=", commandeVo.getPrixTotal());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", commandeVo.getDateCreation());
        query += SearchUtil.addConstraintMinMax("o", "prixTotal", commandeVo.getPrixTotalMin(), commandeVo.getPrixTotalMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", commandeVo.getDateCreationMin(), commandeVo.getDateCreationMax());
        if (commandeVo.getUser() != null) {
            query += SearchUtil.addConstraint("o", "user.id", "=", commandeVo.getUser().getId());
            query += SearchUtil.addConstraint("o", "user.username", "LIKE", commandeVo.getUser().getUsername());
        }

        return entityManager.createQuery(query).getResultList();
    }

}
