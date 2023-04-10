package BankFiles.AccountTypes;

public class SavingsAccount extends Account {
    public SavingsAccount(Person person, int id){
        //Calls the Account Constructor and inherits all its methods
        super(person, id);
    }
    @Override
    public String toString(){
        String savingsInfo = "";
        savingsInfo += String.format("%d(Savings)  : %s", super.getId(), super.toString());
        return (savingsInfo);
    }
}
