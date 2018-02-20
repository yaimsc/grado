package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Alumno;
import clases.Matricula;

public class AlumnoModelo extends Conector{
	
	
	public Alumno getAlumno (int id){
		
		Alumno alumno = new Alumno(); 
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from alumno where id = ?");	
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery(); 
			
			if(rs.next()){
			
				 alumno.setId(rs.getInt("id")); 
				 alumno.setDni(rs.getString("dni"));
				 alumno.setNombre(rs.getString("nombre"));
				 alumno.setEmail(rs.getString("email"));
				 
				 return alumno; 

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return alumno;
		
	}
	
	
	

}
