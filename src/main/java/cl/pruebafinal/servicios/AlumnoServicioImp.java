package cl.pruebafinal.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pruebafinal.models.Alumno;
import pruebafinal.models.Materia;

public class AlumnoServicioImp implements AlumnoServicio {
	private Map<String,Alumno> listaAlumnos = new HashMap<>();
	@Override
	public void crearAlumno(Alumno alumno) {
		
		
	}

	@Override
	public void agregarMateria(String rutAlumno, Materia nuevaMateria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Materia> materiasPorAlumno(String rutAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Alumno> listarAlumnos() {
		// TODO Auto-generated method stub
		return listaAlumnos;
	}

}
