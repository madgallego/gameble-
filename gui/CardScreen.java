package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;


public class CardScreen {
	private JFrame window;

	public CardScreen(){
		window = new JFrame();
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

	private JPanel Lottery(){
		JPanel roll = new JPanel();
		roll.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		roll.setBackground(Color.YELLOW);
		roll.add(createButton("Print", 2));


		return roll;
	}// end of lottery function

	private JPanel NumberArea(){
		JPanel box = new JPanel();
		box.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		box.setLayout(new GridLayout( 6, 5, 5, 5));
		for (int i = 0; i < 25; i++) {
			JButton newPush = createButton("Button", i);
			box.add(newPush);
		}

		return box;
	}

	private JButton createButton(String buttonName, int i){
		JButton button = new JButton(buttonName +" "+ i);
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

}//end of class
