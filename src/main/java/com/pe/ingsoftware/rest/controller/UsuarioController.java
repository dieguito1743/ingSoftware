/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.rest.controller;

import com.pe.ingsoftware.dto.UsuarioDTO;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dbermudez
 */
@RestController
public class UsuarioController {

    @Autowired
    @Qualifier("jsonTransformer")
    private IJsonTransformer jsonTransformer;
    //
    @Autowired
    @Qualifier("usuario")
    private IBDCrud crud;

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    /*, produces = "application/json") para otra version de spring*/
    public void consultarUno(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") String id) {
        try {
            UsuarioDTO objetoDTO = (UsuarioDTO) crud.consultarUno(id);
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

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    /*, consumes = "application/json", produces = "application/json") para otra version de spring*/
    public void insertar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            UsuarioDTO objetoDTO = (UsuarioDTO) jsonTransformer.fromJSON(jsonEntrada, UsuarioDTO.class);
            if (crud.insertar(objetoDTO)>0) {
                String jsonSalida = jsonTransformer.toJson(objetoDTO);

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
                String jsonSalida = "{result: null}";
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            }
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                //Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    /*, produces = "application/json") para otra version de spring*/
    public void consultarTodo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            ArrayList<UsuarioDTO> arrayList = crud.consultarTodo();
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

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    /*, consumes = "application/json", produces = "application/json")*/
    public void actualizar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("id") String id) {
        try {
            UsuarioDTO objetoDTO = (UsuarioDTO) jsonTransformer.fromJSON(jsonEntrada, UsuarioDTO.class);
            if (crud.actualizar(crud.consultarUno(id), objetoDTO)) {
                String jsonSalida = jsonTransformer.toJson(objetoDTO);

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
                String jsonSalida = "{result: none}";

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
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

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    /*, produces = "application/json")*/
    public void borrar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") String id) {
        try {
            if (crud.borrar(id)) {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
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

        }
    }

    @RequestMapping(value = "/usuario/testing", method = RequestMethod.GET)
    /*, produces = "application/json") para otra version de spring*/
    public void testing(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            UsuarioDTO objetoDTO = new UsuarioDTO("13200096", "Diego Bermudez", "dieguito.1743@gmail.com", 24);
            String jsonUsuario = jsonTransformer.toJson(objetoDTO);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonUsuario);

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
}
