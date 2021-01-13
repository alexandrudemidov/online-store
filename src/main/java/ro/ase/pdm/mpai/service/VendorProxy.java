package ro.ase.pdm.mpai.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import ro.ase.pdm.mpai.model.Store;
import ro.ase.pdm.mpai.model.Transaction;
import ro.ase.pdm.mpai.service.IAcceptTransaction;

@Setter
@Getter
public class VendorProxy implements IAcceptTransaction {

    private double agreedCommission = 0.05;
    private Store store;

    @SneakyThrows
    @Override
    public void addIncome(Double transactionAmount) {
        if (store == null) {
            store = Store.getInstance();
        }
        store.addIncome((1 - agreedCommission) * transactionAmount);
        System.out.println("Transaction with value" + transactionAmount +
                " from vendor was accepted with 5% commission");
    }
}
