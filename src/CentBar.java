import javax.swing.*;
import java.awt.*;

public class CentBar extends JPanel {
    int position;
    Color color;
    public CentBar(){
        color = Color.GREEN;
        position = 0;
    }

    public void  setPosition(int position){
        this.position = position;
        this.setSize(this.getWidth(), 50);
    }

    public void paintComponent(Graphics g){
        //background
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, this.getWidth()-2, this.getHeight()-2);
        //scale
        g.setColor(Color.GRAY);
        g.fillRect(this.getWidth()/2-1, 0, 2, this.getHeight());
        g.fillRect(this.getWidth()/4-1, 0, 2, this.getHeight());
        g.fillRect(this.getWidth()/4*3-1, 0, 2, this.getHeight());

        g.setColor(color);
        g.fillRect(this.getWidth()/2-1+position*this.getWidth()/100, 0, 3, this.getHeight());
    }
}
