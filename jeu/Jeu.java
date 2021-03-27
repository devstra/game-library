package jeu;

/**
 * Tous les jeux de la bibliothèque doivent hériter de cette classe pour pouvoir les assembler
 * @author prxzr
 */
public abstract class Jeu {


    private String[] arguments;
    private boolean gagné;


    /**
     * Créer un jeu qui utilise des arguments
     * @param args : les arguments utilisé lors de l'éxecution du main
     */
    public Jeu(String[] args){
        this.arguments = args;
        this.gagné = false;
    }


    /**
     * Créer un jeu sans arguments
     */
    public Jeu(){
        this.arguments = null;
        this.gagné = false;
    }


    /**
     * Lance l'execution du jeu
     * @throws Exception
     */
    public abstract void jouer() throws Exception;


    /**
     * Récupère la valeur de "gagné"
     * @return l'état du jeu (gagné ou perdu)
     */
    public boolean estGagné(){
        return this.gagné;
    }


    /**
     * Marque le jeu comme étant gagné ou perdu
     * @param gagné : true si le jeu est gagné, false sinon
     */
    public void setGagné(boolean gagné) {
        this.gagné = gagné;
    }


    /**
     * Récupère les arguments utilisés à la création du jeu
     * @return les arguments utilisés à l'execution
     */
    public String[] getArguments() {
        return arguments;
    }
}
