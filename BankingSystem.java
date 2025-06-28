import java.util.Scanner;
public class BankingSystem {
    static final int MAX=100;
    static Account[] accounts=new Account[MAX];
    static int count=0;
    public static Account findById(String id) {
        for (int i=0; i<count; i++) {
            if (accounts[i].getID().equals(id)) {
                return accounts[i];
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n Banking System Menu ---");
            System.out.println("1.Create New Account");
            System.out.println("2.Deposit Money");
            System.out.println("3.Withdraw Money");
            System.out.println("4.Transfer Money");
            System.out.println("5.Check Balance");
            System.out.println("0.Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine(); 
            switch (option) {
                case 1:
                    System.out.print("Enter ID:");
                    String newId=sc.nextLine();
                    System.out.print("Enter Name:");
                    String newName=sc.nextLine();
                    System.out.print("Enter Initial Balance:");
                    int bal=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the account type\n1.Savings\n2.Current\n3.Deposite Premium");
                    int type= sc.nextInt();
                    if (bal>0) {
                        if(type==1){
                            accounts[count++]=new Savings(newId, newName, bal);
                        }
                        else if(type==2){
                            accounts[count++]=new Current(newId, newName, bal);
                        }
                        else if(type==3){
                            accounts[count++]=new Deposite_premium(newId, newName, bal);
                        }
                        else{
                            System.out.println("Wrong command");
                        }
                    } 
                    else {
                        if(type==1){
                            accounts[count++]=new Savings(newId, newName);
                        }
                        else if(type==2){
                            accounts[count++]=new Current(newId, newName);
                        }
                        else if(type==3){
                            accounts[count++]=new Deposite_premium(newId, newName);
                        }
                        else{
                            System.out.println("Wrong command");
                        }
                    }
                    System.out.println("Account created");
                    break;

                case 2:
                    System.out.print("Enter Account ID:");
                    String creditId=sc.nextLine();
                    Account creditAcc=findById(creditId);
                    if (creditAcc!=null) {
                        System.out.print("Enter amount:");
                        int amt=sc.nextInt();
                        creditAcc.deposit(amt);
                        System.out.println("Credited");
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account ID:");
                    String debitId=sc.nextLine();
                    Account debitAcc=findById(debitId);
                    if (debitAcc!=null) {
                        System.out.print("Enter amount:");
                        int amt=sc.nextInt();
                        debitAcc.withdraw(amt);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 4:
                    System.out.print("From Account ID:");
                    String fromId=sc.nextLine();
                    System.out.print("To Account ID:");
                    String toId=sc.nextLine();
                    Account fromAcc=findById(fromId);
                    Account toAcc=findById(toId);
                    if (fromAcc!=null && toAcc != null) {
                        if(fromAcc instanceof Deposite_premium){
                            System.out.println("Transfer not possible");
                            break;
                        }
                        System.out.print("Enter amount:");
                        double amt=sc.nextInt();
                        fromAcc.transferTo(toAcc, amt);
                        System.out.println("Transfer successful");
                    } else {
                        System.out.println("Transfer failed");
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter Account ID:");
                    String checkId=sc.nextLine();
                    Account checkAcc=findById(checkId);
                    if (checkAcc!=null) {
                        System.out.println("Balance:" + checkAcc.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 0:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
