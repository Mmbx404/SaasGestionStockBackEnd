package org.mmb.gestionstock.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mmb.gestionstock.service.util.*;


import org.mmb.gestionstock.bean.Compte;
import org.mmb.gestionstock.ws.rest.provided.vo.CompteVo;

@Component
public class CompteConverter extends AbstractConverter<Compte, CompteVo> {


    public CompteConverter() {
        init(true);
    }

    @Override
    public Compte toItem(CompteVo vo) {
        if (vo == null) {
            return null;
        } else {
            Compte item = new Compte();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getEmail()))
                item.setEmail(vo.getEmail());
            if (StringUtil.isNotEmpty(vo.getMdp()))
                item.setMdp(vo.getMdp());
            if (StringUtil.isNotEmpty(vo.getDateCreation()))
                item.setDateCreation(DateUtil.parse(vo.getDateCreation()));


            return item;
        }
    }

    @Override
    public CompteVo toVo(Compte item) {
        if (item == null) {
            return null;
        } else {
            CompteVo vo = new CompteVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (StringUtil.isNotEmpty(item.getEmail()))
                vo.setEmail(item.getEmail());

            if (StringUtil.isNotEmpty(item.getMdp()))
                vo.setMdp(item.getMdp());

            if (item.getDateCreation() != null)
                vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));

            return vo;
        }
    }

    public void init(Boolean value) {
    }


}
