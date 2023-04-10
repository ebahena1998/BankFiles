package BankFiles.AccountTypes.TransactionTypes;

public class DebitTransaction extends Transaction {
    public DebitTransaction(int transId, double transAmount){
        super(transId, transAmount);
    }
    @Override
    public String toString() {
        String debitInfo = "";
        debitInfo += String.format("%d : %s :%,.2f", super.getTransID(), "Debit", super.getTransAmount());
        return(debitInfo);
    }
    
}
