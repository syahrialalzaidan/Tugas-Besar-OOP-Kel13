import javax.swing.*;
import java.awt.*;

public class Buttons extends JButton {
    private int[] position;
    private Color color;
    private Boolean isOccupied;

    public Buttons(int x, int y) {
        position = new int[2];
        position[0] = x;
        position[1] = y;
        color = Color.WHITE;
        isOccupied = false;
        //setBackground(color);
        //this.setFocusable(false);
        //setBounds(300 + (x % 6) * 50, 100 + (y / 6) * 50, 50, 50);
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(Boolean isOccupied)
    {
        this.isOccupied = isOccupied;
    }
}
