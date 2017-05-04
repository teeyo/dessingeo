package metier;

import java.io.Serializable;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public abstract class Figure implements Serializable{
	
	//____une figure se définit par x points
    protected Point[] points;
    protected boolean selected;
    protected Color couleurContour=Color.BLACK;
    protected Color couleurRemplissage=Color.BLUE;
    
    //____Les méthodes abstraites
    public abstract void dessiner(Graphics g);
    public abstract double getSurface();
    public abstract double getPerimetre();
    public abstract double distanceAuCentre(Point p);
    
    public void selectionner(){
        selected=true;
    }
    public void deSelectionner(){
        selected=false; 
    }
    public boolean isSelected() {
        return selected;
     }
     public void setSelected(boolean selected) {
        this.selected = selected;
     }
     public Color getCouleurContour() {
        return couleurContour;
     }
     public void setCouleurContour(Color couleurContour) {
        this.couleurContour = couleurContour;
     }
     public Color getCouleurRemplissage() {
        return couleurRemplissage;
     }
     public void setCouleurRemplissage(Color couleurRemplissage) {
        this.couleurRemplissage = couleurRemplissage;
     }

}
