package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Alumno;
import clases.Asignatura;
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
				
				
				matricula.setAlumno(alumnoModelo.selectAlumno(rs.getInt("id_alumno")));
				matricula.setAsignatura(asignaturaModelo.selectAsignatura(rs.getInt("id_asignatura")));
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
		
		Matricula matricula = new Matricula(); 
		AlumnoModelo alumnoModelo = new AlumnoModelo(); 
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo(); 
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from matricula where id_alumno = ?");	
			pst.setInt(1, id_alumno);
			ResultSet rs = pst.executeQuery(); 
			
			if(rs.next()){
				
				
				matricula.setAlumno(alumnoModelo.selectAlumno(rs.getInt("id_alumno")));
				matricula.setAsignatura(asignaturaModelo.selectAsignatura(rs.getInt("id_asignatura"))); 
				matricula.setFecha(rs.getDate("fecha"));
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return matricula;
		
	}
	
	public ArrayList<Matricula> getAlumnoconAsignaturas(Alumno alumno){
		
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo(); 
		
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from matricula where id_alumno = ?");
			pst.setInt(1, alumno.getId());
			ResultSet rs = pst.executeQuery(); 
			
			while(rs.next()){
				Matricula matricula = new Matricula(); 
				matricula.setFecha(rs.getDate("fecha"));
				matricula.setAsignatura(asignaturaModelo.selectAsignatura(rs.getInt("id_asignatura")));
				
				matriculas.add(matricula); 
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return matriculas; 
		
	}
	
public ArrayList<Matricula> getAsignaturaconAlumnos(Asignatura asignatura){
		
		AlumnoModelo alumnoModelo = new AlumnoModelo(); 
	
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from matricula where id_asignatura = ?");
			pst.setInt(1, asignatura.getId());
			ResultSet rs = pst.executeQuery(); 
			
			while(rs.next()){	
				Matricula matricula = new Matricula(); 
				matricula.setFecha(rs.getDate("fecha"));
				matricula.setAlumno(alumnoModelo.selectAlumno(rs.getInt("id_alumno")));
				
				matriculas.add(matricula); 
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return matriculas; 
		
	}
	
}

