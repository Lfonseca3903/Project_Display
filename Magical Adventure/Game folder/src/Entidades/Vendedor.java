package Entidades;

import Itens.ArmaPrincipal;
import Itens.ConsumivelCombate;
import Itens.ItemHeroi;
import Itens.Pocao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *  Classe responsável pelo design do vendedor
 */
public class Vendedor {
    /**
     * Lista de artigos que o vendedor possui
     */
    protected ArrayList<ItemHeroi> listaArtigos;

    /**
     * Método para adicionar ítems ao inventário do vendedor
     *
     * @param item ítem a ser adicionado ao inventário do vendedor
     */
    public void AdicionarItems(ItemHeroi item) {
        listaArtigos.add(item);
    }

    /**
     * Método construtor do vendedor
     */
    public Vendedor() {
        this.listaArtigos = new ArrayList<>();
    }

    /**
     * Método que imprime a lista de artigos a venda. Este método é invocado automaticamente quando o método {@link #vender(Heroi)}
     * é invocado
     *
     * @return a lista de ítems à venda (no máximo 10 ítems de todos os ítems que o vendedor possui)
     */
    public ArrayList<ItemHeroi> imprimirLoja() {
        ArrayList<ItemHeroi> listaArtigosTemporaria = new ArrayList<>(listaArtigos);
        ArrayList<ItemHeroi> listaArtigosDisponiveis = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {

            System.out.println("---------Item " + i + "---------");

            if (listaArtigosTemporaria.size() > 1) {
                ItemHeroi item = listaArtigosTemporaria.get(rand.nextInt(listaArtigosTemporaria.size()));

                if (item instanceof ArmaPrincipal) {
                    ArmaPrincipal armaAtual = (ArmaPrincipal) item;
                    armaAtual.mostrarDetalhes();
                    listaArtigosTemporaria.remove(armaAtual);
                    listaArtigosDisponiveis.add(armaAtual);
                }

                if (item instanceof ConsumivelCombate) {
                    ConsumivelCombate consumivelCombateAtual = (ConsumivelCombate) item;
                    consumivelCombateAtual.mostrarDetalhes();
                    listaArtigosTemporaria.remove((consumivelCombateAtual));
                    listaArtigosDisponiveis.add(consumivelCombateAtual);
                }

                if (item instanceof Pocao) {
                    Pocao pocaoAtual = (Pocao) item;
                    pocaoAtual.mostrarDetalhes();
                    listaArtigosTemporaria.remove(pocaoAtual);
                    listaArtigosDisponiveis.add(pocaoAtual);
                }

            } else {
                ItemHeroi item = listaArtigosTemporaria.get(0);

                if (item instanceof ArmaPrincipal) {
                    ArmaPrincipal armaAtual = (ArmaPrincipal) item;
                    armaAtual.mostrarDetalhes();
                    listaArtigosTemporaria.remove(armaAtual);
                    listaArtigosDisponiveis.add(armaAtual);
                }

                if (item instanceof ConsumivelCombate) {
                    ConsumivelCombate consumivelCombateAtual = (ConsumivelCombate) item;
                    consumivelCombateAtual.mostrarDetalhes();
                    listaArtigosTemporaria.remove((consumivelCombateAtual));
                    listaArtigosDisponiveis.add(consumivelCombateAtual);
                }

                if (item instanceof Pocao) {
                    Pocao pocaoAtual = (Pocao) item;
                    pocaoAtual.mostrarDetalhes();
                    listaArtigosTemporaria.remove(pocaoAtual);
                    listaArtigosDisponiveis.add(pocaoAtual);
                }
            }
        }

        return listaArtigosDisponiveis;
    }

    /**
     * Método que permite ao herói comprar um item se esse tiver ouro suficiente
     *
     * @param heroi Herói que compra o ítem
     * @return valor booleano false se o herói não quiser comprar nada e true se quiser comprar alguma coisa (mesmo que acabe não comprando nada)
     */
    public boolean vender(Heroi heroi) {
        System.out.println("Ouro: " + heroi.getOuro());
        System.out.println("Deseja comprar algo?");
        System.out.println("0-Sim");
        System.out.println("1-Não");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option != 0 && option != 1) {
            System.out.println("Por favor, escolha uma opção válida");
            option = sc.nextInt();
        }

        if (option == 1) {
            return false;
        }

        ArrayList<ItemHeroi> listaArtigosDisponiveis = imprimirLoja();

        while (option == 0) {
            System.out.println("Qual item deseja comprar?");
            sc = new Scanner(System.in);
            option = sc.nextInt();

            while (option < 0 || option >= listaArtigosDisponiveis.size()) {
                System.out.println("Por favor, escolha uma opção válida");
                option = sc.nextInt();
            }

            if (heroi.getOuro() >= listaArtigosDisponiveis.get(option).getPreco() && !heroi.getInventario().contains(listaArtigosDisponiveis.get(option)) &&
                    listaArtigosDisponiveis.get(option).getHeroisPermitidos().contains(heroi.nome)) {
                heroi.setOuro(heroi.getOuro() - listaArtigosDisponiveis.get(option).getPreco());

                if (listaArtigosDisponiveis.get(option) instanceof ArmaPrincipal) {
                    ArmaPrincipal armaPrincipalAtual = (ArmaPrincipal) listaArtigosDisponiveis.get(option);
                    heroi.setArmaPrincipal(armaPrincipalAtual);
                    listaArtigosDisponiveis.remove(listaArtigosDisponiveis.get(option));
                }

                if (listaArtigosDisponiveis.get(option) instanceof ConsumivelCombate) {
                    ConsumivelCombate consumivelCombateAtual = (ConsumivelCombate) listaArtigosDisponiveis.get(option);
                    heroi.adicionarConsumivel(consumivelCombateAtual);
                    listaArtigosDisponiveis.remove(listaArtigosDisponiveis.get(option));
                }

                if (listaArtigosDisponiveis.get(option) instanceof Pocao) {
                    Pocao pocaoAtual = (Pocao) listaArtigosDisponiveis.get(option);
                    heroi.adicionarConsumivel(pocaoAtual);
                    listaArtigosDisponiveis.remove(listaArtigosDisponiveis.get(option));
                }
                System.out.println("Item adquirido");
                System.out.println("Ouro restante: " + heroi.getOuro());
            } else {
                System.out.println("Não foi possível adquirir o item");
                if (heroi.getOuro() < listaArtigosDisponiveis.get(option).getPreco()) {
                    System.out.println("-Ouro insuficiente");
                }
                if (heroi.getInventario().contains(listaArtigosDisponiveis.get(option))) {
                    System.out.println("-Já possui este ítem no seu inventário");
                }
                if (!listaArtigosDisponiveis.get(option).getHeroisPermitidos().contains(heroi.nome)) {
                    System.out.println("-Não pode usar este ítem");
                }
            }
            System.out.println("Deseja continuar na loja?");
            System.out.println("0-Sim");
            System.out.println("1-Não");
            sc = new Scanner(System.in);
            option = sc.nextInt();

            while (option != 0 && option != 1) {
                System.out.println("Por favor, escolha uma opção válida");
                option = sc.nextInt();
            }

            if (option == 1) {
                return true;
            } else {
                for (int i = 0; i < listaArtigosDisponiveis.size(); i++) {
                    System.out.println("---------Item " + i + "---------");
                    listaArtigosDisponiveis.get(i).mostrarDetalhes();
                }
            }
        }
        return true;
    }
}
