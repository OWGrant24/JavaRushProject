package JavaRush.JavaRush_Projects.HTML_Editor.listeners;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import JavaRush.JavaRush_Projects.HTML_Editor.View;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view){
        this.view = view;
    }
    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu jMenu = (JMenu) menuEvent.getSource();
        for(Component jMenuTab : jMenu.getMenuComponents()){
            jMenuTab.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
