import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TampilanAwal implements ActionListener {
    JFrame frame = new JFrame();
    JButton StartButton = new JButton("Start");
    JButton ExitButton = new JButton("Exit");
    JLabel label;
    public TampilanAwal(){
        frame.setTitle("Game SimCity");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,720);
        frame.setLayout(null);


        StartButton.setBounds(600,310, 200, 40);
        StartButton.setFocusable(false);
        StartButton.addActionListener(this);
        StartButton.setHorizontalTextPosition(JButton.CENTER);
        StartButton.setVerticalTextPosition(JButton.BOTTOM);
        StartButton.setFont(new Font("Comic Sans", Font.BOLD,25));
        StartButton.setIconTextGap(-15);
        StartButton.setForeground(Color.cyan);
        StartButton.setBackground(Color.lightGray);

        ExitButton.setBounds(600,350, 200, 40);
        ExitButton.setFocusable(false);
        ExitButton.addActionListener(this);
        ExitButton.setHorizontalTextPosition(JButton.CENTER);
        ExitButton.setVerticalTextPosition(JButton.BOTTOM);
        ExitButton.setFont(new Font("Comic Sans", Font.BOLD,25));
        ExitButton.setIconTextGap(-15);
        ExitButton.setForeground(Color.cyan);
        ExitButton.setBackground(Color.lightGray);
    
        frame.add(StartButton);
        frame.add(ExitButton);

        ImageIcon image = new ImageIcon("LogoSims.png"); // create an ImageIcon
        frame.setIconImage(image.getImage()); //change icon of this
        frame.getContentPane().setBackground(new Color(123, 50, 250)); //change color of background

        ImageIcon icon = new ImageIcon("LogoSims.png");

        ImageIcon icon2 = new ImageIcon("LogoSims.png");



        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(640,150, 200, 200);
        label.setVisible(true);
        frame.add(label);
        

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== StartButton){
            frame.dispose();
            NewWindow myWindow = new NewWindow();
        }
    }




}
