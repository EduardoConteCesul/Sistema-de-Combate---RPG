package Main;

import Classes.Personagem;
import Interfaces.Especial;
import Personagens.Arqueiro;
import Personagens.Clerigo;
import Personagens.Guerreiro;
import Personagens.Mago;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Personagem> personagems = new ArrayList<>();

        criarPersonagem(scanner, personagems);

        while (contarVivos(personagems) > 1){
            System.out.println("----- NOVO TURNO -----");
            exibirStatusTodos(personagems);

            System.out.println("\n Selecione o personagem que ira agir " + "(digite o número correspondente, ou 0 para encerrar):");
            int opcao = lerInteiro(scanner);
            if (opcao == 0){
                System.out.println("Batalha foi encerrada pelo usuário");
                continue;
            }
            if (opcao < 1 || opcao > personagems.size()){
                System.out.println("Opção inválida! Tente novamente");
                continue;
            }
            Personagem atuante = personagems.get(opcao - 1);

            menuAcoes(scanner, atuante, personagems);
        }
        System.out.println("\n ----- BATALHA ENCERRADA -----");
        exibirStatusTodos(personagems);
        scanner.close();
    }

    private static void menuAcoes(Scanner sc, Personagem atuante, List<Personagem> personagems){
        System.out.println("\n Ações para " + atuante.getNome() + ": ");
        System.out.println("1 - Atacar");
        System.out.println("2 - Usar Habilidade Especial");

        if (atuante instanceof Clerigo){
            System.out.println("3 - Curar Aliado");
        }


        System.out.println("0 - Passar a vez");
        System.out.println("Escolha sua ação");
        int acao = lerInteiro(sc);

        switch (acao){
            case 1:
                Personagem alvoAtaque = escolherAlvo(sc, personagems, atuante);
                if (alvoAtaque != null){
                    atuante.atacar(alvoAtaque);
                }
                break;

            case 2:
                if (atuante instanceof Especial){
                    Personagem alvoEspecial = escolherAlvo(sc, personagems, atuante);
                    if (alvoEspecial != null){
                        ((Especial) atuante).usarHabilidadeEspecial(alvoEspecial);
                    }
                }else {
                    System.out.println(atuante.getNome() + " não possui habilidade especial");
                }
            case 3:
                if (atuante instanceof Clerigo){
                    Personagem alvoEspecial = escolherAlvo(sc, personagems, atuante);
                    if (alvoEspecial != null){
                        ((Clerigo) atuante).curar(alvoEspecial);
                    }

                }else{
                    System.out.println("Opção invalida para este personagem");
                }
                break;
            case 0:
                System.out.println(atuante.getNome() + " passou a vez");
                break;
            default:
                System.out.println("Ação invalida");
        }

    }

    private static Personagem escolherAlvo(Scanner scanner, List<Personagem> personagens, Personagem atuante){

        List<Personagem> alvosDisponiveis = new ArrayList<>();

        for (Personagem p : personagens){
            if (p.getHp() > 0 && p != atuante){
                alvosDisponiveis.add(p);
            }
        }

        if (alvosDisponiveis.isEmpty()){
            System.out.println("Não ha alvos disponiveis");
            return null;
        }

        for (int i = 0; i< alvosDisponiveis.size(); i++){
            Personagem personagem = alvosDisponiveis.get(i);
            System.out.println(i + 1 + " - " + personagem.getNome() +
                    " (" + personagem.getClass().getSimpleName() + ") HP: " + personagem.getHp());
        }

        System.out.println("Digite a opcao do atacado: ");
        int escolha = lerInteiro(scanner);

        if (escolha < 1 || escolha > alvosDisponiveis.size()){
            System.out.println("Opção Invalida! Ação cancelada");
            return null;
        }
        return alvosDisponiveis.get(escolha - 1);

    }

    private static int lerInteiro(Scanner sc){
        int num = 0;
        try{
            num = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Valor Invalido");
        }
        return num;
    }

    private static int contarVivos(List<Personagem> lista){
        int vivos = 0;
        for (Personagem personagem : lista){
            if (personagem.getHp() > 0){
                vivos ++;
            }
        }
        return vivos;
    }


    private static void criarPersonagem(Scanner scanner, List<Personagem> personagems) {

        System.out.println("Quantos personagens deseja criar?");
        int quantidade = lerInteiro(scanner);
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n Criação de personagem numero " + (i + 1) + "---");
            System.out.println("Escolha a classe: ");
            System.out.println("1 - Guerreiro: ");
            System.out.println("2 - Mago: ");
            System.out.println("3 - Arqueiro: ");
            System.out.println("4 - Clérigo: ");
            int classe = lerInteiro(scanner);
            System.out.println("Digite o nome do personagem");
            String nome = scanner.nextLine();
            Personagem personagem = null;

            switch (classe) {
                case 1:
                    personagem = new Guerreiro(nome, 120, 5, 20);
                    break;
                case 2:
                    personagem = new Mago(nome, 90, 2, 30);
                    break;
                case 3:
                    personagem = new Arqueiro(nome, 100,3, 25);
                    break;
                case 4:
                    personagem = new Clerigo(nome, 110, 4, 18);
                    break;
                case 0:
                    System.out.println("Classe invalido");
                    personagem = new Guerreiro(nome, 120, 5, 20);
            }
            personagems.add(personagem);
            System.out.println("Personagem criado: " + personagem.getClass() + "(" + personagem.getClass().getSimpleName() + ")");
        }
    }

    private static void exibirStatusTodos(List<Personagem> personagens){
        System.out.println("----- STATUS ATUAL DOS PERSONAGENS -----");
        for (Personagem personagem : personagens){
            personagem.exibirStatus();
        }
    }
}
