
/**
 * Write a description of class Debitcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Debitcard extends Bankcard
{   private int Pin_number;
    private int Withdrawal_amount;
    private String Date_of_withdrawal;
    private boolean Has_withdrawn;
    
    public Debitcard( int Pin_number, int balance_amount, int card_id, String bank_account, String issuer_bank, String client_name)
    {
        super(issuer_bank, card_id, balance_amount,bank_account);
       super.setclient_name(client_name);
       this.Pin_number=Pin_number;
       this.Has_withdrawn=false;
    }
    
     public int getPin_number()
    {
     return this.Pin_number;
    }
    
    public String getDate_of_withdrawal()
     { 
         return this.Date_of_withdrawal;
     }
        
    public boolean getHas_withdrawn()
        {
         return this.Has_withdrawn;
        }
        
    public int getWithdrawal_amount()
        {
        return this.Withdrawal_amount;
        }
        
    public void setWithdrawal_amount (int Withdrawal_amount)
        {
        this.Withdrawal_amount= Withdrawal_amount;
        }
        
    public void setDate_of_withdrawal (String Date_of_withdrawal)
    {
     this.Date_of_withdrawal= Date_of_withdrawal;
    }
        
        public void Withdraw(int Withdrawal_amount,String Date_of_withdrawal,int Pin_number)
        {
        if (this.Pin_number!=Pin_number)  
        {
         System.out.println("You have entered incorrect pin number");
         
        }
        else if (this.Pin_number==Pin_number && Withdrawal_amount <= super.getbalance_amount()) 
        {
         this.setWithdrawal_amount(Withdrawal_amount);
        super.setbalance_amount (super.getbalance_amount()-Withdrawal_amount);
          this.Has_withdrawn=true;
          setDate_of_withdrawal(Date_of_withdrawal);
        }
        else 
        { 
    
         System.out.println("Something went wrong. Please try again.");        
        
        }
}
    
    public void display()
    {  super.display();
        if (this.Has_withdrawn==true)
        {
    System.out.println("The Pin number is" + this.Pin_number);
    System.out.println("The withdrawal amount is" + this.Withdrawal_amount);
    System.out.println("The Date of withdrawal is" + this.Date_of_withdrawal);
    }
    else 
    {
    System.out.println("The Balance amount is"+super.getbalance_amount());
    }
    
}
        
    }