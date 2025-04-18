package Personagens;

import Classes.Personagem;
import Interfaces.Especial;

public class Guerreiro extends Personagem implements Especial {
    private int forca;
    private int stamina;
    private boolean gritoUsado;
    private int bonusForca;

    public Guerreiro(String nome, int hpMax, int defesaBase, int forca){
        super(nome, hpMax, defesaBase);
        this.forca = forca;
        this.stamina = 100;
        this.gritoUsado = false;
        this.bonusForca = 5;
    }

    @Override
    protected int getPoderAtaque() {
        return forca + bonusForca;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        alvo.receberDano(espadaMortal());
    }

    public int gritoDeGuerra() {
        if (!gritoUsado ){
            gritoUsado = true;
            return bonusForca + 5;
        }else {
            return bonusForca;
        }
    }


    @Override
    public void exibirStatus() {
        System.out.println(
                "Nome: " + getNome() +
                        " | HP:  " + getHp() +
                        " | HpMax: " + getHpMax() +
                        " | DefesaBase: " + getDefesaBase() +
                        " | Força: " + forca +
                        " | Stamina: " + stamina +
                        " | Bônus força: " + bonusForca
        );
    }

    private int espadaMortal(){
        if (stamina > 20){
            stamina -= 20;
            return 2 * getPoderAtaque();
        }else{
            System.out.println("Guerreiro não tem stamina suficiente");
            return 0;
        }
    }
}
