// The "Tic_Tac_Toe_Game" class.
import java.awt.*;
import hsa.Console;

public class Tic_Tac_Toe_Game
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	
	int positions[][]=new int[3][3];

	c.setColor (Color.black);
	c.drawRect (120, 45, 420, 420);
	c.setColor (Color.cyan);
	c.fillRect (121, 46, 419, 419);
	c.setColor (Color.black);
	lineThickener (260, 45, 260, 465, 2);
	lineThickener (400, 45, 400, 465, 2);
	lineThickener (120, 185, 540, 185, 1);
	lineThickener (120, 325, 540, 325, 1);
	/*circleThickener (20, 20, 80, 80);
	circleThickener (125, 125, 80, 80);
	circleThickener (225, 125, 80, 80);
	circleThickener (225, 225, 80, 80);*/
	drawX (135, 25, 195, 85);
	drawX (235, 25, 295, 85);
	drawX (35, 125, 95, 185);
	drawX (135, 225, 195, 285);
	drawX (35, 225, 95, 285);


	// Place your program here.  'c' is the output console
    } // main method


    //if(position[i][i]=1)(
    //drawX()
    //)
    public static void lineThickener (int x1, int y1, int x2, int y2, int direction)
    {

	if (direction == 1) //horizontal and diagonal lines
	{
	    for (int i = 0 ; i < 15 ; i++)
		c.drawLine (x1, y1 + i, x2, y2 + i);
	}
	if (direction == 2) //vertical
	{
	    for (int i = 0 ; i < 15 ; i++)
		c.drawLine (x1 + i, y1, x2 + i, y2);
	}
    }


    public static void circleThickener (int x, int y, int width, int length)
    {
	c.setColor (Color.black);
	c.fillOval (x, y, width, length);
	c.setColor (Color.cyan);
	c.fillOval (x + 20, y + 20, width - 40, length - 40);
    }


    public static void drawX (int x1, int y1, int x2, int y2)
    {
	c.setColor (Color.black);
	lineThickener (x1, y1, x2, y2, 1);
	lineThickener (x1, y1 + 6, x2, y2 + 6, 1);
	lineThickener (x1, y2, x2, y1, 1);
	lineThickener (x1, y2 + 6, x2, y1 + 6, 1);
    }



} // Tic_Tac_Toe_Game class
