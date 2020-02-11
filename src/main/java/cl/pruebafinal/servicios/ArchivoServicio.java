package cl.pruebafinal.servicios;

import java.util.List;
import java.util.Map;

import pruebafinal.models.Alumno;
import pruebafinal.models.Materia;

public interface ArchivoServicio {
	List<Alumno> cargarDatos(String ruta);
	void exportarDatos(Map<String,Alumno> alumnos, String ruta);
	Alumno setDatosAlumno(String rut,String nombre);
	Materia setDatosMateria(String Nombre);
}
