package assemblage;

import jeu.Jeu;

public abstract class Assemblage extends Jeu {

    private Jeu j1;
    private String nom;


    /**
     * Cré un nouvel assemblage de jeux
     * @param nom : le nom que l'ont veut donné à l'assemblage
     * @param j1 : le jeu à assembler
     */
    public Assemblage(String nom, Jeu j1){
        this.nom = nom;
        this.j1 = j1;
    }


    /**
     * Récupère le jeu composant l'assemblage
     * @return j1 : premier jeu de l'assemblage
     */
    public Jeu getJ1() {
        return j1;
    }

    /**
     * Récupère le nom donné à l'asssemblage de jeux par l'utilisateur
     * @return nom : le nom de l'assemblage
     */
    public String getNom() {
        return nom;
    }


    /**
     * Récupère l'état de l'assemblage, s'il est gagné ou perdu
     */
    public abstract boolean estGagné();
}
