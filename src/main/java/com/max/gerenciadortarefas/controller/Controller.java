package com.max.gerenciadortarefas.controller;

import com.max.gerenciadortarefas.model.Tarefa;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class Controller implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    private List<Tarefa> tarefas;
    private Tarefa tarefaSelecionada;

    public Controller() {
        tarefas = new ArrayList<>();
        tarefaSelecionada = new Tarefa();
    }

    public List<Tarefa> listarTarefas() {
        return entityManager.createQuery("SELECT t FROM Tarefa t", Tarefa.class).getResultList();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefa.setData(new Date());
        entityManager.persist(tarefa);
        tarefas.add(tarefa);
        tarefaSelecionada = new Tarefa();
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage("Tarefa adicionada com sucesso!"));
    }

    public void removerTarefa(Tarefa tarefa) {
        entityManager.remove(entityManager.merge(tarefa));
        tarefas.remove(tarefa);
    }

    public void buscarTarefaPorId(Long id) {
        tarefaSelecionada = entityManager.find(Tarefa.class, id);
    }

    public void concluirTarefa(Tarefa tarefa) {
        tarefa.setConcluida(true);
        entityManager.merge(tarefa);
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


