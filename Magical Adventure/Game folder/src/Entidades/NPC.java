package Entidades;

/**
 * Classe responsável pelo design de entidades do tipo NPC
 */
public class NPC extends Entidade {
    protected int ouro;

    /**
     * Método construtor da entidade do tipo NPC
     * @param nome Nome da entidade
     * @param maxHP Vida máxima da entidade
     * @param forca Nível de força da entidade
     * @param ouro Valor em ouro que a entidade possui e que o herói irá obter se matar a entidade
     */
    public NPC(String nome, int maxHP, int forca, int ouro) {
        super(nome, maxHP, forca);
        this.ouro = ouro;
    }


}
