package cl.pruebafinal.servicios;

import java.util.List;
import java.util.Map;

import pruebafinal.models.Alumno;
import pruebafinal.models.Materia;

public interface AlumnoServicio {
	void crearAlumno(Alumno alumno);
	void agregarMateria(String rutAlumno, Materia nuevaMateria);
	List<Materia>materiasPorAlumno(String rutAlumno);
	Map<String, Alumno> listarAlumnos();
}
