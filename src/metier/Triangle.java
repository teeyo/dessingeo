package metier;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Triangle extends Figure{
	
	public Triangle(Point p1, Point p2, Point p3){
		points = new Point[3];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
	}
	
	@Override
	public void dessiner(Graphics g) {
		 int[] polX = {points[0].getX(),points[1].getX(),points[2].getX()};
	       int[] polY = {points[0].getY(),points[1].getY(),points[2].getY()};
	       g.setColor(couleurRemplissage);
	       g.fillPolygon(polX, polY, 3);
	       g.setColor(couleurContour);
	       g.drawPolygon(polX, polY, 3);
	       if(selected==true) {
	    	   g.setColor(Color.black);
	    	   int[] polx = {points[0].getX()+2,points[1].getX()+2,points[2].getX()+2};
	           int[] poly = {points[0].getY()+2,points[1].getY()+2,points[2].getY()+2};
	    	   g.drawPolygon(polx, poly, 3);
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
		// TODO Auto-generated method stub
		return 0;
	}

}
