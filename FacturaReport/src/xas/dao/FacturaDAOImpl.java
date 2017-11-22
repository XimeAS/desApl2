package xas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xas.model.Factura;

public class FacturaDAOImpl implements FacturaDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public FacturaDAOImpl() {
		getConnection();
	}
	
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/tesdb","utng","mexico");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

	@Override
	public void createFactura(Factura factura) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("INSERT INTO factura (proveedor, fecha, importe, empleado)"+" values(?,?,?,?);");
				
				
				preparedStatement.setString(1,factura.getProveedor());
				preparedStatement.setString(2,factura.getFecha());
				preparedStatement.setFloat(3,factura.getImporte());
				preparedStatement.setString(4,factura.getEmpleado());
				
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Factura readFactura(Long id) {
		Factura factura =null;
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM factura WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet= preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					factura = new Factura(
					resultSet.getLong(1),
					resultSet.getString(2),
					resultSet.getString(3),
					resultSet.getFloat(4),
					resultSet.getString(5)
					);
				}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return factura;
		
	}

	@Override
	public List<Factura> readAllFacturas() {
		List<Factura> facturas =new ArrayList<Factura>();
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM factura");
				resultSet= preparedStatement.executeQuery();
				
			while(resultSet.next()) {
			Factura factura= new Factura(
					resultSet.getLong(1),
					resultSet.getString(2),
					resultSet.getString(3),
					resultSet.getFloat(4),
					resultSet.getString(5)
					);
			facturas.add(factura);
			}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return facturas;
	}

	@Override
	public void updateFactura(Factura factura) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("UPDATE factura SET proveedor=?, fecha=?, importe=?, empleado=? WHERE id=?;");
				preparedStatement.setString(1,factura.getProveedor());
				preparedStatement.setString(2,factura.getFecha());
				preparedStatement.setFloat(3,factura.getImporte());
				preparedStatement.setString(4,factura.getEmpleado());
				preparedStatement.setLong(5,factura.getId());
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}	
		
	}
	
	@Override
	public void deleteFactura(Long id) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("DELETE FROM factura WHERE id=?;");
				
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}	
	}

}