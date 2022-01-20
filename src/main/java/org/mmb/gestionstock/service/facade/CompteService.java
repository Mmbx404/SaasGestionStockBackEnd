package org.mmb.gestionstock.service.facade;

import java.util.List;

import org.mmb.gestionstock.bean.Compte;
import org.mmb.gestionstock.ws.rest.provided.vo.CompteVo;

public interface CompteService {

    /**
     * find all Compte in database
     *
     * @return List<Compte> , If database is empty return  null.
     */
    List<Compte> findAll();

    /**
     * find Compte from database by reference (reference)
     *
     * @param reference - reference of Compte
     * @return the founded Compte , If no Compte were
     * found in database return  null.
     */
    Compte findByReference(String reference);

    /**
     * find Compte from database by id (id)
     *
     * @param id - id of Compte
     * @return the founded  Compte , If no Compte were
     * found in database return  null.
     */
    Compte findById(Long id);

    /**
     * delete Compte from database
     *
     * @param id - id of Compte to be deleted
     */
    int deleteById(Long id);


    /**
     * save Compte in database
     *
     * @param compte - Compte to be saved
     * @return the saved Compte, If the Compte can't be saved return null.
     */
    Compte save(Compte compte);

    /**
     * save list Compte in database
     *
     * @param comptes - list of Compte to be saved
     * @return the saved Compte list
     */
    List<Compte> save(List<Compte> comptes);

    /**
     * update Compte in database
     *
     * @param compte - Compte to be updated
     * @return the updated Compte, If the Compte can't be updated return null.
     */
    Compte update(Compte compte);

    /**
     * delete Compte from database
     *
     * @param compte - Compte to be deleted
     * @return 1 if Compte deleted successfully, If the Compte can't be deleted return negative int
     */
    int delete(Compte compte);

    /**
     * delete Compte from database by reference (reference)
     *
     * @param reference - reference of Compte to be deleted
     * @return 1 if Compte deleted successfully
     */
    int deleteByReference(String reference);

    /**
     * search for Compte in by some criteria
     *
     * @return the searhed list Compte
     */
    List<Compte> findByCriteria(CompteVo compteVo);
}
