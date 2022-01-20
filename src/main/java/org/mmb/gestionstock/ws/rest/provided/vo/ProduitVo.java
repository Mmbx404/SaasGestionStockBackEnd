package org.mmb.gestionstock.ws.rest.provided.vo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.mmb.gestionstock.bean.User;

import java.math.BigDecimal;

public class ProduitVo {

    private String id;
    private String reference;
    private String prix;
    private String qteStock;
    private String dateAjout;
    private String prixUnitaire;

    private User user;


    private String prixMax;
    private String prixMin;
    private String qteStockMax;
    private String qteStockMin;
    private String dateAjoutMax;
    private String dateAjoutMin;
    private String prixUnitaireMax;
    private String prixUnitaireMin;

    public ProduitVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPrix() {
        return this.prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQteStock() {
        return this.qteStock;
    }

    public void setQteStock(String qteStock) {
        this.qteStock = qteStock;
    }

    public String getDateAjout() {
        return this.dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getPrixUnitaire() {
        return this.prixUnitaire;
    }

    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }


    public String getPrixMax() {
        return this.prixMax;
    }

    public void setPrixMax(String prixMax) {
        this.prixMax = prixMax;
    }

    public String getPrixMin() {
        return this.prixMin;
    }

    public void setPrixMin(String prixMin) {
        this.prixMin = prixMin;
    }

    public String getQteStockMax() {
        return this.qteStockMax;
    }

    public void setQteStockMax(String qteStockMax) {
        this.qteStockMax = qteStockMax;
    }

    public String getQteStockMin() {
        return this.qteStockMin;
    }

    public void setQteStockMin(String qteStockMin) {
        this.qteStockMin = qteStockMin;
    }

    public String getDateAjoutMax() {
        return this.dateAjoutMax;
    }

    public void setDateAjoutMax(String dateAjoutMax) {
        this.dateAjoutMax = dateAjoutMax;
    }

    public String getDateAjoutMin() {
        return this.dateAjoutMin;
    }

    public void setDateAjoutMin(String dateAjoutMin) {
        this.dateAjoutMin = dateAjoutMin;
    }

    public String getPrixUnitaireMax() {
        return this.prixUnitaireMax;
    }

    public void setPrixUnitaireMax(String prixUnitaireMax) {
        this.prixUnitaireMax = prixUnitaireMax;
    }

    public String getPrixUnitaireMin() {
        return this.prixUnitaireMin;
    }

    public void setPrixUnitaireMin(String prixUnitaireMin) {
        this.prixUnitaireMin = prixUnitaireMin;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
