package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.Pocao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Classe responsável pelo design de entidades do tipo herói
 */
public abstract class Heroi extends Entidade {
    /**
     * Nível de experiência do herói
     */
    protected int nivel;
    /**
     * Valor em ouro que o herói possui
     */
    protected int ouro;
    /**
     * Arma principal do herói
     */
    protected ArmaPrincipal armaPrincipal;
    /**
     * Inventário do herói
     */
    protected ArrayList<Consumivel> inventario;

    /**
     * Método construtor do herói
     * @param nome Nome do herói
     * @param maxHP Vida máxima do herói
     * @param forca Nível de força do herói
     * @param nivel Nível de experiência do herói
     * @param ouro Valor em ouro que o herói possui
     * @param armaPrincipal Arma principal do herói
     */
    public Heroi(String nome, int maxHP, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, maxHP, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }

    /**
     * Método através do qual o herói ataca uma entidade. O método está vazio porque ele será sobrescrito de acordo com
     * as particularidades do ataque de cada tipo de herói (cavaleiro, arqueiro ou feiticeiro)
     * @param npc Entidade a ser atacada
     */
    public boolean atacar(NPC npc){
return true;
    }

    /**
     * Método para aceder ao valor em ouro que o herói possui em classes que não herdam a classe {@link Heroi}
     * @return Valor em ouro que o herói possui
     */
    public int getOuro() {
        return ouro;
    }

    /**
     * Método para aceder ao inventário do herói em classes que não herdam a classe {@link Heroi}
     * @return Inventário do herói
     */
    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    /**
     * Método para alterar o valor em ouro que o herói possui quando, por exemplo, esse compra um item novo
     * @param ouro Valor em ouro que o herói possui
     */
    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * Método para trocar a arma que o herói tem equipada quando esse compra uma arma nova
     * @param armaPrincipal Arma principal do herói
     */
    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    /**
     * Método para adicionar uma poção ou um consumível de combate ao inventário do herói quando esse compra um ítem de
     * um desses dois tipos. Quando o herói compra uma arma, essa funcionalidade é controlada pelo método
     * {@link #setArmaPrincipal}
     * @param consumivel Um ítem consumível, que pode ser uma poção ou um consumível de combate
     */
    public void adicionarConsumivel(Consumivel consumivel){
        inventario.add(consumivel);
    }

    /**
     * Método que permite ao herói usar uma poção
     * @return Um valor booleano que é falso se o herói não quiser usar uma poção e true se o quiser (mesmo que não o use por qualquer razão)
     */
    public boolean UsarPocao() {
        System.out.println("Pontos de vida: " + HP + "/" + maxHP);
        System.out.println("Nível de força: " + forca);
        System.out.println("Deseja usar uma poção?");
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

        {
            int cont = 0;
            ArrayList<Pocao> pocoesDisponiveis = new ArrayList<>();

            for (Consumivel consumivel : inventario) {
                if (consumivel instanceof Pocao) {
                    Pocao pocaoAtual = (Pocao) consumivel;
                    cont++;
                    System.out.println("-----" + (cont - 1) + "-----");
                    pocaoAtual.mostrarDetalhes();
                    pocoesDisponiveis.add(pocaoAtual);
                }
            }

            if (cont == 0) {
                System.out.println("Não há poções no inventório");
                return false;
            }

            System.out.println("Qual poção deseja usar?");
            sc = new Scanner(System.in);
            option = sc.nextInt();

            while (option < 0 || option >= cont) {
                System.out.println("Por favor, escolha uma opção válida");
                option = sc.nextInt();
            }

            if (HP < maxHP && ((HP + pocoesDisponiveis.get(option).getVidaCurar()) <= maxHP)) {
                HP += pocoesDisponiveis.get(option).getVidaCurar();
                forca += pocoesDisponiveis.get(option).getAumentoForca();
                System.out.println("Pontos de vida: " + HP + "/" + maxHP);
                System.out.println("Nível de força: " + forca);
                inventario.remove(pocoesDisponiveis.get(option));
                return true;
            } else if (((HP + pocoesDisponiveis.get(option).getVidaCurar()) > maxHP)) {
                System.out.println("A poção que escolheu só poderá restaurar até o valor da sua vida máxima, " +
                        "\no que signica que alguns pontos de vida serão desperdiçados. Tem certeza que deseja continuar?");
                System.out.println("0-Sim");
                System.out.println("1-Não");
                sc = new Scanner(System.in);
                option = sc.nextInt();

                while (option != 0 && option != 1) {
                    System.out.println("Por favor, escolha uma opção válida");
                    option = sc.nextInt();
                }

                if (option == 1) {
                    return false;
                }

                HP =maxHP;
                forca += pocoesDisponiveis.get(option).getAumentoForca();
                System.out.println("Pontos de vida: " + HP + "/" + maxHP);
                System.out.println("Nível de força: " + forca);
                inventario.remove(pocoesDisponiveis.get(option));
                return true;

            }
            else {
                System.out.println("Não é possível usar esta poção no momento");
                return false;
            }
        }
    }
}
