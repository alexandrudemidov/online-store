package ro.ase.pdm.mpai.model;

import lombok.Getter;
import lombok.Setter;
import ro.ase.pdm.mpai.service.IAcceptTransaction;

import javax.persistence.*;

@Entity
public class Store implements IAcceptTransaction {

    private static Store instance = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;

    @Getter
    @Column(name = "dailyIncome")
    private double dailyIncome = 0;

    @Setter
    @Column(name = "date")
    private String date;

    public static Store getInstance() throws Exception {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    @Override
    public void addIncome(Double transactionAmount){
        dailyIncome += transactionAmount;
    }
}
