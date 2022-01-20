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
import org.mmb.gestionstock.bean.Produit;
import org.mmb.gestionstock.service.facade.ProduitService;
import org.mmb.gestionstock.ws.rest.provided.converter.ProduitConverter;
import org.mmb.gestionstock.ws.rest.provided.vo.ProduitVo;

@Api("Manages produit services")
@RestController
@RequestMapping("/api/SUPERADMIN/produit")
//@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
public class ProduitRest {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private ProduitConverter produitConverter;

    @ApiOperation("Saves the specified produit")
    @PostMapping("/")
    public ProduitVo save(@RequestBody ProduitVo produitVo) {
        System.out.println("This is given User name in produit Vo : " + produitVo.getUser().getUsername());
        Produit produit = produitConverter.toItem(produitVo);
        System.out.println("This is given User name in produit : " + produit.getUser().getUsername());
        produit = produitService.save(produit);
        return produitConverter.toVo(produit);
    }

    @ApiOperation("Delete the specified produit")
    @DeleteMapping("/")
    public int delete(@RequestBody ProduitVo produitVo) {
        Produit produit = produitConverter.toItem(produitVo);
        return produitService.delete(produit);
    }

    @ApiOperation("Updates the specified produit")
    @PutMapping("/")
    public ProduitVo update(@RequestBody ProduitVo produitVo) {
        Produit produit = produitConverter.toItem(produitVo);
        produit = produitService.update(produit);
        return produitConverter.toVo(produit);
    }

    @ApiOperation("Finds a list of all produits")
    @GetMapping("/")
    public List<ProduitVo> findAll() {
        return produitConverter.toVo(produitService.findAll());
    }

    @ApiOperation("Finds a produit by id")
    @GetMapping("/id/{id}")
    public ProduitVo findById(@PathVariable Long id) {
        return produitConverter.toVo(produitService.findById(id));
    }


    @ApiOperation("Deletes a produit by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return produitService.deleteById(id);
    }

    @ApiOperation("Finds a  produit by reference")
    @GetMapping("/reference/{reference}")
    public ProduitVo findByReference(@PathVariable String reference) {
        return produitConverter.toVo(produitService.findByReference(reference));
    }

    @ApiOperation("Deletes a  produit by reference")
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return produitService.deleteByReference(reference);
    }


    @ApiOperation("Finds a produit by reference of compte")
    @GetMapping("/compte/reference/{reference}")
    public List<ProduitVo> findByUserUsername(@PathVariable String reference) {
        return produitConverter.toVo(produitService.findByUserUsername(reference));
    }

    @ApiOperation("Deletes a produit by reference of compte")
    @DeleteMapping("/compte/reference/{reference}")
    public int deleteByUserUsername(@PathVariable String reference) {
        return produitService.deleteByUserUsername(reference);
    }

    @ApiOperation("Finds produit by id of compte")
    @GetMapping("/compte/id/{id}")
    public List<ProduitVo> findByUserId(@PathVariable Long id) {
        return produitConverter.toVo(produitService.findByUserId(id));
    }

    @ApiOperation("Deletes produit by id of compte")
    @DeleteMapping("/compte/id/{id}")
    public int deleteByUserId(@PathVariable Long id) {
        return produitService.deleteByUserId(id);
    }

    @ApiOperation("Search produit by a specific criteria")
    @PostMapping("/search")
    public List<ProduitVo> findByCriteria(@RequestBody ProduitVo produitVo) {
        return produitConverter.toVo(produitService.findByCriteria(produitVo));
    }

    public ProduitConverter getProduitConverter() {
        return produitConverter;
    }

    public void setProduitConverter(ProduitConverter produitConverter) {
        this.produitConverter = produitConverter;
    }

    public ProduitService getProduitService() {
        return produitService;
    }

    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }

}