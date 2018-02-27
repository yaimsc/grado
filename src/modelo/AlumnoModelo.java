package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import clases.Alumno;
import clases.Asignatura;
import clases.Matricula;
import clases.Provincia; 

public class AlumnoModelo extends Conector{
	
	
	public Alumno selectAlumno (int id){
		
		Alumno alumno = new Alumno(); 
		ProvinciaModelo provinciaModelo = new ProvinciaModelo(); 
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from alumnos where id = ?");	
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery(); 
			
			if(rs.next()){
			
				 alumno.setId(rs.getInt("id")); 
				 alumno.setDni(rs.getString("dni"));
				 alumno.setNombre(rs.getString("nombre"));
				 alumno.setEmail(rs.getString("email"));
				 alumno.setProvincia(provinciaModelo.selectProvincia(rs.getInt("id")));
				 
				 return alumno; 

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return alumno;
		
	}
	
	
	public ArrayList<Alumno> getAlumnosAsignaturas (){
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>(); 
		MatriculaModelo matriculaModelo = new MatriculaModelo(); 
		ProvinciaModelo provinciaModelo = new ProvinciaModelo(); 
	
		try {
			
		PreparedStatement pst = super.conexion.prepareStatement("select * from alumnos");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Alumno alumno = new Alumno();	
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setEmail(rs.getString("email"));
				alumno.setProvincia(provinciaModelo.selectProvincia(rs.getInt("id")));
				ArrayList<Matricula> matriculas = matriculaModelo.getAlumnoconAsignaturas(alumno); 
				alumno.setMatriculas(matriculas);
				
				alumnos.add(alumno); 
				
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos; 
		
		
		
		
		

		
	}
	
	
	

}
