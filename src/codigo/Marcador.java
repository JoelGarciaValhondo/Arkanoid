package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{

	GLabel texto = new GLabel("");
	int puntuacion = 0;
	
	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		texto.setLabel("Marcador = ");
		texto.setColor(Color.WHITE);
		//la fuente en windows 11 no funciona, pero deber�a funcionar en windows 10
		//si est� instalada en el sistema operativo, lo viste en clase Jorge(problema de windows 11).
		//Adem�s, es la fuente con los n�meros de Arkanoid incluidos(Se llama iomanoid).
		texto.setFont(new Font("Iomanoid", Font.BOLD, 30));
		
	}

	//suma el n� de puntos que se indica en la variable puntos 
	//a la puntuacion actual.
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos; 
		texto.setLabel("Marcador = " + puntuacion);
	}
	
	//void para a�adir el marcador.
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() - 100, 20);
		arkanoid.add(texto, arkanoid.getWidth() - 260, 40);
	}
}
