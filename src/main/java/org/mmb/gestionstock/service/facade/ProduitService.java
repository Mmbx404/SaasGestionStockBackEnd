package org.mmb.gestionstock.service.facade;

import java.util.List;

import org.mmb.gestionstock.bean.Produit;
import org.mmb.gestionstock.ws.rest.provided.vo.ProduitVo;

public interface ProduitService {

    /**
     * find all Produit in database
     *
     * @return List<Produit> , If database is empty return  null.
     */
    List<Produit> findAll();

    /**
     * find Produit from database by reference (reference)
     *
     * @param reference - reference of Produit
     * @return the founded Produit , If no Produit were
     * found in database return  null.
     */
    Produit findByReference(String reference);

    /**
     * find Produit from database by id (id)
     *
     * @param id - id of Produit
     * @return the founded  Produit , If no Produit were
     * found in database return  null.
     */
    Produit findById(Long id);

    /**
     * delete Produit from database
     *
     * @param id - id of Produit to be deleted
     */
    int deleteById(Long id);

    List<Produit> findByUserUsername(String reference);

    int deleteByUserUsername(String reference);

    List<Produit> findByUserId(Long id);

    int deleteByUserId(Long id);

    /**
     * save Produit in database
     *
     * @param produit - Produit to be saved
     * @return the saved Produit, If the Produit can't be saved return null.
     */
    Produit save(Produit produit);

    /**
     * save list Produit in database
     *
     * @param produits - list of Produit to be saved
     * @return the saved Produit list
     */
    List<Produit> save(List<Produit> produits);

    /**
     * update Produit in database
     *
     * @param produit - Produit to be updated
     * @return the updated Produit, If the Produit can't be updated return null.
     */
    Produit update(Produit produit);

    /**
     * delete Produit from database
     *
     * @param produit - Produit to be deleted
     * @return 1 if Produit deleted successfully, If the Produit can't be deleted return negative int
     */
    int delete(Produit produit);

    /**
     * delete Produit from database by reference (reference)
     *
     * @param reference - reference of Produit to be deleted
     * @return 1 if Produit deleted successfully
     */
    int deleteByReference(String reference);

    /**
     * search for Produit in by some criteria
     *
     * @return the searhed list Produit
     */
    List<Produit> findByCriteria(ProduitVo produitVo);
}
