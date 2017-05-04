package IHM;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class BarreOutils extends JToolBar implements ActionListener{
	
	ArrayList<JToggleButton> bouttons = new ArrayList<JToggleButton>();
	DGApp app;
	JComboBox cf = new JComboBox();
	JLabel dimension = new JLabel();
	JButton ccon, crem ;
	JOptionPane infos;
	JLabel dessinCourant = new JLabel();
	
	
	public BarreOutils(){
		this.setName("Barre d'outils");
		ajouterBoutton("Selectionner", "icons/select.png");
		ajouterBoutton("Supprimer", "icons/delete.png");
		ajouterBoutton("Propriétés", "icons/properties.png");
		ccon = new JButton("Couleur contour");
		crem = new JButton("Couleur remplissage");
		ccon.addActionListener(this);crem.addActionListener(this);
		this.add(ccon);this.add(crem);
		ajouterOptionFigure();
		ajouterListener();
		ccon.setBackground(Color.black);
		crem.setBackground(Color.orange);
		afficherDimensions();
		infos = new JOptionPane();
		this.add(dessinCourant);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		app.p.dessin.desselectionner();
		app.p.repaint();
		if (a.getSource() == bouttons.get(0)){
			deselectionBouttons(0);
		}else if (a.getSource() == bouttons.get(1)){
			deselectionBouttons(1);
		}else if (a.getSource() == bouttons.get(2)){
			deselectionBouttons(2);
		}else if(a.getSource() == ccon){
			deselectionBouttons(-1);
			ccon.setBackground(JColorChooser.showDialog(this, "Choisissez une couleur pour le contour", Color.white));
		}else if(a.getSource() == crem){
			deselectionBouttons(-1);
			crem.setBackground(JColorChooser.showDialog(this, "Choisissez une couleur pour le contour", Color.white));
		}
		
	}
	
	private void deselectionBouttons(int position){
		for(int i =0;i<bouttons.size();i++){
			if (i == position){
				continue;
			}else{
				bouttons.get(i).setSelected(false);
			}
		}
	}
	
	private void ajouterBoutton(String nom, String path){
		ImageIcon i = new ImageIcon(path);
		JToggleButton b = new JToggleButton(nom);
		b.setIcon(i);
		this.add(b);
		bouttons.add(b);
	}
	
	private void ajouterListener(){
		for(int i =0;i<bouttons.size();i++){
			bouttons.get(i).addActionListener(this);
		}
	}
	
	private void ajouterOptionFigure(){
		JLabel optionContour = new JLabel("Choix de la figure : ");
		this.cf = new JComboBox();
		optionContour.setLabelFor(cf);
		cf.setName("Choix de la figure à dessiner");
		cf.addItem("Cercle");
		cf.addItem("Rectangle");
		cf.addItem("Losange");
		cf.addItem("Ligne");
		cf.addItem("Text");
		cf.addItem("Triangle");
		this.add(optionContour);
		this.add(cf);
		cf.addActionListener(this);
	}
	
	private void afficherDimensions(){
		JLabel ld = new JLabel("Coordonnées : ");
		this.dimension.setForeground(Color.blue);
		ld.setLabelFor(dimension);
		this.add(ld);
		this.add(dimension);
		cf.addActionListener(this);
	}
}
