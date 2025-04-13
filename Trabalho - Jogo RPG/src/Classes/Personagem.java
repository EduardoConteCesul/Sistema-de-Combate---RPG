package Classes;

import com.sun.management.UnixOperatingSystemMXBean;

public abstract class Personagem{

    private String nome;
    private int hp;
    private int hpMax;
    private int defesaBase;

    public Personagem(String nome, int hp, int hpMax, int defesaBase){
        this.nome = nome;
        this.hp = hp;
        this.hpMax = hpMax;
        this.defesaBase = defesaBase;
    }

    public void atacar(Personagem alvo) {

    }

    public void receberDano(int quantidade){

    }

    public void receberDano(int quantidade, boolean critico){

    }

    public void receberCura(int quantidade){

    }

    public abstract void exibirStatus();

    protected abstract int getPoderAtaque();
}
