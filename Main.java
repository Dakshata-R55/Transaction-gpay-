package FinTransaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String args[]) {

        List<User> user = new ArrayList<>();
        AccountNumber accNum=new AccountNumber("SBI34567",5000,"1111");
        User currentUser = new User("9876543211",accNum,"Ram");
        user.add(currentUser);


        Scanner sc = new Scanner(System.in);
        while(true)
        {
        System.out.println("------WELCOME-------");
        System.out.println("Enter your Phone no");
        String userPhn = sc.nextLine();

        currentUser=null ;
        boolean checkUser=false;
            int c;

        for ( c = 0; c < user.size(); c++)
        {

                if (user.get(c).getUserPhn()!=null&&user.get(c).getUserPhn().equals(userPhn))
                {
                    currentUser = user.get(c);
                    System.out.println("Welcome back!!" + currentUser.getUserName());
                    System.out.println("_______you are successfully logged in!!_______");
                    checkUser=true;
                    break;
            }
        }

            if (checkUser==false)
            {
                System.out.println("Enter your name");
                String userName=sc.nextLine();
                System.out.println("Enter your Account Number");
                String userAccNum=sc.nextLine();
                System.out.println("Enter upi pin of your account ");
                String upi=sc.nextLine();
                AccountNumber accN=new AccountNumber(userAccNum,5000,upi);
                currentUser = new User(userPhn,accN,userName);
                user.add(currentUser);
                System.out.println("_______you are successfully signed in_______");
        }

       String choice="0";
        while(!choice.equals("7")){
        System.out.println("Heyyy you can do below things by using meeee");
        System.out.println("1 Send Money");
        System.out.println("2 Delete");
        System.out.println("3 Check Balance");
        System.out.println("4 Transaction History");
        System.out.println("5 Self transfer");
        System.out.println("6 Add bank account");
        System.out.println("7 Exit");
        System.out.println("Did you see!! What you want to do with me, Enter your choice below");
         choice = sc.nextLine();



            if (choice.equals("1"))
            {
for(int i=0;i<user.size();i++)
{
    if(user.get(i).getUserName().equals(currentUser.getUserName())){
        continue;
    }
    else
    {
    System.out.print(i+1+" ");
    System.out.println(user.get(i).getUserName());
}}

              System.out.println("Select contact to send money");
int contact=sc.nextInt();


if(contact<=user.size())
{
    System.out.println("From which account you want to send money");

    for(int i=0;i<currentUser.accNum.size();i++)
    {
        System.out.println((i+1) +" " + currentUser.accNum.get(i).getAccNum());
    System.out.println("BALANCE" + " " + currentUser.accNum.get(i).getBalance());
}
    int acc=sc.nextInt();

    if((acc-1)<currentUser.accNum.size())
    {
        System.out.println("Enter amount to send money");
        int amt = sc.nextInt();
        sc.nextLine();

        if(currentUser.accNum.get(acc - 1).getBalance()>amt){
        while (true) {
            System.out.println("Enter upi pin");
            String up = sc.nextLine();

            if (up.equals(currentUser.accNum.get(acc - 1).getUpi()))
            {
                int reBal = currentUser.accNum.get(acc - 1).getBalance();
                currentUser.accNum.get(acc - 1).setBalance(reBal - amt);

                LocalDateTime now = LocalDateTime.now();
                System.out.println("------Transaction done successfully!!------");

                int add = user.get(contact - 1).accNum.get(0).getBalance();
                user.get(contact - 1).accNum.get(0).setBalance(add + reBal);
                TransactionHistory traHisRec = new TransactionHistory(currentUser.getUserName(), now,amt, "RECEIVED");
                user.get(contact-1).accNum.get(0).mny.add(traHisRec);

                TransactionHistory traHis = new TransactionHistory(user.get(contact - 1).getUserName(), now,amt, "SENT");
                currentUser.accNum.get(acc - 1).mny.add(traHis);
                break;
            }
            else
            {
                System.out.println("You entered a wrong upi pin....kindly enter a correct one");
            }
        }
        }
        else
        {
            System.out.println("________Insufficient balance________");
            }
        }
    }
else
{
    System.out.println("");
}
        }


            else if (choice.equals("2"))
            {
                System.out.println("Which account you want to delete");
                for(int i=0;i<currentUser.accNum.size();i++)
                {
                    System.out.println(i+1 +" "+currentUser.accNum.get(i).getAccNum());
                }
                int del=sc.nextInt();
                currentUser.accNum.remove(del-1);
                System.out.println("_________Account deleted successfully_________");
        }


       else if (choice.equals("3"))
       {
                System.out.println("Enter which account");
            for(int i=0;i<currentUser.accNum.size();i++)
            {
                System.out.print(i+1 + " ");
                System.out.println(currentUser.accNum.get(i).getAccNum());

            }
            int display=sc.nextInt();
            System.out.println("Enter upi pin to check balance");
            String upiDis=sc.nextLine();

            if(currentUser.accNum.get(display-1).getUpi().equals(upiDis))
            {
                System.out.println("Balance : " + currentUser.accNum.get(display-1).getBalance());
            }
        }


       else if (choice.equals("4"))
       {
                System.out.println("For which account you want to see transaction ");

                for(int i=0;i<currentUser.accNum.size();i++)
                {
                    System.out.println((i + 1) + " " + currentUser.accNum.get(i).getAccNum());
                }
                int i= sc.nextInt();




                    for(int k=0;k<currentUser.accNum.get(i-1).mny.size();k++)
                    {
                        System.out.println("Account Holder Name: " + currentUser.accNum.get(i-1).mny.get(k).getForWhom());
                        System.out.println(currentUser.accNum.get(i-1).mny.get(k).getRecOrSen() + " : "  + currentUser.accNum.get(i-1).mny.get(k).getAmountHow());
                    System.out.println("Date & Time: " + currentUser.accNum.get(i-1).mny.get(k).getDatTim());
                }
       }




        else if(choice.equals("5"))
        {
            System.out.println("From which account you want to send money");

            for(int i=0;i<currentUser.accNum.size();i++)
            {
                System.out.print(i+1 + " ");
            System.out.println(currentUser.accNum.get(i).getAccNum());
        }
            int accsent=sc.nextInt();
            System.out.println("For which account you want to send money");

            for(int i=0;i<currentUser.accNum.size();i++)
            {
                if(accsent-1==i)
                {
                    continue;
                }

                else
                {
                    System.out.print(i+1+" ");
                System.out.println(currentUser.accNum.get(i).getAccNum());
            }

                int accRec=sc.nextInt();
                System.out.println("BALANCE : " + currentUser.accNum.get(accsent-1).getBalance());
                System.out.println("How much amount you want to send");
                int amtSen= sc.nextInt();

                int bef=currentUser.accNum.get(accsent-1).getBalance();
                currentUser.accNum.get(accsent-1).setBalance(bef-amtSen);
                LocalDateTime now=LocalDateTime.now();
                TransactionHistory traHis = new TransactionHistory(currentUser.getUserName(), now,amtSen, "SENT-Self Transfer");
                currentUser.accNum.get(accsent - 1).mny.add(traHis);


                int aft=currentUser.accNum.get(accRec-1).getBalance();
                currentUser.accNum.get(accRec-1).setBalance(aft+amtSen);
                TransactionHistory traHisR = new TransactionHistory(currentUser.getUserName(), now,amtSen, "RECEIVED-Self transfer");
                currentUser.accNum.get(accRec - 1).mny.add(traHisR);

                System.out.println("_________Transaction done successfully_________");
            }}


        else if(choice.equals("6"))
        {
            System.out.println("Enter your Account Number");

            String userAccNum=sc.nextLine();

            System.out.println("Enter upi pin of your account ");
            String upi=sc.nextLine();
            AccountNumber accN=new AccountNumber(userAccNum,5000,upi);
            currentUser.accNum.add(accN);
            System.out.println("________Account added successfully_________");
        }


       else if(choice.equals("7"))
       {
            System.out.print("Visit again!!");
            System.out.println(currentUser.getUserName());
        }


       else {
            System.out.println("Enter a valid choice");
        }}
    }}}
