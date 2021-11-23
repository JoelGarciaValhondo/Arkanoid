package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {
	
	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	
	Bola bola1 = new Bola(10, 10, Color.BLUE);
	Cursor miCursor = new Cursor(0, 400, 60, 10, Color.GREEN);
	
	public void init(){
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
	}
	
	public void run(){
		creaPiramide();
		while(true){
			bola1.muevete(this); //paso el objeto arkanoid  que se est� ejecutando
			pause(5);
			//el cursor sigue a la bola con la siguiente linea de codigo
			miCursor.muevete(getWidth(), (int)bola1.getX());
		}
	}//run
	
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(getWidth(), evento.getX()); 
	}
	
	private void creaPiramide(){
		int numeroLadrillos = 14;
		for(int j=0; j < numeroLadrillos; j++){
			for(int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j, ALTO_LADRILLO*j, ANCHO_LADRILLO, ALTO_LADRILLO, Color.BLUE);
			                                     //pos x                                //pos y           //ancho         //alto
				add(miLadrillo);
			}
		}
	}//creaPiramide
	
}//GraphicsProgram