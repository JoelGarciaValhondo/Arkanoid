package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 44;
	static final int ALTO_LADRILLO = 20;
	static final int ANCHO_PANTALLA = 520;
	
	Bola bola1 = new Bola(10, 10, Color.WHITE);
	Cursor miCursor = new Cursor(0, 400, 60, 10, Color.BLACK);
	
	GImage historia = new GImage ("imagenes/historia.jpg");
	GImage fondo = new GImage("imagenes/fondo.png");
	GRect fondoMarcador = new GRect(300, 600);
	Marcador miMarcador = new Marcador(20, 40);
	
	public void init(){
		add(historia);//añade la imagen de antes de empezar.
		waitForClick();//espera hasta q le des un click.
		remove(historia);//quita la imagen al hacer click.
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA- 30,0);
		add(fondo);//añade el fondo
		addMouseListeners();
		add(bola1, 50, 100);//añade la bola.
		add(miCursor);//añade el cursor.
		setSize(ANCHO_PANTALLA + 300 ,500);//añade tamaño pantalla.
	}
	
	public void run(){
		creaPiramide();//creamos la pirámide de ladrillos.
		miMarcador.addMarcador(this);//creamos el marcador.
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando.
			pause(5);
			miCursor.muevete(ANCHO_PANTALLA - 30, (int) bola1.getX());
		}
	}
	
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}
	
	
	//creamos el void de la piramide de ladrillos.
	private void creaPiramide(){
		int numeroLadrillos = 11;
		int desplazamiento_inicial_X = 12;
		int desplazamiento_inicial_Y = 15;
		
		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				LadrilloGimage miLadrillo = new LadrilloGimage("imagenes/ladrillo.jpg");
				
				add(miLadrillo, ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						ALTO_LADRILLO*j + desplazamiento_inicial_Y);
			}
		}
	}
	
	
}