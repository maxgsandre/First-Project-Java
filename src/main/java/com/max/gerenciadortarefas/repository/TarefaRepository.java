package com.max.gerenciadortarefas.repository;

import com.max.gerenciadortarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByResponsavel(String responsavel);

    List<Tarefa> findByPrioridade(String prioridade);

    List<Tarefa> findByConcluida(boolean concluida);

    Optional<Tarefa> findByTitulo(String titulo);

    List<Tarefa> findByResponsavelAndPrioridade(String responsavel, String prioridade);

    List<Tarefa> findByResponsavelAndConcluida(String responsavel, boolean concluida);

}
