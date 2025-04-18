package Personagens;

import Classes.Personagem;
import Interfaces.Especial;
import Interfaces.Suporte;

public class Clerigo extends Personagem implements Especial, Suporte {

    private int fe;
    private int oracoes;

    public Clerigo(String nome, int hpMax, int defesaBase, int fe) {
        super(nome, hpMax, defesaBase);
        this.fe = fe;
        this.oracoes = 5;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        alvo.receberDano(golpeSagrado());
    }

    @Override
    public void curar(Personagem aliado) {
        if ((aliado.getHp() + fe) > aliado.getHpMax()){
            aliado.setHp(aliado.getHpMax());
            return;
        }
        aliado.receberCura(curaDivina());
    }

    @Override
    public void exibirStatus() {
        System.out.println("Status Atual do Personagem:\n"+
                "Nome: " + getNome() +
                " | HP: " + getHp() +
                " | HpMax: " + getHpMax() +
                " | Defesa Base: " + getDefesaBase() +
                " | Fe: " + fe +
                " | Oracoes: " + oracoes
        );
    }

    @Override
    protected int getPoderAtaque() {
        return fe / 2;
    }

    private int golpeSagrado(){
        if (oracoes >= 1){
            oracoes -= 1;
            return fe;
        }
        System.out.println("Oracoes indisponiveis");
        return 0;
    }

    private int curaDivina(){
        return fe;
    }
}
