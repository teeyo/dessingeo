package metier;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Point implements Serializable{

	private int x , y ;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y ;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point p)
    {
        int a = p.x - this.x;
        int b = p.y - this.y;
        return (Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
    }
	
}
