package monte;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JPanel;

public class MonteCarlo extends JPanel{
	Arc2D.Double arc;
	public double radius=4;
	
	public MonteCarlo(){
		arc = new Arc2D.Double(0,0,getRadius()/2,getRadius()/2,0,90,Arc2D.PIE);
	}
	public MonteCarlo(double radius){
//		setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		setBackground(Color.BLUE);
		this.radius = radius;
		arc = new Arc2D.Double(-getRadius(),0,getRadius()*2,getRadius()*2,0,90,Arc2D.PIE);
	}
	@Override
	public java.awt.Dimension getPreferredSize() {
		return new Dimension((int)getRadius(),(int)getRadius());
	};
public double getPie() {
	Graphics2D g = (Graphics2D)getGraphics();
	g.setColor(Color.WHITE);
		double [] areas = new double [100];
		for(int i=0;i<100;i++){
			int counter = 0;
			for(int j=0;j<1000;j++){
				int randomX = new Random().nextInt((int)getRadius());
				int randomY = new Random().nextInt((int)getRadius());
				g.fill(new Ellipse2D.Double(randomX, randomY, 1, 1));
				if(arc.contains(new Point(randomX,randomY))){
					counter++;
					System.out.println("IN");
				}else
					System.out.println("OUT");
				
				
//				repaint();
				
				
			}
			areas[i] = counter*getRadius()*getRadius()/1000;
		}
		double totalArea = 0;
		for(int i=0;i<100;i++)
			totalArea += areas[i];
		totalArea = totalArea/100;
		double pie = totalArea*4/(getRadius()*getRadius());
		return pie;
		
	}
	
	public double getRadius(){
		return radius*100;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
//	@Override
//	public void paint(Graphics arg0) {
//		// TODO Auto-generated method stub
//		super.paint(arg0);
//		
//		
//	}
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		Graphics2D g = (Graphics2D)arg0;
		g.setColor(Color.RED);
		g.fill(arc);
		setOpaque(false);
		g.dispose();
	}
	
	
	
	

}
