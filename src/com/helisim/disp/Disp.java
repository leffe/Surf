package com.helisim.disp;

	import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.helisim.surf1.Tracer;

	public class Disp extends Canvas{

	    /**
		 * 
		 */
		private static final long serialVersionUID = -6592818051841784042L;
		
		private final Tracer mTracer;

		public Disp(Tracer tracer) {
			mTracer = tracer;
	        setBackground(Color.lightGray);
	        
	        Frame aFrame = new Frame();
	        aFrame.addWindowListener(mListener);
	        
	        aFrame.setSize(1300, 1000);
	        aFrame.setBackground(Color.gray);
	        aFrame.add(this);
	        aFrame.setVisible(true);
	        
	    }


	    @Override
	    public void paint(Graphics g){
	    	System.out.println("paint(...)");
	     
	        g.setColor(Color.blue);
//	        g.drawLine(30, 30, 80, 80);
//	        g.drawRect(20, 150, 100, 100);
//	    //    g.fillRect(20, 150, 100, 100);
//	        g.fillOval(150, 20, 100, 100); 
////	        Image img1 = Toolkit.getDefaultToolkit().getImage("sky.jpg"); 
////	        g.drawImage(img1, 140, 140, this); 
	        
	        g.setColor(Color.red);
	        
//	        g.fillOval(150, 180, 5, 5); 
	        
	        mTracer.go(g);
	        
	    }
	    
	    static WindowListener mListener = new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing?");
				System.exit(0);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		}; 
	    
	}

