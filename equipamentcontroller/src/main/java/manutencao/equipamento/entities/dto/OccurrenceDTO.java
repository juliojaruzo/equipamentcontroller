package manutencao.equipamento.entities.dto;


import manutencao.equipamento.entities.OrderService;
import org.springframework.format.annotation.DateTimeFormat;

public class OccurrenceDTO {

    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private String description;
    private OrderService orderService;

    public OccurrenceDTO(){
    }

    public OccurrenceDTO(Long id, String description, OrderService orderService) {
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
