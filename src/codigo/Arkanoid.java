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
	int vidas = 3;//Vidas iniciales
	
	Bola bola1 = new Bola(10, 10, Color.WHITE);
	Cursor miCursor = new Cursor("imagenes/barra-arkanoid.jpg", 0, 400);
	
	GImage fotoVidas = new GImage ("imagenes/vidas.jpg");
	GImage gameOver = new GImage ("imagenes/gameOver.jpg");
	GImage win = new GImage ("imagenes/win.jpg");
	GImage segundoNivel = new GImage ("imagenes/segundoNivel.jpg");
	GImage tercerNivel = new GImage ("imagenes/tercerNivel.jpg");
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
			pause(1);
            //Estos dos siguientes if, los niveles, creo que están mal configurados
			//y cuando encuentre la forma correcta de usarlos, los cambiaré.
			if(miMarcador.puntuacion == 66){
				add(segundoNivel);
				waitForClick();
				remove(segundoNivel);
				segundoNivel();
			}
			if(miMarcador.puntuacion == 177){
				add(tercerNivel);
				waitForClick();
				remove(tercerNivel);
				tercerNivel();
			}
			if(miMarcador.puntuacion == 443){
				add(win);
				waitForClick();
				remove(win);
			}
			vidasFinal();//Quita una vida
			//Cuando no queden vidas, game over.
			if(vidas == 0){
				add(gameOver);
			}
		}
	}
	
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}
	
	
	//creamos el void de la piramide de ladrillos. (Public para poder hacer segunda pirámide).
	public void creaPiramide(){
		int numeroLadrillos = 11;
		int desplazamiento_inicial_X = 12;
		int desplazamiento_inicial_Y = 15;
		
		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo("imagenes/ladrillo.jpg");
				
				add(miLadrillo, ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						ALTO_LADRILLO*j + desplazamiento_inicial_Y);
			}
		}
	}
	
	//SIGUENTES DOS VOID, SON LOS NIVELES.
	public void segundoNivel(){
		int numeroLadrillos = 11;
		int desplazamiento_inicial_X = 12;
		int desplazamiento_inicial_Y = 15;
		
		for(int p=0; p<5; p++){
			for(int x=0; x<numeroLadrillos; x++){
			Ladrillo miLadrillo = new Ladrillo("imagenes/ladrillo.jpg");
			add(miLadrillo, ANCHO_LADRILLO*x + desplazamiento_inicial_X, ALTO_LADRILLO*p + desplazamiento_inicial_Y);
			}
		}
		
	}
	
	public void tercerNivel(){
		int numeroLadrillos = 11;
		int desplazamiento_inicial_X = 12;
		int desplazamiento_inicial_Y = 15;
		
		for(int p=0; p<8; p++){
			for(int x=0; x<numeroLadrillos; x++){
			Ladrillo miLadrillo = new Ladrillo("imagenes/ladrillo.jpg");
			add(miLadrillo, ANCHO_LADRILLO*x + desplazamiento_inicial_X, ALTO_LADRILLO*p + desplazamiento_inicial_Y);
			}
		}
	}
	
	//Quitar 1 vida cada vez que toque abajo (empezamos con 3 vidas).
	public void vidasFinal(){
		if(bola1.getY() == 440){
			vidas = vidas - 1;
			add(fotoVidas);
			waitForClick();
			remove(fotoVidas);
			bola1.setLocation(50, 100);
		}		
	}
	
}//END