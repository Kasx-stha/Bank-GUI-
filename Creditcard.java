
/**
 * Write a description of class Creditcard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Creditcard extends Bankcard

{
   private int CVC_number;
   private int Grace_period;
   private double credit_limit;
   private double interest_rate;
   private String expiration_date;
   private boolean is_granted;
   
   
   public Creditcard( int card_id, String client_name,String issuer_bank, String bank_account, int balance_amount,int CVC_number,double interest_rate,String expiration_date)
   {
       super(issuer_bank, card_id, balance_amount,bank_account);
       super.setclient_name(client_name);
       this.CVC_number= CVC_number;
       this.interest_rate= interest_rate;
       this.expiration_date= expiration_date;
       this.is_granted= false;
       
    }
    
    public int getCVC_number()
    {
     return this.CVC_number;
    }
    
    public int getGrace_period()
    {
    return this.Grace_period;
    }
    
    public double getinterest_rate()
    {
     return this.interest_rate;
    }
    
    public double getcredit_limit()
    {
    return this.credit_limit;
    }
    
    public String getexpiration_date()
    {
     return this.expiration_date;
    }
    
    public boolean getis_granted()
    {
    return this.is_granted;
    }
    
    public void setcredit_limit (double credit_limit,int Grace_period)
    { if (credit_limit<=2.5*super.getbalance_amount())
        {
     this.credit_limit=credit_limit;
     this.Grace_period=Grace_period;
     this.is_granted=true;
    }
    else 
    {
    System.out.println("Cannot be issued. Insufficient balance");
    }
}

    public void CancelCreditcard()
      {
          if(this.is_granted==true)
          { this.CVC_number=0;
            this.credit_limit=0;
            this.Grace_period=0;
            this.is_granted=false;
        }
        else
        {
        System.out.println("Your Credit is not issued in your account.");
        }
      }

      public void display()
      {
       super.display();
       System.out.println("The CVC number is"+ this.CVC_number);
       System.out.println("The interest rate is"+ this.interest_rate);
       System.out.println("The expiration date is"+ this.expiration_date);
       System.out.println("The is garnted status is"+ this.is_granted);
      
       if(is_granted == true)
       {
        System.out.println("The credit limit is" + this.credit_limit);
        System.out.println("The grace limit is" + this.Grace_period);
        }
    }
}
   

