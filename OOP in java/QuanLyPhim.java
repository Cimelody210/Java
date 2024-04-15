package java3;

class Day{
    private int day;
    private int month;
    private int year;
    public Day(int day, int month, int year){
        this.day = day;
        this.month= month;
        this.year=year;
    }

    public int getDay(){ return day;}
    public int getMonth(){ return month;}
    public int getYear(){ return year;}
    
    public void SetDay(int days){ this.day = days;}
    public void SetMonth(int months){ this.month = months;}
    public void SetYear(int years){ this.year = years;}
}

class HangSanXuat{
    private String tenhangSX;
    private int namSX;
    private HangSanXuat hangSX;
    private int giahang;
    private Day ngayChuyen;

    public VanChuyen(String tenhang, int namsx, HangSanXuat hangsx, double giahang, Day ngayvanchuyen){
        this.tenhang= tenhangSX;
        this.namsx = namSX;
        this.hangsx = hangsx;
        this.giahang= giahang;
        this.ngayvanchuyen = ngayChuyen;
    }
    public int getTenHangSX(){ return tenhangSX;}
    public int getNamSX(){ return tenhangSX;}
}

public class QuanLyPhim{
    public static void Main(String[] args)
    {
        // Here is main code
    }
}