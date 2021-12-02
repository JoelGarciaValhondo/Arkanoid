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
		texto.setColor(Color.MAGENTA);
		//la fuente en windows 11 no funciona, pero debería funcionar en windows 10
		//si está instalada en el sistema operativo, lo viste en clase Jorge(problema de windows 11).
		//Además, es la fuente con los números de Arkanoid incluidos(Se llama iomanoid, ves el zip en el java build path).
		texto.setFont(new Font("Iomanoid", Font.BOLD, 30));
		
	}

	//suma el nº de puntos que se indica en la variable puntos 
	//a la puntuacion actual.
	public void incrementaMarcador(int puntos){
		//Para que en los siguientes niveles aumente 2 o 3 puntos, dependiendo del nivel.
		if(puntuacion <= 66){
			puntuacion = puntuacion + puntos;
		}
		if(puntuacion > 66 && puntuacion <= 177){
			puntuacion = puntuacion + puntos*2;
		}
		if(puntuacion > 177){
			puntuacion = puntuacion + puntos*3;
		}
		texto.setLabel("Marcador = " + puntuacion);
	}
	
	//void para añadir el marcador.
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() - 100, 20);
		arkanoid.add(texto, arkanoid.getWidth() - 260, 40);
	}
	
	
}
