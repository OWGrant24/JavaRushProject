package JavaRush_Projects.hhBot;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GUI_Main {

    private JPanel mainPanel;
    private JButton startButton;
    private JButton siteHHbutton2;
    private JButton exitButton3;

    public GUI_Main() {
        exitButton3.addActionListener(e -> {
            System.exit(0);
        });
        siteHHbutton2.addActionListener(e -> {
            if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
                try {
                    Desktop.getDesktop().browse(new URI("hh.ru"));
                } catch (IOException | URISyntaxException ex) {
                    ex.getMessage();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
