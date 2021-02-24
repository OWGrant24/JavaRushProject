package JavaRush.JavaRush_Projects.HTML_Editor.listeners;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import JavaRush.JavaRush_Projects.HTML_Editor.View;

public class TabbedPaneChangeListener implements ChangeListener {
    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
