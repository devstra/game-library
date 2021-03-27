package jeux.tictactoe;

import jeu.Jeu;
import jeux.tictactoe.TicTacToe.Pièce;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static jeux.tictactoe.TicTacToe.Pièce.CROIX;
import static jeux.tictactoe.TicTacToe.Pièce.ROND;

/**
 * Jeu de morpion
 * @author profs IUT
 */
public class JeuTicTacToe extends Jeu {

    public JeuTicTacToe() {
        super();
    }

    @Override
    public void jouer() {
        TicTacToe tic = new TicTacToe();
        Pièce j = ROND;
        System.out.println(tic);
        while (!tic.fini()) {
            Coord c;
            if (j == ROND)
                c = saisie(tic);
            else
                c = choixAléatoire(tic);
            tic.poser(c, j);
            System.out.println(tic);
            j = j == ROND ? CROIX : ROND;
        }
        j = tic.gagnant();
        if (j == null) {
            System.out.println("Match nul");
            setGagné(false);
        } else if (j == ROND) {
            System.out.println("Bravo");
            setGagné(true);
        } else {
            System.out.println("Dommage");
            setGagné(false);
        }

    }


    private static Coord choixAléatoire(TicTacToe tic) {
        ArrayList<Coord> coords = new ArrayList<>();
        for (int li = 0; li < TicTacToe.NB; ++li)
            for (int co = 0; co < TicTacToe.NB; ++co) {
                Coord c = new Coord(li, co);
                if (tic.estVide(c))
                    coords.add(c);
            }
        Random r = new Random();
        return coords.get(r.nextInt(coords.size()));
    }

    private static Coord saisie(TicTacToe tic) {
        System.out.println("Entrez le numéro (compris entre 0 et " + (TicTacToe.NB - 1) + ") de ligne suivi du numéro de colonne où placer votre pièce.");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int li, co;
                li = sc.nextInt();
                co = sc.nextInt();
                if (li >= 0 && li < TicTacToe.NB && co >= 0 && co < TicTacToe.NB)
                    return new Coord(li, co);
            } catch (Exception e) {
            }
            System.out.println("Raté, veuillez essayer à nouveau");
        }
    }
}
