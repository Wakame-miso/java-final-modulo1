package pruebafinal.models;

public class AlumnoMateria {
	Alumno alumno;
	Materia materia;
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public AlumnoMateria(Alumno alumno, Materia materia) {
		super();
		this.alumno = alumno;
		this.materia = materia;
	}
	@Override
	public String toString() {
		return "AlumnoMateria [alumno=" + alumno.getNombre() + ", materia=" + materia.getNombre() + "]";
	}
	
}
