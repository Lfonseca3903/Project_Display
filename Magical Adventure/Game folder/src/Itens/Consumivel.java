package Itens;

import java.util.ArrayList;

/**
 * Classe responsável pelo design geral de todos os ítems do tipo consumível
 */
public abstract class Consumivel extends ItemHeroi {

    /**
     * Método construtor de ítems consumíveis
     * @param preco Preço do ítem
     * @param nome Nome do ítem
     */
    public Consumivel(int preco, String nome, ArrayList<String> heroisPermitidos) {
        super(preco, nome, heroisPermitidos);
    }

}
