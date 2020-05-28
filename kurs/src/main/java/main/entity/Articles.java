package main.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "articles")
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //@OneToMany(targetEntity = Operations.class, cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "artickesId", referencedColumnName = "id")
    //private List<Operations> operations = new ArrayList<>();
}
