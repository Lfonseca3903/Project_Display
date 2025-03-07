package Main;

import Entidades.Heroi;
import Jogo.Jogo;

/**
 * Classe Main, que roda o jogo
 */
public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        Heroi heroi = jogo.criarPersonagem();
        jogo.aventuraMagica(heroi);
        jogo.tryAgain(heroi);
    }
}