public abstract class Book
{
    protected Writer writer;

    protected Book(Writer writer){
        this.writer = writer;
    }
    public abstract void create(){
        
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
