package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class BarreMenu extends JMenuBar implements ActionListener{
	
	ArrayList<JMenu> elements = new ArrayList<JMenu>();
	ArrayList<JMenuItem> sousElements = new ArrayList<JMenuItem>();
	DGApp app;
	
	public BarreMenu(){
		ajouterElement("Fichier",'F');
		ajouterSousElement("Nouveau", elements.get(0));
		sousElements.get(0).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		ajouterSousElement("Ouvrir", elements.get(0));
		sousElements.get(1).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		ajouterSousElement("Enregistrer", elements.get(0));
		sousElements.get(2).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		ajouterSousElement("Enregistrer sous", elements.get(0));
		sousElements.get(3).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		elements.get(0).addSeparator();
		ajouterSousElement("Quitter", elements.get(0));
		sousElements.get(4).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		ajouterElement("A propos de DessinGeo",'A');
		ajouterSousElement("Cadre du projet",elements.get(1));
		sousElements.get(5).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		ajouterListener();
	}
	
	private void ajouterElement(String txt , char mn){
		JMenu menu = new JMenu();
		menu.setText(txt);
		menu.setMnemonic(mn);
		elements.add(menu);
	}
	
	private void ajouterSousElement(String txt , JMenu m){
		JMenuItem el = new JMenuItem();
		el.addActionListener(this);
		el.setText(txt);
		m.add(el);
		sousElements.add(el);
	}
	
	private void ajouterListener(){
		for (int i = 0 ; i < elements.size() ; i++){
			elements.get(i).addActionListener(this);
			this.add(elements.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		if (arg0.getActionCommand().equals("Quitter")){
			if (app.p.dessin.getNombresFigures() > 1){
				int rep = JOptionPane.showConfirmDialog(this.getParent(), 
						"Êtes vous sûr de vouloir quitter le programme ? "
						, "Quitter", JOptionPane.YES_NO_OPTION);
				if (rep == JOptionPane.YES_OPTION){
					app.dispose();
				}
			}else{
				app.dispose();
			}
		}else if (arg0.getActionCommand().equals("Enregistrer sous")){
			JFileChooser enregistrer = new JFileChooser(new File("Enregistrements"));
			String path = new String();
			if (enregistrer.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
				path = enregistrer.getSelectedFile().getAbsolutePath();
				app.p.dessin.enregistrer(path);
			}
		}else if (arg0.getActionCommand().equals("Nouveau")){
			if (app.p.dessin.getNombresFigures() > 1){
					app.p.dessin.enregistrer(app.titre);
					if (app.p.dessin != null){
					app.p.dessin.viderDessin();
					}
					app.titre = null;
					app.br.dessinCourant.setText("Dessin courant : ");
					app.repaint();
				}
			}else if (arg0.getActionCommand().equals("Ouvrir")){
			JFileChooser ouvrir = new JFileChooser(new File("Enregistrements"));
			String path = new String();
			if (ouvrir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
				path = ouvrir.getSelectedFile().getAbsolutePath();
				app.br.dessinCourant.setText("Dessin courant : "+ouvrir.getSelectedFile().getName());
				app.titre = path;
			}else{
				app.titre = null;
			}
			app.p.dessin = app.p.dessin.charger(path);
			if (app.p.dessin != null){
			app.p.repaint();
			}
		}
		else if (arg0.getActionCommand().equals("Cadre du projet")){
			@SuppressWarnings("unused")
			CadreProjet cd = new CadreProjet();
		}
		else if (arg0.getActionCommand().equals("Enregistrer")){
			if (app.titre != null){
				app.p.dessin.enregistrer(this.app.titre);
			}else{
				JFileChooser enregistrer = new JFileChooser(new File("Enregistrements"));
				String path = new String();
				if (enregistrer.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
					path = enregistrer.getSelectedFile().getAbsolutePath();
					app.p.dessin.enregistrer(path);
				}
			}
		}
	}
	
}
