package manutencao.equipamento.entities.dto;

import manutencao.equipamento.entities.Client;
import manutencao.equipamento.entities.Equipament;
import manutencao.equipamento.entities.Responsible;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class OrderServiceDTO {

    private Long id;
    private Equipament equipament;
    private Client client;
    private Responsible responsible;
    private String problemDescription;
    private String serviceDone;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime emissionDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closedDate;

    public OrderServiceDTO(){
    }

    public OrderServiceDTO(Long id, Equipament equipament, Client client, Responsible responsible, String problemDescription, String serviceDone, LocalDateTime emissionDate, LocalDateTime closedDate) {
        this.id = id;
        this.equipament = equipament;
        this.client = client;
        this.responsible = responsible;
        this.problemDescription = problemDescription;
        this.serviceDone = serviceDone;
        this.emissionDate = emissionDate;
        this.closedDate = closedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipament getEquipament() {
        return equipament;
    }

    public void setEquipament(Equipament equipament) {
        this.equipament = equipament;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Responsible getResponible() {
        return responsible;
    }

    public void setResponible(Responsible responible) {
        this.responsible = responsible;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getServiceDone() {
        return serviceDone;
    }

    public void setServiceDone(String serviceDone) {
        this.serviceDone = serviceDone;
    }

    public LocalDateTime getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDateTime emissionDate) {
        this.emissionDate = emissionDate;
    }

    public LocalDateTime getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDateTime closedDate) {
        this.closedDate = closedDate;
    }
}
