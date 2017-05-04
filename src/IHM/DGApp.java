package IHM;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DGApp extends JFrame implements WindowListener{
	
	Papier p = new Papier();
	BarreMenu bm = new BarreMenu();
	BarreOutils br = new BarreOutils();
	BarreOutilsText bt = new BarreOutilsText();
	String titre = new String();
	
	public DGApp(){
		this.p.app = this;
		this.bm.app = this;
		this.br.app = this;
		this.bt.app = this;
		persoFenetre();
	}
	
	//____personnaliser la fenêtre principale
	private void persoFenetre() {
		this.addWindowListener(this);
		this.setTitle("DessinGeo - (version bêtà)");
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setJMenuBar(bm);
		this.add(br,BorderLayout.NORTH);
		this.add(bt,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		DGApp app = new DGApp();

	}
	
	public void setTitre(String t){
		titre = t;
		this.setTitle(titre);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		JFileChooser enregistrer = new JFileChooser(new File("Enregistrements"));
		String path = new String();
		if (enregistrer.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
			path = enregistrer.getSelectedFile().getAbsolutePath();
			this.p.dessin.enregistrer(path);
			this.br.dessinCourant.setText("Dessin courant : "+enregistrer.getSelectedFile().getName());
			this.titre = path;
		}
	}

}
