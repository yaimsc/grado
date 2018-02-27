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
	
	final static int MOSTRAR_MATRICULAS = 1; 
	final static int ALUMNOS_MATRICULAS = 2;
	final static int MATRICULAS_ALUMNOS = 3; 
	final static int ALUMNOS_HORAS = 4; 
	final static int SALIR = 0; 
	
	
	public void menuMatricula(){
		
		
		int opcion = 0;
		
		
		do{
			
			MatriculaModelo matriculaModelo = new MatriculaModelo(); 
			Scanner lector = new Scanner (System.in);
			
			//solo hay 1 en el menu
			System.out.println("------------MENU-----------");
			System.out.println(MOSTRAR_MATRICULAS + " listar matriculas");
			System.out.println(ALUMNOS_MATRICULAS + " listar alumnos con sus matriculas"); 
			System.out.println(MATRICULAS_ALUMNOS + " listar matriculas con sus alumnos");
			System.out.println(ALUMNOS_HORAS + " listar alumnos con las horas totales"); 
			
			opcion = Integer.parseInt(lector.nextLine()); 
			
			switch (opcion){
			
			case MOSTRAR_MATRICULAS:
				ArrayList <Matricula> matriculas = 	matriculaModelo.selectAll(); 
				this.mostrarMatriculas(matriculas); 
				break;
				
			case ALUMNOS_MATRICULAS: 
				AlumnoModelo alumnoModelo = new AlumnoModelo(); 
				ArrayList<Alumno> alumnos = alumnoModelo.getAlumnosAsignaturas(); 
				this.mostrarAlumnosAsignaturas(alumnos);
				break; 
				
			case MATRICULAS_ALUMNOS: 
				AsignaturaModelo asignaturaModelo = new AsignaturaModelo(); 
				ArrayList<Asignatura> asignaturas = asignaturaModelo.getAsignaturaAlumnos(); 
				this.mostarAsignaturasAlumnos(asignaturas);
			
			case ALUMNOS_HORAS: 
//				alumnos = alumnoModelo.getAlumnosAsignaturas(); 
//				this.mostrarAlumnosconHorasMatriculadas(alumno); 
					break;
				

			default:
				break;
			}
			
		}while( opcion != SALIR); 
		
	}

	public void mostrarMatricula(ArrayList<Matricula> matriculas){

		Iterator<Matricula> i = matriculas.iterator(); 
		
		while(i.hasNext()){
			
			Matricula matricula = i.next(); 
			
			System.out.println(matricula.getAlumno().getNombre() + " " + matricula.getAlumno().getDni() + " " +  matricula.getAlumno().getProvincia().getNombre() +  " " + matricula.getAsignatura().getNombre() + " " + matricula.getAsignatura().getHoras()); 
		}
		
		
	}
	
	
	public void mostrarMatriculas(ArrayList<Matricula> matriculas) {
		
		Iterator<Matricula> i = matriculas.iterator(); 
		
		while(i.hasNext()){
			Matricula matricula = i.next();
			mostrarMatricula(matriculas); 	
		}
		
	}
	
	public void mostrarAlumnosAsignaturas(ArrayList<Alumno> alumnos){
		
		MatriculaModelo matriculaModelo = new MatriculaModelo(); 
		
		//recorrer array de alumnos
		Iterator<Alumno> i = alumnos.iterator(); 
		
		while(i.hasNext()){
			Alumno alumno = i.next(); 
			System.out.println(alumno.getNombre() + " " + alumno.getDni() + " " + alumno.getProvincia().getNombre() + " : ");
		
			ArrayList<Matricula> matriculas = matriculaModelo.getAlumnoconAsignaturas(alumno); 
		
			//recorrer array de matriculas
			Iterator<Matricula> j = matriculas.iterator(); 
			while(j.hasNext()){
				Matricula matricula = j.next(); 
				System.out.println(matricula.getAsignatura().getNombre() + " " + matricula.getAsignatura().getHoras());
			}
		
		}
		
	}
	
	public void mostarAsignaturasAlumnos(ArrayList<Asignatura> asignaturas){
		
		MatriculaModelo matriculaModelo = new MatriculaModelo(); 
		
		Iterator<Asignatura> i = asignaturas.iterator(); 
		
		while(i.hasNext()){
			Asignatura asignatura = i.next(); 
			System.out.println(asignatura.getNombre() + " " + asignatura.getHoras() + " : ");
			
			ArrayList<Matricula> matriculas = matriculaModelo.getAsignaturaconAlumnos(asignatura); 
			
			//recorrer array de matriculas
			
			Iterator<Matricula> j = matriculas.iterator(); 
			while(j.hasNext()){
				Matricula matricula = j.next(); 
				System.out.println(matricula.getAlumno().getNombre() + " " + matricula.getAlumno().getDni() + " " + matricula.getAlumno().getProvincia().getNombre());
			} 
			
		}
	}
	
}
