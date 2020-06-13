package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;

import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GUI {

	private static JFrame frmXianXiaGame;
	private static JTextField textField;
	private static JTextArea textArea;
	private static int screenHeight;
	private static int screenWidth;
	private static String input = "";
    private static boolean inputEntered;
	private static int txtSDown = 1000;
	private static int txtSUp = 1000;
    private ActionListener listener = new ActionListener() {
    	public void actionPerformed(ActionEvent evt) {
    		input = textField.getText().trim();
    		inputEntered = true;
    		textField.setText("\n");
    		textArea.append(input);
    		textArea.append("\n\n");
    	};};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = (int)screenSize.getHeight();
		screenWidth = (int)screenSize.getWidth();
		new GUI();
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmXianXiaGame = new JFrame();
		frmXianXiaGame.setTitle("Xian Xia Game");
		frmXianXiaGame.setBounds(screenWidth/8, screenHeight/8, screenWidth/2, screenHeight/2);
		frmXianXiaGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel text = new JPanel();
		text.setBorder(new EmptyBorder(1, 1, 1, 1));
		frmXianXiaGame.getContentPane().add(text, BorderLayout.CENTER);
		text.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		text.add(scrollPane, BorderLayout.CENTER);
		
		JPanel stats = new JPanel();
		frmXianXiaGame.getContentPane().add(stats, BorderLayout.WEST);
		stats.setBorder(new EmptyBorder(1, 1, 1, 1));
		stats.setLayout(new BorderLayout(0, 0));
		
		JTextPane statsPane = new JTextPane();
		statsPane.setEditable(false);
		statsPane.setBorder(new EmptyBorder(1,50,1,50));
		stats.add(statsPane, BorderLayout.CENTER);
		
		JPanel response = new JPanel();
		response.setBorder(new EmptyBorder(1, 1, 1, 1));
		frmXianXiaGame.getContentPane().add(response, BorderLayout.SOUTH);
		response.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		response.add(textField);
		textField.setColumns(10);
		textField.addActionListener(listener);
		
		JPanel pic = new GraphicsUser();
		pic.setBorder(new EmptyBorder(5, 30, 5, 125));
		frmXianXiaGame.getContentPane().add(pic, BorderLayout.EAST);
		pic.setLayout(new BorderLayout(0, 0));
		
		frmXianXiaGame.setVisible(true);
	}
	public static void prinTF(String text)
    {
        textArea.append(" "+text+"\n");
        try {Thread.sleep(1000*txtSDown/txtSUp);} catch(InterruptedException ex) {
        Thread.currentThread().interrupt();}
        try {
                textArea.setCaretPosition(textArea.getLineStartOffset(textArea.getLineCount() - 1));
            } catch (BadLocationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public void actionPerformed(ActionEvent e) 
    {
            JTextField inputField = (JTextField)e.getSource();
            input = new String(inputField.getText());
            inputEntered = true;
            inputField.setText("\n");
    }
    public static String getInput() throws InterruptedException {
        while (inputEntered == false) {
            Thread.sleep(100);
        }
        String userInput = input;
        input = "";
        inputEntered = false;
        textField.setText("\n");
        return userInput;
    }
}
