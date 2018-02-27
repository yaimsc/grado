package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Alumno;
import clases.Asignatura;
import clases.Matricula;

public class AsignaturaModelo extends Conector{
	
	
	public Asignatura selectAsignatura (int id){
		
			
			try {
				
				PreparedStatement pst = super.conexion.prepareStatement("select * from asignatura where id = ?");	
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery(); 
				
				if(rs.next()){
					
					Asignatura asignatura = new Asignatura(); 
					 asignatura.setId(rs.getInt("id")); 
					 asignatura.setNombre(rs.getString("nombre"));
					 asignatura.setHoras(rs.getInt("horas"));
					 
					 return asignatura;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return null; 
			
		}
	
	public ArrayList<Asignatura> getAsignaturaAlumnos (){
	
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>(); 
		MatriculaModelo matriculaModelo = new MatriculaModelo(); 
	
		
		try {
		
			PreparedStatement pst = super.conexion.prepareStatement("select * from asignatura");
			ResultSet rs = pst.executeQuery();
		
			while(rs.next()){
				Asignatura asignatura = new Asignatura(); 	
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas")); 
				ArrayList<Matricula> matriculas = matriculaModelo.getAsignaturaconAlumnos(asignatura); 
				asignatura.setMatriculas(matriculas);
				
				asignaturas.add(asignatura); 
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return asignaturas; 
			
	}

}


