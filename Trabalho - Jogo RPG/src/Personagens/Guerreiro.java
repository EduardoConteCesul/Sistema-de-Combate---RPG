package Personagens;

import Classes.Personagem;
import Interfaces.Especial;

public class Guerreiro extends Personagem implements Especial {
    private int forca;
    private int stamina;
    private boolean gritoUsado;
    private int bonusForca;

    public Guerreiro(String nome, int hp, int hpMax, int defesaBase, int forca, int stamina, boolean gritoUsado, int bonusForca){
        super(nome, hp, hpMax, defesaBase);
        this.forca = forca;
        this.stamina = stamina;
        this.gritoUsado = gritoUsado;
        this.bonusForca = bonusForca;
    }
    @Override
    protected int getPoderAtaque();
}
