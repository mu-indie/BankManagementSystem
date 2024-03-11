package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create a scanner object
        Scanner scanner = new Scanner(System.in);

        // create a bank object
        Bank DECEMBER1 = new Bank();

        //create a variable to save the user choice from the menu
        int userChoice;

        do {
            System.out.println("\nwelcome to DECEMBER1 bank");
            System.out.println("1. add account");
            System.out.println("2. deposit funds");
            System.out.println("3. withdraw funds");
            System.out.println("4. view transaction history");
            System.out.println("5. exit");
            System.out.print("enter your choice: ");

            userChoice = scanner.nextInt();
            scanner.nextLine(); // consumes the new line character

            switch (userChoice){
                case 1:
                    System.out.print("enter account number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("enter the account holder's name: ");
                    String accountHolderName = scanner.nextLine();

                    System.out.print("enter initial balance");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); //consumes new line character

                    System.out.print("enter account type (savings, checking): ");
                    String accountType = scanner.nextLine();

                    DECEMBER1.addAccount(accountNumber,accountHolderName,balance, accountType);

                    break;

                case 2:
                    System.out.print("enter account number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount account = DECEMBER1.getAccount(accountNumber);

                    if (account != null ){
                        System.out.println("welcome "+ account.getAccountHolderName());
                        System.out.print("enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }else {
                        System.out.println("account not found!!");
                    }
                    break;

                case 3:
                    System.out.print("enter account number: ");
                    accountNumber = scanner.nextLine();

                    account = DECEMBER1.getAccount(accountNumber);

                    if (account != null){
                        System.out.println("welcome "+ account.getAccountHolderName());
                        System.out.println("enter the amount you wish to withdraw");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    }else {
                        System.out.println("account not found!!");
                    }
                    break;
                case 4:
                    System.out.print("enter account number: ");
                    accountNumber = scanner.nextLine();

                    account = DECEMBER1.getAccount(accountNumber);

                    if (account != null){
                        System.out.println("welcome "+ account.getAccountHolderName());
                        System.out.println("Transaction History For Account: " + accountNumber);

                        List<String> transactions = account.getTransactionHistory();

                        for ( String transaction: transactions){
                            System.out.println(transaction);
                        }
                    }else {
                        System.out.println("account not found!!");
                    }
                    break;
                case 5:
                    System.out.println("exiting DECEMBER1 ...");
                    break;

                default:
                    System.out.println("invalid choice. please enter choice between 1 and 4");
            }
        }while (userChoice != 5);

        //close the scanner object
        scanner.close();
    }
}