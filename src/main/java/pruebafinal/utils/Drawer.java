package pruebafinal.utils;

public class Drawer {
	public void DibujarLista(String[] opciones) {

		for (int i = 0; i < opciones.length; i++) {
			System.out.printf("%d. %s%n", i + 1, opciones[i]);
		}
	}
}
