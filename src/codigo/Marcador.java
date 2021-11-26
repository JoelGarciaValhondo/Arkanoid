package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{

	GLabel texto = new GLabel("");
	//puntuación inicial
	int puntuacion = 0;
	
	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		texto.setLabel("0");
		texto.setColor(Color.WHITE);
		texto.setFont(new Font("Arial", Font.BOLD, 18)); //Importar fuente arkanoid a acm y cambiarlo aqui.
	}

	//suma el numero de puntos que se indica en puntos a la puntuación.
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos; //puntuacion += puntos; esta es la forma correcta.
		texto.setLabel("" + puntuacion);
	}
	
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() - 100, 20);
		arkanoid.add(texto, arkanoid.getWidth() - 100, 40);
	}
	
}
