package com.pe.ingsoftware.dao.views;

import com.pe.ingsoftware.dao.conexion.Conexion;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DiegoDavid
 */
@Component("reporteprogramaciones1")
public class ReporteProgramaciones1DAO implements IBDCrud<ReporteProgramaciones1View> {

    private static final String SQL_SELECT_ALL = "SELECT "
            + "idprogramacion,idcurso,idprofesor,cycleprogramacion,groupprogramacion,cyclecurso,plancurso,programcurso,namecurso,nameprofesor,lastnameprofesor "
            + "FROM reporte_programaciones_without_aulas ";
    
    private static String SQL_CONSULTAR_TODO_DE = "SELECT "
            + "idprogramacion,idcurso,idprofesor,cycleprogramacion,groupprogramacion,cyclecurso,plancurso,programcurso,namecurso,nameprofesor,lastnameprofesor "
            + "FROM reporte_programaciones_without_aulas"
            + "WHERE ";
    
    private static final Conexion cnn = Conexion.crearConexion();
    
    @Override
    public int insertar(ReporteProgramaciones1View objetoNuevo) throws BussinessException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean actualizar(ReporteProgramaciones1View objetoAntiguo, ReporteProgramaciones1View objetoActualizar)
            throws BussinessException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean borrar(ReporteProgramaciones1View objetoBorrar) throws BussinessException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<ReporteProgramaciones1View> consultarTodo() throws BussinessException {
        ArrayList<ReporteProgramaciones1View> profesorArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        ReporteProgramaciones1View objetoDTO;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                profesorArrayList = null;
            } else {
                do {
                    objetoDTO = new ReporteProgramaciones1View(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                    profesorArrayList.add(objetoDTO);
                } while (rs.next());
            }
            return profesorArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return profesorArrayList;
    }

    @Override
    public ReporteProgramaciones1View consultarUno(Object primaryKey) throws BussinessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReporteProgramaciones1View consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<ReporteProgramaciones1View> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        ArrayList<ReporteProgramaciones1View> objetoArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT "
            + "idprogramacion,idcurso,idprofesor,cycleprogramacion,groupprogramacion,cyclecurso,plancurso,programcurso,namecurso,nameprofesor,lastnameprofesor "
            + "FROM reporte_programaciones_without_aulas "
            + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        ReporteProgramaciones1View profesor;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_CONSULTAR_TODO_DE);
            switch (tipoCampo) {
                case 0:
                    ps.setInt(1, Integer.parseInt(valorCampo.toString()));
                    break;
                case 1:
                    ps.setDouble(1, Double.parseDouble(valorCampo.toString()));
                    break;
                case 2:
                    ps.setString(1, valorCampo.toString());
                    break;
                case 3:
                    Time time = null;
                    ps.setTime(1, time.valueOf(valorCampo.toString()));
                    break;
                default:
                    ps.setString(1, valorCampo.toString());
                    break;
            }
            System.out.println(SQL_CONSULTAR_TODO_DE);
            rs = ps.executeQuery();
            if (!rs.next()) {
                objetoArrayList = null;
            } else {
                do {
                    profesor = new ReporteProgramaciones1View(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                    objetoArrayList.add(profesor);
                } while (rs.next());
            }
            return objetoArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return objetoArrayList;
    }

    @Override
    public ArrayList<ReporteProgramaciones1View> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<ReporteProgramaciones1View> selectPrograma() throws BussinessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<ReporteProgramaciones1View> selectPlan(String filtro) throws BussinessException {
        // TODO Auto-generated method stub
        return null;
    }

}
