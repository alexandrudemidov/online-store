package ro.ase.pdm.mpai.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "transactionAmount")
    private double transactionAmount;

    @Column(name = "transactionDate")
    private String transactionDate;

    @Column(name = "clientIban")
    private String clientIban;
}
