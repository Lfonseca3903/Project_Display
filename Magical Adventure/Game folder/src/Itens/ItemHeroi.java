package Itens;

import java.util.ArrayList;

/**
 * Classe responsável pelo design geral de todos os tipos de ítem
 */
public abstract class ItemHeroi {
    /**
     * Nome do ítem
     */
    protected String nome;
    /**
     * Preço do ítem em ouro
     */
    protected int preco;
    /**
     * Heróis que podem usar o ítem
     */
    protected ArrayList<String> heroisPermitidos;

    /**
     * Método construtor do ítem
     * @param preco Preço do ítem em ouro
     * @param nome Nome do ítem
     * @param heroisPermitidos Lista de heróis que podem usar o ítem. È um dos poucos casos em que faz sentido passar a lista no construtor
     */
    public ItemHeroi(int preco, String nome, ArrayList<String> heroisPermitidos) {
        this.preco = preco;
        this.nome = nome;
        this.heroisPermitidos = heroisPermitidos;
    }

    /**
     * Método que mostra os detalhes do ítem
     */
    public void mostrarDetalhes(){
            System.out.println("Nome: " + nome);
            System.out.println("Preço: " + preco);
            System.out.println("Herois permitidos:");
            for (String heroiAtual : heroisPermitidos){
                System.out.println("     -" + heroiAtual);
            }
    }

    /**
     * Método utilizado para obter o preço do ítem em classes que não herdam o método {@link ItemHeroi}
     * @return Preço do ítem em ouro
     */
    public int getPreco() {
        return preco;
    }

    /**
     * Método utilizado para obter a lista de heróis permitidos em classes que não herdam o método {@link ItemHeroi}
     * @return lista de heróis permitidos
     */
    public ArrayList<String> getHeroisPermitidos() {
        return heroisPermitidos;
    }
}
