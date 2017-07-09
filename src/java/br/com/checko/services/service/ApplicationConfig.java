/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Roberto Duré
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.checko.services.service.TbAtletaFacadeREST.class);
        resources.add(br.com.checko.services.service.TbCategoriaFacadeREST.class);
        resources.add(br.com.checko.services.service.TbCidadesFacadeREST.class);
        resources.add(br.com.checko.services.service.TbClubeFacadeREST.class);
        resources.add(br.com.checko.services.service.TbEstadosFacadeREST.class);
        resources.add(br.com.checko.services.service.TbEventoFacadeREST.class);
        resources.add(br.com.checko.services.service.TbGruposUsuariosFacadeREST.class);
        resources.add(br.com.checko.services.service.TbInscricaoFacadeREST.class);
        resources.add(br.com.checko.services.service.TbPenalidadeFacadeREST.class);
        resources.add(br.com.checko.services.service.TbPercursoFacadeREST.class);
        resources.add(br.com.checko.services.service.TbPrismaFacadeREST.class);
        resources.add(br.com.checko.services.service.TbProvaFacadeREST.class);
        resources.add(br.com.checko.services.service.TbResultadoProvaFacadeREST.class);
        resources.add(br.com.checko.services.service.TbUsuariosFacadeREST.class);
    }
    
}
