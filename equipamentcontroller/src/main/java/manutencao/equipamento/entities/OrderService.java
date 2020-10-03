package manutencao.equipamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_service")
public class OrderService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Equipament equipament;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Responsible responsible;

    @Column(name = "service_done")
    private String serviceDone;

    @Column(name = "problem_description")
    private String problemDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "orderService")
    private List<Occurrence> occurrences;

    @DateTimeFormat(pattern = "dd/MM/yyy HH:mm")
    private LocalDateTime emissionDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closedDate;

    @PrePersist
    public void prePersist(){
        final LocalDateTime atualDate = LocalDateTime.now();
        this.emissionDate = atualDate;
    }

    public OrderService(Long id, Client client, LocalDateTime emissionDate, LocalDateTime closedDate, String problemDescription, Equipament equipament, Responsible responsible, String serviceDone){
    }

    public OrderService(Long id, Equipament equipament, Client client, Responsible responsible, String serviceDone, String problemDescription, List<Occurrence> occurrences, LocalDateTime emissionDate, LocalDateTime closedDate) {
        this.id = id;
        this.equipament = equipament;
        this.client = client;
        this.responsible = responsible;
        this.serviceDone = serviceDone;
        this.problemDescription = problemDescription;
        this.occurrences = occurrences;
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

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public String getServiceDone() {
        return serviceDone;
    }

    public void setServiceDone(String serviceDone) {
        this.serviceDone = serviceDone;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public List<Occurrence> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(List<Occurrence> occurrences) {
        this.occurrences = occurrences;
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
