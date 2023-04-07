package com.trybe.acc.java.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Construtor.
   * 
   * @param nome Nome da pessoa candidata.
   * @param numero Numero da pessoa candidata.
   */
  public PessoaCandidata(String nome, int numero) {
    this.setNome(nome);
    this.setNumero(numero);
    this.setVotos(0);
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  /**
   * Inserir votos da pessoa candidata.
   * 
   * @param votos Colocar numero de votos da pessoa.
   */
  private void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    votos++;
  }
}
