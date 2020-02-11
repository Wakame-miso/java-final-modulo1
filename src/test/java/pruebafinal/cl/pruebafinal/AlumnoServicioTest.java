package pruebafinal.cl.pruebafinal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import pruebafinal.models.Alumno;
import pruebafinal.models.Materia;
import pruebafinal.utils.AlumnoServicio;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@DisplayName("Crear Alumno")
public class AlumnoServicioTest {

	public static AlumnoServicio alumnoServicio;

	public static Materia matematicas;

	public static Materia lenguaje;

	public static Alumno mapu;

	public static AlumnoServicio alumnoServicioMock;
	
	public static Alumno alumno;
	
	public static List<Materia> materias;
	
	@BeforeAll
	public static void alumnoServicioMock() {
		alumnoServicio = mock(AlumnoServicio.class);
		materias = new ArrayList<Materia>();
		alumno = new Alumno("1", "Juanito", "Perez", "Calle 101", materias);
		alumnoServicio.crearAlumno(alumno);
	}
	


	@Test
	@DisplayName("Crear Alumno")
	public void crearAlumnoTest() {
	
		assertEquals("1", alumno.getRut());
		assertEquals("Juanito", alumno.getNombre());
		assertEquals("Perez", alumno.getApellido());
		assertEquals("Calle 101", alumno.getDireccion());
		assertEquals(materias, alumno.getMaterias());
		
	}
	
	@Test
	@DisplayName("Agregar Materia")
	public void agregarMateriaTest()
	{
		
//		alumnoServicio.agregarMateria("1", );
	}
	
	@Test
	@DisplayName("Materias por Alumno")
	public static void materiasPorAlumnosTest()
	{
		//alumnoServicio.materiasPorAlumnos(rutAlumno)();
	}
	
	@Test
	@DisplayName("Listar Alumnos")
	public static void listarAlumnosTest()
	{
		alumnoServicio.listarAlumnos();
	}
	
	
}
