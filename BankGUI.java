import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;





/**
 * Write a description of class BankGUI here.
 *
 * @author (Kasis Shrestha)
 * @version (5/09/2023)
 */
public class BankGUI implements ActionListener  
{
        //making instance variable of m1
       private JFrame Bank_card_frame;
       private JPanel bankcard_panel;
       private JButton Debitcard;
       private JButton Creditcard;
        
        //making instance variable of m2
       private JFrame Debit_card_frame;
       private JPanel debitcard_panel;
       private JLabel heading,card_id, client_name, issuer_bank,
       balance_amount, bank_account, pin_number, withdrawal_amount,
       dateof_withdrawal;
       private JTextField card, client, issuer, balance, bank, pin,
       withdrawal;
       private JButton add_debitcard, go_back,withdraw, display, clear;
       private JComboBox day, month, year;
       
        //making instance variable of m3
        private JFrame Credit_card_frame;
        private JPanel creditcard_panel;
        private JLabel heading2, card_id2, client_name2, issuer_bank2,
        balance_amount2, bank_account2, cvc_number, interest_rate, 
        expiration_date, credit_limit, grace_period;
        private JTextField card2, client2, issuer2, balance2, bank2, cvc,
        intrestrate, creditlimit, graceperiod;
        private JButton add_creditcard, cancel_creditcard, go_back2,
        set_creditlimit, display2, clear2;
        private JComboBox day2, month2,year2;
        
        //creating arraylist
        ArrayList<Bankcard> Arr_list = new ArrayList<Bankcard>(); 
           public void actionPerformed(ActionEvent k)
{
    // add button
    //using getsource for Debit Card
        if(k.getSource()==Debitcard)
    {
        Bank_card_frame.dispose();
        m2();
    }
     
     else if (k.getSource() == add_debitcard) 
     {
        // logic for add debit card
        try {
            int pin_number = Integer.valueOf(pin.getText());
            int balance_amount = Integer.valueOf(balance.getText());
            int card_id = Integer.valueOf(card.getText());
            String bank_account = bank.getText();
            String issuer_bank = issuer.getText();
            String client_name = client.getText();
    
            // new or flag
            boolean o = true;
            // for each loop
            for (Bankcard i : Arr_list) 
            {
                // instance of operator for getting value
                if (i instanceof Debitcard) 
                {
                    // downcasting(converting)
                    Debitcard obj_debit = (Debitcard) i;
                    // comparing the value of card_id (if the values are same or not)
                    if (obj_debit.getcard_id() == card_id)
                    {
                        o = false;
                    }
                }
    
            }
    
            if (o == true)
            {
                // creating obj
                Debitcard obj_debit = new Debitcard(pin_number, balance_amount, card_id, bank_account, issuer_bank, client_name);
    
                // add arr_list
                Arr_list.add(obj_debit);
                // creating JOptionPane for message dialog
                JOptionPane.showMessageDialog(debitcard_panel, "Added Successfully");
            } else 
            {
                // creating JOptionPane for message dialog
                JOptionPane.showMessageDialog(debitcard_panel, "The DebitCard with Card ID: " + card_id + " is already added.", "ALERT", JOptionPane.WARNING_MESSAGE);
            }
        } 
        catch (NumberFormatException b) 
        {
                
                //using message dialog to show the error
                JOptionPane.showMessageDialog(debitcard_panel,"Invalid Input.Please enter a valid number." , "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch (NullPointerException b)
        {
               
                //using message dialog to show the error
               JOptionPane.showMessageDialog(debitcard_panel, "Please fill in all required fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    else if (k.getSource()== withdraw )
    { 
        try
        {
        int card_id = Integer.valueOf(card.getText());
        int pin_number = Integer.valueOf(pin.getText());
        int withdrawal_amount= Integer.valueOf(withdrawal.getText());
        String Year= year.getSelectedItem().toString();
        String Month= month.getSelectedItem().toString();
        String Day= day.getSelectedItem().toString();
        String dateof_withdrawal=Year+" "+Month+" "+Day;
        
          for ( Bankcard j: Arr_list)
            {
            // instance of operator for getting value
            if (j instanceof Debitcard)
            {
              //downcasting(converting)
              Debitcard obj_debit = (Debitcard) j;    
              // comparing the value of card_id (if the values are same or not)
              if (obj_debit.getcard_id() == card_id)
              {
              //message dialog
              JOptionPane.showMessageDialog(debitcard_panel, "The card id is :"+card_id+"\n"+ "The withdrawal amount is :"+withdrawal_amount+ "\n"+ "The Date of withdrawal is:"+dateof_withdrawal+"\n"+ "The pin number is :"+pin_number);
              
              //calling withdraw method 
               if (pin_number== obj_debit.getPin_number())
               {
                if(withdrawal_amount<= obj_debit.getbalance_amount())
                {
                obj_debit.Withdraw(withdrawal_amount,dateof_withdrawal, pin_number);
                int sub= obj_debit.getbalance_amount()- withdrawal_amount;
                String s= Integer.toString(sub);
                balance.setText(s);
                
                
                
                  JOptionPane.showMessageDialog(debitcard_panel, "Transaction is successful.");
                }
                else
                {
                 JOptionPane.showMessageDialog(debitcard_panel,"Your transaction cannot be made. You donot have sufficient balance amount.", "ALERT", JOptionPane.WARNING_MESSAGE);
                }
                }
                else
                {
                 JOptionPane.showMessageDialog(debitcard_panel," Unsuccessful Transaction.", "Try again", JOptionPane.WARNING_MESSAGE);
            
                }
              }
           }
         }
        }
        catch (NumberFormatException b) 
        {
                
                //using message dialog to show the error
                JOptionPane.showMessageDialog(debitcard_panel,"Invalid Input.Please enter a valid number." , "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        catch (NullPointerException b)
        {
               
                //using message dialog to show the error
               JOptionPane.showMessageDialog(debitcard_panel, "Please fill in all required fields.", "ERREOR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    else if(k.getSource()==go_back)
    {
        
        Debit_card_frame.dispose();
        m1();
    }
        
    else if (k.getSource()== display )
    {
        
        int pin_number = Integer.valueOf(pin.getText());
        int withdrawal_amount= Integer.valueOf(withdrawal.getText());
        int balance_amount = Integer.valueOf(balance.getText());
        String Year= year.getSelectedItem().toString();
        String Month= month.getSelectedItem().toString();
        String Day= day.getSelectedItem().toString();
        String dateof_withdrawal=Year+" "+Month+" "+Day;
        
        
       System.out.println("The Pin number is: " + pin_number);
        System.out.println("The Withdrawal amount is: " + withdrawal_amount);
        System.out.println("The Date of withdrawal is: " + dateof_withdrawal);
        System.out.println("The Balance amount is:  "+ balance_amount);
        
        //JOPtionPane
        JOptionPane.showMessageDialog(debitcard_panel,"The Pin number is: " + pin_number+
        "\n"+"The Withdrawal amount is: " + withdrawal_amount+ "\n"+"The Date of withdrawal is: " + dateof_withdrawal+
        "\n"+"The Balance amount is: "+ balance_amount);
    }
    

    else if (k.getSource()== clear )
    {
        card.setText("");
        client.setText("");
        issuer.setText("");
        balance.setText("");
        bank.setText("");
        pin.setText("");
        withdrawal.setText("");
        
        //JOptionPane
        JOptionPane.showMessageDialog(debitcard_panel, "Cleared");
    
    }
    // for credit card
    //using getsource for Credit Card
      else if(k.getSource()==Creditcard)
    {
        Bank_card_frame.dispose();
        m3();
    }
    
    else if (k.getSource() == add_creditcard) 
    {
        try 
        {
            // logic for add credit card
            int Card_ID = Integer.parseInt(card2.getText());
            String Client_Name = client2.getText();
            String Issuer_Bank = issuer2.getText();
            String Bank_Account = bank2.getText();
            int Balance_Amount = Integer.parseInt(balance2.getText());
            int CVC_number = Integer.parseInt(cvc.getText());
            double Interest_rate = Double.parseDouble(intrestrate.getText());
            String Year2 = year2.getSelectedItem().toString();
            String Month2 = month2.getSelectedItem().toString();
            String Day2 = day2.getSelectedItem().toString();
            String expiration_date = Year2 + " " + Month2 + " " + Day2;
          
    
            // new or flag
            boolean a = true;
            // for each loop
            for (Bankcard j : Arr_list) 
            {
                // instance of operator fro getting value
                if (j instanceof Creditcard) 
                {
                    // downcasting (converting)
                    Creditcard obj_credit = (Creditcard) j;
                    // comparing the value of card_id (if the values are same or not)
                    if (obj_credit.getcard_id() == Card_ID) 
                    {
                        a = false;
                        break; // exit the loop when a match is found
                    }
                }
            }
            if (a == true) 
            {
             Creditcard obj_credit = new Creditcard(Card_ID, Client_Name, Issuer_Bank,
             Bank_Account, Balance_Amount, CVC_number, Interest_rate, expiration_date);
             Arr_list.add(obj_credit);
            // displaying the customized message
            JOptionPane.showMessageDialog(creditcard_panel, "Added Successfully");
            
            } 
            else 
            {
            JOptionPane.showMessageDialog(creditcard_panel,"The Credit card with Card ID:" + Card_ID + " is already added.", "ALERT", JOptionPane.WARNING_MESSAGE);
           
            }
            } 
        catch (NumberFormatException e) 
        {    
                //using message dialog to show the error
                JOptionPane.showMessageDialog(creditcard_panel,"Invalid Input.Please enter a valid number.", "ERROR",JOptionPane.ERROR_MESSAGE );
        } 
        catch (NullPointerException e)
        
        {   
                //using message dialog to show te error
                JOptionPane.showMessageDialog(creditcard_panel, "Please fill in all required fields.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    else if (k.getSource()== set_creditlimit)
    {
        try
        {
        double credit_limit =  Double.valueOf(creditlimit.getText());
        int grace_period = Integer.valueOf(graceperiod.getText());
        int CARD_id = Integer.valueOf(card2.getText());
        
        for ( Bankcard j: Arr_list)
        {
            // instance of operator for getting value
            if (j instanceof Creditcard)
            {
              //downcasting(converting)
              Creditcard obj_credit = (Creditcard) j;    
              // comparing the value of card_id (if the values are same or not)
              if (obj_credit.getcard_id() == CARD_id)
                {
                    
                    //message dialog
                   JOptionPane.showMessageDialog(creditcard_panel, "The card id is : "+CARD_id+"\n"+ "The credit limit is :" + credit_limit+ "\n"+"The garce period is: "+grace_period + "\n" );
                  
                    if (credit_limit <= 2.5 * obj_credit.getbalance_amount()) 
                    //calling set_creditlimit method
                    {
                        obj_credit.setcredit_limit(credit_limit, grace_period);
                     JOptionPane.showMessageDialog(creditcard_panel,"Your creditlimit is sucessful." );
                    }
    
                    else
                   {
                     JOptionPane.showMessageDialog(creditcard_panel,"Your creditlimit is unsucessful." ,"Try Again",JOptionPane.WARNING_MESSAGE);
       
                   }
                }
            }
        }
    }
        catch (NumberFormatException e) 
        {    
                //using message dialog to show the error
                JOptionPane.showMessageDialog(creditcard_panel,"Invalid Input.Please enter a valid number.", "ERROR",JOptionPane.ERROR_MESSAGE );
        } 
        catch (NullPointerException e)
        
        {   
                //using message dialog to show te error
                JOptionPane.showMessageDialog(creditcard_panel, "Please fill in all required fields.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    


    else if (k.getSource()== cancel_creditcard)
       
    {
        int CARD_ID = Integer.parseInt(card2.getText());
            String Client_Name = client2.getText();
            String Issuer_Bank = issuer2.getText();
            String Bank_Account = bank2.getText();
            int Balance_Amount = Integer.parseInt(balance2.getText());
            int CVC_number = Integer.parseInt(cvc.getText());
            double Interest_rate = Double.parseDouble(intrestrate.getText());
            String Year2 = year2.getSelectedItem().toString();
            String Month2 = month2.getSelectedItem().toString();
            String Day2 = day2.getSelectedItem().toString();
            String expiration_date = Year2 + " " + Month2 + " " + Day2;
            double credit_limit =  Double.valueOf(creditlimit.getText());
            int grace_period = Integer.valueOf(graceperiod.getText());
           
           
        for ( Bankcard j: Arr_list)
        {   
          
            // instance of operator for getting value
            if (j instanceof Creditcard)
            {
              //downcasting(converting)
              Creditcard obj_credit = (Creditcard) j;    
              // comparing the value of card_id (if the values are same or not)
              if (obj_credit.getcard_id() == CARD_ID)
               { 
                 obj_credit.CancelCreditcard();
                 JOptionPane.showMessageDialog(creditcard_panel, "Your credit card is cancelled");
                 cvc.setText(" ");
                 creditlimit.setText(" ");
                 graceperiod.setText(" ");
                 Arr_list.remove(obj_credit);
                 
               }
               else
               {
                JOptionPane.showMessageDialog(creditcard_panel, "You have entered Invalid Card ID");
               }
            }
            }
        
    }
    else if(k.getSource()==go_back2)
    {
        Credit_card_frame.dispose();
        m1();
    }
    else if (k.getSource()== display2)
    {
        
        int CVC_number = Integer.parseInt(cvc.getText());
        double Interest_rate = Double.parseDouble(intrestrate.getText());
        String Year2 = year2.getSelectedItem().toString();            
        String Month2 = month2.getSelectedItem().toString();
        String Day2 = day2.getSelectedItem().toString();
        String expiration_date = Year2 + " " + Month2 + " " + Day2;
        double credit_limit =  Double.valueOf(creditlimit.getText());
        int grace_period = Integer.valueOf(graceperiod.getText());
            
        System.out.println("The CVC number is: " + CVC_number);
        System.out.println("The Interest rate is: " + Interest_rate);
        System.out.println("The Expiration Date is: " + expiration_date);
        System.out.println("The Credit Limit is:  "+ credit_limit);
        System.out.println("The Grace period is:  "+ grace_period);
        
        //JOPtionPane
        JOptionPane.showMessageDialog(debitcard_panel,"The CVC number is: " + CVC_number+
        "\n"+"The Interest rate is: " +Interest_rate+ "\n"+"The Expiration date is: " + expiration_date+
        "\n"+"The Credit Limit is: "+ credit_limit+ "\n"+"The Grace period is: " + grace_period);
    }
    
    else if (k.getSource()== clear2)
    { 
       card2.setText("");
       client2.setText("");
       issuer2.setText("");
       balance2.setText("");
       bank2.setText("");
       cvc.setText("");
       intrestrate.setText("");
       creditlimit.setText("");
       graceperiod.setText("");
       
       JOptionPane.showMessageDialog(creditcard_panel, "Cleared");
    }
    

   }
   
   public static void main (String [] args)
   {
     BankGUI gui = new BankGUI();
     gui.m1();
    
   }
      
  public void m1()
   
   { 
           // Creating JFrame
        Bank_card_frame = new JFrame();
        Bank_card_frame.setTitle("Bank Card");
        Bank_card_frame.setBounds(0, 0, 600, 600);
        Bank_card_frame.setResizable(false);
        Bank_card_frame.setLayout(null);
        // Creating JPanel
        bankcard_panel = new JPanel();
        bankcard_panel.setBounds(0, 0, 600, 600);
        bankcard_panel.setBackground(Color.WHITE);
        bankcard_panel.setLayout(null);
        
        //Creating JLable
        JLabel welcome= new JLabel("Welcome to Nabil Bank.");
        welcome.setBounds(100, 80, 400, 50);
        welcome.setFont(new Font("Times New Roman", Font.PLAIN,35));
        welcome.setForeground(Color.blue);
        bankcard_panel.add(welcome);
        
        JLabel text= new JLabel("Choose your prefered card");
        text.setBounds(110, 150, 400, 30);
        text.setFont(new Font("Times New Roman", Font.PLAIN,15));
        text.setForeground(Color.blue);
        bankcard_panel.add(text);
        //Creating JButton
        Debitcard = new JButton();
        Debitcard.setText("Debit Card");
        Debitcard.setFont(new Font("Times New Roman",Font.PLAIN,40));
        Debitcard.setBounds(110, 200, 300, 80);
        bankcard_panel.add(Debitcard);
        //adding ActionListener
        Debitcard.addActionListener(this);
        
        Creditcard= new JButton();
        Creditcard.setText("Credit Card");
        Creditcard.setFont(new Font("Times New Roman",Font.PLAIN,40));
        Creditcard.setBounds(110, 370, 300, 80);
        bankcard_panel.add(Creditcard);
        //adding ActionListener
        Creditcard.addActionListener(this);
        
        Bank_card_frame.add(bankcard_panel);
        Bank_card_frame.setVisible(true);
       
    }
    
  public void m2()
    {
         //Creating JFrame
         Debit_card_frame = new JFrame();
         Debit_card_frame.setTitle("Debit Card");
         Debit_card_frame.setBounds(0, 0, 850, 850);
         Debit_card_frame.setResizable(false);
         Debit_card_frame.setLayout(null);
         
         //Creating JPanel
         debitcard_panel = new JPanel();
         debitcard_panel.setBounds(0, 0, 850, 800);
         debitcard_panel.setBackground(Color.WHITE);
         debitcard_panel.setLayout(null);
         
         //Creating JLabel
          heading = new JLabel("Debit Card");
          heading.setForeground(Color.BLUE);
          heading.setBounds(295, 30, 250, 50);
          heading.setFont(new Font("Times New Roman Bold", Font.PLAIN,35));
          debitcard_panel.add(heading);
          
          card_id = new JLabel("Card ID");
          card_id.setBounds(50, 80, 100, 100);
          card_id.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(card_id);
          
          client_name = new JLabel("Client Name");
          client_name.setBounds(375, 80, 100, 100);
          client_name.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(client_name);
          
          issuer_bank = new JLabel("Issuer Bank");
          issuer_bank.setBounds(50, 145, 100, 100);
          issuer_bank.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(issuer_bank);
          
          balance_amount = new JLabel("Balance Amount");
          balance_amount.setBounds(375, 145, 150, 100);
          balance_amount.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(balance_amount);
          
          bank_account = new JLabel("Bank Account");
          bank_account.setBounds(50, 220, 150, 100);
          bank_account.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(bank_account);
          
          pin_number = new JLabel("PIN Number");
          pin_number.setBounds(375, 220, 100, 100);
          pin_number.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(pin_number);
          
          withdrawal_amount = new JLabel("Withdrawal Amount");
          withdrawal_amount.setBounds(50, 370, 200, 100);
          withdrawal_amount.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(withdrawal_amount);
          
          dateof_withdrawal = new JLabel("Date of Withdrawal");
          dateof_withdrawal.setBounds(50, 435, 200, 100);
          dateof_withdrawal.setFont(new Font("Times New Roman", Font.PLAIN,18));
          debitcard_panel.add(dateof_withdrawal);
          
          //Creating JTextField
          card = new JTextField();
          card.setBounds(175, 115, 185, 30);
          card.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(card);
          
          client = new JTextField();
          client.setBounds(505, 115, 185, 30);
          client.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(client);
          
          issuer = new JTextField();
          issuer.setBounds(175, 180, 185, 30);
          issuer.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(issuer);
          
          balance = new JTextField();
          balance.setBounds(505, 180, 185, 30);
          balance.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(balance);
          
          bank = new JTextField();
          bank.setBounds(175, 255, 185, 30);
          bank.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(bank);
          
          pin = new JTextField();
          pin.setBounds(505, 255, 185, 30);
          pin.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(pin);
        
          withdrawal = new JTextField();
          withdrawal.setBounds(215, 405, 185, 30);
          withdrawal.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(withdrawal );
          
          //Creating JButton
          add_debitcard = new JButton();
          add_debitcard.setText("Add Debit card");
          add_debitcard.setBounds(285, 335, 150, 30);
          add_debitcard.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(add_debitcard);
          //adding ActionListener
          add_debitcard.addActionListener(this);
        
          go_back = new JButton();
          go_back.setText("Go back");
          go_back.setBounds(700, 35, 100, 30);
          go_back.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(go_back);
          //adding ActionListener
          go_back.addActionListener(this);
          
           //Creating JButton
          withdraw = new JButton();
          withdraw.setText("Withdraw");
          withdraw.setBounds(250, 575, 120, 30);
          withdraw.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(withdraw);
          //adding ActionListener
          withdraw.addActionListener(this);
    
          display = new JButton();
          display.setText("Display");
          display.setBounds(400, 575, 120, 30);
          display.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(display);
          //adding ActionListener
          display.addActionListener(this);
          
          clear = new JButton();
          clear.setText("Clear");
          clear.setBounds(550, 575, 120, 30);
          clear.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(clear);
          //adding ActionListener
          clear.addActionListener(this);
          
          //Creating JComboBox
          String [] Day = {"1","2", "3", "4", "5", "6", "7", "8", "9",
         "10","11","12", "13", "14", "15", "16", "17", "18", "19","20", 
         "21","22", "23", "24", "25", "26", "27", "28", "29","30"};
          day  = new JComboBox(Day);
          day.setBounds (212, 470, 135, 30);
          day.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(day);
     
          String [] Months= {"January", "February", "March", "April", "May",
          "June", "July", "August","September", "October", "November", "December"};
          month = new JComboBox(Months);
          month.setBounds (362, 470, 135, 30);
          month.setFont(new Font("Times New Roman", Font.PLAIN,16));
          debitcard_panel.add(month);
       
          String [] Year = {"2000", "2001","2002","2003","2004","2005",
           "2006", "2007","2008","2009","2010","2011",
           "2012", "2013","2014","2015","2016","2017",
           "2018", "2019","2020","2021","2022","2023"};
          year = new JComboBox(Year);
          year.setBounds (512, 470, 135, 30);
          year.setFont(new Font("Times New Roman", Font.PLAIN,16));
           debitcard_panel.add(year);
          
          //adding JPanel in JFrame
          Debit_card_frame.add(debitcard_panel);
          Debit_card_frame.setVisible(true);
    }
    
  public void m3()
    {
            //Creating JFrame
         Credit_card_frame = new JFrame();
         Credit_card_frame.setTitle("Credit Card");
         Credit_card_frame.setBounds(0, 0, 850, 850);
         Credit_card_frame.setResizable(false);
         Credit_card_frame.setLayout(null);
         
         //Creating JPanel
         creditcard_panel= new JPanel();
         creditcard_panel.setBounds(0, 0, 850, 800);
         creditcard_panel.setBackground(Color.WHITE);
         creditcard_panel.setLayout(null);
         
         
         //Creating JLabel
          heading2 = new JLabel("Credit Card");
          heading2.setForeground(Color.BLUE);
          heading2.setBounds(295, 30, 250, 50);
          heading2.setFont(new Font("Times New Roman Bold", Font.PLAIN,35));
          creditcard_panel.add(heading2);
          
          card_id2 = new JLabel("Card ID");
          card_id2.setBounds(50, 80, 100, 100);
          card_id2.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(card_id2);
          
           client_name2 = new JLabel("Client Name");
          client_name2.setBounds(375, 80, 100, 100);
          client_name2.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(client_name2);
          
          issuer_bank2 = new JLabel("Issuer Bank");
          issuer_bank2.setBounds(50, 145, 100, 100);
          issuer_bank2.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(issuer_bank2);
          
           balance_amount2 = new JLabel("Balance Amount");
          balance_amount2.setBounds(375, 145, 200, 100);
          balance_amount2.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(balance_amount2);
          
          bank_account2 = new JLabel("Bank Account");
          bank_account2.setBounds(50, 220, 200, 100);
          bank_account2.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(bank_account2);
          
          cvc_number = new JLabel("CVC Number");
          cvc_number.setBounds(375, 220, 200, 100);
          cvc_number.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(cvc_number);
          
          interest_rate = new JLabel("Interest Rate");
          interest_rate.setBounds(50, 370, 130, 100);
          interest_rate.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(interest_rate );
          
          expiration_date = new JLabel("Expiration Date");
          expiration_date.setBounds(50, 435, 130, 100);
          expiration_date.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(expiration_date);
          
         credit_limit = new JLabel("Credit Limit");
          credit_limit.setBounds(50, 500, 130, 100);
          credit_limit.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(credit_limit );
          
          grace_period = new JLabel("Grace Period");
          grace_period.setBounds(50, 565, 1430, 100);
          grace_period.setFont(new Font("Times New Roman", Font.PLAIN,18));
          creditcard_panel.add(grace_period);
          
          //Creating JTextField
          card2 = new JTextField();
          card2.setBounds(175, 115, 180, 30);
          card2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(card2);
          
          client2 = new JTextField();
          client2.setBounds(505, 115, 180, 30);
          client2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(client2);
          
          issuer2 = new JTextField();
          issuer2.setBounds(175, 180, 180, 30);
          issuer2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(issuer2);
          
          balance2 = new JTextField();
          balance2.setBounds(505, 180, 180, 30);
          balance2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(balance2);
          
          bank2 = new JTextField();
          bank2.setBounds(175, 255, 180, 30);
          bank2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(bank2);
          
          cvc = new JTextField();
          cvc.setBounds(505, 255, 180, 30);
          cvc.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(cvc);
          
          intrestrate = new JTextField();
          intrestrate.setBounds(180, 400, 180, 30);
          intrestrate.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(intrestrate );
          
          creditlimit = new JTextField();
          creditlimit.setBounds(180, 535, 180, 30);
          creditlimit.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(creditlimit );
          
          graceperiod = new JTextField();
          graceperiod.setBounds(180, 600, 180, 30);
          graceperiod.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(graceperiod);
          
          //Creating JButton
          add_creditcard = new JButton();
          add_creditcard.setText("Add Credit card");
          add_creditcard.setBounds(250, 335, 150, 30);
          add_creditcard.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(add_creditcard);
          //adding ActionListener
          add_creditcard.addActionListener(this);
          
          cancel_creditcard = new JButton();
          cancel_creditcard.setText("Cancel Credit card");
          cancel_creditcard.setBounds(500, 335, 180, 30);
          cancel_creditcard.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(cancel_creditcard);
          //adding ActionListener
          cancel_creditcard.addActionListener(this);
        
          go_back2 = new JButton();
          go_back2.setText("Go back");
          go_back2.setBounds(700, 35, 100, 30);
          go_back2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(go_back2);
          //adding ActionListener
          go_back2.addActionListener(this);
          
          //Creating JButton
          set_creditlimit = new JButton();
          set_creditlimit.setText("Set Credit Limit");
          set_creditlimit.setBounds(250, 665, 165, 30);
          set_creditlimit.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(set_creditlimit);
          //adding ActionListener
          set_creditlimit.addActionListener(this);
    
          display2 = new JButton();
          display2.setText("Display");
          display2.setBounds(440, 665, 100, 30);
          display2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(display2);
          //adding ActionListener
          display2.addActionListener(this);
          
          clear2 = new JButton();
          clear2.setText("Clear");
          clear2.setBounds(580, 665, 100, 30);
          clear2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(clear2);
          //adding ActionListener
          clear2.addActionListener(this);
          
          //Creating JComboBox
           String [] Day2 = {"1","2", "3", "4", "5", "6", "7", "8", "9",
         "10","11","12", "13", "14", "15", "16", "17", "18", "19","20", 
         "21","22", "23", "24", "25", "26", "27", "28", "29","30"};
           day2  = new JComboBox(Day2);
          day2.setBounds (182, 475, 130, 25);
          day2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(day2);
     
         String [] Month2= {"January", "February", "March", "April", "May",
          "June", "July", "August","September", "October", "November", "December"};
          month2 = new JComboBox(Month2);
          month2.setBounds (332, 475, 130, 25);
          month2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(month2);
       
         String [] Year2 = {"2000", "2001","2002","2003","2004","2005",
           "2006", "2007","2008","2009","2010","2011",
           "2012", "2013","2014","2015","2016","2017",
           "2018", "2019","2020","2021","2022","2023", "2024", "2025"};
          year2 = new JComboBox(Year2);
          year2.setBounds (482, 475, 130, 25);
          year2.setFont(new Font("Times New Roman", Font.PLAIN,16));
          creditcard_panel.add(year2);
           
           
         //adding JPanel in JFrame
         Credit_card_frame.add(creditcard_panel);
         Credit_card_frame.setVisible(true);
    }

}
