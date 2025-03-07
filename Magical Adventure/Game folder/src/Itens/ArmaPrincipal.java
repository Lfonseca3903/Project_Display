package Itens;

import java.util.ArrayList;

/**
 *  Classe responsável pelo design de ítems do tipo arma
 */
public class ArmaPrincipal extends ItemHeroi{
    /**
     * Valor do ataque normal da arma
     */
    protected int ataque;
    /**
     * Valor do ataque especial da arma
     */
    protected int ataqueEspecial;

    /**
     * Método construtor de ítems do tipo arma
     * @param preco Preço da arma
     * @param nome Nome da arma
     * @param ataqueEspecial Valor do ataque especial da arma
     * @param ataque Valor do ataque normal da arma
     */
    public ArmaPrincipal(int preco, String nome, ArrayList<String> heroisPermitidos, int ataqueEspecial, int ataque) {
        super(preco, nome, heroisPermitidos);
        this.ataqueEspecial = ataqueEspecial;
        this.ataque = ataque;
    }

    /**
     * Método utilizado para obter o valor do ataque normal da arma em métodos que não herdam o método {@link ArmaPrincipal}
     * @return Valor do ataque normal da arma
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Método utilizado para obter o valor do ataque especial da arma em métodos que não herdam o método {@link ArmaPrincipal}
     * @return Valor do ataque especial da arma
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
}
