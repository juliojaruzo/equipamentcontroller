package manutencao.equipamento.repositories;

import manutencao.equipamento.entities.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
