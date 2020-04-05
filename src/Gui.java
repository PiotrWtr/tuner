import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Gui {
    JButton button;
    JFrame frame;
    JLabel freqLabel;
    AudioHandler player;
    public void zmienTekst(){
        button.setText("Zostalem klikniety");
    }
    public void startGui(){
        player = new AudioHandler();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Kliknij mnie");
        frame.getContentPane().add(BorderLayout.SOUTH, button);


        freqLabel = new JLabel("freq");
        frame.getContentPane().add(BorderLayout.CENTER, freqLabel);
        freqLabel.setVerticalAlignment(SwingConstants.CENTER);
        freqLabel.setHorizontalAlignment(SwingConstants.CENTER);

        button.addActionListener(new LabelListener());

        frame.setSize(300,300);

        frame.setVisible(true);

    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            freqLabel.setText("klikniety " + (int) (Math.random()*10));
            player.play();
        }
    }
}
