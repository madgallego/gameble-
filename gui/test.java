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
import javax.swing.plaf.basic.BasicBorders;

public class test {
    private JFrame window;
    private int count = 3;

	
	public test()
	{
		show();
        window.add(playButton(), BorderLayout.SOUTH);
	}

    private JButton PlayButton(){
        JButton button = new JButton("PLAY!");
		button.setFocusable(false); //to remove box boarder of text
		button.setToolTipText("Try this button"); //for tip shadow
		button.setFont(new Font("Times New Roman", Font.PLAIN, 24));// changes the button text font
		button.setSize(new Dimension(200,50));
		//button.setMargin(new Insets(10, 10,10,10));// changes the surrounding size of the margin of the font
			
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					window.remove(window);
				}
            });
        return button;
    }
	private void show()
	{
		window = new JFrame();
		window.setTitle("Screen 1");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(500,700);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
		JPanel panel = new JPanel ();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel.setBackground(Color.YELLOW);

		panel.add(createButton("Print", 2));



		JPanel panel2 = new JPanel ();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panel2.setBackground(Color.RED);
		panel2.setLayout(new GridLayout( 6, 5, 5, 5)); 

		panel2.add(headerLetter("B"));
		panel2.add(headerLetter("I"));
		panel2.add(headerLetter("N"));
		panel2.add(headerLetter("G"));
		panel2.add(headerLetter("O"));
		window.add(panel,BorderLayout.NORTH);


		for (int i = 0; i < 25; i++) {
			JButton newPush = createButton("Button", i);
			panel2.add(newPush);
		}
		window.add(panel2);

		window.setVisible(true);

	}

	private JButton createButton(String buttonName, int i){
		JButton button = new JButton(buttonName +" "+ i);
		button.setFocusable(false); //to remove box boarder of text
		button.setToolTipText("Try this button"); //for tip shadow
		button.setFont(new Font("Times New Roman", Font.PLAIN, 24));// changes the button text font
		button.setSize(new Dimension(200,50));
		//button.setMargin(new Insets(10, 10,10,10));// changes the surrounding size of the margin of the font              
                
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(count>0){
                    System.out.println("Point 2");
                    button.setText("boing");
                    button.setEnabled(false);
                    count--;
                }
                if(count==0){
                    window.remove();
                }
            }	
        });

		return button;
	}

	private JLabel headerLetter(String letter){
		JLabel textLabel = new JLabel(letter,SwingConstants.CENTER);
		textLabel.setForeground(Color.BLACK);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		textLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
		
		return textLabel;
	}

}
