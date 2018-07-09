package com.pe.ingsoftware.dao.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;

@Component("reporteprogramaciones2")
public class ReporteProgramaciones2DAO implements
		IBDCrud<ReporteProgramaciones2View> {

	private static final String SQL_SELECT_ALL = "SELECT "
			+ "idprogramacion,idcurso,idprofesor,cycleprogramacion,groupprogramacion,cyclecurso,plancurso,programcurso,namecurso,nameprofesor,lastnameprofesor "
			+ "FROM reporte_programaciones_with_aulas ORDER by programcurso desc, plancurso asc,cyclecurso asc";

	private static String SQL_CONSULTAR_TODO_DE = "SELECT "
			+ "idprogramacion,idcurso,idprofesor,cycleprogramacion,groupprogramacion,cyclecurso,plancurso,programcurso,namecurso,nameprofesor,lastnameprofesor "
			+ "FROM reporte_programaciones_with_aulas" + "WHERE ";

	private static final Conexion cnn = Conexion.crearConexion();

	@Override
	public int insertar(ReporteProgramaciones2View objetoNuevo)
			throws BussinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean actualizar(ReporteProgramaciones2View objetoAntiguo,
			ReporteProgramaciones2View objetoActualizar)
			throws BussinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(ReporteProgramaciones2View objetoBorrar)
			throws BussinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ReporteProgramaciones2View> consultarTodo()
			throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReporteProgramaciones2View consultarUno(Object primaryKey)
			throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReporteProgramaciones2View consultarUno(Object campo,
			Object valorCampo, int tipoCampo) throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReporteProgramaciones2View> consultarTodoDe(Object campo,
			Object valorCampo, int tipoCampo) throws BussinessException {
		ArrayList<ReporteProgramaciones2View> objetoArrayList = new ArrayList();
		SQL_CONSULTAR_TODO_DE = "SELECT "
				+ "idprogramacion,idcurso,idprofesor,idaula,cycleprogramacion,groupprogramacion,cyclecurso,plancurso,programcurso,namecurso,nameprofesor,lastnameprofesor,numberaula,pavilionaula  "
				+ "FROM reporte_programaciones_with_aulas "
				+ "WHERE "
				+ campo.toString()
				+ " = ? ORDER by programcurso desc, plancurso asc,cyclecurso asc";
		PreparedStatement ps;
		ResultSet rs;
		ReporteProgramaciones2View reporte;
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
			rs = ps.executeQuery();
			if (!rs.next()) {
				objetoArrayList = null;
			} else {
				do {
					reporte = new ReporteProgramaciones2View(rs.getInt(1),
							rs.getInt(2), rs.getInt(3), rs.getInt(4),
							rs.getInt(5), rs.getInt(6), rs.getString(7),
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12),
							rs.getString(13), rs.getString(14));
					objetoArrayList.add(reporte);
				} while (rs.next());
			}
			return objetoArrayList;
		} catch (SQLException ex) {
			Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			cnn.cerrarConexion();
		}
		return objetoArrayList;
	}

	@Override
	public ArrayList<ReporteProgramaciones2View> consultarTodoDe(Object campo1,
			Object valorCampo1, int tipoCampo1, Object campo2,
			Object valorCampo2, int tipoCampo2) throws BussinessException {
		ArrayList<ReporteProgramaciones2View> objetoArrayList = new ArrayList();
		SQL_CONSULTAR_TODO_DE = "SELECT "
				+ "idprogramacion,idcurso,idprofesor,idaula,idhorario,cycleprogramacion,groupprogramacion,cyclecurso,plancurso,programcurso,namecurso,nameprofesor,lastnameprofesor,numberaula,pavilionaula,dayhorario,timestarthorario,timeendhorario "
				+ "FROM reporte_programaciones_w_horario_aula "
				+ "WHERE "
				+ campo1.toString()
				+ " = ? and "
				+ campo2.toString()
				+ " = ? ORDER by programcurso desc, plancurso asc,cyclecurso asc";
		PreparedStatement ps;
		ResultSet rs;
		ReporteProgramaciones2View reporte;
		try {
			ps = cnn.getCnn().prepareStatement(SQL_CONSULTAR_TODO_DE);
			switch (tipoCampo1) {
			case 0:
				ps.setInt(1, Integer.parseInt(valorCampo1.toString()));
				break;
			case 1:
				ps.setDouble(1, Double.parseDouble(valorCampo1.toString()));
				break;
			case 2:
				ps.setString(1, valorCampo1.toString());
				break;
			case 3:
				Time time = null;
				ps.setTime(1, time.valueOf(valorCampo1.toString()));
				break;
			default:
				ps.setString(1, valorCampo1.toString());
				break;
			}
			switch (tipoCampo2) {
			case 0:
				ps.setInt(2, Integer.parseInt(valorCampo2.toString()));
				break;
			case 1:
				ps.setDouble(2, Double.parseDouble(valorCampo2.toString()));
				break;
			case 2:
				ps.setString(2, valorCampo2.toString());
				break;
			case 3:
				Time time = null;
				ps.setTime(2, time.valueOf(valorCampo2.toString()));
				break;
			default:
				ps.setString(2, valorCampo2.toString());
				break;
			}
			rs = ps.executeQuery();
			if (!rs.next()) {
				objetoArrayList = null;
			} else {
				do {
					reporte = new ReporteProgramaciones2View(rs.getInt(1),
							rs.getInt(2), rs.getInt(3), rs.getInt(4),
							rs.getInt(5), rs.getInt(6), rs.getInt(7),
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12),
							rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16),
							rs.getString(17), rs.getString(18));
					objetoArrayList.add(reporte);
				} while (rs.next());
			}
			return objetoArrayList;
		} catch (SQLException ex) {
			Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ReporteProgramaciones1View.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			cnn.cerrarConexion();
		}
		return objetoArrayList;
	}

	@Override
	public ArrayList<ReporteProgramaciones2View> selectPrograma()
			throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReporteProgramaciones2View> selectPlan(String filtro)
			throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}
}
