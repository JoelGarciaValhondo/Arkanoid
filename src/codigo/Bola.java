package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx = 1; //velocidad eje x
	int dy = 1; //velocidad eje y
	
	public Bola(double width, double height) {
		super(width, height);
	}
	public Bola(double width, double height, Color c) {
		super(width, height);
		setFillColor(c);
		setFilled(true);
	}
	
	public void muevete(Arkanoid ark){
		//rebote con el suelo y el techo
		if(getY() > ark.getHeight() || getY() < 10){
			dy = dy* -1;
		}
		//rebote con la pared derecha e izquierda
		if(getX() + getWidth() > ark.ANCHO_PANTALLA - 30 || getX() < 10){
			dx = dx* -1;
		}
		
		//chequeo la esquina izquierda de la bola
		if(chequeaColision(getX(), getY(), ark)){
			if(chequeaColision(getX() + getWidth(), getY(), ark)){
				if(chequeaColision(getX(), getY() + getHeight(), ark)){
					if(chequeaColision(getX() + getWidth(), getY() + getHeight(), ark)){
						
					}
				}
			}
		}
		
		
		//mueve la bola en la direccion correcta
		this.move(dx, dy);
	}
	
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;
		auxiliar = ark.getElementAt(posx, posy);
		int random = 1;//int para hacer que los ladrillos se rompan o no (randomizador más abajo).
		
		if(auxiliar == ark.miCursor){ //si entra aquí es que choca con el cursor
			dy *= -1;
			noHaChocado = false;
		}else if (auxiliar == null){ //si vale null es que no ha habia nada ahi
			
		}else if(auxiliar instanceof Ladrillo){//si es un ladrillo
			if(auxiliar.getX() >= posx || auxiliar.getX() <= posx){
				dx *= -1;
			}
			if(auxiliar.getY() >= posy || auxiliar.getY() <= posy){
				dy *= -1;
			}
			//randomizador que dice si se rompe o no cada ladrillo.
			if(random < Math.random()*4){
				ark.miMarcador.incrementaMarcador(1);
				ark.remove(auxiliar);//borro ladrillo
			}
			
			
			noHaChocado = false;
		}
		
		return noHaChocado;
	}
	
}//GOval
