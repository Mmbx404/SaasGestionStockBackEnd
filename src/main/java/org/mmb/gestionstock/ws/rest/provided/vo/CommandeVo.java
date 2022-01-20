package org.mmb.gestionstock.ws.rest.provided.vo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.mmb.gestionstock.bean.User;

import java.math.BigDecimal;

public class CommandeVo {

    private String id;
    private String reference;
    private String prixTotal;
    private String dateCreation;

    private User user;


    private String prixTotalMax;
    private String prixTotalMin;
    private String dateCreationMax;
    private String dateCreationMin;

    public CommandeVo() {
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

    public String getPrixTotal() {
        return this.prixTotal;
    }

    public void setPrixTotal(String prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }


    public String getPrixTotalMax() {
        return this.prixTotalMax;
    }

    public void setPrixTotalMax(String prixTotalMax) {
        this.prixTotalMax = prixTotalMax;
    }

    public String getPrixTotalMin() {
        return this.prixTotalMin;
    }

    public void setPrixTotalMin(String prixTotalMin) {
        this.prixTotalMin = prixTotalMin;
    }

    public String getDateCreationMax() {
        return this.dateCreationMax;
    }

    public void setDateCreationMax(String dateCreationMax) {
        this.dateCreationMax = dateCreationMax;
    }

    public String getDateCreationMin() {
        return this.dateCreationMin;
    }

    public void setDateCreationMin(String dateCreationMin) {
        this.dateCreationMin = dateCreationMin;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
