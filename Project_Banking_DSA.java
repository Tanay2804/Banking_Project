import java.io.*;
import java.util.ArrayList;
import java.util.List;

class BankWork {
    // initialize and declare objects.
    final int max_limit = 20;
    final int min_limit = 1;
    final double min_bal = 500;

    private String name[] = new String[max_limit];
    private List<Integer> accNo = new ArrayList<>();
    private List<String> accType = new ArrayList<>();
    private double balamount[] = new double[max_limit];
    // here our data is stored in a tabular manner eg:
    // [index] name accNo accType balamount
    // 1 Tanay 128 savings 1000000
    // 2 Tushaar 122 savings 1000000

    static int totRec = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // create a constructor here of Bank.
    BankWork() {
        for (int i = 0; i < max_limit; i++) {
            name[i] = "";
            accNo.add(0);
            accType.add("");
            balamount[i] = 0.0;
        }
    }

    // Create method to create New entry.
    public void newEntry() {
        boolean permit = true;
        int tempacc;
        if (totRec > max_limit) {
            System.out.print("\nSorry we cannot admit you in our bank..\n");
            permit = false;
        }

        // create new entry.
        if (permit = true) {
            System.out.print("=====SAVING NEW ENTRY=====\n");
            try {
                // create object.
                System.out.flush();
                System.out.print("Enter the Account Number of the Customer : ");
                tempacc = Integer.parseInt(br.readLine());
                if (accNo.contains(tempacc)) {
                    System.out.println("The Account already exists");
                } else {
                    accNo.add(totRec, tempacc);
                    // enter the name of customer here.
                    System.out.print("Enter the name of the Customer : ");
                    System.out.flush();
                    name[totRec] = br.readLine();
                    // enter the type of account.
                    System.out.print("Enter Account Type : ");
                    System.out.flush();
                    accType.add(totRec, br.readLine());
                    do {
                        // enter the starting amount.
                        // minimum amount must be 1000.
                        System.out.print("Enter Initial  Amount to be deposited : ");
                        System.out.flush();
                        balamount[totRec] = Double.parseDouble(br.readLine());
                    } while (balamount[totRec] < min_bal);
                    totRec++;// Incrementing Records
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Exception in Entering a record....");
            }
        }
    }

    // create method to display records.
    public void display() {
        int account = 0;
        boolean valid = false;
        int index = 0;
        System.out.println("\n=====DISPLAYING THE RECORDS=====\n");
        try {
            // create object.
            // enter account number.
            System.out.print("Enter the account number for display record : ");
            account = Integer.parseInt(br.readLine());
            // check for valid account number
            // for (int j : accNo) {
            // if (account == accNo[index]) {
            // valid = true;
            // break;
            // } else
            // index++;
            // }
            if (accNo.contains(account)) {
                valid = true;
                index = accNo.indexOf(account);
            }
            if (valid == true) {
                System.out.println("\nAccount Number : " + account);
                System.out.println("Name : " + name[index]);
                System.out.println("Account Type : " + accType.get(index));
                System.out.println("Balance Amount : " + balamount[index] + "\n");
            }
        } catch (Exception e) {
            System.out.println("Exception in Displaying record....." + e);
        }
    }

    // create method to deposit amount.
    public void deposit() {
        // String str;
        double amount;
        int account;
        boolean valid = false;
        int index = 0;
        System.out.print("\n=====DEPOSIT AMOUNT=====\n");

        try {
            System.out.print("Enter Account No : ");
            System.out.flush();
            account = Integer.parseInt(br.readLine());
            // for (int j : accNo) {
            // if (account == accNo[index]) {
            // valid = true;
            // break;
            // } else
            // index++;
            // }
            if (accNo.contains(account)) {
                valid = true;
                index = accNo.indexOf(account);
            } else
                System.out.println("Account Doesn't Exist");
            if (valid == true) {
                System.out.println("Name: " + name[index]);
                System.out.println("Account Number: " + accNo.get(index));
                System.out.println("Balance Amount: " + balamount[index]);
                System.out.print("Enter Amount you want to Deposit  : ");
                System.out.flush();
                amount = Double.parseDouble(br.readLine());
                balamount[index] = balamount[index] + amount;
                // Displaying Depsit Details
                System.out.println("\nAfter Updation...");
                System.out.println("Account Number :  " + accNo.get(index));
                System.out.println("Balance Amount :  " + balamount[index] + "\n");
            }
        } catch (Exception e) {
            System.out.println("Exception in Depositing record.....");
        }
    }

    // creating method for withdraw money.
    public void withdraw() {
        double amount, checkamount;
        int account;
        boolean valid = false;
        int index = 0;
        System.out.print("\n=====WITHDRAW MONEY=====\n");
        try {
            // create object.
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
            // enter account number for entering money
            System.out.print("Enter the account number to deposit money : ");
            System.out.flush();
            account = Integer.parseInt(obj.readLine());
            // check for valid account number
            // for (int j : accNo) {
            // if (account == accNo[index]) {
            // valid = true;
            // break;
            // } else
            // index++;
            // }
            if (accNo.contains(account))
                valid = true;
            index = accNo.indexOf(account);

            if (valid == true) {
                System.out.println("Balance is : " + balamount[index]);
                System.out.print("Enter Amount you want to withdraw  : ");
                System.out.flush();
                amount = Double.parseDouble(obj.readLine());
                checkamount = balamount[index] - amount;

                if (checkamount >= min_bal) {
                    balamount[index] = checkamount;
                    // Updating the amount after withdraw.
                    System.out.println("\nAfter Updation...");
                    System.out.println("Account Number :  " + accNo.get(index));
                    System.out.println("Updated Balance Amount :  " + balamount[index] + "\n");
                } else {
                    System.out.println("\nAs per Bank Rule you should maintain minimum balance of Rs 500\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in Withdrawing record.....");
        }
    }
};

public class Project_Banking_DSA {
    public static void main(String args[]) {
        System.out.println("-----------------------------");
        System.out.println("MADE BY: TANAY TIBREWAL IN 1ST YEAR;\nDated: June 28,2023");
        System.out.println("-----------------------------");
        String str;
        int choice = 0;
        BankWork BW_obj = new BankWork();
        do {
            // creating Menu.
            System.out.println("Choose Your Choices:");
            System.out.println("1) New Record Entry ");
            System.out.println("2) Display Record Details ");
            System.out.println("3) Deposit...");
            System.out.println("4) Withdraw...");
            System.out.println("5) Exit");
            System.out.print("Enter your choice :  ");
            System.out.flush();
            try {
                // creating objects.
                BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                str = obj.readLine();
                choice = Integer.parseInt(str);

                switch (choice) {
                    case 1:
                        // for new entry.
                        BW_obj.newEntry();
                        break;

                    case 2:
                        // for display.
                        BW_obj.display();
                        break;

                    case 3:
                        // for deposit.
                        BW_obj.deposit();
                        break;

                    case 4:
                        // for display.
                        BW_obj.withdraw();
                        break;

                    case 5:
                        System.out.print("\n.....THANKS FOR VISITING.....");
                        break;

                    default:
                        System.out.println("\nInvalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Exception in Main..");
            }
        } while (choice != 5);
    }
}
