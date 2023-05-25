package com.max.gerenciadortarefas.controller;

import com.max.gerenciadortarefas.model.Tarefa;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class CadastraTarefaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    private List<Tarefa> tarefas;
    private Tarefa tarefaSelecionada;

    public CadastraTarefaController() {
        tarefas = new ArrayList<>();
        tarefaSelecionada = new Tarefa();
    }

    public List<Tarefa> listarTarefas() {
        return entityManager.createQuery("SELECT t FROM Tarefa t", Tarefa.class).getResultList();
    }

    public void adicionarTarefa() {
        tarefaSelecionada.setData(new Date());
        entityManager.persist(tarefaSelecionada);
        tarefas.add(tarefaSelecionada);
        tarefaSelecionada = new Tarefa();
    }

    public void removerTarefa(Tarefa tarefa) {
        entityManager.remove(entityManager.merge(tarefa));
        tarefas.remove(tarefa);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Tarefa getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }
}
