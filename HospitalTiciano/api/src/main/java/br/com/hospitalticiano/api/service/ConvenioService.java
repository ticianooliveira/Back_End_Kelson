package br.com.hospitalticiano.api.service;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.model.Convenio;
import br.com.hospitalticiano.api.repository.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioService {

    @Autowired
    ConvenioRepository convenioRepository;

    public void creat(Convenio convenio){
        convenioRepository.save(convenio);
    }

    public List<Convenio> findAll() {
        return convenioRepository.findAll();
    }
    public Optional<Convenio> findById(Long id){
        return convenioRepository.findById(id);
    }
    public void update(Long id, Convenio convenio){
        Optional<Convenio> convenioFromDb = findById(id);

        if (convenioFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Convênio não encontrado no banco de dados");
        }
        Convenio convenioUpdated = convenioFromDb.get();
        convenioUpdated.setName(convenio.getName());
        convenioUpdated.setId(convenio.getId());

        convenioRepository.save(convenioUpdated);
    }
}
