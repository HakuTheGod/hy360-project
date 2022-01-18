public class User{
    private int id;
    private String name;


    void setUserID(int id){
        this.id = id;
    }

    void setUserName(String name){
        this.name = name;
    }

    String getUserName(){
        return this.name;
    }

    int getUserID(){
       return this.id;
    }    
}