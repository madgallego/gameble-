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

public class menu{
	JFrame window;
	
	public menu() {
		window = new JFrame();
		//frame properties
		window.setLayout(new BorderLayout(0,0));
		window.setTitle("Game-bling! BINGO++");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(400,400);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
		//panels
		window.add(TitleSpace(), BorderLayout.NORTH);
		window.add(filler("       "), BorderLayout.EAST);
		window.add(filler("       "), BorderLayout.WEST);
		window.add(filler("       "), BorderLayout.SOUTH);
		window.add(MenuButtons(), BorderLayout.CENTER);

		window.setVisible(true);
	}
	
	private JPanel TitleSpace() {
		JPanel title = new JPanel();
		title.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		JLabel textLabel = new JLabel("BINGO++",SwingConstants.CENTER);
		textLabel.setForeground(Color.BLACK);
		textLabel.setFont(new Font("Courier New", Font.PLAIN, 36));
		title.add(textLabel);


		return title;
	}//end of titlespace panel
	
	private JPanel MenuButtons() {
		JPanel menu = new JPanel();
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		menu.setLayout(new GridLayout( 3, 1, 200,2));
		
		menu.add(filler(" "));
		JButton newPush = new JButton("start");
		newPush.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Point 2");
				window.dispose();
			}	
		});
		menu.add(newPush);
		menu.add(filler(" "));

		return menu;
	}//end of titlespace panel

	private JLabel filler(String text){
		JLabel textLabel = new JLabel(text,SwingConstants.CENTER);
		textLabel.setForeground(Color.BLACK);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		textLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
		
		return textLabel;
	}
	
	
}
