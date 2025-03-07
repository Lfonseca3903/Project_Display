package Itens;

import java.util.ArrayList;

/**
 * Classe responsável pelo design de consumíveis do tipo poção
 */
public class Pocao extends Consumivel{
    /**
     * Pontos de vida que a poção cura
     */
    protected int vidaCurar;
    /**
     * Pontos adicionais de força que a poção fornece
     */
    protected int aumentoForca;

    /**
     * Método construtor de ítems do tipo poção
     * @param preco Preço do ítem
     * @param nome Nome do ítem
     * @param vidaCurar Pontos de vida que a poçãp cura
     * @param aumentoForca Pontos adicionais de força que a poçãp fornece
     */
    public Pocao(int preco, String nome, ArrayList<String> heroisPermitidos, int vidaCurar, int aumentoForca) {
        super(preco, nome, heroisPermitidos);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    /**
     * Método utilizado para obter os pontos de vida curados pela poção em métodos que não herdam o método {@link Pocao}
     * @return Pontos de vida que o ítem cura
     */
    public int getVidaCurar() {
        return vidaCurar;
    }

    /**
     * Método utilizado para obter os pontos adicionais de força que a poção fornece em métodos que não herdam o método {@link Pocao}
     * @return Pontos adicionais de força que a poçãp fornece
     */
    public int getAumentoForca() {
        return aumentoForca;
    }

    /**
     * Método para mostrar os detalhes do ítem com as particularidades das poções
     */
    @Override
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Vida a curar: " + vidaCurar + "HP");
        System.out.println("Aumento de força: " + aumentoForca + " pontos");
    }
}
