package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class BarreOutilsText extends JToolBar implements ActionListener{
	
	ArrayList<JComponent> composants = new ArrayList<JComponent>();
	DGApp app;
	JButton couleurText;
	JTextField text;
	JComboBox choixFont, choixTaille , choixStyle;
	
	public BarreOutilsText(){
		this.setName("Barre d'outils - option du text");
		ajouterChoixFont();
		ajouterTailleFont();
		persoCouleurText();
		ajouterText();
		ajouterChoixStyle();
		ajouterComposants();
	}
	
	private void ajouterChoixFont(){
		JLabel lb = new JLabel("Police : ");
		choixFont = new JComboBox();
		lb.setLabelFor(choixFont);
		choixFont.setName("Choix de la police");
		ajoutDesFontsSysteme();
		composants.add(lb);
		composants.add(choixFont);
		choixFont.addActionListener(this);
	}
	
	private void ajoutDesFontsSysteme(){
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String f:fonts){
			choixFont.addItem(f);
		}
	}
	
	private void ajouterChoixStyle(){
		JLabel lb = new JLabel("Style de la police : ");
		choixStyle = new JComboBox();
		lb.setLabelFor(choixStyle);
		choixStyle.setName("Choix du style de la police");
		choixStyle.addItem("Normal");
		choixStyle.addItem("Gras");
		choixStyle.addItem("Italique");
		composants.add(lb);
		composants.add(choixStyle);
		choixStyle.addActionListener(this);
	}
	
	private void ajouterTailleFont(){
		JLabel lb = new JLabel("Taille de la police : ");
		choixTaille = new JComboBox();
		lb.setLabelFor(choixTaille);
		choixTaille.setName("Choix de la taille de la police");
		for(int i=9 ; i <= 70 ; i++){
			choixTaille.addItem(i);
		}
		composants.add(lb);
		composants.add(choixTaille);
		choixTaille.addActionListener(this);
	}
	
	private void ajouterComposants(){
		for(int i =0 ; i < composants.size(); i++){
			this.add(composants.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == couleurText){
			new JColorChooser();
			couleurText.setBackground(JColorChooser.showDialog(couleurText, "Choisissez la couleur de la police", Color.blue));
			text.setForeground(couleurText.getBackground());
		}else if (arg0.getSource() == choixFont){
			Font f = new Font(choixFont.getSelectedItem().toString(), Font.PLAIN, 12);
			text.setFont(f);
		}else if (arg0.getSource() == choixStyle){
			Font f;
			switch (choixStyle.getSelectedIndex()){
			case 0 :
				f = new Font(choixFont.getSelectedItem().toString(), Font.PLAIN, 12);
				text.setFont(f);
				break;
			case 1 : 
				f = new Font(choixFont.getSelectedItem().toString(), Font.BOLD, 12);
				text.setFont(f);
				break;
			case 2 :
				f = new Font(choixFont.getSelectedItem().toString(), Font.ITALIC, 12);
				text.setFont(f);
				break;
			}
		}
		
	}
	
	private void persoCouleurText(){
		couleurText = new JButton("Couleur de la police");
		couleurText.setBackground(Color.BLUE);
		couleurText.addActionListener(this);
		this.add(couleurText);
	}
	private void ajouterText(){
		text = new JTextField("Ecrivez votre text ici, puis cliquez sur la zone du dessin pour le placer");
		text.setForeground(couleurText.getBackground());
		text.addActionListener(this);
		this.add(text);
	}
}
