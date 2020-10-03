package manutencao.equipamento.entities.dto;

import manutencao.equipamento.entities.Client;


public class ClientDTO {

    private Long id;

    private String name;
    private String adress;
    private String email;
    private String phone;

    public ClientDTO(){
    }

    public ClientDTO(Client obj) {
      id = obj.getId();
      name = obj.getName();
      adress = obj.getAdress();
      email = obj.getEmail();
      phone = obj.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
