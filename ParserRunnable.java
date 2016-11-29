
public class ParserRunnable implements Runnable{

	public ParserRunnable() {
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		dblpParser d = dblpParser.getSingletonDblpParser();
		notify();
	}

}
