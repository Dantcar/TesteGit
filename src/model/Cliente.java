/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe base para gerar objetos do tipo Cliente
 * @author aluno
 */
public class Cliente {
    private String nome;
    private String cpf;
    private float renda;
    private boolean ativo;

    public Cliente(){
        
    }
    
    public Cliente(String nome, String cpf, float renda, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.ativo = ativo;
    }

    /**
     * @return the nome
     */   
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the renda
     */
    public float getRenda() {
        return renda;
    }

    /**
     * @param renda the renda to set
     */
    public void setRenda(float renda) {
        this.renda = renda;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
