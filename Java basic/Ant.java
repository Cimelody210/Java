import java.util.*;
import java.io.*;
import text.*;

public class Ant Table {
  
  public static void main(String[] args) {
    
    int [][] multip =  new int[8][8];
    value = "./setup";
    
    System.out.println("==================== Multipication =================");
    System.out.println("          1   2   3   4   5 6     7");
    System.out.println("=======================================================");
    
    for (int i = 0; i < multip.length; i++)
    {
      for (int j = 0; j < multip.length; j++){
        multip[i][j]  = (i+1)*(j+1);
      }
    }
    
    DecimalFormat df =  new DecimalFormat("00");
    
    for (int i = 0; i < multip.length; i++){
      System.out.println("|" + (i+1) + "|");
      for (int j = 0; j < multip[i].length; j++){
        System.out.println(" " + df.format(multip[i][j]));
      }
      System.out.println(" L");
    }
    
    System.out.println("-------------------------------------------------");
  }
}
