package assemblage;

import jeu.Jeu;

/**
 * Assemblage de jeux où Jeu1 doit être gagné en un nombre prédéfini d'essais pour gagner
 * @author prxzr
 */
public class AuPlusGagné extends Assemblage {

    private int nbEssais;


    /**
     * Cré un nouvel assemblage de jeux de type AuPlusGagné
     * @param nom : le nom que l'ont veut donné à l'assemblage
     * @param j1 : le jeu à assembler
     * @param essais : le nombre d'essais maximal que l'on veut appliquer
     */
    public AuPlusGagné(String nom, Jeu j1, int essais){
        super(nom, j1);
        this.nbEssais = essais;
    }


    /**
     * Execute les jeux de l'assemblage
     * @throws Exception
     */
    @Override
    public void jouer() throws Exception {
        int nbPartiesJouées = 0;

        while (nbPartiesJouées < nbEssais){
            try {
                getJ1().jouer();

                if (getJ1().estGagné()){
                    break;
                }

                nbPartiesJouées++;
            } catch (Exception e){
                //handle it
            }
        }

        //affiche gagné ou perdu en fonction du résultat de l'assemblage
        System.out.println(getNom() + " est " + (estGagné() ? "gagné." : "perdu."));
    }


    /**
     * Récupère l'état de l'assemblage, s'il est gagné ou perdu
     * @return true si Jeu1 a été gagné en moins d'essais que le nombre maximal autorisé, retourne false sinon
     */
    @Override
    public boolean estGagné() {
        return getJ1().estGagné();
    }
}
