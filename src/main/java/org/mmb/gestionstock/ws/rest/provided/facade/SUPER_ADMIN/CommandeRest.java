package org.mmb.gestionstock.ws.rest.provided.facade.SUPER_ADMIN;

import java.util.List;

import org.mmb.gestionstock.service.facade.UserService;
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
import org.mmb.gestionstock.bean.Commande;
import org.mmb.gestionstock.service.facade.CommandeService;
import org.mmb.gestionstock.ws.rest.provided.converter.CommandeConverter;
import org.mmb.gestionstock.ws.rest.provided.vo.CommandeVo;

@Api("Manages commande services")
@RestController
@RequestMapping("/api/SUPERADMIN/commande")
//@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
public class CommandeRest {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommandeConverter commandeConverter;

    @ApiOperation("Saves the specified commande")
    @PostMapping("/")
    public CommandeVo save(@RequestBody CommandeVo commandeVo) {
        Commande commande = commandeConverter.toItem(commandeVo);
        commande = commandeService.save(commande);
        return commandeConverter.toVo(commande);
    }

    @ApiOperation("Delete the specified commande")
    @DeleteMapping("/")
    public int delete(@RequestBody CommandeVo commandeVo) {
        Commande commande = commandeConverter.toItem(commandeVo);
        return commandeService.delete(commande);
    }

    @ApiOperation("Updates the specified commande")
    @PutMapping("/")
    public CommandeVo update(@RequestBody CommandeVo commandeVo) {
        Commande commande = commandeConverter.toItem(commandeVo);
        commande = commandeService.update(commande);
        return commandeConverter.toVo(commande);
    }

    @ApiOperation("Finds a list of all commandes")
    @GetMapping("/")
    public List<CommandeVo> findAll() {
        return commandeConverter.toVo(commandeService.findAll());
    }

    @ApiOperation("Finds a commande by id")
    @GetMapping("/id/{id}")
    public CommandeVo findById(@PathVariable Long id) {
        return commandeConverter.toVo(commandeService.findById(id));
    }


    @ApiOperation("Deletes a commande by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return commandeService.deleteById(id);
    }

    @ApiOperation("Finds a  commande by reference")
    @GetMapping("/reference/{reference}")
    public CommandeVo findByReference(@PathVariable String reference) {
        return commandeConverter.toVo(commandeService.findByReference(reference));
    }

    @ApiOperation("Deletes a  commande by reference")
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }


    @ApiOperation("Finds a commande by reference of compte")
    @GetMapping("/compte/reference/{reference}")
    public List<CommandeVo> findByUserUsername(@PathVariable String reference) {
        return commandeConverter.toVo(commandeService.findByUserUsername(reference));
    }

    @ApiOperation("Deletes a commande by reference of compte")
    @DeleteMapping("/compte/reference/{reference}")
    public int deleteByUserUsername(@PathVariable String reference) {
        return commandeService.deleteByUserUsername(reference);
    }

    @ApiOperation("Finds commande by id of compte")
    @GetMapping("/compte/id/{id}")
    public List<CommandeVo> findByUserId(@PathVariable Long id) {
        return commandeConverter.toVo(commandeService.findByUserId(id));
    }

    @ApiOperation("Deletes commande by id of compte")
    @DeleteMapping("/compte/id/{id}")
    public int deleteByUserId(@PathVariable Long id) {
        return commandeService.deleteByUserId(id);
    }

    @ApiOperation("Search commande by a specific criteria")
    @PostMapping("/search")
    public List<CommandeVo> findByCriteria(@RequestBody CommandeVo commandeVo) {
        return commandeConverter.toVo(commandeService.findByCriteria(commandeVo));
    }

    public CommandeConverter getCommandeConverter() {
        return commandeConverter;
    }

    public void setCommandeConverter(CommandeConverter commandeConverter) {
        this.commandeConverter = commandeConverter;
    }

    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

}