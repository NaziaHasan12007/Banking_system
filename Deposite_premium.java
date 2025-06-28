public class Deposite_premium extends Account{
    int installment=0;
    
    public  Deposite_premium(String id, String name){
        super(id, name);
    }
    public Deposite_premium(String id, String name, double balance){
        super(id, name, balance);
    }
    @Override
    public void deposit(double amount){
        
        double newBalance= (getBalance()+amount);
        double profit= newBalance*0.7;
        double netBalance= newBalance+profit;
        setBalance(netBalance);
        System.out.println("Deposited");
        installment++;
    }
    public void withdraw(double amount){
      if(installment!=5){
        System.out.println("Can't withdraw money before 5 installemnts");
        return;
      }
      if(getBalance()<amount){
        System.out.println("Not enough money");
      }
      else{
        setBalance(getBalance()-amount);
        System.out.println("Withdraw successful");
      }
   }
}
