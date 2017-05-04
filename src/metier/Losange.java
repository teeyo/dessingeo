package metier;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Losange extends Figure{
	
	public Losange(Point p1, Point p2, Point p3 , Point p4){
		points = new Point[4];
		points[0] = p1;
		points[1] = p2;		
		points[2] = p3;
		points[3] = p4;
	}
	@Override
	public void dessiner(Graphics g) {
       int[] polX = {points[0].getX(),points[1].getX(),points[2].getX(),points[3].getX()};
       int[] polY = {points[0].getY(),points[1].getY(),points[2].getY(),points[3].getY()};
       g.setColor(couleurRemplissage);
       g.fillPolygon(polX, polY, 4);
       g.setColor(couleurContour);
       g.drawPolygon(polX, polY, 4);
       if(selected==true) {
    	   g.setColor(Color.black);
    	   int[] polx = {points[0].getX()+2,points[1].getX()+2,points[2].getX()+2,points[3].getX()+2};
           int[] poly = {points[0].getY()+2,points[1].getY()+2,points[2].getY()+2,points[3].getY()+2};
    	   g.drawPolygon(polx, poly, 4);
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
