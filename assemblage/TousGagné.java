package assemblage;

import jeu.Jeu;

/**
 * Assemblage de jeux où Jeu1 et Jeu2 doivent être gagnés pour gagner
 * @author prxzr
 */
public class TousGagné extends Assemblage {

    private Jeu j2;


    /**
     * Cré un nouvel assemblage de jeux de type TousGagné
     * @param nom : le nom que l'ont veut donné à l'assemblage
     * @param j1 : le premier jeu à assembler
     * @param j2 : le deuxième jeu à assembler
     */
    public TousGagné(String nom, Jeu j1, Jeu j2){
        super(nom, j1);
        this.j2 = j2;
    }


    /**
     * Execute les jeux de l'assemblage
     * @throws Exception
     */
    @Override
    public void jouer() {
        try {
            getJ1().jouer();

            if (getJ1().estGagné()) {
                j2.jouer();
            }
        } catch (Exception e){
            //handle exception
        }

        //affiche gagné ou perdu en fonction du résultat de l'assemblage
        System.out.println(getNom() + " est " + (estGagné() ? "gagné." : "perdu."));
    }


    /**
     * Récupère l'état de l'assemblage, s'il est gagné ou perdu
     * @return true si Jeu1 ET Jeu2 ont été gagné, retourne false sinon
     */
    @Override
    public boolean estGagné() {
        return getJ1().estGagné() && j2.estGagné();
    }
}
