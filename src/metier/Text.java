package metier;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Text extends Figure{
	
	String nom , txt;
	int taille;
	Font font;
	int style;
	
	public Text(Point p , String t, String n, int ta, int s){
		points = new Point[1];
		points[0] = p;
		txt = t;
		nom = n;
		taille = 10+((ta+1)*4);
		style = s;
		switch (style){
		case 0 :
			font = new Font(nom, Font.PLAIN, taille);
			break;
		case 1 : 
			font = new Font(nom, Font.BOLD, taille);
			break;
		case 2 :
			font = new Font(nom, Font.ITALIC, taille);
			break;
		}
	}
	
	@Override
	public void dessiner(Graphics g) {
		g.setColor(couleurRemplissage);
		g.setFont(font);
		g.drawString(txt, points[0].getX(), points[0].getY());
		if (this.isSelected()){
			g.setColor(Color.black);
			g.drawLine(points[0].getX(), points[0].getY()+1, points[0].getX()+txt.length(), points[0].getY()+1);
		}
	}
	
	@Override
	public double getSurface() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distanceAuCentre(Point p) {
		return points[0].distance(p);
	}

}
