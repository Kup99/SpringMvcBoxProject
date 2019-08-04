package spring.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Box")
@NamedNativeQueries({@NamedNativeQuery(name = "id", query = "select * from Box where id like :id",
        resultClass = Box.class),
        @NamedNativeQuery(name = "allInfo", query = "select * from Box ",
                resultClass = Box.class)})
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String colour;
    private String weight;
    private String name;


    public Box() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}