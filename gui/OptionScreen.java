package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OptionScreen {
    private JFrame window;
    private String name;
    private String level;
    public OptionScreen(){
        window = new JFrame();
		//frame properties
		window.setLayout(new BorderLayout(0,0));
		window.setTitle("Game-bling! BINGO++");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(400,400);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
		//panels
		window.add(UserInfo(), BorderLayout.NORTH);
		window.add(filler("       "), BorderLayout.EAST);
		window.add(filler("       "), BorderLayout.WEST);
		window.add(filler("       "), BorderLayout.SOUTH);
		window.add(OptionButtons(), BorderLayout.CENTER);

		window.setVisible(true);
    }

    private JPanel UserInfo(){
        JPanel info = new JPanel();
        JLabel textLabel = new JLabel("Username: ",SwingConstants.CENTER);
		textLabel.setForeground(Color.BLACK);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField userIN = new JTextField(10);
        userIN.setForeground(Color.BLACK);
        userIN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        userIN.setToolTipText("Click Enter When Done (MAX 10 CHARACTERS)");
        userIN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = userIN.getText();
				System.out.println(name);
			}	
		});
        
        info.add(textLabel);
        info.add(userIN);
        
        return info;
    }

    private JPanel OptionButtons(){
        JPanel options = new JPanel();
		options.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		options.setLayout(new GridLayout( 4, 1, 200,2));
		
        
		JButton easy = new JButton("Easy");
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				level = "easy";
				System.out.println("Point 2");
				OptionScreen UserUX = new OptionScreen();
				window.dispose();
			}	
		});

        JButton average = new JButton("Average");
		average.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                level = "average";
				System.out.println("Point 2");
				OptionScreen UserUX = new OptionScreen();
				window.dispose();
			}	
		});

        JButton difficult = new JButton("Difficult");
		difficult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				level = "difficult";
				System.out.println("Point 2");
				OptionScreen UserUX = new OptionScreen();
				window.dispose();
			}	
		});

        options.add(filler("Choose your Level"));
		options.add(easy);
        options.add(average);
        options.add(difficult);
		

        return options;
    }

    private JLabel filler(String text){
		JLabel textLabel = new JLabel(text,SwingConstants.CENTER);
		textLabel.setForeground(Color.BLACK);
		textLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
		
		return textLabel;
	}

}
