
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static Scanner scnr = new Scanner(System.in);
    
    //Static Field refers to the Object Class since Construcor contains no arguments
    public static Bank chase = new Bank();
    
    //Main Method
    public static void main(String[] args){
        int input = 0;

        do{
            input = printMenu();
            options(input);
        } while(input != 8);

    }
    //End of Main Method

    //Menu Method
    public static int printMenu(){
        System.out.print("\n1 - Open a Checking account\n");
        System.out.print("2 - Open Saving Account\n");
        System.out.print("3 - List Accounts\n");
        System.out.print("4 - Account Statement\n");
        System.out.print("5 - Deposit funds\n");
        System.out.print("6 - Withdraw funds\n");
        System.out.print("7 - Close an account\n");
        System.out.print("8 - Exit\n");
        System.out.print("Please enter your choice: ");
        int input = scnr.nextInt();
        //Reset Buffer
        scnr.nextLine();
        return input;
    }
    //End of printMenu Method

    //Options Method
    public static void options(int input){
        switch(input){

            case 1: option1();
                    break;
            case 2: option2();
                    break;
            case 3: option3();
                    break;
            case 4: option4();
                    break;
            case 5: option5();
                    break;
            case 6: option6();
                    break;
            case 7: option7();
                    break;
        }
    }
    //End of Options Method

    //Beginning of option1 Method
    public static void option1(){
        System.out.print("Enter first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scnr.nextLine();
        System.out.print("Enter social security number: ");
        String SSN = scnr.nextLine();
        System.out.print("Enter overdraft limit: ");
        double overdraft = scnr.nextDouble();
        chase.openCheckingAccount(firstName, lastName, SSN, overdraft);
        //Clear the buffer
        scnr.nextLine();
        System.out.println("Thank you, the account number is " + (Bank.bankId - 1));
    }
    //End of option1 Method

    //Beginning of option2 Method
    public static void option2(){
        System.out.print("Enter first name: ");
        String firstName = scnr.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scnr.nextLine();
        System.out.print("Enter social security number: ");
        String SSN = scnr.nextLine();
        chase.openSavingAccount(firstName, lastName, SSN);
        System.out.println("Thank you, the account number is " + (Bank.bankId - 1));
    }
    //End of option2 Method

    //Beginning of option3 Method
    //Print Banks account list (checking or savings)
    public static void option3(){
        chase.listAccounts();
    }
    //End of option3 Method

    //Beginning of option4 Method
    //Print Accounts transactions (debit or credit)
    public static void option4(){
        try{
            System.out.print("Enter account number: ");
            int accountNumber = scnr.nextInt();
            Account temp = chase.findAccount(accountNumber);
            chase.printTransactionList(temp);
        }
        //Catch InputMismatch Exception and do nothing
        catch(InputMismatchException ime){
            //If accountNumber has an incorrect data type, reset buffer
            scnr.nextLine();
        }
        //Catch AccountNot Found Exception and print personal message
        catch(AccountNotFoundException anfe){
            System.out.print(anfe.getMessage());
        }
        
    }
    //End of option4 Method

    //Beginning of option5 Method
    public static void option5(){
        try{
            System.out.print("Enter account number: ");
            int accountNumber = scnr.nextInt();
            Account temp = chase.findAccount(accountNumber);
            try{
                System.out.print("Enter the amount to deposit: ");
                double amount = scnr.nextDouble();
                chase.depositAmount(temp, amount);
                System.out.print(String.format("Deposit successful, the balance is: %,.2f", temp.getBalance()));
            }
            catch(InputMismatchException ime){
                //Clear the buffer
                scnr.nextLine();
                //If amount has an incorrect data type, throw a new DepositFailedException
                throw new DepositFailedException(String.format("Deposit failed, the balance is: %,.2f", temp.getBalance()));
            }
        }
        //Catch InputMismatch Exception and do nothing
        catch(InputMismatchException ime){
            //If accountNumber has an incorrect data type, reset buffer
            scnr.nextLine();
        }
        //Catch AccountNotFoundException and print personal message
        catch(AccountNotFoundException anfe){
            System.out.print(anfe.getMessage());
        }
        //Catch DepositFailedException and print the current balance
        catch(DepositFailedException dfe){
            System.out.print(dfe.getMessage());
        }
        
    }
    //End of option5 Method

    //Beginning of option6 Method
    public static void option6(){
        try{
            System.out.print("Enter account number: ");
            int accountNumber = scnr.nextInt();
            Account temp = chase.findAccount(accountNumber);
            try{
                System.out.print("Enter the withdrawal amount: ");
                double userAmount = scnr.nextDouble();
                chase.withdrawAmount(temp, userAmount);
                System.out.print(String.format("Withdraw sucessful, the new balance is: %,.2f", temp.getBalance()));
            }
            catch(InputMismatchException ime){
                //Reset Buffer
                scnr.nextLine();
                throw new WithdrawalFailedException(String.format("Withdrawal Failed, the balance is: %,.2f", temp.getBalance()));
            }
        }
        catch(InputMismatchException ime){
            //Reset buffer
            scnr.nextLine();
        }
        catch(AccountNotFoundException anfe){
            System.out.print(anfe.getMessage());
        }
        catch(WithdrawalFailedException wfe){
            System.out.print(wfe.getMessage());
        }
    }
    //End of option6 Method
    
    //Beginning of option7 Method
    public static void option7(){
        try{
            System.out.print("Enter account number to close: ");
            int accountNumber = scnr.nextInt();
            Account temp = chase.findAccount(accountNumber);
            chase.closeAccount(temp);
        }
        catch(InputMismatchException ime){
            //Reset Buffer
            scnr.nextLine();
        }
        catch(AccountNotFoundException anfe){
            System.out.print(anfe.getMessage());
        }
        catch(AccountClosedException ace){
            System.out.print(ace.getMessage());
        }
    }
    
}