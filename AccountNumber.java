package FinTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountNumber {
    private String upi;
    private int balance;
private String accNum;
private TransactionHistory ts;

    public AccountNumber(String accNum,int bal,String upi)
    {
        this.accNum=accNum;
        this.balance=bal;
        this.upi=upi;
    }

    List<TransactionHistory> mny=new ArrayList<>();
    //Map<String,List> map=new HashMap<>();


    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
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

    public TransactionHistory getTs() {
        return ts;
    }

    public void setTs(TransactionHistory ts) {
        this.ts = ts;
    }
}
