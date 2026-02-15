package FinTransaction;

import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        List<User> user = new ArrayList<>();
       User currentUser=new User("Ram");//default user
       user.add(currentUser);
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        System.out.println("------WELCOME-------");
        System.out.println("Enter your Phone no");
        String userPhn = sc.nextLine();
        currentUser=null ;
        boolean checkUser=false;
            int c=0;
        for ( c = 0; c < user.size(); c++) {

                if (user.get(c).getUserPhn()!=null&&user.get(c).getUserPhn().equals(userPhn)) {
                    currentUser = user.get(c);
                    System.out.println("Welcome back!!" + currentUser.getUserName());
                    System.out.println("_______you are successfully loggee in!!_______");
                    checkUser=true;
                    break;

            }}
            if (checkUser==false) {
                System.out.println("Enter your name");
                String userName=sc.nextLine();
                System.out.println("Enter your Account Number");
                String userAccNum=sc.nextLine();
                System.out.println("Enter upi pin of your account ");
                Integer upi=new Integer(sc.nextLine());
                AccountNumber accN=new AccountNumber(userAccNum,5000,upi);
                currentUser = new User(userPhn,accN,userName);
                user.add(currentUser);
                System.out.println("_______you are successfully signed in_______");
        }
        Integer choice=0;
        while(choice!=7){
        System.out.println("Heyyy you can do below things by using meeee");
        System.out.println("1 Send Money");
        System.out.println("2 Receive/Request Money");
        System.out.println("3 Check Balance");
        System.out.println("4 Transaction History");
        System.out.println("5 Self transfer");
        System.out.println("6 Add bank account");
        System.out.println("7 Exit");
        System.out.println("Did you see!! What you want to do with me, Enter your choice below");
         choice = new Integer(sc.nextLine());
            TransactionHistory traHis=null;


            if (choice == 1) {
for(int i=0;i<user.size();i++){
    System.out.print(i+1+" ");
    System.out.println(user.get(i).getUserName());
}
              System.out.println("Select contact to send money");
Integer contact=new Integer(sc.nextLine());
if(contact<user.size())
{
    System.out.println("From which account you want to send money");

    for(int i=0;i<currentUser.accNum.size();i++)
    {
        System.out.println((i+1) +" " + currentUser.accNum.get(i).getAccNum());
    System.out.println("BALANCE" + " " + currentUser.accNum.get(i).getBalance());
}
    int acc=sc.nextInt();

    if((acc-1)<currentUser.accNum.size()){
        System.out.println("Enter amount to send money");
        int amt=sc.nextInt();
        System.out.println("Enter upi pin");
        int up=sc.nextInt();
        if(up==currentUser.accNum.get(acc-1).getUpi())
        {
            int reBal=currentUser.accNum.get(acc-1).getBalance();
            currentUser.accNum.get(acc-1).setBalance(reBal-amt);
            //user.get(contact-1).accNum.get()
            System.out.println("------Transaction done successfully!!------");

 new TransactionHistory(user.get(contact-1).getUserName(),amt);
 currentUser.accNum.get(acc-1).setTs(traHis);
        }
    }

}
        }

            else if (choice == 2)
            {


        }

       else if (choice == 3) {
            for(int i=0;i<currentUser.accNum.size();i++){
                System.out.print(i+1 + " ");
                System.out.println(currentUser.accNum.get(i).getAccNum());
            }
            int display=sc.nextInt();
            System.out.println("Enter upi pin to check balance");
            int upiDis=sc.nextInt();
            if(currentUser.accNum.get(display-1).getUpi()==upiDis){
                System.out.println("Balance : " + currentUser.accNum.get(display-1).getBalance());
            }
        }
        else if (choice == 4) {
            System.out.println(traHis.map);
        }
        else if(choice==5){
            System.out.println("From which account you want to send money");
            for(int i=0;i<currentUser.accNum.size();i++){
                System.out.print(i+1 + " ");
            System.out.println(currentUser.accNum.get(i).getAccNum());
        }
            int accsent=sc.nextInt();
            System.out.println("For which account you want to send money");
            for(int i=0;i<currentUser.accNum.size();i++){
                if(accsent-1==i){
                    continue;
                }
                else{
                    System.out.print(i+1+" ");
                System.out.println(currentUser.accNum.get(i));
            }
                int accRec=sc.nextInt();
                System.out.println("BALANCE : " + currentUser.accNum.get(accsent-1).getBalance());
                System.out.println("How much amount you want to send");
                int amtSen= sc.nextInt();
                currentUser.accNum.get(accsent-1).setBalance(-amtSen);
                currentUser.accNum.get(accRec-1).setBalance(+amtSen);
                System.out.println("_________Transaction done successfully_________");
            }}
        else if(choice==6){
            System.out.println("Enter your Account Number");
            String userAccNum=sc.nextLine();
            System.out.println("Enter upi pin of your account ");
            Integer upi=new Integer(sc.nextLine());
            AccountNumber accN=new AccountNumber(userAccNum,5000,upi);
            currentUser.accNum.add(accN);
            System.out.println("________Account added successfully_________");
        }
       else if(choice==7){
            System.out.print("Visit again!!");
            System.out.println(currentUser.getUserName());
        }
        else {
            System.out.println("Enter a valid choice");
        }}
    }}
}
