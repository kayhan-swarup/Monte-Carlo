package monte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
	
	static NumberFormat formatter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			formatter= new DecimalFormat("#0.00000");
			JFrame frame = new JFrame("Monte Carlo");
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 90);
			JTextField t = new JTextField();JButton start = new JButton("Start");
			t.setBounds(10,10,200,30);start.setBounds(230,10,100,30);
			frame.setLayout(null);
			
			start.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					double radius = Double.parseDouble(t.getText());
					frame.setVisible(false);
					JFrame f = new JFrame();
					JButton btn= new JButton();
					JLabel label = new JLabel();
					MonteCarlo m  = new MonteCarlo(radius);
					btn.setBounds(0,(int)m.getRadius(),100,50);btn.setText("Go Monte!");
					label.setBounds((int)m.getRadius()-100,(int)m.getRadius(),100,30);
					btn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							double pie = m.getPie();
							label.setText("Pie = "+formatter.format(pie));
							System.out.println("Pie: "+formatter.format(pie));
						}
					});
					f.setLayout(null);
					f.setVisible(true);
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(m.getPreferredSize().width+20, m.getPreferredSize().height+100);
					
					m.setBounds(0,0,(int)m.getRadius(),(int)m.getRadius());
					f.add(m);
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					
					f.add(btn);
					f.add(label);
					
				}
			});
			frame.add(t);frame.add(start);
//			frame.pack();
//			f.setSize(m.getWidth()+50, m.getHeight()+btn.getHeight()+50);
//			f.pack();
		}

}
