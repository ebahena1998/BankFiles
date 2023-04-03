import java.util.ArrayList;

public class Bank{
    //Instance Field
    //instances of objects (account)

    //Static Field (Shared with all Bank classes)
    private static ArrayList<Account> accountList = new ArrayList<Account>();
    public static int bankId = 1000;

    //No Constructor made for Bank, thus Default Constructor of
    //Object Class is called
    //Java automatically creates a default Constructor of Bank()

    //Returns a reference of the Account created
    //Checking Account
    public Account openCheckingAccount(String firstName, String lastName, String SSN, double overdraft){
        //Declaring and Instantiating an Account object
        //Instantiating an Person object that refers to the Account
        //Static Variable (Class Variable) is being incremented by 1, i.e. bankId
        Account newAccount = new CheckingAccount(new Person(firstName, lastName, SSN), bankId++, overdraft);
        //Adding an Account reference to the ArrayList contained inside the class Bank
        accountList.add(newAccount);
        //Returns a reference of type Account
        return newAccount;
    }

    //Savings Account
    public Account openSavingAccount(String firstName, String lastName, String SSN){
        Account newAccount = new SavingsAccount(new Person(firstName, lastName, SSN), bankId++);
        accountList.add(newAccount);
        return newAccount;
    }

    //List Accounts
    public void listAccounts(){
        for(Account temp : accountList){
            System.out.println(temp);
        }
    }

    //Find Account associated with user's input
    public Account findAccount(int userId) throws AccountNotFoundException{
        for(Account temp : accountList){
            if(temp.getId() == userId){
               return temp;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    //Print List of Transactions Associated with the Account
    public void printTransactionList(Account userAccount){
        {
            for(Transaction temp : userAccount.getTransactionList()){
                System.out.println(temp);
            }
            System.out.print(String.format("Balance: %,.2f", userAccount.getBalance()));
        }
    }

    //Deposit into an Account
    public boolean depositAmount(Account userAccount, double  userAmount) throws DepositFailedException{
        if(userAccount.getStatus() == true){
            if(userAmount > 0){
                userAccount.deposit(userAmount);
                return true;
            }
            throw new DepositFailedException(String.format("Deposit failed, the balance is: %,.2f", userAccount.getBalance()));
        }
        return false;
    }

    //Withdraw from Account
    public boolean withdrawAmount(Account userAccount, double  userAmount) throws WithdrawalFailedException{
        if(userAccount.getStatus() == true){
            if(userAmount > 0){
                userAccount.withdraw(userAmount);
                return true;
            }
            throw new WithdrawalFailedException(String.format("Withdrawal failed, the balance is: %,.2f", userAccount.getBalance()));
        }
        return false;
    }

    //Close the Account
    public boolean closeAccount(Account userAccount) throws AccountClosedException{
        if(userAccount.getStatus() == true){
            userAccount.setStatus(false);
            if(userAccount.getBalance() > 0){
                throw new AccountClosedException(String.format("Account closed, current balance is: %,.2f, deposits are no longer possible", userAccount.getBalance()));
            }
            throw new AccountClosedException(String.format("Account closed, current balance is: %,.2f, withdrawals are no longer possible", userAccount.getBalance()));
        }
        return false;
    }

}