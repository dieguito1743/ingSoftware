/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.rest.controller;

import com.pe.ingsoftware.dto.DisponibilidadesDTO;
import com.pe.ingsoftware.dto.HorariosDTO;
import com.pe.ingsoftware.dto.ProgramacionesDTO;
import com.pe.ingsoftware.dto.Programaciones_horariosDTO;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DiegoDavid
 */
@RestController
public class DisponibilidadesController {

    @Autowired
    @Qualifier("jsonTransformer")
    private IJsonTransformer jsonTransformer;
    //
    @Autowired
    @Qualifier("disponibilidades")
    private IBDCrud crud;
    //
    @Autowired
    @Qualifier("programaciones")
    private IBDCrud crud2;
    //
    @Autowired
    @Qualifier("horarios")
    private IBDCrud crud3;
    //
    @Autowired
    @Qualifier("programaciones_horarios")
    private IBDCrud crud4;

    @CrossOrigin
    @RequestMapping(value = "/disponibilidades", method = RequestMethod.GET, produces = "application/json")
    public void consultarTodo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            ArrayList<DisponibilidadesDTO> arrayList = crud.consultarTodo();
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
                //Logger.getLogger(DisponibilidadesController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(DisponibilidadesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/disponibilidades/{id}", method = RequestMethod.GET, produces = "application/json")
    public void consultarUno(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") String id) {
        try {
            DisponibilidadesDTO objetoDTO = (DisponibilidadesDTO) crud.consultarUno(id);
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
                //Logger.getLogger(DisponibilidadesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(DisponibilidadesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/disponibilidades/profesor/{idprofesor}/curso/{idcurso}", method = RequestMethod.GET, produces = "application/json")
    public void consultarDisponibilidadProfesorParaElCurso(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idprofesor") String idprofesor, @PathVariable("idcurso") String idcurso) {
        try {//falta validar que sean del mismo ciclo
            boolean retornar = false;//retorna bad request
            ArrayList<DisponibilidadesDTO> arrayList = crud.consultarTodoDe("idprofesor", idprofesor, 0);
            ProgramacionesDTO objetoDTO = (ProgramacionesDTO) crud2.consultarUno("idcurso", idcurso, 0);
            ArrayList<Programaciones_horariosDTO> arrayList2 = crud4.consultarTodoDe("idprogramacion", objetoDTO.getIdprogramacion(), 0);
            for (Programaciones_horariosDTO objetoAux : arrayList2) {
                //hay que pasarle otro parametro cyclehorario para que valide el ciclo del horario pero falta implementar el metodo
                ArrayList<HorariosDTO> arrayList3 = crud3.consultarTodoDe("idhorario", objetoAux.getIdhorario(), 0);
                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    for (int y = arrayList3.size() - 1; y >= 0; y--) {
                        if (arrayList.get(i).getDaydisponibilidad().equalsIgnoreCase(arrayList3.get(y).getDayhorario())) {
                            retornar = true;//si hay disponibilidad retornara una respuesta acertada con la disonibilidad del profesor
                        }
                    }
                }
            }
            if (retornar) {
                String jsonSalida = jsonTransformer.toJson(arrayList);

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
                //Logger.getLogger(DisponibilidadesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(DisponibilidadesController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
