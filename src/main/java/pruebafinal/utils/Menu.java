package pruebafinal.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.pruebafinal.servicios.AlumnoServicioImp;
import cl.pruebafinal.servicios.ArchivoServicioImp;
import pruebafinal.utils.Utilidad;
//import pruebafinal.cl.pruebafinal.App;
import pruebafinal.models.Alumno;
//import pruebafinal.models.AlumnoMateria;
import pruebafinal.models.Calificacion;
import pruebafinal.models.Materia;
import pruebafinal.models.MateriaEnum;

//import static pruebafinal.utils.DataUtils.fabricaAlumno;

public class Menu extends MenuTemplate {
	AlumnoServicio alumnoServicio;
	ArchivoServicio archivoServicio;
	Scanner sc = new Scanner(System.in);
	List<Alumno> listaAlumnos = new ArrayList<>();
	List<Calificacion> calificaciones = new ArrayList<>();
	private Utilidad utilidad = new Utilidad();
	private AlumnoServicioImp alumnoServicioImp = new AlumnoServicioImp();
	private ArchivoServicioImp archivoServicioImp = new ArchivoServicioImp();

	@Override
	void cargarDatos() {
		utilidad.limpiarPantalla();
		utilidad.printLine("Cargar Datos");
		System.out.print("Ingresa la ruta en donde se encuentra el archivo notas.csv : ");
		String ruta = sc.nextLine();
		List<Alumno> alumnosACargar = archivoServicioImp.cargarDatos(ruta);
		alumnosACargar.forEach(alumno -> alumnoServicioImp.crearAlumno(alumno));
		System.out.println("Datos cargados correctamente.");
	}

//		System.out.println("------------------ Cargar Datos");
//		System.out.println("Ingresa la ruta en donde se encuentra el archivo notas.csv : ");
//		String ruta = sc.nextLine();
//		try {
//			calificaciones = CsvUtils.loadCSV(ruta);
//			listaAlumnos = fabricaAlumno();
//
//			for (Calificacion cal : calificaciones) {
//				for (Alumno alumno : listaAlumnos) {
//					if (cal.getRut().equals(alumno.getRut())) {
//						for (Materia materia : alumno.getMaterias()) {
//							if (materia.getNombre().name().equals(cal.getMateria())) {
//								materia.agregarNota(Double.parseDouble(cal.getNotas()));
//								App.alumnoMaterias.add(new AlumnoMateria(alumno,materia));
//								
//								
//
//							}
//
//						}
//
//					}
//				}
//
////				System.out.println(cal);
//				
//			}
//			iniciarMenu();
//		} catch (Exception e) {
//			e.getStackTrace();
//		}		
//	}

	@Override
	void exportarDatos() {
		utilidad.limpiarPantalla();
		utilidad.printLine("Exportar Datos");
		System.out.print("Ingresa la ruta en donde se exportará el archivo promedios.txt : ");
		String ruta = sc.nextLine();
		archivoServicioImp.exportarDatos(alumnoServicioImp.listarAlumnos(), ruta);
		System.out.println("Datos exportados correctamente.");
	}

	@Override
	void crearAlumno() {

		System.out.println("Ingresa RUT");
		String rut = sc.nextLine();
		System.out.println("Ingresa nombre:");
		String nombre = sc.nextLine();
		System.out.println("Ingresa apellido:");
		String apellido = sc.nextLine();
		System.out.println("Ingresa dirección:");
		String direccion = sc.nextLine();
		Alumno alumno = new Alumno(rut, nombre, apellido, direccion, new ArrayList<Materia>());
		listaAlumnos.add(alumno);
		iniciarMenu();
	}

	@Override
	void agregarMateria() {
		System.out.println("----------Agregar Materia");
		System.out.println("Ingresa RUT");
		String rut = sc.nextLine();
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getRut().equals(rut)) {
				System.out.println("1. " + MateriaEnum.MATEMATICAS);
				System.out.println("2. " + MateriaEnum.LENGUAJE);
				System.out.println("3. " + MateriaEnum.CIENCIA);
				System.out.println("4. " + MateriaEnum.HISTORIA);
				System.out.println("Selecciona una Materia: ");
				String materiaNum = sc.nextLine();
				switch (Integer.parseInt(materiaNum)) {
				case 1:
					Materia mate = new Materia(MateriaEnum.MATEMATICAS, null);
					alumno.getMaterias().add(mate);
					System.out.println("Materia Agregada");
					iniciarMenu();
					break;
				case 2:
					Materia leng = new Materia(MateriaEnum.LENGUAJE, null);
					alumno.getMaterias().add(leng);
					System.out.println("Materia Agregada");
					iniciarMenu();
					break;
				case 3:
					Materia ciencia = new Materia(MateriaEnum.CIENCIA, null);
					alumno.getMaterias().add(ciencia);
					System.out.println("Materia Agregada");
					iniciarMenu();
					break;
				case 4:
					Materia hist = new Materia(MateriaEnum.HISTORIA, null);
					alumno.getMaterias().add(hist);
					System.out.println("Materia Agregada");
					iniciarMenu();
					break;
				default:
					System.out.println("Selección incorrecta. Intente nuevamente");
					agregarMateria();
					break;
				}
			}
		}
	}

	@Override
	void agregarNotaPasoUno() {
		System.out.println("----------Agregar Nota");
		System.out.println("Ingresa rut del alumno: ");
		String rut = sc.nextLine();
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getRut().equals(rut)) {
				System.out.println("Alumno tiene las siguientes materias agregadas: ");
				int index = 1;
				for (Materia materia : alumno.getMaterias()) {
					System.out.println(index + ". " + materia.getNombre());
					index++;
				}
				System.out.println("Seleccionar Materia: ");
				String materiaNum = sc.nextLine();

				if (Integer.parseInt(materiaNum) <= alumno.getMaterias().size()) {
					System.out.println("Ingresar Nota: ");
					String nota = sc.nextLine();

					alumno.getMaterias().get(Integer.parseInt(materiaNum) - 1).getNotas().add(Double.parseDouble(nota));
					System.out.println("Nota agregada a "
							+ alumno.getMaterias().get(Integer.parseInt(materiaNum) - 1).getNombre());
					iniciarMenu();
				} else {
					System.out.println("Materia no disponible. Intente nuevamente");
					agregarNotaPasoUno();
					break;
				}

			}
		}

	}

	@Override
	void listarAlumnos() {
//Solucion PDF		
		utilidad.limpiarPantalla();
		utilidad.printLine("Listar Alumnos");
		alumnoServicioImp.listarAlumnos().entrySet().stream().forEach((alumno) -> {
			System.out.println("\nDatos Alumno");
			System.out.println("\tRUT: " + alumno.getValue().getRut() + "\n\tNombre: " + alumno.getValue().getNombre()
					+ "\n\tApellido: " + alumno.getValue().getApellido() + "\n\tDirección: "
					+ alumno.getValue().getDireccion());
			if (alumno.getValue().getMaterias() != null) {
				System.out.println("Materias");
				alumno.getValue().getMaterias().forEach(materia -> {
					System.out.println("\t" + materia.getNombre());
					if (materia.getNotas() != null) {
						System.out.println("\t\tNotas");
						System.out.println("\t\t" + materia.getNotas().toString());
					}
				});
			}
		});

//		System.out.printf("Datos Alumnos %n%n");
//		for (Alumno alumno : listaAlumnos) {
//			System.out.println("RUT: " + alumno.getRut());
//			System.out.println("Nombre: " + alumno.getNombre());
//			System.out.println("Apellido: " + alumno.getApellido());
//			System.out.printf("Dirección: " + alumno.getDireccion() + "%n%n");
//			// Mostrar materias...
//			System.out.println("Materias:");
//			for (Materia materia : alumno.getMaterias()) {
//				System.out.println(materia.nombre);
//				System.out.println("Notas:");
//				if (materia.getNotas() != null)
//					System.out.println(materia.getNotas());
//				else
//					System.out.println("No hay notas");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		iniciarMenu();
	}

	@Override
	void terminarPrograma() {
		utilidad.limpiarPantalla();
		utilidad.printLine("Adios");
		System.exit(0);
	}

	public void iniciarMenu() {
		dw.DibujarLista(new String[] { "Crear Alumnos", "Listar Alumnos", "Agregar Materias", "Agregar Notas",
				"Cargar Datos", "Exportar Datos", "Salir" });
		System.out.println("Seleccion:");

		String input = (sc.nextLine());
		switch (input) {
		case "1":

			crearAlumno();
			break;
		case "2":
			listarAlumnos();
			break;
		case "3":
			agregarMateria();
			break;
		case "4":
			agregarNotaPasoUno();
			break;
		case "5":
			cargarDatos();
			break;
		case "6":
			exportarDatos();
			break;
		case "7":
			System.exit(0);
		default:
			System.out.println("----------Selección no permitida--------\n");
			iniciarMenu();
			break;

		}

	}
}
