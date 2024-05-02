package projects.zuka.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Data {

    @Id
    private String coinName;
    private Double value;

    public Double getValue() {
        return value;
    }

    public String getCoinName() {
        return coinName;
    }
}
