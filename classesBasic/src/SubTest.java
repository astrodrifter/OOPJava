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
