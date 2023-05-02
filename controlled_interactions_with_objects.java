import java.util.*;
import java.util.HashMap;

class InvalidLoginException extends Exception{
    public InvalidLoginException(String message){
        super(message);
    }
}

interface AdminQIF{
    public void putRecord(String rollNumber, int totalScore);
    public int getRecord(String rollNumber); 
}

class ResultEnquiry{

    public AdminResultManager adminLogin(String uname, String pass) throws InvalidLoginException {
        AdminResultManager adminResultManager = new AdminResultManager();

        if(uname == "admin" && pass == "1234" ){
            return adminResultManager;
        }
        else{
            throw new InvalidLoginException("Invalid Login Credentials");
        } 
        
    }
    
    private class AdminResultManager implements AdminQIF{
        Map<String, Integer> db = new HashMap<String, Integer>();
        
        public void putRecord(String rollNumber, int totalScore){
            db.put(rollNumber, totalScore);
        }

        public int getRecord(String rollNumber){
            return db.get(rollNumber);
        }

    }
}

interface QIF{
    public void getTotalMarks(String rollNumber);
}

public class controlled_interactions_with_objects {
    public static void main(String[] args) {
        ResultEnquiry resultEnquiry = new ResultEnquiry();
        try {
            AdminQIF adminResultManager = resultEnquiry.adminLogin("admin", "1234");
            adminResultManager.putRecord("19BCE0001", 100);
            adminResultManager.putRecord("19BCE0002", 90);
            System.out.println("" + adminResultManager.getRecord("19BCE0002"));
            
        } catch (InvalidLoginException e) {
            System.out.println("Invalid login credentials. ");
        }
    }
}
