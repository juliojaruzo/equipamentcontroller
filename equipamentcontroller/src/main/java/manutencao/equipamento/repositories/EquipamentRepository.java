package manutencao.equipamento.repositories;

import manutencao.equipamento.entities.Equipament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentRepository extends JpaRepository<Equipament, Long> {
}
