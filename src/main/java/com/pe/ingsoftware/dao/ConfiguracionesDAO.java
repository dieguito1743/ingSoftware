package com.pe.ingsoftware.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.ConfiguracionesDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;

@Component("configuraciones")
public class ConfiguracionesDAO implements IBDCrud<ConfiguracionesDTO> {

	private static final String SQL_INSERT = "INSERT "
			+ "INTO CONFIGURACIONES (cycleconfiguracion, statusconfiguracion) "
			+ "VALUES (?,0) ";
	private static final String SQL_SELECT_WHERE = "SELECT "
			+ "idconfiguracion, cycleconfiguracion, statusconfiguracion "
			+ "FROM CONFIGURACIONES "
			+ "WHERE statusconfiguracion = ?";
	private static final String SQL_UPDATE = "UPDATE "
			+ "CONFIGURACIONES "
			+ "SET cycleconfiguracion = ?, statusconfiguracion = ? "
			+ "WHERE idconfiguracion = ?";

	private static final Conexion cnn = Conexion.crearConexion();

	@Override
	public int insertar(ConfiguracionesDTO objetoNuevo) throws BussinessException {
		int retorno = -1;
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = cnn.getCnn().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, objetoNuevo.getCycleconfiguracion());
			if (ps.executeUpdate() > 0) {
				rs = ps.getGeneratedKeys();
				if (rs != null && rs.next()) {
					retorno = rs.getInt(1);
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			cnn.cerrarConexion();
		}
		return retorno;
	}

	@Override
	public boolean actualizar(ConfiguracionesDTO objetoAntiguo, ConfiguracionesDTO objetoActualizar)
			throws BussinessException {
		boolean retorno = false;
		PreparedStatement ps;
		try {
			ps = cnn.getCnn().prepareStatement(SQL_UPDATE);
			ps.setString(1, objetoActualizar.getCycleconfiguracion());
			ps.setInt(2, objetoActualizar.getStatusconfiguracion());
			ps.setInt(3, objetoAntiguo.getIdconfiguracion());
			if (ps.executeUpdate() > 0) {
				retorno = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			cnn.cerrarConexion();
		}
		return retorno;
	}

	@Override
	public boolean borrar(ConfiguracionesDTO objetoBorrar) throws BussinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ConfiguracionesDTO> consultarTodo() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfiguracionesDTO consultarUno(Object primaryKey) throws BussinessException {
		PreparedStatement ps;
		ResultSet rs;
		ConfiguracionesDTO objetoDTO = new ConfiguracionesDTO();
		try {
			ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
			ps.setInt(1, Integer.parseInt(primaryKey.toString()));
			rs = ps.executeQuery();
			if (rs.next()) {
				objetoDTO.setIdconfiguracion(rs.getInt(1));
				objetoDTO.setCycleconfiguracion(rs.getString(2));
				objetoDTO.setStatusconfiguracion(rs.getInt(3));
			}
			return objetoDTO;
		} catch (SQLException ex) {
			Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ConfiguracionesDTO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			cnn.cerrarConexion();
		}
		return objetoDTO;
	}

	@Override
	public ConfiguracionesDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ConfiguracionesDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo)
			throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ConfiguracionesDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1,
			Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ConfiguracionesDTO> selectPrograma() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ConfiguracionesDTO> selectPlan(String filtro) throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
