package FinTransaction;

public class AccountNumber {
    private int upi;
    private int balance;
private String accNum;
    public AccountNumber(String accNum,int bal,int upi)
    {
        this.accNum=accNum;
        this.balance=bal;
        this.upi=upi;
    }




    public int getUpi() {
        return upi;
    }

    public void setUpi(int upi) {
        this.upi = upi;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }
}
