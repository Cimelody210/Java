import java.util.*;
package graficos;

public class Layouts2Java {
  public static void main(String[] args) {
    Marco2Layout miMarco = new Marco2Layout();
    miMarco.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    System.out.println("Trưởng thành");
  }
}
class Marco2Layout extends Jframe{
  
  public Marco2Layout()
  {
    setVisible(true);
    setBound(300,200,500,300);
    setTitle("Prifuvh");
    Lamina2Layout miLamina = new Lamina2Layout();
    add(miLamina);
  }
}

class Lamina2Layout extends Jframe{
  public Lamina2Layout()
  {
    setLayout(new BorderLayout(10,10));
    add(new JButton("A"), BorderLayout.NORTH);
    add(new JButton("B"), BorderLayout.EAST);
    add(new JButton("C"), BorderLayout.SOUTH);
    add(new JButton("DA"), BorderLayout.WEST);
    add(new JButton("23A"), BorderLayout.CENTER);
  }
}