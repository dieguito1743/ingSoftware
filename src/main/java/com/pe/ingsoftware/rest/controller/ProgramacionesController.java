/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.rest.controller;

import com.pe.ingsoftware.dao.views.ReporteProgramaciones1View;
import com.pe.ingsoftware.dto.ProgramacionesDTO;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DiegoDavid
 */
@RestController
public class ProgramacionesController {

    @Autowired
    @Qualifier("jsonTransformer")
    private IJsonTransformer jsonTransformer;
    //
    @Autowired
    @Qualifier("programaciones")
    private IBDCrud crud;
    //
    @Autowired
    @Qualifier("reporteprogramaciones1")
    private IBDCrud crud2;

    @CrossOrigin
    @RequestMapping(value = "/programaciones", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insertar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            ProgramacionesDTO objetoDTO = (ProgramacionesDTO) jsonTransformer.fromJSON(jsonEntrada, ProgramacionesDTO.class);
            int id;
            if ((id = crud.insertar(objetoDTO)) > 0) {
                objetoDTO.setIdprogramacion(id);
                String jsonSalida = jsonTransformer.toJson(objetoDTO);

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
            }
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                //Logger.getLogger(ProgramacionesController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(ProgramacionesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/programaciones/curso/{id}", method = RequestMethod.GET, produces = "application/json")
    public void consultarUnCurso(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") String id) {
        try {
            ProgramacionesDTO objetoDTO = (ProgramacionesDTO) crud.consultarUno("idcurso", id, 0);
            if(objetoDTO != null) {
                String jsonSalida = jsonTransformer.toJson(objetoDTO);

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            }else {
            	httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
            }

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                //Logger.getLogger(ProgramacionesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(ProgramacionesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/programaciones/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void actualizar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("id") String id) {
        try {
            ProgramacionesDTO objetoDTO = (ProgramacionesDTO) jsonTransformer.fromJSON(jsonEntrada, ProgramacionesDTO.class);
            if (crud.actualizar(crud.consultarUno(id), objetoDTO)) {
                String jsonSalida = jsonTransformer.toJson(crud.consultarUno(id));

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
            }

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                //Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/programaciones/reporte/{id}", method = RequestMethod.GET, produces = "application/json")
    public void reporteProgramacion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") String id) {
        try {
            System.out.println("dentro del metodo");
            ArrayList<ReporteProgramaciones1View> objetoArrayList = crud2.consultarTodoDe("cycleprogramacion", id, 0);
            if(objetoArrayList != null && !objetoArrayList.isEmpty()) {
                String jsonSalida = jsonTransformer.toJson(objetoArrayList);

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            }else {
            	httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
            }
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                //Logger.getLogger(ProgramacionesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(ProgramacionesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
