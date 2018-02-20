package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clases.Asignatura;

public class AsignaturaModelo extends Conector{
	
	
	public Asignatura getAsignatura (int id){
		
		Asignatura asignatura = new Asignatura(); 
			
			try {
				
				PreparedStatement pst = super.conexion.prepareStatement("select * from asignatura where id = ?");	
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery(); 
				
				if(rs.next()){
				
					 asignatura.setId(rs.getInt("id")); 
					 asignatura.setNombre(rs.getString("nombre"));
					 asignatura.setHoras(rs.getInt("horas"));
					 
					 return asignatura; 
	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			return asignatura;
			
		}
			

			
	}


