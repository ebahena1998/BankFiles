public class CheckingAccount extends Account {
    public CheckingAccount(Person person, int id, double overdraft){
        //Calls the Account Constructor and inherits all its methods
        super(person, id);
        //Calls the Account withdraw() method from the super class
        super.withdraw(overdraft);
    }
    @Override
    public String toString(){
        String checkingInfo = "";
        checkingInfo += String.format("%d(Checking) : %s", super.getId(), super.toString());
        return(checkingInfo);
    }
}
