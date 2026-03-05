package FinTransaction;
import java.time.LocalDateTime;
import java.util.*;
public class TransactionHistory {
private String forWhom;


    private LocalDateTime datTim;
    private int amountHow;
    private String recOrSen;

    //List<TransactionDate> mny=new ArrayList<>();
public TransactionHistory(String forWhom,LocalDateTime ld,int hm,String recOrSen)
{
    this.forWhom=forWhom;
    this.datTim=ld;
    this.amountHow=hm;
    this.recOrSen=recOrSen;

   // this.an.mny.add(td);
//this.an.map.put(forWhom,mny);
}

public TransactionHistory(){}


    public String getForWhom() {
        return forWhom;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }




    public LocalDateTime getDatTim() {
        return datTim;
    }

    public int getAmountHow() {
        return amountHow;
    }

    public String getRecOrSen() {
        return recOrSen;
    }
}
