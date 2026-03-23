package com.decimo.tarefas.Services;

import com.decimo.tarefas.Repositories.TarefaRepository;
import com.decimo.tarefas.models.TarefaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaModel criarTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    public List<TarefaModel> findAll() {
        return tarefaRepository.findAll();
    }

    public TarefaModel findById(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

}
