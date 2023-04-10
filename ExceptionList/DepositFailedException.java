package BankFiles.ExceptionList;

public class DepositFailedException extends Exception{
    public DepositFailedException(){
        super();
    }
    public DepositFailedException(String message){
        super(message);
    }
    
}
