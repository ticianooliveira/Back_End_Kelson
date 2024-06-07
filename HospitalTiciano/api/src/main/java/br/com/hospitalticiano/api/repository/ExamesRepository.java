package br.com.hospitalticiano.api.repository;

import br.com.hospitalticiano.api.model.Exames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamesRepository extends JpaRepository<Exames, Long> {
}