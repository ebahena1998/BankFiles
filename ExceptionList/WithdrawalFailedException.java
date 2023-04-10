package BankFiles.ExceptionList;

public class WithdrawalFailedException extends Exception {
    public WithdrawalFailedException(){
        super();
    }
    public WithdrawalFailedException(String message){
        super(message);
    }
}
