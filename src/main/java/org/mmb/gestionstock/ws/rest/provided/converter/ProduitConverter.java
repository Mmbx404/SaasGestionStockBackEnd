package org.mmb.gestionstock.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mmb.gestionstock.service.util.*;


import org.mmb.gestionstock.bean.Produit;
import org.mmb.gestionstock.ws.rest.provided.vo.ProduitVo;

@Component
public class ProduitConverter extends AbstractConverter<Produit, ProduitVo> {

    @Autowired
    private CompteConverter compteConverter;
    private Boolean compte;

    public ProduitConverter() {
        init(true);
    }

    @Override
    public Produit toItem(ProduitVo vo) {
        if (vo == null) {
            return null;
        } else {
            Produit item = new Produit();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getPrix()))
                item.setPrix(NumberUtil.toBigDecimal(vo.getPrix()));
            if (StringUtil.isNotEmpty(vo.getQteStock()))
                item.setQteStock(NumberUtil.toInt(vo.getQteStock()));
            if (StringUtil.isNotEmpty(vo.getDateAjout()))
                item.setDateAjout(DateUtil.parse(vo.getDateAjout()));
            if (StringUtil.isNotEmpty(vo.getPrixUnitaire()))
                item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
            if (vo.getUser() != null && this.compte)
                item.setUser(vo.getUser());


            return item;
        }
    }

    @Override
    public ProduitVo toVo(Produit item) {
        if (item == null) {
            return null;
        } else {
            ProduitVo vo = new ProduitVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getPrix() != null)
                vo.setPrix(NumberUtil.toString(item.getPrix()));
            if (item.getQteStock() != null)
                vo.setQteStock(NumberUtil.toString(item.getQteStock()));
            if (item.getDateAjout() != null)
                vo.setDateAjout(DateUtil.formateDate(item.getDateAjout()));
            if (item.getPrixUnitaire() != null)
                vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
            if (item.getUser() != null && this.compte) {
                vo.setUser(item.getUser());
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        compte = value;
    }


    public CompteConverter getCompteConverter() {
        return this.compteConverter;
    }

    public void setCompteConverter(CompteConverter compteConverter) {
        this.compteConverter = compteConverter;
    }

    public boolean isCompte() {
        return this.compte;
    }

    public void setCompte(boolean compte) {
        this.compte = compte;
    }
}
