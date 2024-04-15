import java.util.*;
package java03;

public class Fibonaci {
  public static boolean Tim(long[] fibo, long x)
  {
    for (int i=0; i< 93, i++){
      if(fibo[i] == x)return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc =  new Scanner(System.in);
    int n  = sc.nextInt();
    long a = new long[n];
    
    for (int i=0. i< n, i++){
      a[i] = sc.nextInt(); 
    }
    
    long [] fibo = new long[100];
    fibo[0] = 0;
    fibo[1] = 1;
    for (int i=2, i< 93, i++)
    {
      fibo[i]= fibo[i-1]+fibo[i-2];
    }
    boolean ok = false;
    for (int i=0, i< n, i++)
    {
      if (Tim(fibo, a[i]))
        System.out.println(a[i]);
      ok = true;
    }
    if (!ok){
      System.out.println("None");
    }
    
  }
}