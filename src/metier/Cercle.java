package metier;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Cercle extends Figure implements Serializable{

	private double rayon;
	
	public Cercle(Point p, double rayon) {
        points = new Point[1];
        points[0] = p;
        this.rayon = rayon;
    }
	
	public Cercle(Point c, Point p) {
        points = new Point[2];
        points[0] = c;
        points[1] = p;
        this.rayon = c.distance(p);
    }
	
	
	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	@Override
	public void dessiner(Graphics g) {		
		int x1=(int)(points[0].getX()-rayon);
		int y1=(int)(points[0].getY()-rayon);
		g.setColor(couleurRemplissage);
		g.fillOval(x1, y1, (int)(2*rayon),(int)(2*rayon));
		g.setColor(couleurContour);
		g.drawOval(x1, y1, (int)(2*rayon),(int)(2*rayon));
		if(this.isSelected()==true){
			g.setColor(Color.black);
			g.drawOval(x1-2, y1-2, (int)(2*rayon)+4,(int)(2*rayon)+4);
	        }  	
	}

	@Override
	public double getSurface() {
		return Math.PI*rayon*rayon;
	}

	@Override
	public double getPerimetre() {
		return 2*Math.PI*rayon;
	}

	@Override
	public double distanceAuCentre(Point p) {
		double distance=points[0].distance(p);
		return distance;
	}

	@Override
    public String toString() {
        return "Cercle | centre : (" + points[0] + ") | rayon : " + rayon ;
    }
}
