import java.lang.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame implements ActionListener, Runnable{
	private JPanel panel;
	private JLabel countLabel;
	private JButton[] b = new JButton[10];
	private JButton retry,exit;
	private static int counter=0;
	private  static int current,timer;
	
	Random colorSelect = new Random();
	Random changeTimer = new Random();

	public MainUI(){
		super("Click Counter");
		this.setSize(650,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		panel =  new JPanel();
		panel.setLayout(null);
		
		countLabel = new JLabel("Score: "+counter);
		countLabel.setBounds(250,25,350,60);
		countLabel.setFont(new Font("Times New Roman",Font.BOLD,26));
		panel.add(countLabel);
		
		b[0] = new JButton("Button 1");
		b[0].setBounds(150,100,120,40);
		b[0].setBackground(Color.RED);
		b[0].addActionListener(this);
		panel.add(b[0]);
		
		b[1] = new JButton("Button 2");
		b[1].setBounds(350,100,120,40);
		b[1].setBackground(Color.RED);
		b[1].addActionListener(this);
		panel.add(b[1]);
		
		b[2] = new JButton("Button 3");
		b[2].setBounds(150,200,120,40);
		b[2].setBackground(Color.RED);
		b[2].addActionListener(this);
		panel.add(b[2]);
		
		b[3] = new JButton("Button 4");
		b[3].setBounds(350,200,120,40);
		b[3].setBackground(Color.RED);
		b[3].addActionListener(this);
		panel.add(b[3]);
		
		b[4] = new JButton("Button 5");
		b[4].setBounds(150,300,120,40);
		b[4].setBackground(Color.RED);
		b[4].addActionListener(this);
		panel.add(b[4]);
		
		b[5] = new JButton("Button 6");
		b[5].setBounds(350,300,120,40);
		b[5].setBackground(Color.RED);
		b[5].addActionListener(this);
		panel.add(b[5]);
		
		b[6] = new JButton("Button 7");
		b[6].setBounds(150,400,120,40);
		b[6].setBackground(Color.RED);
		b[6].addActionListener(this);
		panel.add(b[6]);
		
		b[7] = new JButton("Button 8");
		b[7].setBounds(350,400,120,40);
		b[7].setBackground(Color.RED);
		b[7].addActionListener(this);
		panel.add(b[7]);
		
		b[8] = new JButton("Button 9");
		b[8].setBounds(150,500,120,40);
		b[8].setBackground(Color.RED);
		b[8].addActionListener(this);
		panel.add(b[8]);
		
		b[9] = new JButton("Button 10");
		b[9].setBounds(350,500,120,40);
		b[9].setBackground(Color.RED);
		b[9].addActionListener(this);
		panel.add(b[9]);
		

		
		exit = new JButton("Exit");
		exit.setBounds(150,600,320,40);
		exit.setBackground(Color.WHITE);
		exit.addActionListener(this);
		panel.add(exit);

		//retry = new JButton("Retry");
		//retry.setBounds(80,600,220,40);
		//retry.setBackground(Color.GREEN);
		//retry.addActionListener(this);
		
		this.add(panel);
	}
	

	public void run()
	{
		try{
			while(counter>=0){
				current = colorSelect.nextInt(10);
				timer = 2000+changeTimer.nextInt(5000)/1000;

				b[current].setBackground(Color.GREEN);
				Thread.sleep(timer);
				b[current].setBackground(Color.RED);
			}
			countLabel.setText("You Loose!!");
			for(int i =0;i<10;i++){
				b[i].setEnabled(false);
			}
			//panel.add(retry);
			exit.setBounds(350,600,220,40);

		}
		catch(Exception e){}
	}


	public void actionPerformed(ActionEvent ae)
	{
		String elementText = ae.getActionCommand();
		
		if(elementText.equals(b[current].getText()))
		{
			counter = counter+1;
			countLabel.setText("Score: "+counter);
		}
		else if(elementText.equals(exit.getText()))
		{
			System.exit(0);
		}
		// else if(elementText.equals(retry.getText()))
		// {
		// 	counter = 0;
		// 	MainUI m1 = new MainUI();
		// 	this.setVisible(false);
		// 	m1.setVisible(true);
		// 	m1.run();
		// }
		 else if(!elementText.equals(b[current].getText())){
			counter = counter-1;
			countLabel.setText("Score: "+counter);
		}

	}

}
