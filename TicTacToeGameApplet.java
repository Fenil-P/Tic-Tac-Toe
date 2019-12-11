import java.awt.*;          //Abstract Window Toolkit
import java.awt.event.*;    //Event Handling Such As A Mouse Click
import javax.swing.*;       //Application programming interface which provides Graphical user interface for Java Programs

public class TicTacToeGame implements ActionListener    //Check for mouse click events
{
    /* Instance Variabless */
    private JFrame window = new JFrame ("Tic Tac Toe");     //Output Window for the Program
    Container contentPane = window.getContentPane ();       //Holds the contents of the JFrame

    /* Creating the title */
    private JLabel space1 = new JLabel (" Tic");
    private JLabel space2 = new JLabel (" Tac");
    private JLabel space3 = new JLabel (" Toe");

    private JLabel infoLabel = new JLabel ("Choose Game Mode"); //Label whose turn it is

    private JButton option1 = new JButton ("Play PVP");     //Button to Choose PvP Game Mode
    private JButton option2 = new JButton ("Play AI");      //Button to Choose AI Game Mode

    /*  Tic Tac Toe Game Buttons  */
    private JButton button1 = new JButton ("");
    private JButton button2 = new JButton ("");
    private JButton button3 = new JButton ("");
    private JButton button4 = new JButton ("");
    private JButton button5 = new JButton ("");
    private JButton button6 = new JButton ("");
    private JButton button7 = new JButton ("");
    private JButton button8 = new JButton ("");
    private JButton button9 = new JButton ("");

    private String letter = "";         //Label for the Buttons
    private int count = 0;              //Counter For Turns
    private boolean win = false;        //Check to see if someone won
    private boolean click = false;      //used to access an if statement code
    private boolean click2 = false;     //used to access an if statement code
    private int random = 0;             //Random Move for AI
    private boolean move = false;       //Check fo AI Move Completion
    private int animationCount = 0;
    int R = (int) (Math.random () * 256);
    int G = (int) (Math.random () * 256);
    int B = (int) (Math.random () * 256);
    Color color1 = new Color (R, G, B);
    Color color2 = new Color (R, G, B);
    Color color3 = new Color (R, G, B);
    public TicTacToeGame ()  //creates a Constructor (which are used to create objects)
    {
	/* Create Window */
	window.setSize (600, 750);
	window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	contentPane.setBackground (Color.white);                    //Set Background
	contentPane.setLayout (new GridLayout (5, 3, 5, 5));
	//GridLayout (rows, columns, space between rows, space between columns);

	/*  Add Title And Info Labels  */
	contentPane.add (space1);
	contentPane.add (space2);
	contentPane.add (space3);

	/*  Change Button Colors  */
	button1.setBackground (Color.black);
	button2.setBackground (Color.black);
	button3.setBackground (Color.black);
	button4.setBackground (Color.black);
	button5.setBackground (Color.black);
	button6.setBackground (Color.black);
	button7.setBackground (Color.black);
	button8.setBackground (Color.black);
	button9.setBackground (Color.black);
	option1.setBackground (Color.gray);
	option2.setBackground (Color.gray);

	/* Add Buttons To The Window */
	contentPane.add (option1);
	contentPane.add (infoLabel);
	contentPane.add (option2);
	contentPane.add (button1);
	contentPane.add (button2);
	contentPane.add (button3);
	contentPane.add (button4);
	contentPane.add (button5);
	contentPane.add (button6);
	contentPane.add (button7);
	contentPane.add (button8);
	contentPane.add (button9);


	/*  Change Font of Button and Label Text    */
	space1.setFont (new Font ("Segoe Script", Font.BOLD, 75));
	space2.setFont (new Font ("Segoe Script", Font.BOLD, 75));
	space3.setFont (new Font ("Segoe Script", Font.BOLD, 75));
	button1.setFont (new Font ("Dialog", Font.BOLD, 80));
	button2.setFont (new Font ("Dialog", Font.BOLD, 80));
	button3.setFont (new Font ("Dialog", Font.BOLD, 80));
	button4.setFont (new Font ("Dialog", Font.BOLD, 80));
	button5.setFont (new Font ("Dialog", Font.BOLD, 80));
	button6.setFont (new Font ("Dialog", Font.BOLD, 80));
	button7.setFont (new Font ("Dialog", Font.BOLD, 80));
	button8.setFont (new Font ("Dialog", Font.BOLD, 80));
	button9.setFont (new Font ("Dialog", Font.BOLD, 80));
	option1.setFont (new Font ("Dialog", Font.BOLD, 20));
	option2.setFont (new Font ("Dialog", Font.BOLD, 20));
	infoLabel.setFont (new Font ("Dialog", Font.BOLD, 19));

	/* Add The Action Listener To The Buttons */
	button1.addActionListener (this);
	button2.addActionListener (this);
	button3.addActionListener (this);
	button4.addActionListener (this);
	button5.addActionListener (this);
	button6.addActionListener (this);
	button7.addActionListener (this);
	button8.addActionListener (this);
	button9.addActionListener (this);
	option1.addActionListener (this);
	option2.addActionListener (this);

	/* Make Window Visible */
	window.setVisible (true);
	while (click == false && click2 == false)
	{
	    if (animationCount % 180000 == 0)
	    {
		R = (int) (Math.random () * 255) + 1;
		G = (int) (Math.random () * 255) + 1;
		B = (int) (Math.random () * 255) + 1;
		color1 = new Color (R, G, B);
		R = (int) (Math.random () * 255) + 1;
		G = (int) (Math.random () * 255) + 1;
		B = (int) (Math.random () * 255) + 1;
		color2 = new Color (R, G, B);
		R = (int) (Math.random () * 255) + 1;
		G = (int) (Math.random () * 255) + 1;
		B = (int) (Math.random () * 255) + 1;
		color3 = new Color (R, G, B);
	    }
	    if (animationCount <= 300000)
		space1.setText ("");
	    else
	    {
		space1.setText (" Tic");
		space1.setForeground (color1);
	    }
	    if (animationCount <= 600000)
		space2.setText ("");
	    else
	    {
		space2.setText (" Tac");
		space2.setForeground (color2);
	    }
	    if (animationCount <= 900000)
		space3.setText ("");
	    else
	    {
		space3.setText (" Toe");
		space3.setForeground (color3);
	    }
	    if (animationCount == 1050000)
		animationCount = 1;
	    animationCount++;
	}
	space1.setText (" Tic");
	space1.setForeground (Color.black);
	space2.setText (" Tac");
	space2.setForeground (Color.black);
	space3.setText (" Toe");
	space3.setForeground (Color.black);
    }


    public void actionPerformed (ActionEvent e)  //Infinite loop that checks if a button is pressed
    {
	/* Calculate Who's Turn It Is*/
	if (count % 2 == 1)
	    letter = "X";
	else if (count % 2 == 0)
	    letter = "O";


	UIManager.put ("Button.disabledText", Color.white);


	if (e.getSource () == option1 || click == true) //Player vs Player
	{
	    //e.getSource() checks if a button was clicked

	    option1.setEnabled (false);
	    option2.setEnabled (false);
	    click = true;       //Makes Sure this code runs without having to press PVP button over and over again

	    if (count < 9)
		infoLabel.setText ("       Turn: Player " + (count % 2 + 1));   //Displays whose turn it is


	    /* Display X's or O's on the buttons */
	    if (e.getSource () == button1)
	    {
		button1.setText (letter);
		button1.setEnabled (false);
	    }
	    else if (e.getSource () == button2)
	    {
		button2.setText (letter);
		button2.setEnabled (false);
	    }
	    else if (e.getSource () == button3)
	    {
		button3.setText (letter);
		button3.setEnabled (false);
	    }
	    else if (e.getSource () == button4)
	    {
		button4.setText (letter);
		button4.setEnabled (false);
	    }
	    else if (e.getSource () == button5)
	    {
		button5.setText (letter);
		button5.setEnabled (false);
	    }
	    else if (e.getSource () == button6)
	    {
		button6.setText (letter);
		button6.setEnabled (false);
	    }
	    else if (e.getSource () == button7)
	    {
		button7.setText (letter);
		button7.setEnabled (false);
	    }
	    else if (e.getSource () == button8)
	    {
		button8.setText (letter);
		button8.setEnabled (false);
	    }
	    else if (e.getSource () == button9)
	    {
		button9.setText (letter);
		button9.setEnabled (false);
	    }

	    /* Determines who won */

	    // Horizontal Wins
	    if (button1.getText () == button2.getText () && button2.getText () == button3.getText () && button1.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button1.setEnabled (true);
		button1.setEnabled (false);
		button2.setEnabled (true);
		button2.setEnabled (false);
		button3.setEnabled (true);
		button3.setEnabled (false);
	    }
	    else if (button4.getText () == button5.getText () && button5.getText () == button6.getText () && button4.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button4.setEnabled (true);
		button4.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button6.setEnabled (true);
		button6.setEnabled (false);
	    }
	    else if (button7.getText () == button8.getText () && button8.getText () == button9.getText () && button7.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button7.setEnabled (true);
		button7.setEnabled (false);
		button8.setEnabled (true);
		button8.setEnabled (false);
		button9.setEnabled (true);
		button9.setEnabled (false);
	    }

	    /* Vertical Wins */
	    else if (button1.getText () == button4.getText () && button4.getText () == button7.getText () && button1.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button1.setEnabled (true);
		button1.setEnabled (false);
		button4.setEnabled (true);
		button4.setEnabled (false);
		button7.setEnabled (true);
		button7.setEnabled (false);
	    }
	    else if (button2.getText () == button5.getText () && button5.getText () == button8.getText () && button2.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button2.setEnabled (true);
		button2.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button8.setEnabled (true);
		button8.setEnabled (false);
	    }
	    else if (button3.getText () == button6.getText () && button6.getText () == button9.getText () && button3.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button3.setEnabled (true);
		button3.setEnabled (false);
		button6.setEnabled (true);
		button6.setEnabled (false);
		button9.setEnabled (true);
		button9.setEnabled (false);
	    }

	    /* Diagonal Wins */
	    else if (button1.getText () == button5.getText () && button5.getText () == button9.getText () && button1.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button1.setEnabled (true);
		button1.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button9.setEnabled (true);
		button9.setEnabled (false);
	    }
	    else if (button3.getText () == button5.getText () && button5.getText () == button7.getText () && button3.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.cyan);
		button3.setEnabled (true);
		button3.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button7.setEnabled (true);
		button7.setEnabled (false);
	    }
	    else
		win = false;

	    /* Show a Dialof If Someone Wins Or The Game Is Tie */
	    if (win == true)
		JOptionPane.showMessageDialog (null, letter + " WINS!");
	    else if (count >= 9 && win == false)
		JOptionPane.showMessageDialog (null, "Tie Game!");

	    count++;
	} //Only this part is executed if PVP Button is Pressed

	else if (e.getSource () == option2 || click2 == true) //Player Vs AI
	{
	    option1.setEnabled (false);
	    option2.setEnabled (false);



	    click2 = true;      //Makes Sure this code runs without having to press AI button over and over again



	    if (letter.equals ("X"))    //X is the Player
	    {

		/* Display X's on the buttons */
		if (e.getSource () == button1)
		{
		    button1.setText (letter);
		    button1.setEnabled (false);
		}
		else if (e.getSource () == button2)
		{
		    button2.setText (letter);
		    button2.setEnabled (false);
		}
		else if (e.getSource () == button3)
		{
		    button3.setText (letter);
		    button3.setEnabled (false);
		}
		else if (e.getSource () == button4)
		{
		    button4.setText (letter);
		    button4.setEnabled (false);
		}
		else if (e.getSource () == button5)
		{
		    button5.setText (letter);
		    button5.setEnabled (false);

		}
		else if (e.getSource () == button6)
		{
		    button6.setText (letter);
		    button6.setEnabled (false);
		}
		else if (e.getSource () == button7)
		{
		    button7.setText (letter);
		    button7.setEnabled (false);
		}
		else if (e.getSource () == button8)
		{
		    button8.setText (letter);
		    button8.setEnabled (false);
		}
		else if (e.getSource () == button9)
		{
		    button9.setText (letter);
		    button9.setEnabled (false);
		}
		count++;
	    }

	    /* Determines who won */
	    // Horizontal Wins
	    if (button1.getText () == button2.getText () && button2.getText () == button3.getText () && button1.getText () != "")
		win = true;
	    else if (button4.getText () == button5.getText () && button5.getText () == button6.getText () && button4.getText () != "")
		win = true;
	    else if (button7.getText () == button8.getText () && button8.getText () == button9.getText () && button7.getText () != "")
		win = true;


	    /* Vertical Wins */
	    else if (button1.getText () == button4.getText () && button4.getText () == button7.getText () && button1.getText () != "")
		win = true;
	    else if (button2.getText () == button5.getText () && button5.getText () == button8.getText () && button2.getText () != "")
		win = true;
	    else if (button3.getText () == button6.getText () && button6.getText () == button9.getText () && button3.getText () != "")
		win = true;


	    /* Diagonal Wins */
	    else if (button1.getText () == button5.getText () && button5.getText () == button9.getText () && button1.getText () != "")
		win = true;
	    else if (button3.getText () == button5.getText () && button5.getText () == button7.getText () && button3.getText () != "")
		win = true;
	    else
		win = false;

	    /* Show a Dialof If Someone Wins Or The Game Is Tie */
	    if (win == true)
	    {
		JOptionPane.showMessageDialog (null, letter + " WINS!");
		System.exit (-1);
	    }
	    else if (count >= 9 && win == false)
	    {
		JOptionPane.showMessageDialog (null, "Tie Game!");
		System.exit (-1);
	    }

	    if (count % 2 == 1)
		letter = "X";
	    else if (count % 2 == 0)
		letter = "O";


	    if (letter.equals ("O"))    //O is AI
	    {
		infoLabel.setText ("        Good Luck!  ");

		while (move == false)   //Loop runs until a valid move is made
		{
		    if (button5.isEnabled ())
			random = 5;
		    else if ((button1.getText () == "X" && button2.getText () == "X") || (button2.getText () == "X" && button3.getText () == "X") || (button1.getText () == "X" && button3.getText () == "X"))
		    {
			if (button1.isEnabled ())
			    random = 1;
			else if (button2.isEnabled ())
			    random = 2;
			else if (button3.isEnabled ())
			    random = 3;
			else
			    random = (int) (Math.random () * 9 + 1);
		    }
		    else if ((button7.getText () == "X" && button8.getText () == "X") || (button8.getText () == "X" && button9.getText () == "X") || (button7.getText () == "X" && button9.getText () == "X"))
		    {
			if (button7.isEnabled ())
			    random = 7;
			else if (button8.isEnabled ())
			    random = 8;
			else if (button9.isEnabled ())
			    random = 9;
			else
			    random = (int) (Math.random () * 9 + 1);
		    }
		    else if ((button1.getText () == "X" && button4.getText () == "X") || (button4.getText () == "X" && button7.getText () == "X") || (button7.getText () == "X" && button1.getText () == "X"))
		    {
			if (button1.isEnabled ())
			    random = 1;
			else if (button4.isEnabled ())
			    random = 4;
			else if (button7.isEnabled ())
			    random = 7;
			else
			    random = (int) (Math.random () * 9 + 1);
		    }
		    else if ((button3.getText () == "X" && button6.getText () == "X") || (button6.getText () == "X" && button9.getText () == "X") || (button3.getText () == "X" && button9.getText () == "X"))
		    {
			if (button3.isEnabled ())
			    random = 3;
			else if (button6.isEnabled ())
			    random = 6;
			else if (button9.isEnabled ())
			    random = 9;
			else
			    random = (int) (Math.random () * 9 + 1);

		    }
		    else
			random = (int) (Math.random () * 9 + 1);

		    //   random = (int) (Math.random () * 9 + 1); //Random Number from 1-9

		    if (random == 1 && button1.isEnabled ()) //Checks if the random number is 1 and if the button is enables
		    {
			button1.setText (letter);
			button1.setEnabled (false);
			move = true;    //If both conditions are true, then the move is executed and the loop will stop
		    }
		    else if (random == 2 && button2.isEnabled ())   //same as the first if statement
		    {
			button2.setText (letter);
			button2.setEnabled (false);
			move = true;
		    }
		    else if (random == 3 && button3.isEnabled ())
		    {
			button3.setText (letter);
			button3.setEnabled (false);
			move = true;
		    }
		    else if (random == 4 && button4.isEnabled ())
		    {
			button4.setText (letter);
			button4.setEnabled (false);
			move = true;
		    }
		    else if (random == 5 && button5.isEnabled ())
		    {
			button5.setText (letter);
			button5.setEnabled (false);
			move = true;
		    }
		    else if (random == 6 && button6.isEnabled ())
		    {
			button6.setText (letter);
			button6.setEnabled (false);
			move = true;
		    }
		    else if (random == 7 && button7.isEnabled ())
		    {
			button7.setText (letter);
			button7.setEnabled (false);
			move = true;
		    }
		    else if (random == 8 && button8.isEnabled ())
		    {
			button8.setText (letter);
			button8.setEnabled (false);
			move = true;
		    }
		    else if (random == 9 && button9.isEnabled ())
		    {
			button9.setText (letter);
			button9.setEnabled (false);
			move = true;
		    }
		}

		move = false; //move is set to false so the while loop can run if it is the next turn
	    }


	    /* Determines who won */

	    // Horizontal Wins
	    if (button1.getText () == button2.getText () && button2.getText () == button3.getText () && button1.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button1.setEnabled (true);
		button1.setEnabled (false);
		button2.setEnabled (true);
		button2.setEnabled (false);
		button3.setEnabled (true);
		button3.setEnabled (false);
	    }
	    else if (button4.getText () == button5.getText () && button5.getText () == button6.getText () && button4.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button4.setEnabled (true);
		button4.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button6.setEnabled (true);
		button6.setEnabled (false);
	    }
	    else if (button7.getText () == button8.getText () && button8.getText () == button9.getText () && button7.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button7.setEnabled (true);
		button7.setEnabled (false);
		button8.setEnabled (true);
		button8.setEnabled (false);
		button9.setEnabled (true);
		button9.setEnabled (false);
	    }

	    /* Vertical Wins */
	    else if (button1.getText () == button4.getText () && button4.getText () == button7.getText () && button1.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button1.setEnabled (true);
		button1.setEnabled (false);
		button4.setEnabled (true);
		button4.setEnabled (false);
		button7.setEnabled (true);
		button7.setEnabled (false);

	    }
	    else if (button2.getText () == button5.getText () && button5.getText () == button8.getText () && button2.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button2.setEnabled (true);
		button2.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button8.setEnabled (true);
		button8.setEnabled (false);
	    }
	    else if (button3.getText () == button6.getText () && button6.getText () == button9.getText () && button3.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button3.setEnabled (true);
		button3.setEnabled (false);
		button6.setEnabled (true);
		button6.setEnabled (false);
		button9.setEnabled (true);
		button9.setEnabled (false);
	    }

	    /* Diagonal Wins */
	    else if (button1.getText () == button5.getText () && button5.getText () == button9.getText () && button1.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button1.setEnabled (true);
		button1.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button9.setEnabled (true);
		button9.setEnabled (false);
	    }
	    else if (button3.getText () == button5.getText () && button5.getText () == button7.getText () && button3.getText () != "")
	    {
		win = true;
		UIManager.put ("Button.disabledText", Color.red);
		button3.setEnabled (true);
		button3.setEnabled (false);
		button5.setEnabled (true);
		button5.setEnabled (false);
		button7.setEnabled (true);
		button7.setEnabled (false);
	    }
	    else
		win = false;


	    /* Show a Dialof If Someone Wins Or The Game Is Tie */
	    if (win == true)
	    {
		JOptionPane.showMessageDialog (null, letter + " WINS!");
		System.exit (-1);
	    }
	    else if (count >= 8 && win == false)
		JOptionPane.showMessageDialog (null, "Tie Game!");

	    count++;
	}

    }


    public static void main (String[] args)
    {
	new TicTacToeGame ();  //declares the constructor and runs the method

    }
}


