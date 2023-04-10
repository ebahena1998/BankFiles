package BankFiles.AccountTypes;

import java.util.ArrayList;

public class Account{
    //Instance Field
    private Person person;
    private double balance;
    private int id;
    private boolean status;
    private ArrayList<Transaction> transactionList;
    //Static Field
    private static int transID;
    //Constructor
    public Account(Person person, int id){
        //Declaring and initailizing a class to a reference of the class
        this.person = person;
        //Instance Variables of type int (primative) and of type double(primative)
        this.balance = 0.00;
        this.id = id;
        this.status = true;
        //Each Time an Account is made, the list is set to a new List
        this.transactionList = new ArrayList<Transaction>();
        //Each Time an Account is made, set the transaction id to 0.
        this.transID = 0000;
    }
    //Setters
    public void setStatus(boolean status){
        this.status = status;
    }

    //Getters
    public int getId(){
        return (this.id);
    }

    public boolean getStatus(){
        return (this.status);
    }
    
    public double getBalance(){
        return(this.balance);
    }
    //Withdraw Method
    public void withdraw(double amount){
        transactionList.add(new DebitTransaction(++transID, amount));
        this.balance -= amount;
    }

    //Deposit Method
    public void deposit(double amount){
        transactionList.add(new CreditTransaction(++transID, amount));
        this.balance += amount;
    }

    //Get Transaction Method
    public ArrayList<Transaction> getTransactionList() {
        return (this.transactionList);
    }

    //Method Returning a String Reference
    public String toString(){
        String accountInfo = "";
        if(status == true){
            accountInfo += String.format("%s : %,.2f : Account Open", person.toString(), balance);
        } else{
            accountInfo += String.format("%s : %,.2f : Account Closed", person.toString(), balance);
        }
        return (accountInfo);
    }

    
}