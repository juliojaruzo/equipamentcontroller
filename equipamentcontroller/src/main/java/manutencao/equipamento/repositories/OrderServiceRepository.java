package manutencao.equipamento.repositories;

import manutencao.equipamento.entities.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Long> {
    List<OrderService> findByResponsibleIdAndClosedDateIsNull(Long responsibleId);
}
