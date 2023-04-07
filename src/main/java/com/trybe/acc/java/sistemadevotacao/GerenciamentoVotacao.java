package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private Set<String> cpfComputado = new HashSet<String>();
  private int totalVotos;

  /**
   * Cadastrto de pessoa candidata.
   * 
   * @param nome Nome da pessoa candidata.
   * @param numero Numero da pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata pessoa = new PessoaCandidata(nome, numero);
    boolean verificaCadastro = false;
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        verificaCadastro = true;
        break;
      }
    }
    if (verificaCadastro) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      pessoasCandidatas.add(pessoa);
    }
  }

  /**
   * Cadastro de pessoa eleitora.
   * 
   * @param nome Nome da pessoa eleitora.
   * @param cpf Cpf da pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora pessoa = new PessoaEleitora(nome, cpf);
    boolean verificaCadastro = false;
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        verificaCadastro = true;
        break;
      }
    }
    if (verificaCadastro) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      pessoasEleitoras.add(pessoa);
    }
  }

  /**
   * Voto de uma pessoa eleitora para uma pessoa candidata
   * 
   * @param cpfPessoaEleitora Cpf para validar voto.
   * @param numeroPessoaCandidata Numero para voto.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        if (pessoa.getNumero() == numeroPessoaCandidata) {
          pessoa.receberVoto();
        }
      }
      cpfComputado.add(cpfPessoaEleitora);
      totalVotos++;
    }
  }

  /**
   * Mostra resultado da votação.
   */
  public void mostrarResultado() {
    if (cpfComputado.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      int indice = 0;
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        double porcentagemVotos = calcularPorcentagemVotos(indice);
        String text = String.format("Nome: %s - %d votos ( %s%% )", pessoa.getNome(),
            pessoa.getVotos(), porcentagemVotos);
        System.out.println(text);
        indice++;
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }

  /**
   * Calcula e retorna porcentagem total dos votos.
   * 
   * @param indice Indice da pessoa candidata na lista pessoasCandidatas.
   * @return Porcentagem de votos.
   */
  private double calcularPorcentagemVotos(int indice) {
    double porcentagemVotos = (double) pessoasCandidatas.get(indice).getVotos() * 100 / totalVotos;
    return Math.round(porcentagemVotos);
  }
}
