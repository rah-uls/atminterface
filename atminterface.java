import java.util.Scanner;
class BankAccount{
        private double balance;
        public BankAccount(double initialBalance){
            this.balance=initialBalance;
        }
        public double getBalance(){
            return balance;
        }
        public void deposite(double amount){
            if(amount>0){
                balance+=amount;
                System.out.println("Deposite of $ " +amount+ "Successful.current balance: $ "+balance);
            }
            else{
                System.out.println("Invalid Deposite");
            }
        }
        public void withdraw(double amount){
            if(amount>0 && amount<= balance){
                balance-=amount;
                System.out.println("withdrawl of $ "+amount+ "Successful current balance: $"+balance);
            }
            else{
                System.out.println("Invalid withdrawl amount or insuffient balance.");
            }
        }
    }
    class ATM{
        private BankAccount bankAccount;
        public ATM(BankAccount bankAccount){
           this.bankAccount=bankAccount;
        }
        public void displaymenu(){
        System.out.println("ATM MENU:");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. DEPOSITE");
        System.out.println("3. WITHDRAWL");
        System.out.println("4. EXIT");
    }
    public void performTransaction(int choice, Scanner scanner){
    switch(choice){
        case 1:
            System.out.println("current balance: $"+bankAccount.getBalance());
            break;
        case 2:
            System.out.println("enter deposite aamount: $");
            double depositAmount=scanner.nextDouble();
            bankAccount.deposite(depositAmount);
            break;
        case 3:
            System.out.println("enter withdrawl amount: $");
            double withdrawalAmount=scanner.nextDouble();
            bankAccount.withdraw(withdrawalAmount);
            break;
        case 4:
            System.out.println("exiting ATM. thank you:");
            scanner.close();
            System.exit(0);
        default:
            System.out.println("Invalid choice. please select a valid option");
        }
    }
}
public class atminterface{
        public static void main(String args[]){            
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter initial account balance: $");
        double initialBalance=scanner.nextDouble();
        BankAccount bankAccount=new BankAccount(initialBalance);
        ATM atm=new ATM(bankAccount);
        while(true){
            atm.displaymenu();
            System.out.println("select an option: ");
            int choice=scanner.nextInt();
            atm.performTransaction(choice, scanner);
        }
    }
}