package Classes;

public abstract class Personagem{

    private String nome;
    private int hp;
    private int hpMax;
    private int defesaBase;

    public Personagem(String nome, int hpMax, int defesaBase) {
        this.nome = nome;
        this.hp = hpMax;
        this.hpMax = hpMax;
        this.defesaBase = defesaBase;
    }

    public void atacar(Personagem alvo) {
        alvo.receberDano(getPoderAtaque());
    }

    public void receberDano(int quantidade){
        if (hp - quantidade < 0){
            hp = 0;
            return;
        }
        hp -= quantidade;
    }

    public void receberDano(int quantidade, boolean critico){
        if (critico){
            receberDano(quantidade * 2);
        }
    }

    public void receberCura(int quantidade){}

    public abstract void exibirStatus();

    protected abstract int getPoderAtaque();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public void setDefesaBase(int defesaBase) {
        this.defesaBase = defesaBase;
    }
}
