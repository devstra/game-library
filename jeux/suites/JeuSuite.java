package jeux.suites;

import jeu.Jeu;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Jeu de finir la suite
 * @author profs IUT
 */
public class JeuSuite extends Jeu {


	public JeuSuite(String[] args) {
		super(args);
	}

	@Override
	public void jouer() {
		List<Suite> suites = Arrays.asList(
				new SuiteMystère()
				, new SuiteArithmétique(1, 10)
				, new SuiteArithmétique(7, 25)
				, new SuiteGéométrique(1, 10)
				, new SuiteGéométrique(7, 25)
		);
		Random r = new Random();
		Suite suite = suites.get(r.nextInt(suites.size()));
		final int NB = getArguments().length > 0 && getArguments()[0].equals("-hard") ? 3 : 4;
		List<BigInteger> termes = suite.premiersTermes(NB + 1);
		BigInteger aTrouver = termes.remove(NB);
		System.out.println("Trouvez l'entier qui suit logiquement la suite suivante : " + termes);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BigInteger valeur = new BigInteger(sc.next()); // peut lever NumberFormatException
		if (valeur.equals(aTrouver)) {
			System.out.println("Bravo");
			setGagné(true);
		}
		else {
			System.out.println("Dommage");
			setGagné(false);
		}
	}
}
