package com.MercadoMaven.Final.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo")
    private String codigo;

   // @Column(name = "nomeProduto")  // A coluna no banco de dados deve ser nomeProduto
    private String nomeProduto;

    private String descricao;
    private String quantidade;
    private String categoria;
    private String custo;

    @Column(name = "percentualLucro")  // A coluna no banco de dados deve ser percentualLucro
    private String percentualLucro;

    @Column(name = "precoSugerido")  // A coluna no banco de dados deve ser precoSugerido
    private String precoSugerido;

    @Column(name = "valorVenda")  // A coluna no banco de dados deve ser valorVenda
    private String valorVenda;

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getPercentualLucro() {
        return percentualLucro;
    }

    public void setPercentualLucro(String percentualLucro) {
        this.percentualLucro = percentualLucro;
    }

    public String getPrecoSugerido() {
        return precoSugerido;
    }

    public void setPrecoSugerido(String precoSugerido) {
        this.precoSugerido = precoSugerido;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }
}