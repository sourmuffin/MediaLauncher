package launcher;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LauncherFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5421333944892322866L;
	String frameName;
	String website = null;
	String searchSite = null;
	Boolean browser1 = false;
	Boolean browser2 = false;
	Boolean browser3 = false;
	Boolean browser4 = false;
	Boolean browser5 = false;
	
	public LauncherFrame() {
		createMenu();
	}
	

	
	public JPanel createMenu() {
	
		String artistNames = "Search an artist on Website";
		JTextField artists = new JTextField(artistNames);
		//JPanel holdArtists = new JPanel(new BorderLayout());
		
		JPanel holdAll = new JPanel(new BorderLayout());
		JPanel topRow = new JPanel();
		
		topRow.setLayout(new FlowLayout());
		
		JButton top1 = new JButton("Youtube");
		JButton top2 = new JButton("SoundCloud");
		JButton top3 = new JButton("Spotify");
		JButton top4 = new JButton("Netflix");
		JButton top5 = new JButton("PrimeVideo");
		
		top1.setEnabled(false);
		top2.setEnabled(false);
		top3.setEnabled(false);
		
		
		
		topRow.add(top1);
		topRow.add(top2);
		topRow.add(top3);
		topRow.add(top4);
		topRow.add(top5);		
						
		
		
		artists.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                artists.setText("");
                top1.setEnabled(true);
        		top2.setEnabled(true);
        		top3.setEnabled(true);
            }
        });

		artists.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  
				if(browser1 == true || browser2 == true || browser3 == true) {  
				searchSite = website + artists.getText();
			    openWebpage(searchSite);
				}	
				
			  } 
			} );
	
		top1.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  
			website = "https://www.youtube.com/results?search_query=";
			browser1 = true;
			browser2 = false;
			browser3 = false;
			browser4 = false;
			browser5 = false;
			
			if (artists.getText() != "" || artists.getText() != "Search an artist on Website") {
				
				searchSite = website + artists.getText();
			    openWebpage(searchSite);
				
			}
		  } 
		} );
		top2.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				website = "https://soundcloud.com/search?q=";
				browser1 = false;
				browser2 = true;
				browser3 = false;
				browser4 = false;
				browser5 = false;
			   // openWebpage(website);
				if (artists.getText() != "" || artists.getText() != "Search an artist on Website") {
					
					searchSite = website + artists.getText();
				    openWebpage(searchSite);
					
				}
			  } 
			} );
		top3.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				website = "https://open.spotify.com/search/";
				browser1 = false;
				browser2 = false;
				browser3 = true;
				browser4 = false;
				browser5 = false;
			    //openWebpage(website);
				if (artists.getText() != "" || artists.getText() != "Search an artist on Website") {
					
					searchSite = website + artists.getText();
				    openWebpage(searchSite);
					
				}
			  } 
			} );
		top4.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  website = "https://www.netflix.com/browse";
				  browser1 = false;
				  browser2 = false;
				  browser3 = false;
				  browser4 = true;
				  browser5 = false;
				  openWebpage(website);
			  } 
			} );
		top5.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				website = "https://www.primevideo.com/region/na/ref=av_auth_return_redir";
				 browser1 = false;
				 browser2 = false;
				 browser3 = false;
				 browser4 = false;
				 browser5 = true;
				 openWebpage(website);
			  } 
			} );
	
	
		/********END OF TOP ROW CODE**********************************************************************************************************/
		/********TOP OF LIST BOX**********************************************************************************************************/
		
		
		
		
		
		
		//holdArtists.add(artists, BorderLayout.NORTH);
		
		
	
		
		//holdAll.add(holdArtists, BorderLayout.CENTER);
		holdAll.add(topRow, BorderLayout.SOUTH);
		holdAll.add(artists, BorderLayout.CENTER);
		
		/********END OF ALL CODE**********************************************************************************************************/
			return holdAll;
	}
	
	public static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}