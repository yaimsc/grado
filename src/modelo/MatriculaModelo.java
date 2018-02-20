package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import clases.Matricula; 


public class MatriculaModelo extends Conector{
	
	public ArrayList<Matricula> selectAll(){
		
	
		ArrayList <Matricula> matriculas = new ArrayList<Matricula>(); 
		
		AlumnoModelo alumnoModelo = new AlumnoModelo(); 
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		
		
		
		try {
		
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from matricula"); 
			
			while(rs.next()){
				Matricula matricula = new Matricula(); 
				
				//matricula.setAlumno(alumnoModelo.getAlumno(rs.getInt("id_alumno")));
				matricula.setId_alumno(rs.getInt("id_alumno"));
				matricula.setId_asignatura(rs.getInt("id_asignatura"));
				matricula.setFecha(rs.getDate("fecha"));
				
				matriculas.add(matricula); 
				
			}
			
			return matriculas; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return matriculas; 
		
	}
	
	public Matricula selectPorId (int id_alumno){
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from matricula where id_alumno = ?");	
			pst.setInt(1, id_alumno);
			ResultSet rs = pst.executeQuery(); 
			
			if(rs.next()){
				Matricula matricula = new Matricula(); 
				
				//matricula.getId_alumno(rs.getInt("id_alumno")); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}

