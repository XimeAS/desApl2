package xas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xas.model.PromEdu;

public class PromEduDAOImpl implements PromEduDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public PromEduDAOImpl() {
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
	public void createPrograma(PromEdu programa) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("INSERT INTO programa (numero_alumnos, carrera, edificio)"+" values(?,?,?);");
				
				preparedStatement.setLong(1,programa.getNumeroalumnos());
				preparedStatement.setString(2,programa.getCarrera());
				preparedStatement.setString(3,programa.getEdificio());
				
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public PromEdu readPrograma(Long id) {
		PromEdu programa =null;
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM programa WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet= preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					programa = new PromEdu(
					resultSet.getLong(1),
					resultSet.getInt(2),
					resultSet.getString(3),
					resultSet.getString(4)
					);
				}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return programa;
		
	}

	@Override
	public List<PromEdu> readAllProgramas() {
		List<PromEdu> programas =new ArrayList<PromEdu>();
		if(connection!= null) {
			try {
				preparedStatement= connection.prepareStatement("SELECT * FROM programa");
				resultSet= preparedStatement.executeQuery();
				
			while(resultSet.next()) {
			PromEdu programa= new PromEdu(
					resultSet.getLong(1),
					resultSet.getInt(2),
					resultSet.getString(3),
					resultSet.getString(4)
							);
			programas.add(programa);
			}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return programas;
	}

	@Override
	public void updatePrograma(PromEdu programa) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("UPDATE programa SET numero_alumnos=?, carrera=?, edificio=? WHERE id=?;");
				preparedStatement.setInt(1,programa.getNumeroalumnos());
				preparedStatement.setString(2,programa.getCarrera());
				preparedStatement.setString(3,programa.getEdificio());
				preparedStatement.setLong(4,programa.getId());
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}	
		
	}
	
	@Override
	public void deletePrograma(Long id) {
		if(connection!=null) {
			try {
				preparedStatement= connection.prepareStatement("DELETE FROM programa WHERE id=?;");
				
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}	
	}

}