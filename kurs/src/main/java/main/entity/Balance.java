package main.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "createDate")
    private Timestamp createDate;

    @Column(name = "debit")
    private Integer debit;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "amount")
    private Integer amount;

    //@OneToMany(targetEntity = Operations.class, cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "balanceId", referencedColumnName = "id")
    //private List<Operations> operations = new ArrayList<>();
}
