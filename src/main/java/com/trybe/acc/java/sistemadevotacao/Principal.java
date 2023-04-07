package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Método principal do projeto.
   * 
   * @param args Não utilizado.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    while (true) {
      System.out.println("Cadastrar pessoa candidata?\n" + "        1 - Sim\n" + "        2 - Não\n"
          + "        Entre com o número correspondente à opção desejada:");
      byte choice = scan.nextByte();
      if (choice == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scan.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scan.nextInt();

        votacao.cadastrarPessoaCandidata(nome, numero);
      } else if (choice == 2) {
        break;
      }
    }

    while (true) {
      System.out.println("Cadastrar pessoa eleitora?\n" + "        1 - Sim\n" + "        2 - Não\n"
          + "        Entre com o número correspondente à opção desejada:");
      byte choice = scan.nextByte();
      if (choice == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scan.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();

        votacao.cadastrarPessoaEleitora(nome, cpf);
      } else if (choice == 2) {
        break;
      }
    }

    while (true) {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "     1 - Votar\n" + "     2 - Resultado Parcial\n" + "     3 - Finalizar Votação");
      byte choice = scan.nextByte();
      if (choice == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scan.nextInt();

        votacao.votar(cpf, numero);
      } else if (choice == 2 || choice == 3) {
        votacao.mostrarResultado();
        if (choice == 3) {
          break;
        }
      }
    }

    scan.close();
  }

}

