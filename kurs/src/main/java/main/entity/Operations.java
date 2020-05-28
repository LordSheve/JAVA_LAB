package main.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "articlesId")
    private Articles articles;

    @Column(name = "debit")
    private Integer debit;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "createDate")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "balanceId")
    private Balance balance;
}
