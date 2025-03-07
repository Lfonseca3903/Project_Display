package Entidades;

/**
 *  Classe responsável pelo design geral de entidades
 */
public abstract class Entidade {
    /**
     * Nome da entidade
     */
    protected String nome;
    /**
     * Vida máxima da entidade
     */
    protected int maxHP;
    /**
     * Vida atual da entidade
     */
    protected int HP;
    /**
     * Nível de força da entidade
     */
    protected int forca;

    /**
     * Método construtor da entidade
     * <p>Como a entidade deve ser instanciada com a vida atual igual à vida máxima, {@link #HP} não é passado como
     * parâmetro</p>
     * @param nome Nome da entidade
     * @param maxHP Vida máxima da entidade
     * @param forca Nível de força da entidade
     */
    public Entidade(String nome, int maxHP, int forca) {
        this.nome = nome;
        this.maxHP = maxHP;
        this.HP = maxHP;
        this.forca = forca;
    }

    /**
     * Método para mostrar os detalhes da entidade
     */
    public void mostrarDetalhes() {
        System.out.println("****************************");
        System.out.println("Nome: " + nome);
        System.out.println("Vida máxima: " + maxHP);
        System.out.println("Vida atual: " + HP);
        System.out.println("Força: " + forca);
    }

    /**
     * Método para aceder ao nível de força da entidade em classes que não herdam a classe {@link Entidade}
     * @return Nível de força da entidade
     */
    public int getForca() {
        return forca;
    }

    /**
     * Método para aceder à vida máxima da entidade em classes que não herdam a classe {@link Entidade}
     * @return Vida máxima da entidade
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * Método para aceder à vida atual da entidade em classes que não herdam a classe {@link Entidade}
     * @return Vida atual da entidade
     */
    public int getHP() {
        return HP;
    }

    /**
     * Método para alterar a vida máxima do herói quando essa muda por qualquer razão
     * @param maxHP Vida máxima do herói
     */
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    /**
     * Método para alterar o nível de força do herói quando esse muda por qualquer razão
     * @param forca Nível de força do herói
     */
    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * Método para modificar a vida atual da entidade em métodos que o necessitem, por exemplo quando uma entidade
     * ataca a outra
     * @param HP Vida atual da entidade
     */
    public void setHP(int HP) {
        this.HP = HP;
    }
}
