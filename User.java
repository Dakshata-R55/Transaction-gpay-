package FinTransaction;
import java.util.*;
public class User {
    private String userPhn;
   private String userName;
   List<AccountNumber> accNum=new ArrayList<>();

    public User(String userid,AccountNumber accNum,String name){
this.accNum.add(accNum);
        this.userPhn=userid;
        this.userName=name;
    }

    public User(String name){
        this.userName=name;
    }
    public String getUserPhn() {
        return userPhn;
    }

    public void setUserPhn(String userId) {
        this.userPhn= userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
