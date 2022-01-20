package org.mmb.gestionstock.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mmb.gestionstock.service.util.*;


import org.mmb.gestionstock.bean.Commande;
import org.mmb.gestionstock.ws.rest.provided.vo.CommandeVo;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeVo> {

    @Autowired
    private CompteConverter compteConverter;
    private Boolean compte;

    public CommandeConverter() {
        init(true);
    }

    @Override
    public Commande toItem(CommandeVo vo) {
        if (vo == null) {
            return null;
        } else {
            Commande item = new Commande();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getPrixTotal()))
                item.setPrixTotal(NumberUtil.toBigDecimal(vo.getPrixTotal()));
            if (StringUtil.isNotEmpty(vo.getDateCreation()))
                item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if (vo.getUser() != null && this.compte)
                item.setUser(vo.getUser());


            return item;
        }
    }

    @Override
    public CommandeVo toVo(Commande item) {
        if (item == null) {
            return null;
        } else {
            CommandeVo vo = new CommandeVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getPrixTotal() != null)
                vo.setPrixTotal(NumberUtil.toString(item.getPrixTotal()));
            if (item.getDateCreation() != null)
                vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
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
