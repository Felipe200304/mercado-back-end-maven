package com.MercadoMaven.Final.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "funcionarios") // Nome da tabela no banco
public class Funcionario {

    @Id
    private String cpf;

    private String nome;

    private String senha;

    private String permissao;

    @Column(name = "salario_220h")
    private BigDecimal salario220h; // Alterado para BigDecimal para valores monetários

    @Column(name = "horas_trabalhadas")
    private Integer horasTrabalhadas; // Alterado para Integer para valores numéricos

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public BigDecimal getSalario220h() {
        return salario220h;
    }

    public void setSalario220h(BigDecimal salario220h) {
        this.salario220h = salario220h;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}