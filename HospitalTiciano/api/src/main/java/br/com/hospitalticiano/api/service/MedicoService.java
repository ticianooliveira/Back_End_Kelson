package br.com.hospitalticiano.api.service;

import br.com.hospitalticiano.api.model.Exames;
import br.com.hospitalticiano.api.model.Medico;
import br.com.hospitalticiano.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public void creat(Medico medico){
        medicoRepository.save(medico);
    }

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }
    public Optional<Medico> findById(Long id){
        return medicoRepository.findById(id);
    }
    public void update(Long id, Medico medico){
        Optional<Medico> medicoFromDb = findById(id);

        if (medicoFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado no banco de dados");
        }
        Medico medicoUpdated = medicoFromDb.get();
        medicoUpdated.setId(medico.getId());
        medicoUpdated.setName(medico.getName());
        medicoUpdated.setEmail(medico.getEmail());

        medicoRepository.save(medicoUpdated);
    }
}