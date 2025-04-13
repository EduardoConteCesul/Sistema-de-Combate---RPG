package Personagens;

import Classes.Personagem;
import Interfaces.Especial;

public class Arqueiro extends Personagem implements Especial {
    private int destreza;
    private int flechas;

    public Arqueiro(String nome, int hp, int hpMax, int defesaBase, int destreza, int flechas) {
        super(nome, hp, hpMax, defesaBase);
        this.destreza = destreza;
        this.flechas = flechas;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        alvo.receberDano(tiroDuplo());
    }

    @Override
    protected int getPoderAtaque() {
        if (flechas != 0){
            return destreza;
        }
        return destreza / 2;
    }

    private int tiroDuplo(){
        if (flechas >= 2){
            flechas -= 2;
            return 2 * destreza;
        }
        return 0;
    }

    public void flechaVenenosa(Personagem alvo){
        if (flechas >= 0){
            flechas -= 1;
            alvo.receberDano(destreza);
            System.out.println("Efeito de envenenamento aplicado");
            return;
        }
        System.out.println("Flechas indisponiveis.");
    }

    @Override
    public void exibirStatus() {
        System.out.println(
                "Nome: " + getNome() +
                        " | HP: " + getHp() +
                        " | HpMax: " + getHpMax() +
                        " | Defesa Base: " + getDefesaBase() +
                        " | Número de Flechas: " + flechas
                        // Verificar valor de destreza
        );
    }
}
