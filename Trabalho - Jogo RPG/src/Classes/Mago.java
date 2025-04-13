package Classes;

import Interfaces.Especial;

public class Mago extends Personagem implements Especial {

    private int poderMagico;
    private int mana;

    public Mago(String nome, int hp, int hpMax, int defesaBase, int poderMagico, int mana) {
        super(nome, hp, hpMax, defesaBase);
        this.poderMagico = poderMagico;
        this.mana = mana;
    }

    @Override
    protected int getPoderAtaque() {
        return poderMagico / 2;
    }

    @Override
    public void exibirStatus() {

    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {

    }
}
