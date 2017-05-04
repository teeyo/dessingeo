package IHM;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CadreProjet extends JFrame{
	JPanel conteneur = new JPanel();
	JLabel auteur, ecole, formation, annee , encadrant , module;
	
	public CadreProjet(){
		conteneur.setBorder(BorderFactory.createTitledBorder("A propos de Dessin-Geo"));
		auteur = new JLabel("Developpé par : OUSSAMA TAOUFIK - taoufik.oussama@gmail.com");
		ecole = new JLabel("Ecole : U-H2 - Ecole Normale Superieure de l'Enseignement Technique - Mohammedia");
		formation = new JLabel("Formation : Master Systèmes d'information distribués");
		annee = new JLabel("Année de développement : 2013");
		encadrant = new JLabel("Encadrant : Mr M.Youssfi");
		module = new JLabel("Module : Conception et programmation orientée objet | UML/JAVA");
		conteneur.add(ecole);
		conteneur.add(formation);
		conteneur.add(encadrant);
		conteneur.add(module);
		conteneur.add(auteur);
		conteneur.add(annee);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Dessin-Geo");
		this.add(conteneur);
		this.setSize(650,160);
		this.setVisible(true);
	}
}
