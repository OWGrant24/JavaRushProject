package JavaRush.JavaRush_Projects.HTML_Editor.actions;

import javax.swing.*;
import JavaRush.JavaRush_Projects.HTML_Editor.View;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction { //8.1.1
    private View view;

    public UndoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.undo();
    }
}
