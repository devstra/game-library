package jeux.crazy;

import jeu.Jeu;

import java.util.Scanner;

/**
 * Jeu Crazy Circus
 * @author profs IUT
 */
public class CrazyCircus extends Jeu {

	public CrazyCircus() {
		super();
	}


	@Override
	public void jouer() {
		Paquet p = new Paquet();
		Carte depart = p.piocher();
		Carte objectif = p.piocher();
		System.out.println("de " + depart + " à " + objectif);
		System.out.println("ki ->, lo <-, so <->, ni ^_, ma _^");
		System.out.println("entrez votre ordre, vous n'avez qu'une seule chance :");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String ordre = s.next().toLowerCase();
		try {
			Carte c = depart;
			System.out.println("   -> " + c);
			for (int i = 0; i + 1 < ordre.length(); i = i + 2) {
				String od = ordre.substring(i, i + 2);
				if ("ki".equals(od))
					c = c.ki();
				else if ("lo".equals(od))
					c = c.lo();
				else if ("so".equals(od))
					c = c.so();
				else if ("ni".equals(od))
					c = c.ni();
				else if ("ma".equals(od))
					c = c.ma();
				else
					throw new IllegalArgumentException(od + " : commande inconnue");
				System.out.println(od + " -> " + c);
			}
			if (c.equals(objectif)){
				System.out.println("Bravo");
				setGagné(true);
			}
			else{
				System.out.println("Dommage");
				setGagné(false);
			}
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
