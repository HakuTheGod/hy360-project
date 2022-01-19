
package mainClasses;

public class User{
    private int id;
    private String name;


    public void setUserID(int id){
        this.id = id;
    }

    public void setUserName(String name){
        this.name = name;
    }

    public String getUserName(){
        return this.name;
    }

    public int getUserID(){
       return this.id;
    }    
}