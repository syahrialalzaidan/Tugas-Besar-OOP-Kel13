import java.awt.*;

import javax.naming.directory.DirContext;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class RoomGUI implements ActionListener {
    
    private Room room;
    Buttons[][] space = new Buttons[6][6];
    //private char[][] space;

    // private Scanner input;
    MainGUI frame = new MainGUI();
    //MainGUI frame;
    
    RoomGUI(Room room)
    {
        this.room = room;
        for(int i = 0; i < 6; i++) 
        {
            for(int j = 0; j < 6; j++)
            {
            space[i][j] = new Buttons(i,j);
            // button_panel.add(buttons[i]);
            space[i][j].setBackground(Color.BLACK);
            //space[i][i].setFocusable(false);
            space[i][j].setBounds(500 + j * 100, 50 + i * 100, 100, 100);
            space[i][j].addActionListener(this);
            // String text = i + "," + j;
            // buttons[i][j].setText(text);
            // System.out.println("i = " + i + " j = " + j);
            // System.out.println(buttons[i][j].getBounds());
            frame.add(space[i][j]);
            }
        }

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public HashMap<Items, Coordinate> getObject() {
        return object;
    }

    public void setObject(HashMap<Items, Coordinate> object) {
        this.object = object;
    }

    public Room getRigthRoom() {
        return rigthRoom;
    }

    public void setRigthRoom(Room rigthRoom) {
        this.rigthRoom = rigthRoom;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

    public Room getUpperRoom() {
        return upperRoom;
    }

    public void setUpperRoom(Room upperRoom) {
        this.upperRoom = upperRoom;
    }

    public Room getLowerRoom() {
        return lowerRoom;
    }

    public void setLowerRoom(Room lowerRoom) {
        this.lowerRoom = lowerRoom;
    }

    public void placeObject(Items object , int x1 , int y1 , String direction , Color color , Color foregColor , String name)
    {
        

        Coordinate coordinate = new Coordinate(0, 0, 0, 0);
        
        // persegi panjang orientasi kanan
        if(object.getX() >= object.getY())
        {
            // Orientasi Kanan
            if(direction.equalsIgnoreCase("Right"))
            {
                int x2 = x1 + object.getX();
                int y2 = y1 + object.getY();
                coordinate = new Coordinate(x1, y1, x2, y2);
            }

            // Orientasi Kiri
            else if(direction.equalsIgnoreCase("Left"))
            {
                int x2 = x1 + 1;
                int y2 = y1 + object.getY();
                x1 = x2 - object.getX();
                coordinate = new Coordinate(x1, y1, x2, y2);
            }

            // Orientasi atas
            else if(direction.equalsIgnoreCase("Up"))
            {
                int x2 = x1 + object.getY();
                int y2 = y1 + 1;
                y1 = y2 - object.getX();
                coordinate = new Coordinate(x1, y1, x2, y2);
                //System.out.println(coordinate.getX1() + " " + coordinate.getY1() + " " + coordinate.getX2() + " " + coordinate.getY2());
            }

            // Orientasi bawah
            else if(direction.equalsIgnoreCase("Down"))
            {
                int x2 = x1 + object.getY();
                int y2 = y1 + object.getX();
                coordinate = new Coordinate(x1, y1, x2, y2);
            }
        }

        else if(object.getX() < object.getY())
        {
             // Orientasi Kanan
             if(direction.equalsIgnoreCase("Right"))
             {
                 int x2 = x1 + object.getY();
                 int y2 = y1 + object.getX();
                 coordinate = new Coordinate(x1, y1, x2, y2);
             }
 
             // Orientasi Kiri
             else if(direction.equalsIgnoreCase("Left"))
             {
                 int x2 = x1 + 1;
                 int y2 = y1 + object.getX();
                 x1 = x2 - object.getY(); 
                 coordinate = new Coordinate(x1, y1, x2, y2);
             }
 
             // Orientasi atas
             else if(direction.equalsIgnoreCase("Up"))
             {
                 int x2 = x1 + object.getX();
                 int y2 = y1 + 1;
                 y1 = y2 - object.getY();
                 coordinate = new Coordinate(x1, y1, x2, y2);
                 //System.out.println(coordinate.getX1() + " " + coordinate.getY1() + " " + coordinate.getX2() + " " + coordinate.getY2());
             }
 
             // Orientasi bawah
             else if(direction.equalsIgnoreCase("Down"))
             {
                 int x2 = x1 + object.getX();
                 int y2 = y1 + object.getY();
                 coordinate = new Coordinate(x1, y1, x2, y2);
             }
        }

        if(checkAvailableSpace(coordinate))
        {
            this.object.put(object, coordinate);
            System.out.println(coordinate.getX1() + " " + coordinate.getY1() + " " + coordinate.getX2() + " " + coordinate.getY2());
            for(int i = coordinate.getY1(); i < coordinate.getY2(); i++)
            {
                //System.out.println(i);
                for(int j = coordinate.getX1(); j < coordinate.getX2(); j++)
                {
                    System.out.println(i + " , " + j);
                    //this.space[i][j] = object.getName().charAt(0);
                    space[i][j].setBackground(color);
                    space[i][j].setText(name);
                    space[i][j].setForeground(foregColor);
                    space[i][j].setIsOccupied(true);
                }
            }
            System.out.println("Berhasil memasukkan " + object.getName());
        }
        else
        {
            System.out.println(coordinate.getX1() + " " + coordinate.getY1() + " " + coordinate.getX2() + " " + coordinate.getY2());
            System.out.println("Tidak ada ruang untuk " + object.getName());
        }
        
    }

    public Boolean checkAvailableSpace(Coordinate coordinate)
    {
        // Cek apakah Coordinatenya minus
        if (coordinate.getX1() < 0 || coordinate.getX2() < 0 || coordinate.getY1() < 0 || coordinate.getY2() < 0)
        {
            return false;
        }

        // Cek apakah Coordinatenya lebih dari index
        else if(coordinate.getX1() > 6 || coordinate.getX2() > 6 || coordinate.getY1() > 6 || coordinate.getY2() > 6)
        {
            return false;
        }

        // Aman
        else
        {
            for(int i = coordinate.getY1(); i < coordinate.getY2(); i++)
            {
                for(int j = coordinate.getX1(); j < coordinate.getX2(); j++)
                {
                    if(this.space[i][j].getIsOccupied())
                    {
                        System.out.println("Masuk Sini");
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public void actionPerformed(ActionEvent e)
    {   
        System.out.println("actionPlaceFurniture = " + frame.getActionPlaceFurniture());
        if(frame.getActionPlaceFurniture())
        {
            for(int i= 0 ; i < 6 ; i++)
            {
                for(int j = 0 ; j < 6 ; j++)
                {
                    if(e.getSource() == space[i][j])
                    {

                        javax.swing.JComboBox<String> Furniture = frame.getFurniture();
                        String benda = Furniture.getSelectedItem().toString();

                        javax.swing.JComboBox<String> Direction = frame.getDirection();
                        String direction = Direction.getSelectedItem().toString();

                        int x1 = j;
                        int y1 = i;
                        Items object = null;
                        Color color = null;
                        Color foregColor = null;
                        if(benda.equals("Kasur"))
                        {
                            object = new Items("Kasur Single");
                            color = Color.RED;
                            foregColor = Color.BLACK;
                        }
                        else if(benda.equals("Kasur Queen Size"))
                        {
                            object = new Items("Kasur Queen Size");
                            color = Color.RED;
                            foregColor = Color.BLACK;
                        }
                        else if(benda.equals("Kursi"))
                        {
                            object = new Items("Kasur King Size");
                            color = Color.RED;
                            foregColor = Color.BLACK;
                        }
                        else if(benda.equals("Toilet"))
                        {
                            object = new Items("Toilet");
                            color = Color.BLUE;
                            foregColor = Color.WHITE;
                        }
                        else if(benda.equals("Kompor Gas"))
                        {
                            object = new Items("Kompor Gas");
                            color = Color.BLACK;
                            foregColor = Color.WHITE;
                        }
                        else if(benda.equals("Kompor Listrik"))
                        {
                            object = new Items("Kompor Listrik");
                            color = Color.BLACK;
                            foregColor = Color.WHITE;
                        }
                        else if(benda.equals("Meja dan Kursi"))
                        {
                            object = new Items("Meja dan Kursi");
                            color = new Color(150,75,00);
                            foregColor = Color.WHITE;
                        }
                        else if(benda.equals("Jam"))
                        {
                            object = new Items("Jam");
                            color = new Color(93,156,89);
                            foregColor = Color.WHITE;
                        }

                        placeObject(object , x1 , y1 , direction , color , foregColor , object.getName());

                    }
                        
                       
                }
            }
        }
    }

    public static void main(String[] args)
    {
        // MainGUI mainGUI = new MainGUI(); // Create an instance of MainGUI
        // Room room = new Room(null);
        new Room("Room 1");
        
        // Create an instance of MainGUI
       

        // Pass mainGUI as an argument to the Room constructor
        //Room room = new Room(mainGUI);

    }
       
}
    
