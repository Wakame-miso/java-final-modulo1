package pruebafinal.utils;

public class Utilidad {

	public void limpiarPantalla() {
		for (int i = 0; i < 20; i++) {
			System.out.println("");
		}
	}

	public void printLine(String menuDetalle) {
		System.out.println("---------------------------------------------" + menuDetalle);
	}

}
