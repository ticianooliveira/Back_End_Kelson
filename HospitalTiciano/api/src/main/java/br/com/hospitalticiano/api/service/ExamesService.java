package br.com.hospitalticiano.api.service;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.model.Convenio;
import br.com.hospitalticiano.api.model.Exames;
import br.com.hospitalticiano.api.repository.ExamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ExamesService {

    @Autowired
    ExamesRepository examesRepository;

    public void creat(Exames exames){
        examesRepository.save(exames);
    }

    public List<Exames> findAll() {
        return examesRepository.findAll();
    }

    public Optional<Exames> findById(Long id){
        return examesRepository.findById(id);
    }

    public void update(Long id, Exames exames){
        Optional<Exames> examesFromDb = findById(id);

        if (examesFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exame não encontrado no banco de dados");
        }
        Exames examesUpdated = examesFromDb.get();
        examesUpdated.setName(exames.getName());

        examesRepository.save(examesUpdated);
    }
}
