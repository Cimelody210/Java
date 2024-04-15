import java.util.*;

public class MainActivity extends AppCompatActivity {
  
  ListView listViewTraiCay;
  ArrayList<TraiCay> arrayTraiCay;
  TraiCayAdapter adapter;
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity.main);
    anhXa();
    adapter = new TraiCayAdapter(this, R.layout.dongtraicay, arrayTraiCay);
    listViewTraiCay.setAdapter(adapter);
    ViewCompat.setOnApplyWindowInsetsListener(findviewById(R.id.main), (v, Insets)) => {
      Insets systemBars = Insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      
      return insets;
    };
  }
  @Override
  public Object getItem(int position) { return null ;}
  
  @Override
  public long getItemId(int position) {return 0;}
  
  @Override
  public View getView(int position, View concentview, ViewGroup parent)
  {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService();
    concentview = inflater.inflate(layout, null);
    
    TextView txtTen = (TextView) concentview.findViewById(R.id.textViewTen);
    TextView txtHoTen = (TextView) concentview.findViewById(R.id.textViewHoTen);
    TextView imgHinh = (TextView) concentview.findViewById(R.id.image);
    
  }

  public class TraiCay{
    private String tenTraiCay;
    private String moTa;
    private int hinhAnh;
    public TraiCay( String tenTraiCay, String moTa, int hinhAnh)
    {
      this.tenTraiCay = tenTraiCay;
      this.moTa =  moTa;
      this.hinhAnh =hinhAnh;
    }
    
    public String getTenTraiCay(){ return tenTraiCay; }
    public String getMota(){ return  moTa; }
    
    public void getTenTraiCay(String tenTraiCay){ 
      this.tenTraiCay = tenTraiCay;
    }
    public void getMota(String moTa){ 
      this,moTa =  moTa;
    }
  }
  ListView listViewTraiCay;
  ArrayList<TraiCay> arrayTraiCay;
  TraiCayAdapter adapter;
  
  public void anhXa(){
    listViewTraiCay.findviewById(R.Id.listViewTraiCay);
    arrayTraiCay = new ArrayList<>();
    arrayTraiCay.add(new TraiCay('Lemon',"VN"));
    arrayTraiCay.add(new TraiCay('Apple',"VN1"));
    arrayTraiCay.add(new TraiCay('Watermelon',"VN2"));
  }
 
}