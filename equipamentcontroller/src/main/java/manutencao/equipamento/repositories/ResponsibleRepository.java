package manutencao.equipamento.repositories;

import manutencao.equipamento.entities.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
}
