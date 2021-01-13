package ro.ase.pdm.mpai.model;

public abstract class FinancialReport {

    public abstract void calculateIncomeFee();
    public abstract void calculateInsuranceFee();
    public abstract void calculateDebts();


    public final void generateFinancialReport(){
        calculateIncomeFee();
        calculateInsuranceFee();
        calculateDebts();
    }
}
