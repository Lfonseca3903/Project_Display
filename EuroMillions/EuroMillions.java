import java.util.*;

public class EuroMillions {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static ArrayList<Integer> numeros, estrelas, numerosVencedores, estrelasVencedoras, numerosOrdem, estrelasOrdem, numerosPossiveis, estrelasPossiveis;
    static ArrayList<ArrayList<Integer>> chaves, chaveVencedora, ordemSaida;
    public static final String GREEN = "\033[32m";
    public static final String BLUE = "\033[34m";
    public static final String RED = "\033[31m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {

        int op = 0;

        do {
            numerosPossiveis = new ArrayList<>();
            estrelasPossiveis = new ArrayList<>();
            numerosVencedores = new ArrayList<>();
            estrelasVencedoras = new ArrayList<>();
            chaveVencedora = new ArrayList<>();
            numerosOrdem = new ArrayList<>();
            estrelasOrdem = new ArrayList<>();
            ordemSaida = new ArrayList<>();
            chaves = new ArrayList<>();
            numeros = new ArrayList<>();
            estrelas = new ArrayList<>();

            System.out.println();
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1- Gerar uma chave vencedora");
            System.out.println("2- Jogar com chaves próprias");
            System.out.println("3- Jogar com chaves aleatórias");
            System.out.println("4- Simular um jogo");
            System.out.println("0- Sair");
            sc = new Scanner(System.in);
            op = validadorInputs(op, 0, 5);

            switch (op) {
                case 1:
                    geradorChaveVencedora();
                    break;
                case 2:
                    jogarChavesProprias();
                    break;
                case 3:
                    jogarChavesAleatorias();
                    break;
                case 4:
                    simularJogo();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    public static void geradorChaveVencedora() {

        possiveis(50, numerosPossiveis);
        possiveis(12, estrelasPossiveis);

        geradorChaves(5, numerosPossiveis, numerosVencedores);
        geradorChaves(2, estrelasPossiveis, estrelasVencedoras);

        ordem(numerosVencedores, numerosOrdem);
        ordem(estrelasVencedoras, estrelasOrdem);

        displayVencedor();
    }

    public static void displayNormal(String string, ArrayList<Integer> array) {

        for (Integer integer : array) {
            System.out.print(string + "{" + integer + "}" + RESET);
        }
    }

    public static void displayVencedor() {

        System.out.print("Chave vencedora: ");
        displayNormal(GREEN, numerosVencedores);
        System.out.print("-");
        displayNormal(GREEN, estrelasVencedoras);
        System.out.println();
        System.out.print("Ordem de saída: ");
        displayNormal(BLUE, numerosOrdem);
        System.out.print("-");
        displayNormal(BLUE, estrelasOrdem);
    }

    public static void ordem(ArrayList<Integer> array1, ArrayList<Integer> array2) {

        ArrayList<Integer> temp = new ArrayList<>(array1);

        for (int i = 0; i < array1.size(); i++) {
            int num = (temp.get(rand.nextInt(temp.size())));
            array2.add(num);
            temp.remove(Integer.valueOf(num));
        }
    }

    public static void geradorChaves(int length, ArrayList<Integer> array1, ArrayList<Integer> array2) {

        for (int i = 0; i < length; i++) {
            if (!array1.isEmpty()) {
                int num = (array1.get(rand.nextInt(array1.size())));
                array1.remove(Integer.valueOf(num));
                array2.add(num);
            } else {
                break;
            }
        }
    }

    public static void possiveis(int length, ArrayList<Integer> array) {

        for (int i = 1; i < length + 1; i++) {
            array.add(i);
        }
    }

    public static int validadorInputs(int input, int limiteMinimo, int limiteMaximo) {

        try {

            input = sc.nextInt();

            while (input < limiteMinimo || input > limiteMaximo) {
                System.out.println("Por favor, escolha uma opção válida");
                input = sc.nextInt();
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: " + e.getMessage());
            System.exit(0);
        }

        return input;
    }

    private static void jogarChavesProprias() {

        System.out.println("Por favor, escolha o número de chaves. Pode jogar com até 5 chaves");
        int num = 0;
        num = validadorInputs(num, 1, 6);
        int cont = 0;

        possiveis(50, numerosPossiveis);
        geradorChaves(5, numerosPossiveis, numerosVencedores);
        numerosPossiveis.clear();
        possiveis(12, estrelasPossiveis);
        geradorChaves(2, estrelasPossiveis, estrelasVencedoras);
        estrelasPossiveis.clear();
        ordem(numerosVencedores, numerosOrdem);
        ordem(estrelasVencedoras, estrelasOrdem);

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                possiveis(50, numerosPossiveis);
                System.out.println("Por favors escolha o " + (j + 1) + "º " + "número da " + (i + 1) + "ª chave");
                int pos = 0;
                pos = validadorInputs(pos, 1, 51);
                while (numeros.contains(pos)) {
                    System.out.println("Por favor, escolha um número que ainda não tenha escolhido");
                    pos = validadorInputs(pos, 1, 51);
                }
                numeros.add(pos);
            }
            for (int k = 0; k < 2; k++) {
                possiveis(12, estrelasPossiveis);
                System.out.println("Por favors escolha a " + (k + 1) + "ª " + "estrela da " + (i + 1) + "ª chave");
                int pos = 0;
                pos = validadorInputs(pos, 1, 13);
                while (estrelas.contains(pos)) {
                    System.out.println("Por favor, escolha uma estrela que ainda não tenha sido escolhida");
                    pos = validadorInputs(pos, 1, 13);
                }
                estrelas.add(pos);
            }
            numerosPossiveis.clear();
            estrelasPossiveis.clear();
            ArrayList<Integer> aux1 = new ArrayList<>(numeros);
            chaves.add(aux1);
            ArrayList<Integer> aux2 = new ArrayList<>(estrelas);
            chaves.add(aux2);
            if (numerosVencedores.containsAll(numeros) && estrelasVencedoras.containsAll(estrelas)) {
                cont++;
            }
            numeros.clear();
            estrelas.clear();
        }

        for (int i = 0; i < num*2; i++) {
            if (i < 3) {
                if (i % 2 == 0) {
                    chaveVerificador(chaves.get(i).size(), chaves.get(i), numerosVencedores);
                    System.out.print("-");
                    chaveVerificador(chaves.get(i + 1).size(), chaves.get(i + 1), estrelasVencedoras);
                    System.out.println();
                }
            }
        }

        if (cont > 0) {
            System.out.println("Parabéns! Ganhaste no Euromilhões");
        }

        displayVencedor();
    }

    private static void jogarChavesAleatorias() {

        System.out.println("Por favor, escolha o número de chaves. Pode gerar entre 1 e 5 chaves");
        int num = 0;
        num = validadorInputs(num, 1, 6);
        int cont = 0;

        possiveis(50, numerosPossiveis);
        geradorChaves(5, numerosPossiveis, numerosVencedores);
        numerosPossiveis.clear();
        possiveis(12, estrelasPossiveis);
        geradorChaves(2, estrelasPossiveis, estrelasVencedoras);
        estrelasPossiveis.clear();
        ordem(numerosVencedores, numerosOrdem);
        ordem(estrelasVencedoras, estrelasOrdem);


        for (int i = 0; i < num; i++) {
            possiveis(50, numerosPossiveis);
            geradorChaves(5, numerosPossiveis, numeros);
            possiveis(12, estrelasPossiveis);
            geradorChaves(2, estrelasPossiveis, estrelas);
            chaveVerificador(numeros.size(), numeros, numerosVencedores);
            System.out.print("-");
            chaveVerificador(estrelas.size(), estrelas, estrelasVencedoras);
            if (numerosVencedores.containsAll(numeros) && estrelasVencedoras.containsAll(estrelas)) {
                cont++;
            }
            numeros.clear();
            estrelas.clear();
            numerosPossiveis.clear();
            estrelasPossiveis.clear();
            System.out.println();
        }

        displayVencedor();

        if (cont > 0) {
            System.out.println("Parabéns! Ganhaste no Euromilhões");
        }
    }

    private static void chaveVerificador(int length, ArrayList<Integer> array1, ArrayList<Integer> array2) {

        for (int j = 0; j < length; j++) {
            ArrayList<Integer> aux = new ArrayList<>();
            aux.add(array1.get(j));
            if (array2.contains(aux.getFirst())) {
                displayNormal(GREEN, aux);
            } else {
                displayNormal(RED, aux);
            }
        }
    }

    private static void simularJogo() {

        int cont = 0;

        possiveis(50, numerosPossiveis);
        geradorChaves(5, numerosPossiveis, numerosVencedores);
        numerosPossiveis.clear();
        possiveis(12, estrelasPossiveis);
        geradorChaves(2, estrelasPossiveis, estrelasVencedoras);
        estrelasPossiveis.clear();
        ordem(numerosVencedores, numerosOrdem);
        ordem(estrelasVencedoras, estrelasOrdem);

        possiveis(50, numerosPossiveis);
        geradorChaves(5, numerosPossiveis, numeros);
        possiveis(12, estrelasPossiveis);
        geradorChaves(2, estrelasPossiveis, estrelas);

        while (!(numerosVencedores.containsAll(numeros) && estrelasVencedoras.containsAll(estrelas))) {
            numeros.clear();
            estrelas.clear();
            possiveis(50, numerosPossiveis);
            geradorChaves(5, numerosPossiveis, numeros);
            possiveis(12, estrelasPossiveis);
            geradorChaves(2, estrelasPossiveis, estrelas);
            numerosPossiveis.clear();
            estrelasPossiveis.clear();
            cont ++;
            if (cont == 100000) {
                System.out.println("100000 tentativas atingidas!");
            }
            if (cont == 1000000) {
                System.out.println("1000000 tentativas atingidas!");
            }
            if (cont == 10000000) {
                System.out.println("10000000 tentativas atingidas!");
            }
            if (cont == 100000000) {
                System.out.println("100000000 tentativas atingidas!");
            }
            if (cont == 1000000000) {
                System.out.println("1000000000 tentativas atingidas!");
            }
        }

        System.out.println(cont + " tentativas necessárias!");

        displayVencedor();
    }
}
