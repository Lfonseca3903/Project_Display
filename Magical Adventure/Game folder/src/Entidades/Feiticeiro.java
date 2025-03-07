package Entidades;

import Itens.ArmaPrincipal;
import Itens.Consumivel;
import Itens.ConsumivelCombate;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Classe responsável pelo design de heróis do tipo feiticeiro
 */
public class Feiticeiro extends Heroi {

    /**
     * Método construtor do herói do tipo feiticeiro
     * @param nome Nome do herói
     * @param maxHP Vida máxima do herói
     * @param forca Nível de força do herói
     * @param nivel Nível de experiência do herói
     * @param ouro Valor em ouro que o herói possui
     * @param armaPrincipal Arma principal do herói
     */
    public Feiticeiro(String nome, int maxHP, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, maxHP, forca, nivel, ouro, armaPrincipal);
    }

    /**
     * Método de ataque adaptado às particularidades do feiticeiro
     * @param npc Entidade a ser atacada
     */
    @Override
    public boolean atacar (NPC npc) {
        if (!npc.nome.equals("Rei do caos")) {
            System.out.println("É atacado por um " + npc.nome + " no seu caminho!");
        }
        boolean ataqueEspecialUsado = false;

        while (HP > 0 && npc.getHP() > 0) {
            System.out.println("Vida do herói: " + HP + "/" + maxHP);
            System.out.println("Vida do " + npc.nome + ": " + npc.getHP() + "/" + npc.maxHP);
            Scanner sc =  new Scanner(System.in);
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("0-Ataque normal");
            System.out.println("1-Ataque especial");
            System.out.println("2-Ataque consumível");
            int option = sc.nextInt();

            if (!ataqueEspecialUsado) {
                while (option < 0 || option > 2) {
                    System.out.println("Por favor, escolha uma opção válida");
                    option = sc.nextInt();
                }
            } else {
                while (option != 0 && option != 2) {
                    System.out.println("Já usaste um ataque especial nesta luta. Por favor, escolha uma opção válida");
                    option = sc.nextInt();
                }
            }

            switch (option) {
                case 0:
                    npc.setHP(npc.getHP() - (forca + armaPrincipal.getAtaque()));
                    if (npc.getHP() < 1) {
                        break;
                    }
                    HP -= npc.getForca();
                    break;
                case 1:
                    npc.setHP(npc.getHP() - (forca + armaPrincipal.getAtaqueEspecial()));
                    if (npc.getHP() < 1) {
                        break;
                    }
                    HP -= npc.getForca();
                    ataqueEspecialUsado = true;
                    break;
                case 2:
                    int contConsumivelCombate = 0;
                    ArrayList<ConsumivelCombate> listaConsumivelCombate = new ArrayList<>();

                    for (Consumivel consumivelAtual : this.getInventario()) {
                        if (consumivelAtual instanceof ConsumivelCombate) {
                            ConsumivelCombate consumivelCombateAtual = (ConsumivelCombate) consumivelAtual;
                            System.out.println("------Item " + contConsumivelCombate + "------");
                            consumivelCombateAtual.mostrarDetalhes();
                            listaConsumivelCombate.add(consumivelCombateAtual);
                            contConsumivelCombate++;
                        }
                    }

                    if (listaConsumivelCombate.isEmpty()) {
                        System.out.println("Não possui nenhum consumível de combate");
                    } else {
                        System.out.println("Qual consumível de combate deseja usar? Escolha " + listaConsumivelCombate.size() + " para voltar ao menu anterior");
                        int optionConsumivelCombate = sc.nextInt();
                        while (optionConsumivelCombate < 0 || optionConsumivelCombate > listaConsumivelCombate.size()) {
                            System.out.println("Por favor, escolha uma opção válida");
                            optionConsumivelCombate = sc.nextInt();
                        } if (optionConsumivelCombate == listaConsumivelCombate.size()) {
                            break;
                        } else {
                            npc.setHP(npc.getHP() - listaConsumivelCombate.get(optionConsumivelCombate).getAtaqueInstantaneo());
                            if (npc.getHP() < 1) {
                                break;
                            }
                            HP -= npc.getForca();
                            this.getInventario().remove(listaConsumivelCombate.get(optionConsumivelCombate));
                            break;
                        }
                    }
            }
        }
        if (npc.getHP() > 0) {
            System.out.println(npc.nome + " matou o herói. Fim de jogo");
            return false;
        } else {
            System.out.println("O herói matou " + npc.nome);
            System.out.println("Nível de experiência: " + nivel + " ---> " + (nivel + 1));
            nivel += 1;
            System.out.println("Vida máxima: " + maxHP + " ---> " + (maxHP + 10));
            maxHP += 10;
            System.out.println("Nível de força: " + forca + " ---> " + (forca + 1));
            forca += 1;
            System.out.println("Ouro: " + ouro + " ---> " + (ouro + npc.ouro));
            ouro += npc.ouro;
            return true;
        }
    }
}
