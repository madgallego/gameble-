package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.StyledEditorKit;
import java.io.FileNotFoundException;
import util.Lottery;

public class CardScreen {
	private JFrame window;
	private String userName;
	private String userLevel;
	private int hints;
	private int drawCount;
	private Lottery game;

	public CardScreen(String Name, String Level) throws FileNotFoundException{
		userName = Name;
		userLevel = Level;
		window = new JFrame();
		game = new Lottery();
		LevelSetter();
		PrintCardUI();





	}// end of constructor

	private void PrintCardUI(){
		window.setTitle("Let's go Game-bling!");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(500,700);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
		window.add(Lottery(), BorderLayout.NORTH);
		window.add(NumberArea(), BorderLayout.CENTER);




		window.setVisible(true); //to show in the screen
	}//end of CardPrint Block

	private void LevelSetter(){
		switch(userLevel){
		case "easy": hints = 2;
					break;
		case "average": hints = 1;
					break;
		case "difficult": hints = 0;
					break;	
}
	}

	private JPanel Lottery(){
		JPanel roll = new JPanel();
		roll.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		roll.setBackground(Color.YELLOW);
		
		JLabel result = new JLabel("Roll the Numbers!",SwingConstants.CENTER);
		result.setForeground(Color.BLACK);
		result.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JButton drawLots = new JButton("DRAW");
		drawLots.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		drawLots.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(drawCount<15){
					System.out.println(game.get5DrawnNumbers(drawCount*5));
					result.setText("                  | " + game.get5DrawnNumbers(drawCount*5));
					drawCount++;
				}
				else{
					drawLots.setEnabled(false);
				}
			}	
		});
		
		roll.add(drawLots);
		roll.add(result);
		return roll;
	}// end of lottery function

	private JPanel NumberArea(){
		JPanel box = new JPanel();
		box.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		box.setLayout(new GridLayout( 6, 5, 5, 5));
		for (int i = 0; i < 5; i++) {
			for(int j =0; j<5; j++){
				JButton newPush = createButton( i, j);
				box.add(newPush);
			}
		}

		return box;
	}

	private JButton createButton( int i, int j){
		JButton button = new JButton();
		button.setFocusable(false); //to remove box boarder of text
		button.setToolTipText("Try this button"); //for tip shadow
		button.setFont(new Font("Times New Roman", Font.PLAIN, 24));// changes the button text font
		button.setSize(new Dimension(200,50));
		//button.setMargin(new Insets(10, 10,10,10));// changes the surrounding size of the margin of the font
		if(i==1) {
			
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("Point 2");
				}	
			});
		
		}
		else {
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("Working Button");
					button.setText("boing");
					button.setEnabled(false);
				}
				
				
			});
		}
		
		return button;
	}//end of create button function

	private JLabel headerLetter(String letter){
		JLabel textLabel = new JLabel(letter,SwingConstants.CENTER);
		textLabel.setForeground(Color.BLACK);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		textLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
		
		return textLabel;
	}


}//end of class
