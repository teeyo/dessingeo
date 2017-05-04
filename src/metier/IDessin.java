package metier;

import java.awt.Graphics;

public interface IDessin {
	
	public void addFigure(Figure f);
    public Figure getFigurePlusProche(Point p);
    public void dessiner(Graphics g);
    public void afficher();
    public void supprimer(Figure f);
    public void enregistrer(String path);
    public Dessin charger(String path);
}
