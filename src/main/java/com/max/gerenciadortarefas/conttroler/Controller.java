package com.max.gerenciadortarefas.conttroler;

import com.max.gerenciadortarefas.model.Tarefa;
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
    }

    public void removerTarefa(Tarefa tarefa) {
        entityManager.remove(entityManager.merge(tarefa));
        tarefas.remove(tarefa);
    }

    public void concluirTarefa(Tarefa tarefa) {
        tarefa.setConcluida(true);
        entityManager.merge(tarefa);
    }


    public void atualizarTarefa(Tarefa tarefa) {
        entityManager.merge(tarefa);
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return entityManager.find(Tarefa.class, id);
    }
}
