package metier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Dessin implements Serializable, IDessin {
	
	private List<Figure> figures=new ArrayList<Figure>();
	
	@Override
	public void addFigure(Figure f) {
		figures.add(f);	
	}

	public int getNombresFigures(){
		return figures.size();
	}
	@Override
	public Figure getFigurePlusProche(Point p) {
		double dMin=figures.get(1).distanceAuCentre(p);
		int index=1;
		for(int i=1;i<figures.size();i++) {
			figures.get(i).setSelected(false);
                if(figures.get(i).distanceAuCentre(p)<dMin){
                        dMin=figures.get(i).distanceAuCentre(p);
                        index=i;
                }
            }
		return figures.get(index);
	}

	@Override
	public void dessiner(Graphics g) {
		for(Figure f:figures) {
            f.dessiner(g);
        }
	}

	@Override
	public void afficher() {
		for(Figure f:figures) {
            System.out.println(f.toString());
        }
	}

	@Override
	public void supprimer(Figure f) {
		if (figures.size()>1){
			figures.remove(f);
		}
	}
	
	public void viderDessin(){
		figures.clear();
		Rectangle rec = new Rectangle(new Point(0, 0), new Point((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		rec.setCouleurContour(Color.WHITE);
		rec.setCouleurRemplissage(Color.WHITE);
		this.addFigure(rec);
	}
	
	@Override
	public void enregistrer(String path) {
		try
		{
		File f=new File(path+".dga");
		FileOutputStream fos= new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this); 
		oos.close();
		}
		catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void desselectionner(){
		for (int i = 0 ; i < figures.size() ; i++){
			figures.get(i).deSelectionner();
		}
	}

	@Override
	public Dessin charger(String path) {
		try
		{
		File f=new File(path);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dessin d = (Dessin) ois.readObject();
		ois.close();
		return d;
		}
		catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}

}
