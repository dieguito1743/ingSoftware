/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.rest.controller;

import com.pe.ingsoftware.dto.AulasDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.interfaces.IJsonTransformer;
import com.pe.ingsoftware.util.BussinessException;
import com.pe.ingsoftware.util.BussinessMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DiegoDavid
 */
@RestController
public class AulasController {

    @Autowired
    @Qualifier("jsonTransformer")
    private IJsonTransformer jsonTransformer;
    //
    @Autowired
    @Qualifier("aulas")
    private IBDCrud crud;

    @RequestMapping(value = "/aulas", method = RequestMethod.GET)
    /*, produces = "application/json") para otra version de spring*/
    public void consultarTodo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            ArrayList<AulasDTO> arrayList = crud.consultarTodo();
            String jsonSalida = jsonTransformer.toJson(arrayList);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                //Logger.getLogger(AulasController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(AulasController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @RequestMapping(value = "/aulas/{id}", method = RequestMethod.GET)
    /*, produces = "application/json") para otra version de spring*/
    public void consultarUno(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") String id) {
        try {
            AulasDTO objetoDTO = (AulasDTO) crud.consultarUno(id);
            String jsonSalida = jsonTransformer.toJson(objetoDTO);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                //Logger.getLogger(AulasController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(AulasController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
