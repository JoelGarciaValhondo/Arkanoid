package codigo;

import java.awt.Color;
import java.awt.Image;

import acm.graphics.GImage;

public class Cursor extends GImage{

	
	public Cursor(String name, double x, double y) {
		super(name, x, y);
	}

	//void para que se mueva el cursor
	public void muevete(int anchoPantalla, int posX){
		if(posX + getWidth() < anchoPantalla){
			setLocation(posX, getY());
	}	
}
}//GRect

