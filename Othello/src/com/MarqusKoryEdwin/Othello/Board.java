package com.MarqusKoryEdwin.Othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/*
 * Class board creates and adds and 8 by 8 board to the gui
 */
public class Board {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] boardSquares = new JButton[8][8];
    private JPanel board;
    private static final String COLS = "12345678";

    Board() {
        initializeGui();
    }
    
    /*
     * method initializeGui will print out the 
     * graphic user interface with a board that is 8 by 8
     * and buttons 
     *
     *@param: none
     *@return: none
     * 
     */
    public final void initializeGui() 
    {
        // Buttons 
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);

        JButton newBut = new JButton("New Game");
        tools.add(newBut);
        
        JButton creditsBut = new JButton("Credits");
        tools.add(creditsBut);
        
        JButton quitBut = new JButton("Quit");
        tools.add(quitBut);
        
        
        // Add an ActionListener to the credits button which displays credits
        creditsBut.addActionListener(new ActionListener() 
        		{
        			public void actionPerformed(ActionEvent e) 
        			{
        				JOptionPane.showMessageDialog(gui,
        						"Created By: \nMarqus Pino\nKory Borromeo-Macadangdang\nEdwin Reyes\n\nMusic By:\nMarqus Pino"
        						+ "\n\nThis project was created for a Computer Science III H Final Project.");
        			}
        		} );
        
        // Makes the quit button quit
        quitBut.addActionListener(new ActionListener() 
        		{ 	 
        			public void actionPerformed(ActionEvent e) 
        			{
        				System.exit(0);
        			}
        		} );

        board = new JPanel(new GridLayout(0, 9));	
        gui.add(board);

        // board squares
        Insets buttonMargin = new Insets(5,5,5,5);
        for (int i = 0; i < boardSquares.length; i++) 
        {
            for (int j = 0; j < boardSquares[i].length; j++) 
            {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                
                // goes through boardSquares and make every other square a 
               if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) 
                {
                	ImageIcon icon = new ImageIcon( "E:/Othello/Othello/images/Othello Chip Black.png" );
                    b.setIcon(icon);
                    boardSquares[j][i] = b;
                } 
                else 
                {
                	ImageIcon icon = new ImageIcon( "E:/Othello/Othello/images/Othello Chip White.png" );
                    b.setIcon(icon);
                    boardSquares[j][i] = b;
                }            
 
                // this goes through each button square and goes in between each other to make a white square or gray square
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) 
                {
                    b.setBackground(Color.white);
                } else {
                    b.setBackground(Color.darkGray);
                }
                boardSquares[j][i] = b;
            }
        }

        //fill the board
        board.add(new JLabel(""));
        
        // soon to add letters on the top row
        for (int i = 0; i < 8; i++) 
        {
            board.add(
                    new JLabel(COLS.substring(i, i + 1),
                    SwingConstants.CENTER));
        }
         
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++) 
            {
                switch (j) 
                {
                    case 0:
                        board.add(new JLabel("" + (i + 1),
                                SwingConstants.CENTER));
                    default:
                        board.add(boardSquares[j][i]);
                }
            }
        }
    }
    
    /*
     * gets getBoard gets the 8 by 8 board 
     * @param: none
     * @return: board
     */
    public final JComponent getboard() 
    {
        return board;
    }
    
    /*
     * gets getGui gets the gui
     * @param: none
     * @return: gui
     */
    public final JComponent getGui() 
    {
        return gui;
    }
    
    /*
     * Method main will run the program 
     */
    public static void main(String[] args)
    {
        Runnable r = new Runnable() 
        {

            @Override
            public void run() 
            {
            	
                Board cb =
                        new Board();

                JFrame f = new JFrame("Othello");
                f.setResizable(false);
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}




/*   public void playSound() {
try {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("E:/Othello/Othello Song.mp3").getAbsoluteFile());
    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);
    clip.start();
} catch(Exception ex) {
    System.out.println("Error with playing sound.");
    ex.printStackTrace();
}

try{
    AudioInputStream audioInputStream =
        AudioSystem.getAudioInputStream(
            this.getClass().getResource("E:/Othello/Othello Song.mp3"));
    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);
    clip.start();
}
catch(Exception ex)
{
}
}*/