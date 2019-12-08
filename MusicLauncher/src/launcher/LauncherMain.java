package launcher;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class LauncherMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//String temp = "";
		
		LauncherFrame ui = new LauncherFrame();
		
		
		
		
		EventQueue.invokeLater(new Runnable() {

			/** Run the Client Window */
			public void run() {

				
				ui.getContentPane().add(ui.createMenu());
				ui.setTitle("MediaLauncher V1");
				ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ui.setSize(new Dimension(505, 115));
				ui.setResizable(true);
				ui.setLocationRelativeTo(null);
				ui.setVisible(true);

			}

		});
		

	}

	
	
}
