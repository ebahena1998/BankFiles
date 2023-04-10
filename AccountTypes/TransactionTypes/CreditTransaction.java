package BankFiles.AccountTypes.TransactionTypes;

public class CreditTransaction extends Transaction {
    public CreditTransaction(int transId, double transAmount){
        super(transId, transAmount);
    }
    @Override
    public String toString() {
        String creditInfo = "";
        creditInfo += String.format("%d : %s :%,.2f", super.getTransID(), "Credit", super.getTransAmount());
        return (creditInfo);
    }
}
