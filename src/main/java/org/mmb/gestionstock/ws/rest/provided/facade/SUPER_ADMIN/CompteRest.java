package org.mmb.gestionstock.ws.rest.provided.facade.SUPER_ADMIN;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mmb.gestionstock.bean.Compte;
import org.mmb.gestionstock.service.facade.CompteService;
import org.mmb.gestionstock.ws.rest.provided.converter.CompteConverter;
import org.mmb.gestionstock.ws.rest.provided.vo.CompteVo;

@Api("Manages compte services")
@RestController
@RequestMapping("/api/SUPERADMIN/compte")
//@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
public class CompteRest {

    @Autowired
    private CompteService compteService;

    @Autowired
    private CompteConverter compteConverter;

    @ApiOperation("Saves the specified compte")
    @PostMapping("/")
    public CompteVo save(@RequestBody CompteVo compteVo) {
        Compte compte = compteConverter.toItem(compteVo);
        compte = compteService.save(compte);
        return compteConverter.toVo(compte);
    }

    @ApiOperation("Delete the specified compte")
    @DeleteMapping("/")
    public int delete(@RequestBody CompteVo compteVo) {
        Compte compte = compteConverter.toItem(compteVo);
        return compteService.delete(compte);
    }

    @ApiOperation("Updates the specified compte")
    @PutMapping("/")
    public CompteVo update(@RequestBody CompteVo compteVo) {
        Compte compte = compteConverter.toItem(compteVo);
        compte = compteService.update(compte);
        return compteConverter.toVo(compte);
    }

    @ApiOperation("Finds a list of all comptes")
    @GetMapping("/")
    public List<CompteVo> findAll() {
        return compteConverter.toVo(compteService.findAll());
    }

    @ApiOperation("Finds a compte by id")
    @GetMapping("/id/{id}")
    public CompteVo findById(@PathVariable Long id) {
        return compteConverter.toVo(compteService.findById(id));
    }


    @ApiOperation("Deletes a compte by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return compteService.deleteById(id);
    }

    @ApiOperation("Finds a  compte by reference")
    @GetMapping("/reference/{reference}")
    public CompteVo findByReference(@PathVariable String reference) {
        return compteConverter.toVo(compteService.findByReference(reference));
    }

    @ApiOperation("Deletes a  compte by reference")
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return compteService.deleteByReference(reference);
    }


    @ApiOperation("Search compte by a specific criteria")
    @PostMapping("/search")
    public List<CompteVo> findByCriteria(@RequestBody CompteVo compteVo) {
        return compteConverter.toVo(compteService.findByCriteria(compteVo));
    }

    public CompteConverter getCompteConverter() {
        return compteConverter;
    }

    public void setCompteConverter(CompteConverter compteConverter) {
        this.compteConverter = compteConverter;
    }

    public CompteService getCompteService() {
        return compteService;
    }

    public void setCompteService(CompteService compteService) {
        this.compteService = compteService;
    }

}