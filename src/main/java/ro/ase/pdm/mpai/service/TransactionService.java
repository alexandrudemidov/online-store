package ro.ase.pdm.mpai.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ase.pdm.mpai.model.Store;
import ro.ase.pdm.mpai.model.Transaction;
import ro.ase.pdm.mpai.repository.StoreRepository;
import ro.ase.pdm.mpai.repository.TransactionRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StoreRepository storeRepository;

    public Transaction addTransaction(Transaction transaction) {
        try {
            Store store = Store.getInstance();
            store.addIncome(transaction.getTransactionAmount());
            store.setDate(getCurrentDate());
            storeRepository.saveAndFlush(store);
            displayCurrentIncome();
        } catch (Exception e) {
            e.printStackTrace();
        }
        transactionRepository.save(transaction);

        return transaction;
    }

    @SneakyThrows
    public Transaction addVendorTransaction(Transaction transaction) {
        IAcceptTransaction vendorStore = new VendorProxy();
        vendorStore.addIncome(transaction.getTransactionAmount());
        transaction.setTransactionAmount((1 - 0.05) * transaction.getTransactionAmount());
        Store.getInstance().setDate(getCurrentDate());
        displayCurrentIncome();
        storeRepository.saveAndFlush(Store.getInstance());
        transactionRepository.save(transaction);
        return transaction;
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public List<Transaction> transactionsByDate(String date){
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getTransactionDate().equals(date)).collect(Collectors.toList());
    }

    @SneakyThrows
    private void displayCurrentIncome(){
        System.out.println("Store income for today is: " + Store.getInstance().getDailyIncome());
    }

    private String getCurrentDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
