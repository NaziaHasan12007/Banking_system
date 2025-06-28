public abstract class Account {
    private String id;
    private String name;
    private double balance;
    
    public Account(){

    }

    public Account(String id, String name) {
        this.id=id;
        this.name=name;
        this.balance=0;
    }

    public Account(String id, String name, double balance) {
        this.id=id;
        this.name=name;
        this.balance=balance;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }
    
    public double transferTo(Account another, double amount) {
        if (amount<=balance) {
            this.balance-=amount;
            another.setBalance(amount+ another.getBalance());
        } else {
            System.out.println("Transfer failed");
        }
        return balance;
    }

    public String toString() {
        return "Account[id=" + id + ",name=" + name + ",balance=" + balance + "]";
    }
   
   public abstract void deposit(double amount);
   public abstract void withdraw(double amount);
}
