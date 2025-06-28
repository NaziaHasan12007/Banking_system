public class Savings extends Account{
    public Savings(String id, String name){
        super(id, name);
    }
    public Savings(String id, String name, double balance){
        super(id, name, balance);
    }
    @Override
    public void deposit(double amount){
        double newBalance= (getBalance()+amount);
        double profit= newBalance*0.025;
        double netBalance= newBalance+profit;
        setBalance(netBalance);
    }
    public void withdraw(double amount){
      if(getBalance()<amount){
        System.out.println("Not enough money");
      }
      else if(getBalance()-amount<1000){
        System.out.println("Account must have 1000tk");
      }
      else{
        setBalance(getBalance()-amount);

      }
   }
}
