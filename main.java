
import assemblage.Assemblage;

import assemblage.UnGagné;
import jeux.intrus.Intrus;
import jeux.tictactoe.JeuTicTacToe;

public class main {

    public static void main(String[] args) throws Exception {

        Assemblage ex = new UnGagné("example d'assemblage", new Intrus(), new JeuTicTacToe());

        System.out.println("Nom: " + ex.getNom());

        System.out.println("gagné: " + ex.estGagné());

        ex.jouer();

    }
}
