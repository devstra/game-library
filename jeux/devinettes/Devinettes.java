package jeux.devinettes;

import jeu.Jeu;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Jeu de devinettes
 * @author profs IUT
 */
public class Devinettes extends Jeu {

	public Devinettes() {
		super();
	}

	@Override
	public void jouer() {
		List<List<String>> devinettes = Arrays.asList(
				Arrays.asList("Je suis entre 188 et 190, mais je ne suis pas 189. Qui suis-je ?", "et")
				, Arrays.asList("J'ai une serrure mais pas de porte. Qui suis-je ?", "cadenas")
				, Arrays.asList("Qu'est-ce qui t'appartient mais que les autres utilisent plus que toi ?", "prénom", "prenom")
				, Arrays.asList("Je rentre toujours la première et sors toujours la dernière, qui suis-je ?", "clé", "clef")
				, Arrays.asList("Appréciés en amour, les gros, eux, sont à éviter. Les auteurs en ont de fameux, et certains servent pour des jeux. Qui sont-ils ?", "mots")
				, Arrays.asList("Lorsque l'on me nomme, je n'existe plus. Qui suis-je ?", "silence")
				, Arrays.asList("Combien de gouttes d'eau peut-on mettre dans un verre vide ?", "une")
		);
		Random r = new Random();
		List<String> q = devinettes.get(r.nextInt(devinettes.size()));
		System.out.println(q.get(0));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String réponse = sc.nextLine().toLowerCase();
		for (int i = 1; i < q.size(); ++i)
			if (réponse.contains(q.get(i))) {
				System.out.println("Bravo");
				setGagné(true);
				return;
			}
		System.out.println("Dommage");
		setGagné(false);
	}
}
