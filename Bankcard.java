
/**
 * Write a description of class Bankcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bankcard 
{
   private String client_name;
   private String Issuer_bank;
   private String Bank_account;
   private int Card_id;
   private int Balance_amount;
    
   public Bankcard(String issuer_bank,int card_id, 
   int balance_amount,String bank_account)
   {  
       this.client_name= "";
       this.Issuer_bank= issuer_bank;
       this.Card_id= card_id;
       this.Balance_amount= balance_amount;
       this.Bank_account= bank_account;
    }
    
    public String getclient_name()
    {
        return this.client_name;
    }
    public String getissuer_bank()
    {
     return this.Issuer_bank;
    }
    public int getcard_id()
    {
     return this.Card_id;
    }
    public int getbalance_amount()
    {
    return this.Balance_amount;
    }
    public String getbank_account()
    {
    return this.Bank_account;
    }
    
    public void  setclient_name( String client_name)
    {
    this.client_name= client_name;
    }
    
    public void setbalance_amount( int balance_amount)
    {
    this.Balance_amount=Balance_amount;
    }
    
    public void display()
    {
    System.out.println("The Client name is" + this.client_name);
    System.out.println("The Issuer bank is" + this.Issuer_bank);
    System.out.println("The Bank account is" + this.Bank_account);
    System.out.println("The Card Id is" + this.Card_id);
    System.out.println("The Balance amount is" +this.Balance_amount);
    if(this.client_name ==""){
        System.out.println("The client name is empty. Please set appropriate value. ");
        }
        else {
        System.out.println("The Client name is" + this.client_name);
        }
}
}
