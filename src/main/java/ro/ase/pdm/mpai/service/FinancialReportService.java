package ro.ase.pdm.mpai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ase.pdm.mpai.model.FinancialReport;
import ro.ase.pdm.mpai.model.Store;
import ro.ase.pdm.mpai.repository.StoreRepository;

import java.util.List;

@Service
public class FinancialReportService extends FinancialReport {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public void calculateIncomeFee() {
        List<Store> stores = storeRepository.findAll();
        double totalIncome = stores.stream().mapToDouble(Store::getDailyIncome).sum();
        System.out.println("Current income fee to pay: " + totalIncome * 0.4);
    }

    @Override
    public void calculateInsuranceFee() {
        System.out.println("There is no insurance fee at this moment.");
    }

    @Override
    public void calculateDebts() {
        System.out.println("There is no debts at this moment.");
    }
}
