package ch12스레드;

import java.awt.Toolkit;

public class BeepThread extends Thread {
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		for( int i = 0 ; i < 5 ; i++) {
			toolkit.beep(); 
			try {Thread.sleep(100);} catch (Exception e) {}
		} 
	}	
}
