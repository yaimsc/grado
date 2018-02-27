package vista;

import java.util.ArrayList;

import clases.Asignatura;
import modelo.AlumnoModelo;

public class AlumnoVista {

	
	public void buscarAlumno(int id){
		AlumnoModelo alumnoModelo = new AlumnoModelo(); 
		alumnoModelo.selectAlumno(id); 
	}
	
	
	
}
