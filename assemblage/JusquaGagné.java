package assemblage;

import jeu.Jeu;

/**
 * Assemblage de jeux où Jeu1 doit être rejoué jusqu'à être gagné pour gagner
 * @author prxzr
 */
public class JusquaGagné extends Assemblage {


    /**
     * Cré un nouvel assemblage de jeux de type JusquaGagné
     * @param nom : le nom que l'ont veut donné à l'assemblage
     * @param j1 : le jeu à assembler
     */
    public JusquaGagné(String nom, Jeu j1){
        super(nom, j1);
    }


    /**
     * Execute les jeux de l'assemblage
     * @throws Exception
     */
    @Override
    public void jouer() throws Exception {

        while (!estGagné()){
            try {
                getJ1().jouer();

            } catch (Exception e){
                //handle it
            }
        }

        //affiche gagné ou perdu en fonction du résultat de l'assemblage
        System.out.println(getNom() + " est " + (estGagné() ? "gagné." : "perdu."));

    }


    /**
     * Récupère l'état de l'assemblage, s'il est gagné ou perdu
     * @return true si Jeu1 a été gagné, retourne false sinon
     */
    @Override
    public boolean estGagné() {
        return getJ1().estGagné();
    }
}
