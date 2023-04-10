package BankFiles.AccountTypes.TransactionTypes;

public class Transaction {
    private int transId;
    private double transAmount;
    //Constructor
    public Transaction(int transId, double transAmount){
        this.transId = transId;
        this.transAmount = transAmount;
    }

    //Getters
    public int getTransID(){
        return (this.transId);
    }
    public double getTransAmount(){
        return (this.transAmount);
    }
    public String toString(){
        String transactionInfo = "";
        transactionInfo += String.format("%d %.2f", transId, transAmount);
        return(transactionInfo);
    }
}
