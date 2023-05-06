import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI {
    JFrame frame = new JFrame("Location");
    ImageIcon npc = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/npc.png");
    ImageIcon jam = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/clock-bener.png");
    ImageIcon toilet = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/closet.png");
    ImageIcon queenbed = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/queen.png");
    ImageIcon singlebed = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/single.png");
    ImageIcon kingbed = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/king.png");
    ImageIcon mejakursi = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/mejadankursi.png");
    ImageIcon komporgas = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/kompor-gas.png");
    ImageIcon komporlistrik = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/kompor-listrik.png");
    ImageIcon hp = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/handphone.png");
    ImageIcon sajadah = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/sajadah-bener.png");
    ImageIcon sapu = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/broom.png");
    ImageIcon tv = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/television.png");
    ImageIcon laptop = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/lepi.png");
    ImageIcon shower = new ImageIcon("C:/Java/Tugas-Besar-OOP-Kel13/public/shower-bener.png");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // Calculate the width and height of the frame to be 50% of the screen size
    int width = (int) (screenSize.getWidth() * 0.5);
    int height = (int) (screenSize.getHeight());

    public void createGUI(String[][] space) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.getContentPane().removeAll();

        JPanel panel = new JPanel(new GridLayout(6, 6));
        panel.setBackground(Color.PINK);

        // Add labels to the panel to display the contents of the space array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                JLabel label = new JLabel(space[i][j], JLabel.CENTER);
                boolean isNPC = false;
                for (int index = 0; index < GameManager.getSimList().size(); index++) {
                    if (GameManager.getSimList().get(index).getSimPoint().getX() == j
                            && GameManager.getSimList().get(index).getSimPoint().getY() == i) {
                        isNPC = true;
                        label = new JLabel(npc, JLabel.CENTER);
                        // label.setForeground(Color.WHITE);
                        // // label.setSize(40, 20);
                        // panel.add(label);
                }
                }

                if (!(space[i][j] == " " || space[i][j] == "")  && !isNPC) {
                    if (space[i][j] == "J") {
                        label = new JLabel(jam, JLabel.CENTER);
                    } else if (space[i][j] == "T") {
                        label = new JLabel(toilet, JLabel.CENTER);
                    } else if (space[i][j] == "KS") {
                        label = new JLabel(singlebed, JLabel.CENTER);
                    } else if (space[i][j] == "KQS") {
                        label = new JLabel(queenbed, JLabel.CENTER);
                    } else if (space[i][j] == "KKS") {
                        label = new JLabel(kingbed, JLabel.CENTER);
                    } else if (space[i][j] == "KG") {
                        label = new JLabel(komporgas, JLabel.CENTER);
                    } else if (space[i][j] == "KL") {
                        label = new JLabel(komporlistrik, JLabel.CENTER);
                    } else if (space[i][j] == "MDK") {
                        label = new JLabel(mejakursi, JLabel.CENTER);
                    } else if (space[i][j] == "HP") {
                        label = new JLabel(hp, JLabel.CENTER);
                    } else if (space[i][j] == "SJ") {
                        label = new JLabel(sajadah, JLabel.CENTER);
                    } else if (space[i][j] == "S") {
                        label = new JLabel(sapu, JLabel.CENTER);
                    } else if (space[i][j] == "TV") {
                        label = new JLabel(tv, JLabel.CENTER);
                    } else if (space[i][j] == "L") {
                        label = new JLabel(laptop, JLabel.CENTER);
                    } else if (space[i][j] == "SHO") {
                        label = new JLabel(shower, JLabel.CENTER);
                    }

                    label.setForeground(Color.WHITE);
                    // label.setSize(40, 20);
                    panel.add(label);
                } else if(isNPC) {
                    panel.add(label);
                }
                 else {
                    label = new JLabel("E", JLabel.CENTER);
                    label.setForeground(Color.GREEN);
                    panel.add(label);
                }
                
            }
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    public void action() {
        // Remove the blue panel from the frame
        frame.getContentPane().removeAll();

        // Create a new panel with red background and add it to the frame
        JPanel panel = new JPanel();
        panel.setBackground(java.awt.Color.RED);
        frame.add(panel);

        // Create a button and add it to the panel
        JButton button = new JButton("Click me");
        panel.add(button);

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // Refresh the frame to show the new contents
        frame.revalidate();
        frame.repaint();
    }

    // public static void main(String[] args) {
    // TestGUI test = new TestGUI();
    // boolean over = false;
    // Scanner input = new Scanner(System.in);
    // while (!over) {
    // int angka = input.nextInt();
    // if (angka == 0) {
    // over = true;
    // }
    // else if (angka == 1) test.createGUI();
    // else test.action();
    // }
    // input.close();
    // }

}
