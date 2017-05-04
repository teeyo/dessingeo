package IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


import metier.Cercle;
import metier.Dessin;
import metier.Figure;
import metier.Ligne;
import metier.Losange;
import metier.Point;
import metier.Rectangle;
import metier.Text;
import metier.Triangle;


@SuppressWarnings("serial")
public class Papier extends JPanel implements MouseListener , MouseMotionListener{
	
	Dessin dessin = new Dessin();
	DGApp app;
	ArrayList<Point> points = new ArrayList<Point>();
	
	public Papier(){
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		Rectangle rec = new Rectangle(new Point(0, 0), new Point((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		rec.setCouleurContour(Color.WHITE);
		rec.setCouleurRemplissage(Color.WHITE);
		dessin.addFigure(rec);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics arg0) {
		dessin.dessiner(arg0);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (app.br.bouttons.get(2).isSelected()){
			String msg = new String();
			if (dessin.getNombresFigures() > 1){
			Figure f = dessin.getFigurePlusProche(new Point(arg0.getX(), arg0.getY()));
			msg = f.toString() + " | Surface = "+f.getSurface()+ " | Périmètre = "+f.getPerimetre();
			JOptionPane.showMessageDialog(null, msg,"Propriétés",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		int index = -1;
		for ( int i = 0 ; i < app.br.bouttons.size() ; i++){
			if (app.br.bouttons.get(i).isSelected()){
				index = i;
				break;
			}
		}
		if(index == -1){
		switch(app.br.cf.getSelectedIndex()){
			case 0 :
				if (points.isEmpty())
				{
					points.add(new Point(arg0.getX(),arg0.getY()));
				} else{
					points.add(new Point(arg0.getX(),arg0.getY()));
					Cercle c = new Cercle(points.get(0), points.get(1));
					c.setCouleurContour(app.br.ccon.getBackground());
					c.setCouleurRemplissage(app.br.crem.getBackground());
					dessin.addFigure(c);
					
					this.repaint();
					points.clear();
					
				}
				break;
			case 1 :
				if (points.isEmpty())
				{
					points.add(new Point(arg0.getX(),arg0.getY()));
				} else{
					points.add(new Point(arg0.getX(),arg0.getY()));
					Rectangle r = new Rectangle(points.get(0), points.get(1));
					r.setCouleurContour(app.br.ccon.getBackground());
					r.setCouleurRemplissage(app.br.crem.getBackground());
					dessin.addFigure(r);
					this.repaint();
					points.clear();
				}
				break;
			case 2 :
				if (points.size() < 3)
				{
					points.add(new Point(arg0.getX(),arg0.getY()));
				} else {
					Point p = new Point(arg0.getX(), arg0.getY());
					Losange l = new Losange(points.get(0), points.get(1), points.get(2), p );
					l.setCouleurContour(app.br.ccon.getBackground());
					l.setCouleurRemplissage(app.br.crem.getBackground());
					dessin.addFigure(l);
					this.repaint();
					points.clear();
				}
				break;
			case 3 :
				if (points.isEmpty())
				{
					points.add(new Point(arg0.getX(),arg0.getY()));
				} else{
					points.add(new Point(arg0.getX(),arg0.getY()));
					Ligne l = new Ligne(points.get(0), points.get(1));
					l.setCouleurRemplissage(app.br.crem.getBackground());
					dessin.addFigure(l);
					this.repaint();
					points.clear();
				}
				break;
			case 4 :
				if (points.isEmpty())
				{
					Text t = new Text(new Point(arg0.getX(),arg0.getY()), app.bt.text.getText().toString(),
							app.bt.choixFont.getSelectedItem().toString(), app.bt.choixTaille.getSelectedIndex()
							, app.bt.choixStyle.getSelectedIndex());
					t.setCouleurRemplissage(app.bt.couleurText.getBackground());
					dessin.addFigure(t);
					this.repaint();
					points.clear();
				}else{
					points.clear();
				}
				break;
			case 5 :
				if (points.size() < 2)
				{
					points.add(new Point(arg0.getX(),arg0.getY()));
				} else {
					Point p = new Point(arg0.getX(), arg0.getY());
					Triangle t = new Triangle(points.get(0), points.get(1), p );
					t.setCouleurContour(app.br.ccon.getBackground());
					t.setCouleurRemplissage(app.br.crem.getBackground());
					dessin.addFigure(t);
					this.repaint();
					points.clear();
				}
				break;
			}
		}else{
			switch (index){
			case 0:
				Figure f = dessin.getFigurePlusProche(new Point(arg0.getX(),arg0.getY()));
				f.selectionner();
				this.repaint();
				break;
			case 1:
				Figure f1 = dessin.getFigurePlusProche(new Point(arg0.getX(),arg0.getY()));
				dessin.supprimer(f1);
				this.repaint();
				break;
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		app.br.dimension.setText(" ( " + arg0.getX()+" , "+arg0.getY()+" ) ");
		
	}

}
