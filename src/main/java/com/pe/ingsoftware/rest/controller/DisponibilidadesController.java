/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.rest.controller;

import com.pe.ingsoftware.dao.HorariosDAO;
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
import org.springframework.web.bind.annotation.RequestBody;
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
            ArrayList<DisponibilidadesDTO> arrayListDisponibilidad = crud.consultarTodoDe("idprofesor", idprofesor, 0);//obtenemos todas la disponibilidad del profesor
            ProgramacionesDTO objetoDTO = (ProgramacionesDTO) crud2.consultarUno("idcurso", idcurso, 0);
            ArrayList<Programaciones_horariosDTO> arrayList2 = crud4.consultarTodoDe("idprogramacion", objetoDTO.getIdprogramacion(), 0);
            //if(arrayList2 != null && arrayListDisponibilidad != null && objetoDTO != null && !arrayList2.isEmpty()) {
                for (Programaciones_horariosDTO objetoAux : arrayList2) {
                    //hay que pasarle otro parametro cyclehorario para que valide el ciclo del horario pero falta implementar el metodo
                    ArrayList<HorariosDTO> arrayListHorario = crud3.consultarTodoDe("idhorario", objetoAux.getIdhorario(), 0);
                    //if(arrayListHorario != null && !arrayListHorario.isEmpty()) {
                        for (int i = 0; i < arrayListHorario.size(); i++) {
                            for (int y = 0; y < arrayListDisponibilidad.size(); y++) {
                                if (arrayListDisponibilidad.get(y).getDaydisponibilidad().equalsIgnoreCase(arrayListHorario.get(i).getDayhorario())) {
                                	int hdi = Integer.parseInt(arrayListDisponibilidad.get(y).getHourstartdisponibilidad().replace(":", "")) - 20000;
                            		int hdf = Integer.parseInt(arrayListDisponibilidad.get(y).getHourenddisponibilidad().replace(":", "")) + 20000;
                            		int hpi = Integer.parseInt(arrayListHorario.get(i).getTimestarthorario().replace(":", ""));
                            		int hpf = Integer.parseInt(arrayListHorario.get(i).getTimeendhorario().replace(":", ""));
                            		//System.out.println( " " + " idprofesor " + idprofesor + " idprogramacion " +  objetoDTO.getIdprogramacion() +" hdi " + hdi + " hdf "+ hdf + " hpi " + hpi + " hpf " + hpf);
                            		if(hpi>=hdi && hpf<=hdf) {//le damos dos horas de tolerancia  asu horarios del profe pe
                        				//si el horario cae dentro del horario del profesor posee disponibilidad
                        				if(arrayListDisponibilidad.get(y).getStatusdisponibilidad() == 0) {
                        					//esta libre su horario
                        					retornar = true;
                            				break;
                        				}
                        				else {
                        					retornar = false;
                        					break;
                        				}
                        			}else{
                        				retornar = false;
                        				break;
                        			}
                                }
                            }
                            break;
                        }
                    //}
                    break;
                }
            //}
            if (retornar) {
                //String jsonSalida = jsonTransformer.toJson(arrayList);
            	String jsonSalida = "{\"tipo\" : \"0\"}";

                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
            	String jsonSalida = "{\"tipo\" : \"1\"}";

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
    @RequestMapping(value = "/disponibilidades/profesor/{idprofesor}/programacion/{idprogramacion}", method = RequestMethod.PUT, produces = "application/json")
    public void actualizar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada ,@PathVariable("idprofesor") String id, @PathVariable("idprogramacion") String idprogramacion) {
        boolean retornar = false;
    	try {//falta validar que son del ciclo correspondiente al configurado
            ArrayList<Programaciones_horariosDTO> arrayList = crud4.consultarTodoDe("idprogramacion", idprogramacion, 0);
            ArrayList<DisponibilidadesDTO> arrayLisy2 = crud.consultarTodoDe("idprofesor", id, 0);
            for(Programaciones_horariosDTO objetoFor : arrayList) {
            	HorariosDTO objetoDTO = (HorariosDTO) crud3.consultarUno(objetoFor.getIdhorario());
            	for(DisponibilidadesDTO objetoFor2 :arrayLisy2) {
            		int hdi = Integer.parseInt(objetoFor2.getHourstartdisponibilidad().replace(":", "")) - 20000;
            		int hdf = Integer.parseInt(objetoFor2.getHourenddisponibilidad().replace(":", "")) + 2000;
            		int hpi = Integer.parseInt(objetoDTO.getTimestarthorario().replace(":", ""));
            		int hpf = Integer.parseInt(objetoDTO.getTimeendhorario().replace(":", ""));
            		if(objetoDTO.getDayhorario().equalsIgnoreCase(objetoFor2.getDaydisponibilidad())) {
            			if((hpi >= hdf) || (hdi >= hpf)) {
            				//no hay cruce
            			}else{
            				//hay cruce en el horario y se debe actualizar su disponibilidad
            				objetoFor2.setStatusdisponibilidad(1);
            				if(crud.actualizar(objetoFor2, objetoFor2)) {
            					retornar = true;
            					break;
            				}
            			}
            		}
            	}
            }
            if (retornar) {
                String jsonSalida = "{\"resultado\":\"actualizado\"}";

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
}
