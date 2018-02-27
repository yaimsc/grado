package vista;

import modelo.AsignaturaModelo;

public class AsignaturaVista {
	
	public void buscarAsignatura(int id){
		
		AsignaturaModelo asignatura = new AsignaturaModelo(); 
		asignatura.selectAsignatura(id); 
	}

}
