package manutencao.equipamento.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "occurrence")
public class Occurrence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime occurrenceDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private OrderService orderService;

    @PrePersist
    public void prePersist(){
        final LocalDateTime atualDate = LocalDateTime.now();
        this.occurrenceDate = atualDate;
    }

    public Occurrence(Long id, String description, OrderService orderService) {
        this.id = id;
        this.description = description;
        this.orderService = orderService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(LocalDateTime occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
