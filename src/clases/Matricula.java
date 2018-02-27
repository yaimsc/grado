package clases;

import java.util.Date;

public class Matricula {
	
	
	//por la relacion
	protected Alumno alumno;
	protected Asignatura asignatura; 
	
	//atributo suyo propio
	protected Date fecha;
	
	
	/**
	 * @return the id_alumno
	 */
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	/**
	 * @param alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	/**
	 * @return the id_asignatura
	 */
	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	/**
	 * @param id_asignatura the id_asignatura to set
	 */
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
	

}
