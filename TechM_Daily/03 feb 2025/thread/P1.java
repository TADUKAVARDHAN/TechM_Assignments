package threads;

public class P1 extends Thread {
	  @Override
	  public void run() {
	    System.out.println("Hello, World!");
	  }

	  public static void main(String[] args) {
	    P1 thread = new P1();
	    thread.start();
	  }
	}
