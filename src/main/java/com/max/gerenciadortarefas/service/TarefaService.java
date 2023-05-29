package com.max.gerenciadortarefas.service;

import com.max.gerenciadortarefas.model.Tarefa;
import com.max.gerenciadortarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefa.setData(new Date());
        tarefaRepository.save(tarefa);
    }

    public void removerTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

    public Optional<Tarefa> buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public void concluirTarefa(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if (tarefa.isPresent()) {
            Tarefa tarefaExistente = tarefa.get();
            tarefaExistente.setConcluida(true);
            tarefaRepository.save(tarefaExistente);
        }
    }
}
