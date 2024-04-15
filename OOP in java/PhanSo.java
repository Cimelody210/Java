import java.util.*;
package bt;


class PhanSo
{
  private int tuso, mauso;
  public PhanSo()
  {
    tuso, mauso = 0,1;
  }
  public PhanSo(int tu, int mau)
  {
    tuso =  tu;
    mauso = mau;
  }
  public int getTuso(){return tuso; }
  public int getMauso(){return mauso; }
}

public class PhanSo {
    public static void main(String[] args) {
      PhanSo a= new PhanSo(2,3);
      PhanSo b= new PhanSo(1,5);
      System.out.println("Hello, World!");
      System.out.println(a.PhanSo());
  }
}