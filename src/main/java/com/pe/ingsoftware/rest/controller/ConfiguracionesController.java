package com.pe.ingsoftware.rest.controller;

import java.io.IOException;
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

import com.pe.ingsoftware.dto.ConfiguracionesDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.interfaces.IJsonTransformer;
import com.pe.ingsoftware.util.BussinessException;
import com.pe.ingsoftware.util.BussinessMessage;

@RestController
public class ConfiguracionesController {
	
    @Autowired
    @Qualifier("jsonTransformer")
    private IJsonTransformer jsonTransformer;
    //
    @Autowired
    @Qualifier("configuraciones")
    private IBDCrud crud;

	@CrossOrigin
    @RequestMapping(value = "/configuraciones", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insertar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            ConfiguracionesDTO objetoDTO = (ConfiguracionesDTO) jsonTransformer.fromJSON(jsonEntrada, ConfiguracionesDTO.class);
            int id;
            if ((id = crud.insertar(objetoDTO)) > 0) {
            	objetoDTO.setIdconfiguracion(id);
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
                //Logger.getLogger(HorariosController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(HorariosController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
	
	@CrossOrigin
    @RequestMapping(value = "/configuraciones/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void actualizar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("id") String id) {
        try {
        	ConfiguracionesDTO objetoDTO = (ConfiguracionesDTO) jsonTransformer.fromJSON(jsonEntrada, ConfiguracionesDTO.class);
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
    @RequestMapping(value = "/configuraciones", method = RequestMethod.GET, produces = "application/json")
    public void consultarVigente(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
        	ConfiguracionesDTO objetoDTO = (ConfiguracionesDTO) crud.consultarUno("0");
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
                //Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
	
}
