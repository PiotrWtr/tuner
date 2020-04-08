import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Gui {
    JButton button;
    JFrame frame;
    JLabel freqLabel;
    AudioHandler player;

    public void changeLabelText(){
        button.setText("Zostalem klikniety");
    }

    public void startGui(){
        player = new AudioHandler();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Click me!");
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        button.addActionListener(new LabelListener());

        freqLabel = new JLabel("Frequency will be displayed here");
        frame.getContentPane().add(BorderLayout.CENTER, freqLabel);
        freqLabel.setVerticalAlignment(SwingConstants.CENTER);
        freqLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            freqLabel.setText("Random number: " + (int) (Math.random()*10));
            player.play();
        }
    }
}
