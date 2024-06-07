package br.com.hospitalticiano.api.service;

import br.com.hospitalticiano.api.model.Exames;
import br.com.hospitalticiano.api.model.Paciente;
import br.com.hospitalticiano.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public void creat(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id){
        return pacienteRepository.findById(id);
    }
    public void update(Long id, Paciente paciente){
        Optional<Paciente> pacienteFromDb = findById(id);

        if (pacienteFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado no banco de dados");
        }
        Paciente pacienteUpdated = pacienteFromDb.get();
        pacienteUpdated.setId(paciente.getId());
        pacienteUpdated.setName(paciente.getName());


        pacienteRepository.save(pacienteUpdated);
    }
}