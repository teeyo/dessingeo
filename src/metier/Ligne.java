package metier;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Ligne extends Figure{
	
	public Ligne(Point p1, Point p2){
		points = new Point[2];
		points[0] = p1;
		points[1] = p2;
	}
	@Override
	public void dessiner(Graphics g) {
		g.setColor(this.couleurRemplissage);
		g.drawLine(points[0].getX(), points[0].getY(), points[1].getX(), points[1].getY());
		if (this.isSelected()){
			g.setColor(Color.black);
			g.drawLine(points[0].getX(), points[0].getY()-1, points[1].getX(), points[1].getY()-1);
			g.drawLine(points[0].getX(), points[0].getY()+1, points[1].getX(), points[1].getY()+1);
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
		int L = points[0].getX() - points[1].getX();
		Point centre;
		if (L > 0){
			centre = new Point(points[0].getX(), points[0].getY());
			return centre.distance(p);
		}else{
			centre = new Point(points[1].getX(), points[1].getY());
			return centre.distance(p);
		}
	}

}
