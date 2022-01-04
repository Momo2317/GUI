import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class einfacheGui implements ActionListener {
	
	JFrame gui;
	JPanel contentPane;
	JPanel ordnung;
	JPanel mittlereSpalte;
	JPanel rechteSpalte;
	JLabel text;
	JLabel ausgabe;
	JButton prüfen;
	JTextField eingabe;
	
	public einfacheGui() {
		// Fenster
		gui = new JFrame("Primzahltest");
		contentPane = new JPanel(null);
		mittlereSpalte = new JPanel();
		rechteSpalte = new JPanel();
		ausgabe = new JLabel();
		gui.setContentPane(contentPane);
		gui.setSize(400, 300);
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		ordnung = new JPanel();
		
		// Eingabe
		eingabe = new JTextField("", 10);
		mittlereSpalte.add(eingabe);
		eingabe.addActionListener(this);
		
		// Layout
		contentPane.add(ordnung);
		ordnung.setLayout(new BoxLayout(ordnung, BoxLayout.X_AXIS));
		ordnung.add(mittlereSpalte);
		ordnung.add(rechteSpalte);
		ausgabe.setHorizontalAlignment(JLabel.CENTER);
		ausgabe.setVerticalAlignment(JLabel.CENTER);
		ordnung.add(ausgabe);
		
		// Button
		prüfen = new JButton("Prüfen");
		rechteSpalte.add(prüfen);
		prüfen.addActionListener(this);
		
		// Sichtbarkeit
		gui.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.prüfen) {
			String zahl = eingabe.getText();
			if(isPrim(zahl)) {
				eingabe.setText("");
				System.out.println("Die Zahl " + zahl + " ist eine Primzahl!");
				ausgabe.setText(zahl + " ist eine Primzahl!");
			} else {
				eingabe.setText("");
				System.out.println("Die Zahl " + zahl + " ist keine Primzahl!");
				ausgabe.setText(zahl + " ist keine Primzahl!");
			}
		}
	}
	
	boolean isPrim(String zahl) {
		int zahl1 = Integer.parseInt(zahl);
		if(zahl1 < 2) {
			return false;
		}
		for (int i = 2; i * i <= zahl1; i++) {
            if (zahl1 % i == 0) {
                return false;
            }
        }
		return true;
	}
	
	public static void main(String[] args) {
		einfacheGui g = new einfacheGui();
	}

}
