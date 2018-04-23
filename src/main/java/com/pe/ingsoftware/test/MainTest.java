/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.test;

import com.pe.ingsoftware.dao.CursosDAO;
import com.pe.ingsoftware.dao.DisponibilidadesDAO;
import com.pe.ingsoftware.dao.Horas_cursosDAO;
import com.pe.ingsoftware.dao.Preferencias_cursos_profesoresDAO;
import com.pe.ingsoftware.dao.ProfesoresDAO;
import com.pe.ingsoftware.dto.CursosDTO;
import com.pe.ingsoftware.dto.DisponibilidadesDTO;
import com.pe.ingsoftware.dto.Horas_cursosDTO;
import com.pe.ingsoftware.dto.Preferencias_cursos_profesoresDTO;
import com.pe.ingsoftware.dto.ProfesoresDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.interfaces.IJsonTransformer;
import com.pe.ingsoftware.util.BussinessException;
import com.pe.ingsoftware.util.BussinessMessage;
import com.pe.ingsoftware.util.JsonTransformer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbermudez
 */
public class MainTest {

    //@Autowired
    //@Qualifier("jsonTransformer")
    //private static IJsonTransformer jsonTransformer;
    //
    //@Autowired
    //@Qualifier("profesores")
    //private static IBDCrud profesores;
    public static void main(String[] args) {
        //profesoresTest();
        //cursosTetst();
        //disponibilidadesTest();
        //horas_cursosTest();
        //preferencias_cursos_profesoresTest();
        listar_programa_cursos();
        listar_plan_cursos();
    }

    public static void listar_programa_cursos() {
        IBDCrud crud = new CursosDAO();
        IJsonTransformer jsonTransformer = new JsonTransformer();
        String jsonSalida = "";
        try {
            ArrayList<CursosDTO> arrayList = crud.selectPrograma();
            jsonSalida = jsonTransformer.toJson(arrayList);
            for (CursosDTO objeto : arrayList) {
                System.out.println("PROGRAMA: " + objeto.getProgramcurso());
                System.out.println("");
            }
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            jsonSalida = jsonTransformer.toJson(bussinessMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(jsonSalida);
    }

    public static void listar_plan_cursos() {
        IBDCrud crud = new CursosDAO();
        IJsonTransformer jsonTransformer = new JsonTransformer();
        String jsonSalida = "";
        try {
            ArrayList<CursosDTO> arrayList = crud.selectPlan("ISW");
            jsonSalida = jsonTransformer.toJson(arrayList);
            for (CursosDTO objeto : arrayList) {
                System.out.println("PLAN    : " + objeto.getPlancurso());
                System.out.println("");
            }
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            jsonSalida = jsonTransformer.toJson(bussinessMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(jsonSalida);
    }

    public static void profesoresTest() {
        IBDCrud crud = new ProfesoresDAO();
        IJsonTransformer jsonTransformer = new JsonTransformer();
        String jsonSalida = "";
        try {
            ArrayList<ProfesoresDTO> arrayList = crud.consultarTodo();
            jsonSalida = jsonTransformer.toJson(arrayList);
            for (ProfesoresDTO objeto : arrayList) {
                System.out.println("ID      : " + objeto.getIdProfesor());
                System.out.println("CODIGO  : " + objeto.getCodProfesor());
                System.out.println("NOMBRE  : " + objeto.getNameProfesor());
                System.out.println("APELLIDO: " + objeto.getLastNameProfesor());
                System.out.println("ESTADO  : " + objeto.getStatusPorfesor());
                System.err.println("");
            }

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            jsonSalida = jsonTransformer.toJson(bussinessMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(jsonSalida);
    }

    public static void cursosTetst() {
        IBDCrud crud = new CursosDAO();
        IJsonTransformer jsonTransformer = new JsonTransformer();
        String jsonSalida = "";
        try {
            ArrayList<CursosDTO> arrayList = crud.consultarTodo();
            jsonSalida = jsonTransformer.toJson(arrayList);
            for (CursosDTO objeto : arrayList) {
                System.out.println("ID      : " + objeto.getIdcurso());
                System.out.println("CODIGO  : " + objeto.getCodcurso());
                System.out.println("NOMBRE  : " + objeto.getNamecurso());
                System.out.println("CICLO   : " + objeto.getCyclecurso());
                System.out.println("PLAN    : " + objeto.getPlancurso());
                System.out.println("PROGRAMA: " + objeto.getProgramcurso());
                System.err.println("");
            }

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            jsonSalida = jsonTransformer.toJson(bussinessMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(jsonSalida);
    }

    public static void disponibilidadesTest() {
        IBDCrud crud = new DisponibilidadesDAO();
        IJsonTransformer jsonTransformer = new JsonTransformer();
        String jsonSalida = "";
        try {
            ArrayList<DisponibilidadesDTO> arrayList = crud.consultarTodo();
            jsonSalida = jsonTransformer.toJson(arrayList);
            for (DisponibilidadesDTO objeto : arrayList) {
                System.out.println("PROFESOR: " + profesoresTest(objeto.getIdprofesor()).getNameProfesor() + " " + profesoresTest(objeto.getIdprofesor()).getLastNameProfesor());
                System.out.println("DIA     : " + objeto.getDaydisponibilidad());
                System.out.println("INICIO  : " + objeto.getHourstartdisponibilidad());
                System.out.println("FIN     : " + objeto.getHourstartdisponibilidad());
                System.out.println("ESTADO  : " + objeto.getStatusdisponibilidad());
                System.err.println("");
            }

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            jsonSalida = jsonTransformer.toJson(bussinessMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(jsonSalida);
    }

    public static ProfesoresDTO profesoresTest(int id) {
        IBDCrud crud = new ProfesoresDAO();
        try {
            ProfesoresDTO objeto = (ProfesoresDTO) crud.consultarUno(id);
            return objeto;
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            System.out.println(bussinessMessage.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void horas_cursosTest() {
        IBDCrud crud = new Horas_cursosDAO();
        IJsonTransformer jsonTransformer = new JsonTransformer();
        String jsonSalida = "";
        try {
            ArrayList<Horas_cursosDTO> arrayList = crud.consultarTodo();
            jsonSalida = jsonTransformer.toJson(arrayList);
            for (Horas_cursosDTO objeto : arrayList) {
                System.out.println("CURSO   : " + cursosTest(objeto.getIdcurso()).getNamecurso());
                System.out.println("TIPO    : " + objeto.getTypehora_curso());
                System.out.println("HORAS   : " + objeto.getNumberhourhora_curso());
                System.err.println("");
            }

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            jsonSalida = jsonTransformer.toJson(bussinessMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(jsonSalida);
    }

    public static CursosDTO cursosTest(int id) {
        IBDCrud crud = new CursosDAO();
        try {
            CursosDTO objeto = (CursosDTO) crud.consultarUno(id);
            return objeto;
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            System.out.println(bussinessMessage.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void preferencias_cursos_profesoresTest() {
        IBDCrud crud = new Preferencias_cursos_profesoresDAO();
        IJsonTransformer jsonTransformer = new JsonTransformer();
        String jsonSalida = "";
        try {
            ArrayList<Preferencias_cursos_profesoresDTO> arrayList = crud.consultarTodo();
            jsonSalida = jsonTransformer.toJson(arrayList);
            for (Preferencias_cursos_profesoresDTO objeto : arrayList) {
                System.out.println("CURSO   : " + cursosTest(objeto.getIdcurso()).getNamecurso());
                System.out.println("PROFESOR: " + profesoresTest(objeto.getIdprofesor()).getNameProfesor() + " " + profesoresTest(objeto.getIdprofesor()).getLastNameProfesor());
                System.err.println("");
            }

        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            jsonSalida = jsonTransformer.toJson(bussinessMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(jsonSalida);
    }
}
