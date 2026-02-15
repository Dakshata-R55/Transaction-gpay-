package FinTransaction;
import java.util.*;
public class TransactionHistory {
private String forWhom;
private int howMuch;
    private String fromRec;
    private int recamt;
List<Integer>mny=new ArrayList<>();
Map<String,List>map=new HashMap<>();

public TransactionHistory(String forWhom,int howMuch)
{

    this.mny.add(howMuch);
map.put(forWhom,mny);
}


    public int getHowMuch() {
        return howMuch;
    }

    public void setHowMuch(int howMuch) {
        this.howMuch = howMuch;
    }

    public String getForWhom() {
        return forWhom;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }
}
