public class Current extends Account{
    public Current(String id, String name){
        super(id, name);
    }
    public Current(String id, String name, double balance){
        super(id, name, balance);
    }
    public void deposit(double amount){
        double newBalance= (getBalance()+amount);
        setBalance(newBalance);
    }
    public void withdraw(double amount){
      if(getBalance()<amount){
        System.out.println("Not enough money");
      }
      else{
        setBalance(getBalance()-amount);
      }
   }
}
