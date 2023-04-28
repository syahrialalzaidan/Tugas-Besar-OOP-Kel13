import java.awt.*;

import javax.naming.directory.DirContext;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        RoomGUI roomGUI = new RoomGUI();
        Buttons[][] space = new Buttons[6][6];
        
        for(int i = 0; i < 6; i++) 
        {
            for(int j = 0; j < 6; j++)
            {
            space[i][j] = new Buttons(i,j);
            // button_panel.add(buttons[i]);
            space[i][j].setBackground(Color.BLACK);
            //space[i][i].setFocusable(false);
            space[i][j].setBounds(500 + j * 100, 50 + i * 100, 100, 100);
            //space[i][j].addActionListener(this);
            // String text = i + "," + j;
            // buttons[i][j].setText(text);
            // System.out.println("i = " + i + " j = " + j);
            // System.out.println(buttons[i][j].getBounds());
            roomGUI.add(space[i][j]);
            }
        }

        roomGUI.setVisible(true);
        roomGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
