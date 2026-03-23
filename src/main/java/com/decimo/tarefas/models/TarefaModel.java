package com.decimo.tarefas.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Tarefa")
@Table(name = "tb_tarefa")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Descrição da tarefa")
    private String descricao;
    @Column(name = "Data de vencimento")
    private LocalDate dataVencimento;
    @Column(name = "Status de conclusão")
    private String cincluida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCincluida() {
        return cincluida;
    }

    public void setCincluida(String cincluida) {
        this.cincluida = cincluida;
    }
}
