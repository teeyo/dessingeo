package metier;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Rectangle extends Figure implements Serializable{
	
	//____constructeur
    public Rectangle(Point p1, Point p2){
        points = new Point[2];
        points[0] = p1;
        points[1] = p2;
    }
	
	@Override
	public void dessiner(Graphics g) {
		int L=points[1].getX()-points[0].getX();
        int H=points[1].getY()-points[0].getY();
        g.setColor(couleurRemplissage);
        if (L < 0 || H < 0 ){
        	g.fillRect(points[1].getX(), points[1].getY(), Math.abs(L),Math.abs(H));
        	g.setColor(couleurContour);
        	g.drawRect(points[1].getX(), points[1].getY(), Math.abs(L),Math.abs(H));
        	if(selected==true) {
        		g.setColor(Color.black);
                g.drawRect(points[1].getX(), points[1].getY(), Math.abs(L) , Math.abs(H));
            }
        }else{
        	g.fillRect(points[0].getX(), points[0].getY(), L, H);
        	g.setColor(couleurContour);
        	g.drawRect(points[0].getX(), points[0].getY(), L , H);
        	if(this.isSelected()==true) {
        		g.setColor(Color.black);
                g.drawRect(points[0].getX()-2, points[0].getY()-2, L+4,H+4);
            }
        }
        		
	}

	@Override
	public double getSurface() {
		 int L=points[1].getX()-points[0].getX();
	     int H=points[1].getY()-points[0].getY();
	     return Math.abs(L*H);
	}

	@Override
	public double getPerimetre() {
		int L=points[1].getX()-points[0].getX();
		int H=points[1].getY()-points[0].getY();
		return Math.abs(2*(L+H));
	}

	@Override
	public double distanceAuCentre(Point p) {
		int L=points[1].getX()-points[0].getX();
		int H=points[1].getY()-points[0].getY();
		int xc=points[0].getX()+Math.abs(L)/2;int yc=points[0].getY()+Math.abs(H)/2;
		Point centre=new Point(xc,yc);
		double distance=centre.distance(p);
		return distance;
	}
	
	@Override
    public String toString() {
        return "Rectangle | 1er point :  " + points[0] +" | 2ème point : "+ points[1];
    }

}
