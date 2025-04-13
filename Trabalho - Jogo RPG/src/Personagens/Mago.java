package Personagens;

import Classes.Personagem;
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
    public void usarHabilidadeEspecial(Personagem alvo) {
        alvo.receberDano(bolaFogo());
    }

    private int bolaFogo(){
        if (mana >= 30){
            mana =- 30;
            return 3 * poderMagico;
        }else {
            System.out.println("Mana insuficiente!");
            return 0;
        }
    }

    public void raioCongelante(Personagem alvo){
        if (mana < 20){
            System.out.println("Mana insuficiente!");
            return;
        }
        mana =- 20;
        alvo.receberDano(12);
        System.out.println("Efeito congelamento acionado");
    }

    @Override
    public void exibirStatus() {
        System.out.println(
                "Nome: " + getNome() +
                        " | HP: " + getHp() +
                        " | Defesa: " + getDefesaBase() +
                        " | Poder Mágico: " + poderMagico +
                        " | Mana: " + mana
        );
    }
}
