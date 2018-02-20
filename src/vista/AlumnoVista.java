package vista;

import modelo.AlumnoModelo;

public class AlumnoVista {

	
	public void buscarAlumno(int id){
		AlumnoModelo alumnoModelo = new AlumnoModelo(); 
		alumnoModelo.getAlumno(id); 
	}
}
