package HTML_Editor;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter { // Проверь будет ли работать?!

    @Override
    public boolean accept(File f) {
        return ((f.isDirectory())
                || (f.getName().toLowerCase().endsWith(".htm"))
                || (f.getName().toLowerCase().endsWith(".html")));
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
