package br.com.hospitalticiano.api.service;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.repository.ConsultaRepository;
import br.com.hospitalticiano.api.repository.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public void creat(Consulta consulta){
        consultaRepository.save(consulta);
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }
    public Optional<Consulta> findById(Long id){
        return consultaRepository.findById(id);
    }
    public void update(Long id, Consulta consulta){
        Optional<Consulta> consultaFromDb = findById(id);

        if (consultaFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados");
        }
        Consulta consultaUpdated = consultaFromDb.get();
        consultaUpdated.setDescricao(consulta.getDescricao());

        consultaRepository.save(consultaUpdated);
    }
}