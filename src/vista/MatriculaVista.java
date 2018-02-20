package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import clases.Alumno;
import clases.Asignatura;
import clases.Matricula;
import modelo.AlumnoModelo;
import modelo.AsignaturaModelo;
import modelo.MatriculaModelo;
import vista.AlumnoVista;

public class MatriculaVista {

	//crear menu
	
	final static int LISTAR = 1; 
	final static int SALIR = 0; 
	
	
	public void menuMatricula(){
		
		
		int opcion = 0;
		
		
		do{
			
			MatriculaModelo matriculaModelo = new MatriculaModelo(); 
			Scanner lector = new Scanner (System.in);
			
			//solo hay 1 en el menu
			System.out.println("------------MENU-----------");
			System.out.println(LISTAR + " listar matriculas");
			
			opcion = Integer.parseInt(lector.nextLine()); 
			
			switch (opcion){
			
			case LISTAR:
			ArrayList <Matricula> matriculas = 	matriculaModelo.selectAll(); 
			this.mostrarMatriculas(matriculas); 
			
				break;

			default:
				break;
			}
			
		}while( opcion != SALIR); 
		
	}

	public void mostrarMatricula(Matricula matricula){
	
		//sacar la info de alumno y de asignatura
		AlumnoModelo alumnoModelo = new AlumnoModelo(); 
		Alumno alumno = alumnoModelo.getAlumno(matricula.getId_alumno()); 
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo(); 
		Asignatura asignatura = asignaturaModelo.getAsignatura(matricula.getId_asignatura()); 
		
		System.out.println(alumno.getNombre() + " " + alumno.getDni() + " : " + asignatura.getNombre() + " " + asignatura.getHoras());
		
		
	}
	
	
	public void mostrarMatriculas(ArrayList<Matricula> matriculas) {
		
		Iterator<Matricula> i = matriculas.iterator(); 
		
		while(i.hasNext()){
			Matricula matricula = i.next();
			mostrarMatricula(matricula); 	
		}
		
	}
	
}
