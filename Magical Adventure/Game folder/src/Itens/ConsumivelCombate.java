package Itens;

import java.util.ArrayList;

/**
 *  Classe responsável pelo design de consumíveis do tipo combate
 */
public class ConsumivelCombate extends Consumivel {
    /**
     * Valor do ataque instantâneo do consumível de combate
     */
    protected int ataqueInstantaneo;

    /**
     * Método construtor de consumíveis do tipo combate
     * @param preco Preço do ítem
     * @param nome Nome do ítem
     * @param ataqueInstantaneo Valor do ataque instantâneo do consumível de combate
     */
    public ConsumivelCombate(int preco, String nome, ArrayList<String> heroisPermitidos, int ataqueInstantaneo) {
        super(preco, nome, heroisPermitidos);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    /**
     * Método utilizado para obter o valor do ataque instantâneo do consumível de combate em métodos que não herdam o método {@link ConsumivelCombate}
     * @return Valor do ataque instantâneo do consumível de combate
     */
    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }

    /**
     * Método para mostrar os detalhes do ítem com as particularidades dos consumíveis de combate
     */
    @Override
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Ataque instantáneo: " + ataqueInstantaneo + "dmg");
    }
}
