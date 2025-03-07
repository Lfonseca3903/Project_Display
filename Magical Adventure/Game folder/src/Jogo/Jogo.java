package Jogo;

import Entidades.*;
import Itens.ArmaPrincipal;
import Itens.ConsumivelCombate;
import Itens.Pocao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe responsável pelo design geral do jogo
 */
public class Jogo {

    /**
     * Método construtor do jogo
     */
    public Jogo() {
    }

    /**
     * Método de criar personagem
     * @return Herói criado pelo jogador
     */
    public Heroi criarPersonagem() {
        String nome = "";
        System.out.println("Qual o tipo de herói que deseja criar?");
        System.out.println("0-Cavaleiro");
        System.out.println("1-Feiticeiro");
        System.out.println("2-Arqueiro");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option < 0 || option > 2) {
            System.out.println("Por favor, escolha uma opção válida");
            option = sc.nextInt();
        }

        ArmaPrincipal lancaBasica = new ArmaPrincipal(10,"Lança básica", new ArrayList<>(Arrays.asList("Lancelot")), 30, 15);
        ArmaPrincipal varinhaBasica = new ArmaPrincipal(10,"Varinha básica", new ArrayList<>(Arrays.asList("Merlin")), 20, 10);
        ArmaPrincipal arcoBasico = new ArmaPrincipal(10,"Arco básico", new ArrayList<>(Arrays.asList("Robin Hood")), 40, 20);

        int classe = 5;

        switch (option) {
            case 0:
                classe = 0;
                nome = "Lancelot";
                break;
            case 1:
                classe = 1;
                nome = "Merlin";
                break;
            case 2:
                classe = 2;
                nome = "Robin Hood";
                break;
        }

        System.out.println("Em qual dificuldade desseja jogar?");
        System.out.println("0-Fácil");
        System.out.println("1-Difícil");
        option = sc.nextInt();

        while (option < 0 || option > 1) {
            System.out.println("Por favor, escolha uma opção válida");
            option = sc.nextInt();
        }

        int pontos = 0;
        int pontosVida = 0;
        int vida = 0;
        int forca = 0;
        int ouro = 0;

        if (option == 0) {
            pontos = 300;
            System.out.println("Quantos dos 300 pontos deseja colocar na sua vida? O restante dos pontos serão colocados na \n sua força, sendo que são necessários 5 pontos para aumentar o nível de força");
            pontosVida = sc.nextInt();
            while (pontosVida < 1 || pontosVida > 300) {
                System.out.println("Por favor escolha entre 1 e 300 pontos");
                pontosVida = sc.nextInt();
            }
            vida = pontosVida + ((300 - pontosVida)%5);
            forca = 20 + ((300 - pontosVida)/5);
            ouro = 1000;
        } else {
            pontos = 220;
            System.out.println("Quantos dos 220 pontos deseja colocar na sua vida? O restante dos pontos serão colocados na \n sua força, sendo que são necessários 5 pontos para aumentar o nível de força");
            pontosVida = sc.nextInt();
            while (pontosVida < 1 || pontosVida > 220) {
                System.out.println("Por favor escolha entre 1 e 220 pontos");
                pontosVida = sc.nextInt();
            }
            vida = pontosVida + ((220 - pontosVida)%5);
            forca = 20 + ((220 - pontosVida)/5);
            ouro = 750;
        }

        ArrayList<Heroi> arrayAuxiliar = new ArrayList<>();

        switch (classe) {
            case 0:
                Cavaleiro lancelot = new Cavaleiro(nome, vida, forca, 1, ouro, lancaBasica);
                arrayAuxiliar.add(lancelot);
                break;
            case 1:
                Feiticeiro merlin = new Feiticeiro(nome, vida, forca, 1, ouro, varinhaBasica);
                arrayAuxiliar.add(merlin);
                break;
            case 2:
                Arqueiro robinHood = new Arqueiro(nome, vida, forca, 1, ouro, arcoBasico);
                arrayAuxiliar.add(robinHood);
                break;
        }

        System.out.println("Personagem criada com sucesso");
        arrayAuxiliar.get(0).mostrarDetalhes();
        return arrayAuxiliar.get(0);
    }

    /**
     * Método responsável por gerar o jogo
     * Observação: cada encontro com um inimigo (ou vendedor) conta como uma sala diferente. Como antes de cada encontro é providenciado um contexto,
     * e para efeitos de optimização do código, não foram criados métodos para cada encontro.
     * @param heroi Herói da aventura
     */
    public void aventuraMagica(Heroi heroi){
        ArmaPrincipal lancaAvancada = new ArmaPrincipal(2500,"Lança avançada", new ArrayList<>(Arrays.asList("Lancelot")), 60, 30);
        ArmaPrincipal varinhaAvancada = new ArmaPrincipal(2500,"Varinha avançada", new ArrayList<>(Arrays.asList("Merlin")), 40, 20);
        ArmaPrincipal arcoAvancado = new ArmaPrincipal(2500,"Arco avançado", new ArrayList<>(Arrays.asList("Robin Hood")), 80, 40);
        ArmaPrincipal lancaDeluxe = new ArmaPrincipal(5000,"Lança deluxe", new ArrayList<>(Arrays.asList("Lancelot")), 120, 60);
        ArmaPrincipal varinhaDeluxe = new ArmaPrincipal(5000,"Varinha deluxe", new ArrayList<>(Arrays.asList("Merlin")), 80, 40);
        ArmaPrincipal arcoDeluxe = new ArmaPrincipal(5000,"Arco deluxe", new ArrayList<>(Arrays.asList("Robin Hood")), 160, 80);
        ConsumivelCombate bomba = new ConsumivelCombate(500, "Bomba", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")), 75);
        ConsumivelCombate bombaSuper = new ConsumivelCombate(1500, "Super bomba", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")), 150);
        ConsumivelCombate bombaUltra = new ConsumivelCombate(3000, "Bomba ultra", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")), 300);
        Pocao pocao = new Pocao(300, "Poção", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")),100, 0);
        Pocao pocaoSuper = new Pocao(900, "Super poção", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")),200, 0);
        Pocao pocaoUltra = new Pocao(1800, "Poção ultra", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")),300, 0);
        Pocao tonico = new Pocao(2500, "Tónico", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")), 0, 15);
        Pocao tonicoSuper = new Pocao(5000, "Super tónico", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")), 0, 30);
        Pocao tonicoUltra = new Pocao(7500, "Tónico ultra", new ArrayList<>(Arrays.asList("Lancelot",  "Merlin", "Robin Hood")), 0, 45);
        Vendedor vendedor = new Vendedor();

        vendedor.AdicionarItems(lancaAvancada);
        vendedor.AdicionarItems(lancaDeluxe);
        vendedor.AdicionarItems(varinhaAvancada);
        vendedor.AdicionarItems(varinhaDeluxe);
        vendedor.AdicionarItems(arcoAvancado);
        vendedor.AdicionarItems(arcoDeluxe);
        vendedor.AdicionarItems(bomba);
        vendedor.AdicionarItems(bombaSuper);
        vendedor.AdicionarItems(bombaUltra);
        vendedor.AdicionarItems(pocao);
        vendedor.AdicionarItems(pocaoSuper);
        vendedor.AdicionarItems(pocaoUltra);
        vendedor.AdicionarItems(tonico);
        vendedor.AdicionarItems(tonicoSuper);
        vendedor.AdicionarItems(tonicoUltra);

        NPC slime = new NPC("Slime", 50, 15, 250);
        NPC goblin = new NPC("Goblin", 75, 20, 400);
        NPC wolf = new NPC("Lobo", 85, 22, 500);
        NPC bandit = new NPC("Bandido", 100, 25, 600);
        NPC assassin = new NPC("Assassino", 130, 30, 1000);
        NPC darkMage = new NPC("Mago negro", 160, 32, 1300);
        NPC mummy = new NPC("Múmia", 180, 40, 1750);
        NPC ogre = new NPC("Ogro", 200, 45, 2100);
        NPC vampire = new NPC("Vampiro", 250, 50, 2700);
        NPC wyvern = new NPC("Wyvern", 300, 65, 3500);
        NPC kingChaos = new NPC("Rei do caos", 500, 75, 0);

        System.out.println("Em \"Aventura Mágica\", o herói embarca em uma jornada repleta de desafios e inimigos perigosos," +
                "\nem um mundo cheio de magia e mistério. Equipado com armas poderosas e poções mágicas, ele deve enfrentar " +
                "\ncriaturas como slimes, goblins e até poderosos magos negros. Com escolhas estratégicas e habilidade de combate, " +
                "\no herói busca conquistar recompensas e fortalecer suas habilidades. À medida que avança, novas ameaças surgem, " +
                "\ntestando sua coragem e inteligência. Sua missão é superar cada obstáculo, derrotar chefões e, finalmente, alcançar " +
                "\na vitória em um cenário repleto de magia e aventura.");

        System.out.println();
        System.out.println("Deseja seguir pelo Bosque das Trevas ou pela Montanha Misteriosa?");
        System.out.println("0-Bosque das Trevas");
        System.out.println("1-Montanha Misteriosa");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option != 0 && option != 1) {
            System.out.println("Por favor, escolha uma opção válida");
            option = sc.nextInt();
        }

        if (option == 0) {
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            System.out.println("Entraste em uma fazenda abandonada a procura de comida");
            if (!heroi.atacar(slime)) {
                tryAgain(heroi);
            }
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();
            System.out.println("Seguiste por uma trilha estreita com pegadas de vários animais");
            if (!heroi.atacar(wolf)) {
                tryAgain(heroi);
            }
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();

            System.out.println("Encontraste uma bifurcação. No horizonte consegue ver, de um lado, algumas ruínas, do outro, uma caverna." +
                    "\nPara onde deseja ir?");
            System.out.println("0-Ruínas");
            System.out.println("1-Caverna");
            sc = new Scanner(System.in);
            option = sc.nextInt();

            while (option != 0 && option != 1) {
                System.out.println("Por favor, escolha uma opção válida");
                option = sc.nextInt();
            }

            if (option == 1) {
                caverna(heroi);
            }
            if (option == 0){
                System.out.println("Nas ruínas te deparaste com vários corpos com feridas de corte em decomposição");
                if (!heroi.atacar(assassin)) {
                    tryAgain(heroi);
                }
            }

            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();

            System.out.println("Encontraste uma bifurcação. No horizonte consegue ver, de um lado, um cemitério e, do outro, uma fonte." +
                    "\nPara onde deseja ir?");
            System.out.println("0-Cemitério");
            System.out.println("1-Fonte da juventude");
            sc = new Scanner(System.in);
            option = sc.nextInt();

            while (option != 0 && option != 1) {
                System.out.println("Por favor, escolha uma opção válida");
                option = sc.nextInt();
            }

            if (option == 1) {
                fonte(heroi);
            }
            if (option == 0){
                System.out.println("Te deparaste com um sarcófago em aberto");
                if (!heroi.atacar(mummy)) {
                    tryAgain(heroi);
                }
            }

            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();
            System.out.println("Encontraste uma mansão abandonada e decidiste explora-la em na esperança de achar algum tesouro");
            if (!heroi.atacar(vampire)) {
                tryAgain(heroi);
            }
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();
            System.out.println("No fim do bosque apenas um castelo decaído. Sente-te que a batalha final se aproxima...");
            if (!heroi.atacar(kingChaos)); {
                tryAgain(heroi);
            }
            System.out.println("O herói ganhou o jogo!");
            tryAgain(heroi);
        } else {
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            System.out.println("Ouviste um barulho perto de algumas rochas e decidiste investigar");
            if (!heroi.atacar(goblin)) {
                tryAgain(heroi);
            }
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();
            System.out.println("Decidiste descançar perto da nascente de um rio até o amanhecer quando de repente começaste a ouvir passos");
            if (!heroi.atacar(bandit)) {
                tryAgain(heroi);
            }
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();

            System.out.println("Encontraste uma bifurcação. No horizonte consegue ver, de um lado, uma torre antiga e, do outro, um altar." +
                    "\nPara onde deseja ir?");
            System.out.println("0-Torre");
            System.out.println("1-Altar");
            sc = new Scanner(System.in);
            option = sc.nextInt();

            while (option != 0 && option != 1) {
                System.out.println("Por favor, escolha uma opção válida");
                option = sc.nextInt();
            }

            if (option == 1) {
                altar(heroi);
            }
            if (option == 0){
                System.out.println("Na livraria da torre, ouviste o que pareciam encantamentos");
                if (!heroi.atacar(darkMage)) {
                    tryAgain(heroi);
                }
            }

            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();

            System.out.println("Encontraste uma bifurcação. No horizonte consegue ver, de um lado, uma gaiola e, do outro, uma arena." +
                    "\nPara onde deseja ir?");
            System.out.println("0-Gaiola");
            System.out.println("1-Arena");
            sc = new Scanner(System.in);
            option = sc.nextInt();

            while (option != 0 && option != 1) {
                System.out.println("Por favor, escolha uma opção válida");
                option = sc.nextInt();
            }

            if (option == 1) {
                arena(heroi);
            }
            if (option == 0){
                System.out.println("A gaiola é enorme e possui um buraco onde a porta deveria estar");
                if (!heroi.atacar(ogre)) {
                    tryAgain(heroi);
                }
            }

            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();
            System.out.println("Depaste-te com o que parece ser um ninho gigante");
            if (!heroi.atacar(wyvern)) {
                tryAgain(heroi);
            }
            System.out.println("Encontraste um mercador");
            vendedor.vender(heroi);
            heroi.UsarPocao();
            System.out.println("No pico da montanha existe apenas um castelo decaído. Sente-te que a batalha final se aproxima...");
            if (!heroi.atacar(kingChaos)) {
                tryAgain(heroi);
            }
            System.out.println("O herói ganhou o jogo!");
            tryAgain(heroi);
        }
    }



    /**
     * Método que controla a sala "arena"
     * @param heroi Herói da aventura
     */
    public void arena(Heroi heroi) {
        System.out.println("A arena parece estar abandonada... mas decidiste explorar um pouco mais");

        Random rand = new Random();
        int luck = rand.nextInt(10);

        if (luck < 5) {
            System.out.println("Foste emboscado por um grupo de bandidos ao qual pertencia o bandido que matou. Eles decidem vingar-se roubando a sua vida... Fim de jogo");
            tryAgain(heroi);
        } else {
            System.out.println("Encontraste um guerreiro que tinha sido abandonado na prisão. Em compensação por ajudá-lo, o guerreiro te dá um anel mágico de força");
            heroi.setForca(heroi.getForca() + 100);
            System.out.println((heroi.getForca() - 100) + " ---> " + heroi.getForca());
        }
    }

    /**
     * Método que controla a sala "altar"
     * @param heroi Herói da aventura
     */
    public void altar(Heroi heroi) {
        System.out.println("Encontraste uma lâmpada no altar e decidiste a esfregar");

        Random rand = new Random();
        int luck = rand.nextInt(10);

        if (luck < 5) {
            System.out.println("Um génio é libertado... mas ele tinha sido aprisionado por uma boa razão. Todo o seu ouro foi roubado");
            System.out.println(heroi.getOuro() + " ---> " + 0);
            heroi.setOuro(0);
        } else {
            System.out.println("Um génio é libertado e como agradecimento ele te dá 5000 moedas de ouro");
            System.out.println(heroi.getOuro() + " ---> " + heroi.getOuro() + 5000);
            heroi.setOuro(heroi.getOuro() + 5000);
        }
    }

    /**
     * Método que controla a sala "caverna"
     * @param heroi Herói da aventura
     */
    public void caverna(Heroi heroi) {
        System.out.println("Encontraste um misterioso elixir abandonado perto de uma tocha na caverna e decidiste o beber");

        Random rand = new Random();
        int luck = rand.nextInt(10);

        if (luck < 5) {
            System.out.println("O elixir era um veneno disfarçado. Perdeste 15 pontos de força");
            heroi.setForca(heroi.getForca() - 15);
            System.out.println((heroi.getForca() + 15) + " ---> " + heroi.getForca());
        } else {
            System.out.println("Bebeste o elixir. Ganhaste 15 pontos de força");
            heroi.setForca(heroi.getForca() + 15);
            System.out.println((heroi.getForca() - 15) + " ---> " + heroi.getForca());
        }
    }

    /**
     * Método que controla a sala "fonte"
     * @param heroi Herói da aventura
     */
    public void fonte(Heroi heroi) {
        System.out.println("Encontraste uma fada observando a fonte e decidiste falar com ela");

        Random rand = new Random();
        int luck = rand.nextInt(10);

        if (luck < 5) {
            System.out.println("A fada não gostou de ti. A tua vida máxima foi cortada pela metade");
            heroi.setMaxHP(heroi.getMaxHP()/2);
            heroi.setHP(heroi.getMaxHP());
            System.out.println((heroi.getMaxHP()*2) + " ---> " + heroi.getMaxHP());
        } else {
            System.out.println("A fada gostou de ti. Ganhaste 125 pontos de vida");
            heroi.setMaxHP(heroi.getMaxHP() + 125);
            heroi.setHP(heroi.getMaxHP());
            System.out.println((heroi.getMaxHP() - 125) + " ---> " + heroi.getMaxHP());
        }
    }

    /**
     * Método ativado após o herói morrer que dá opções de continuação ao jogador
     * @param heroi Herói da aventura que acabou de morrer
     */
    public void tryAgain(Heroi heroi) {
        System.out.println("Escolha uma das seguintes opções");
        System.out.println("0-Sair");
        System.out.println("1-Jogar com a mesma personagem");
        System.out.println("2-Jogar com uma nova personagem");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option < 0 || option > 2) {
            System.out.println("Por favor, escolha uma opção válida");
            option = sc.nextInt();
        }

        if (option == 0) {
            System.exit(0);
        }
        if (option == 1) {
            heroi.setHP(heroi.getMaxHP());
            aventuraMagica(heroi);
        }
        if (option == 2) {
            aventuraMagica(criarPersonagem());
        }
    }
}
