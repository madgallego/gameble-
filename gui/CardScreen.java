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
	private int totalScore;
	private int clicker=0;

	public CardScreen(String Name, String Level) throws FileNotFoundException{
		userName = Name;
		userLevel = Level;
		totalScore=30;
		window = new JFrame();
		game = new Lottery();

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
		window.add(GambleArea(), BorderLayout.SOUTH);




		window.setVisible(true); //to show in the screen
	}//end of CardPrint Block

	private void LevelSetter(){
		switch(userLevel){
		case "easy": hints = 3;
					break;
		case "average": hints = 2;
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
					game.visualizer();
					drawCount++;
					if(game.getResult()){
						totalScore=totalScore-2;
					}
					else totalScore--;
				}
				else{
					drawLots.setEnabled(false);
					EndResult gameDone = new EndResult(totalScore);
					window.dispose();

				}
			}	
		});
		
		roll.add(drawLots);
		roll.add(result);
		return roll;
	}// end of lottery function

	private JPanel NumberArea(){
		JPanel box = new JPanel();
		box.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		box.setLayout(new GridLayout( 6, 5, 5, 5));
		
		JLabel B = headerLetter("B");
		box.add(B);
		JLabel I = headerLetter("I");
		box.add(I);
		JLabel N = headerLetter("N");
		box.add(N);
		JLabel G = headerLetter("G");
		box.add(G);
		JLabel O = headerLetter("O");
		box.add(O);

		
		for (int i= 0; i < 5; i++) {
			for(int j=0; j<5; j++){
				if(i==2&&j==2){
					JLabel LOGO = new JLabel("BINGO++",SwingConstants.CENTER);
					LOGO.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					LOGO.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));
					box.add(LOGO);
				}
				else{
					JButton newPush = createButton( i, j);
					box.add(newPush);
				}
			}
		}

		return box;
	}

	private JPanel GambleArea(){
		JPanel select = new JPanel();
		select.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		select.setLayout(new GridLayout( 1, 3, 5, 5));

		JButton submit = new JButton("Submit Card");
		submit.setFocusable(false); //to remove box boarder of text
		submit.setToolTipText("Mark this?"); //for tip shadow
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 24));// changes the button text font
		submit.setSize(new Dimension(200,50));
		//button.setMargin(new Insets(10, 10,10,10));// changes the surrounding size of the margin of the font
	
		submit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {


					
					EndResult gameDone = new EndResult(totalScore);
					window.dispose();
				}	
			});
		
		JButton hint = new JButton("HINT!");
		hint.setFocusable(false); //to remove box boarder of text
		hint.setToolTipText("Select boxes form the Card to reveal (limited)"); //for tip shadow
		hint.setFont(new Font("Times New Roman", Font.PLAIN, 24));// changes the button text font
		hint.setSize(new Dimension(200,50));
		//button.setMargin(new Insets(10, 10,10,10));// changes the surrounding size of the margin of the font
	
		hint.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					LevelSetter();
					hint.setEnabled(false);
				}	
			});

		JButton exit = new JButton("Exit");
		exit.setFocusable(false); //to remove box boarder of text
		exit.setToolTipText("Exit to main menu"); //for tip shadow
		exit.setFont(new Font("Times New Roman", Font.PLAIN, 24));// changes the button text font
		exit.setSize(new Dimension(200,50));
		//button.setMargin(new Insets(10, 10,10,10));// changes the surrounding size of the margin of the font
	
		exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					window.dispose();
					new menu();
				}	
			});

		select.add(submit);
		select.add(hint);
		select.add(exit);
		
		return select;
	}


	private JButton createButton( int i, int j){
		JButton button = new JButton("?");
		button.setFocusable(false); //to remove box boarder of text
		button.setToolTipText("Mark this?"); //for tip shadow
		button.setFont(new Font("Times New Roman", Font.PLAIN, 24));// changes the button text font
		button.setSize(new Dimension(200,50));
		//button.setMargin(new Insets(10, 10,10,10));// changes the surrounding size of the margin of the font
	
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					if(hints>0){
						System.out.println("("+i+","+j+")");
						button.setText(game.getValue(i, j));
						hints--;
					}
					else if (clicker%2==0){ 
						button.setText(" X ");
						++clicker;
					}
					else{
						button.setText(" ? ");
						button.setFont(new Font("Times New Roman", Font.BOLD, 24));
						++clicker;
					}
				}	
			});
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
