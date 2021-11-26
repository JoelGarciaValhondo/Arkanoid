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
		
		if(auxiliar == ark.miCursor){ //si entra aquí es que choca con el cursor
			dy = dy* -1;
			noHaChocado = false;
		}else if (auxiliar == null){ //si vale null es que no ha habia nada ahi
			
		}else if(auxiliar instanceof Ladrillo){//si es un ladrillo
			if(auxiliar.getY() + getHeight() == posy || auxiliar.getY() == posy){
				dy = dy* -1;
			}
			else if(auxiliar.getX() + getWidth() == posx || auxiliar.getX() == posx){
				dx = dx* -1;
			}
			ark.miMarcador.incrementaMarcador(1);
			ark.remove(auxiliar);//borro ladrillo
			noHaChocado = false;
		}
		
		return noHaChocado;
	}
	
}//GOval
