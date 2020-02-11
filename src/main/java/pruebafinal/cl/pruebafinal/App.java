package pruebafinal.cl.pruebafinal;

import java.util.ArrayList;
import java.util.List;

import pruebafinal.models.AlumnoMateria;
import pruebafinal.models.Calificacion;
import pruebafinal.utils.CsvUtils;
import pruebafinal.utils.Menu;
import pruebafinal.utils.CalificacionUtils;

/**
 *
 */
public class App 
{
	public static List<AlumnoMateria> alumnoMaterias = new ArrayList<>();
//	public static CalificacionUtils calificacionUtils = new CalificacionUtils();
	public static Menu menu = new Menu();
    public static void main( String[] args )
    {

        menu.iniciarMenu();
//        System.out.println(alumnoMaterias.size());

     
//        calificacionUtils.mostrarCalificaciones(calificaciones, "17.423.112-4");

    }
    

}
