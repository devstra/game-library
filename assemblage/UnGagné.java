package assemblage;

import jeu.Jeu;

/**
 * Assemblage de jeux où soit Jeu1 ou soit Jeu2 doit être gagné pour gagner
 * @author prxzr
 */
public class UnGagné extends Assemblage {

    private Jeu j2;


    /**
     * Cré un nouvel assemblage de jeux de type UnGagné
     * @param nom : le nom que l'ont veut donné à l'assemblage
     * @param j1 : le premier jeu à assembler
     * @param j2 : le deuxième jeu à assembler
     */
    public UnGagné(String nom, Jeu j1, Jeu j2){
        super(nom, j1);
        this.j2 = j2;
    }


    /**
     * Execute les jeux de l'assemblage
     * @throws Exception
     */
    @Override
    public void jouer() throws Exception {
        try {
            getJ1().jouer();

            if (!getJ1().estGagné()) {
                j2.jouer();
            }
        } catch (Exception e) {
            //handle exception
        }

        //affiche gagné ou perdu en fonction du résultat de l'assemblage
        System.out.println(getNom() + " est " + (estGagné() ? "gagné." : "perdu."));
    }


    /**
     * Récupère l'état de l'assemblage, s'il est gagné ou perdu
     * @return true si Jeu1 OU Jeu2 a été gagné, retourne false si aucun n'a été gagné
     */
    @Override
    public boolean estGagné() {
        return getJ1().estGagné() || j2.estGagné();
    }
}
