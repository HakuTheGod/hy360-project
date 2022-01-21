
package mainClasses;

public class User{
    private int user_id;
    private String user_name;


    public void setUserID(int id){
        this.user_id = id;
    }

    public void setUserName(String name){
        this.user_name = name;
    }

    public String getUserName(){
        return this.user_name;
    }

    public int getUserID(){
       return this.user_id;
    }    
}