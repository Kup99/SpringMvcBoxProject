package spring.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "INFO")

public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "memory")
    private Long memory;
    //    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private String type;
    @Column(name = "colour")
    private String colour;
    @Column(name = "weight")
    private Double weight;
    @OneToOne(mappedBy = "info", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private  Box box;



    public Info() {
    }

    public Info(Long memory, String type, String colour, Double weight, Box box) {
        this.memory = memory;
        this.type = type;
        this.colour = colour;
        this.weight = weight;
        this.box = box;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", memory=" + memory +
                ", type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                ", weight=" + weight +
                ", box=" + box +
                '}';
    }
}


