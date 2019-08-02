package spring.example.model;

import javax.persistence.*;

@Entity
@Table(name = "INFO")
@NamedNativeQueries({@NamedNativeQuery(name = "allType", query = "select * from Info where type like :type",
        resultClass = Info.class),
        @NamedNativeQuery(name = "id", query = "select * from Info where id like :id",
                resultClass = Info.class)})

public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MEMORY")
    private Integer memory;
    @Column(name = "TYPE")
    private String type;


    public Info() {
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

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


