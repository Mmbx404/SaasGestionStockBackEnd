package org.mmb.gestionstock.service.facade;

import java.util.List;

import org.mmb.gestionstock.bean.Commande;
import org.mmb.gestionstock.ws.rest.provided.vo.CommandeVo;

public interface CommandeService {

    /**
     * find all Commande in database
     *
     * @return List<Commande> , If database is empty return  null.
     */
    List<Commande> findAll();

    /**
     * find Commande from database by reference (reference)
     *
     * @param reference - reference of Commande
     * @return the founded Commande , If no Commande were
     * found in database return  null.
     */
    Commande findByReference(String reference);

    /**
     * find Commande from database by id (id)
     *
     * @param id - id of Commande
     * @return the founded  Commande , If no Commande were
     * found in database return  null.
     */
    Commande findById(Long id);

    /**
     * delete Commande from database
     *
     * @param id - id of Commande to be deleted
     */
    int deleteById(Long id);

    List<Commande> findByUserUsername(String reference);

    int deleteByUserUsername(String reference);

    List<Commande> findByUserId(Long id);

    int deleteByUserId(Long id);

    /**
     * save Commande in database
     *
     * @param commande - Commande to be saved
     * @return the saved Commande, If the Commande can't be saved return null.
     */
    Commande save(Commande commande);

    /**
     * save list Commande in database
     *
     * @param commandes - list of Commande to be saved
     * @return the saved Commande list
     */
    List<Commande> save(List<Commande> commandes);

    /**
     * update Commande in database
     *
     * @param commande - Commande to be updated
     * @return the updated Commande, If the Commande can't be updated return null.
     */
    Commande update(Commande commande);

    /**
     * delete Commande from database
     *
     * @param commande - Commande to be deleted
     * @return 1 if Commande deleted successfully, If the Commande can't be deleted return negative int
     */
    int delete(Commande commande);

    /**
     * delete Commande from database by reference (reference)
     *
     * @param reference - reference of Commande to be deleted
     * @return 1 if Commande deleted successfully
     */
    int deleteByReference(String reference);

    /**
     * search for Commande in by some criteria
     *
     * @return the searhed list Commande
     */
    List<Commande> findByCriteria(CommandeVo commandeVo);
}
