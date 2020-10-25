package fr.eseo.poo.projet.artiste;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {
	public EtreUnArtiste() {
		JFrame frame = new JFrame();
		PanneauDessin panneauDessin = new PanneauDessin();

		frame.getContentPane().add(panneauDessin);
		frame.setTitle("Etre Un Artiste");

		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneauDessin);
		frame.add(panneauOutils, BorderLayout.EAST);

		frame.setSize(panneauDessin.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/** 
	 * @param args
	 */
	public static void main(String[] args){
		new EtreUnArtiste();
	}
}