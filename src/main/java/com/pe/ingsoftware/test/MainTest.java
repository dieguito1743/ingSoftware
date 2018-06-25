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
import com.pe.ingsoftware.dao.views.ReporteProgramaciones1DAO;
import com.pe.ingsoftware.dao.views.ReporteProgramaciones1View;
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

import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        //reportesTest("20181");
        //profesoresTest();
        //cursosTetst();
        //disponibilidadesTest();
        //horas_cursosTest();
        //preferencias_cursos_profesoresTest();
        listar_programa_cursos();
        //listar_plan_cursos();
    }

    public static void testParseDtae() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
        Calendar calendar = GregorianCalendar.getInstance();
        Date today = null;
        Time timeStart = null;
        Time timeEnd = null;
        try {
            today = sdf.parse("09:00:00");
            calendar.setTime(today);
            timeStart = new Time(calendar.getTimeInMillis());
            System.out.println(calendar.getTime());
            System.out.println(timeStart);
            today = sdf.parse("13:00:00");
            calendar.setTime(today);
            timeEnd = new Time(calendar.getTimeInMillis());
            System.out.println(calendar.getTime());
            System.out.println(timeEnd);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                System.out.println("ID      : " + objeto.getIdprofesor());
                System.out.println("CODIGO  : " + objeto.getcodprofesor());
                System.out.println("NOMBRE  : " + objeto.getnameprofesor());
                System.out.println("APELLIDO: " + objeto.getlastnameprofesor());
                System.out.println("ESTADO  : " + objeto.getstatusprofesor());
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
                System.out.println("PROFESOR: " + profesoresTest(objeto.getIdprofesor()).getnameprofesor() + " " + profesoresTest(objeto.getIdprofesor()).getlastnameprofesor());
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
                System.out.println("PROFESOR: " + profesoresTest(objeto.getIdprofesor()).getnameprofesor() + " " + profesoresTest(objeto.getIdprofesor()).getlastnameprofesor());
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

    public static void reportesTest(String cycle) {
        IBDCrud crud = new ReporteProgramaciones1DAO();
        try {
            ArrayList<ReporteProgramaciones1View> objetoArrayList = crud.consultarTodoDe("cycleprogramacion", cycle, 0);
            if (objetoArrayList.isEmpty() || objetoArrayList == null) {
                System.out.println("reporte vacio");
            } else {
                int i = 1;
                for (ReporteProgramaciones1View objeto : objetoArrayList) {
                    System.out.println(" objeto " + i);
                    System.out.println("\t" + objeto.getPlancurso());
                    System.out.println("\t" + objeto.getProgramcurso());
                    System.out.println("\t" + objeto.getNameprofesor() + " " + objeto.getLastnameprofesor());
                    System.out.println("\t" + objeto.getNamecurso());
                    i++;
                }
            }
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            System.out.println(bussinessMessage.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
