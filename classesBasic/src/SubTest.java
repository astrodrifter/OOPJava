import java.io.*;
import java.util.StringTokenizer;
public class SubTest
{
   public static void main(String args[])
   {
      FixedRateSAccount account = new FixedRateSAccount("f1234", 10000.0, 1.0);
      account.addInterest(); // intersest for Jan
      account.addInterest(); // intersest for Feb
      account.addInterest(); // intersest for Mar
      account.print();
   }
}
class Account
{
   private String accID;
   private double balance;
   public Account(String accountID, double amount)
   {
      accID = accountID;
      balance = amount;
   }
public void deposit(double amount)
{
   balance = balance + amount;
}

public boolean withdraw(double amount)
{
   if (balance >= amount)
   {
      balance = balance - amount;
      return true;
   }
   else
      return false;
}
public double getBalance()
{
   return balance;
}
void print()
{
   System.out.println("ID = " + accID + " Bal = " + balance);
}
}

class FixedRateSAccount extends Account
{
   private double intRate;
   public FixedRateSAccount(String accountID, double amount, double intRate)
   {
      super(accountID,amount);
      this.intRate = intRate;
   }
public void addInterest()
{
	super.deposit(super.getBalance() * intRate / 100);
}
}

/*class CAccount extends Account
{
	private double overdraftLimit;
    private double overdrawnAmount;
    private int transactionCount;

    public CAccount(String id, String name, double amt,
                    double limit)
    {
       super(id, name, amt);
       overdraftLimit = limit;
       overdrawnAmount = 0;
       transactionQAccount = 0;
    }
    public CAccount(String id, String name, double amt)
    {
       super(id, name, amt);
       overdraftLimit = 0;
       overdrawnAmount = 0;
       transactionCount = 0;
    }

    public void getOverdraftLimit()
    {
       return overdraftLimit;
    }

    public void getOverdrawnAmount()
    {
       return overdrawmAmount;
    }

    public void getTransactionCount()
    {
       return transactionCount;
    }

    // only need one mutator - for the overdraft limit

    public void setOverdraftLimit(double limit)
    {
       overdraftLimit = limit;
    }

    // this method will be used in the wirthdraw method later
    public double getAvailableFunds()
    {
       return getBalance() + overdraftLimit - overdrawnAmount;
    }

    public boolean withdraw(double amt)
    {
       double availableFunds = getAvailableFunds();

       if (availableFunds < amt)
          return false;

       else 
       {
          if (getBalance() >= amt)
          {
             super.withdraw(amt);
          }
          else
          {
             double remainingAmount = amt - getBalance();
             super.withdraw(getBalance());
             overdraftAmount += amt;
          }
          transactionCount++;
          return true;
       }
    }

    public void deposit(double amt)
    {
       if (overdradftAmount == 0)
       {
          super.deposit(amt);
       }
       else 
       {
          if (amt <= overdraftAmount)
          {
             overdraftAmount -= amt;
          }
          else
          {
             double remainingAmt -= overdraftAmount;
             super.deposit(remainingAmt);

             // note - this step was left out of the description
             // for this method in the question

             overdraftAmount = 0;
          }
       }
    }
 }

 public void deductCharges()
 {
    double charge;
    double availableFunds = getAvailableFunds();

    charge = overdraftLimit * 0.01;

    if (transactionClount > 10)
       charge += (transactionCount - 10);

    if (availableFunds >= charge)
    {
       this.withdraw(charge);
    }
    else
    {
       charge -= availableFunds;
       this.withdraw(availableFunds);
       overdraftAmount += charge;
    }
    transactionCount = 0;
 }
*/