import java.util.*;
import java.io.*;

public class CheckDate {
  
  public static void main(String[] args throw IDExecption) {
    BufferReader in = new BufferReader(new InputStreamReader(System.in));
    System.out.println("The day of monday");
    String input ="";
    System.out.println("What Day?");
    int inputDay = Integer.parseInt(in.readline());
    int inputMonth = Integer.parseInt(in.readline());
    
    Calendar cal = cal.get(Calendar.MONTH) + 1;
    
    int month = Calendar.getInstance();
    int day = cal.get(Calendar.DATE);
    
    if (inputMonth == month && inputDay== day){
      System.out.println("Right");
    }
    else{
      System.out.println("Wrong");

    }
    
  }
}