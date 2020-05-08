import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Gui {
    JButton button;
    JFrame frame;
    JLabel freqLabel;
    AudioHandler player;
    JPanel bottomPanel;
    CentBar centBar;

    public void changeLabelText(String text){
        freqLabel.setText(text);
    }

    public void startGui(){
        player = new AudioHandler();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setSize(bottomPanel.getWidth(), 100);
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);

        centBar = new CentBar();
        bottomPanel.add(BorderLayout.NORTH, centBar);

        button = new JButton("Click me!");
        button.setSize(button.getWidth(), 50);
        bottomPanel.add(BorderLayout.SOUTH, button);
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
            int randomNumber = (int) (Math.random()*100 - 50);
            //freqLabel.setText();
            changeLabelText("Random position: " + randomNumber);
            centBar.setPosition(randomNumber);
            centBar.repaint();
            player.play();
        }
    }
}
