package JavaRush.JavaRush_Projects.HTML_Editor;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private File currentFile;
    private View view;
    private HTMLDocument document;
    JTabbedPane tabbedPane = new JTabbedPane();  // Панель с двумя вкладками
    JTextPane jTextPane = new JTextPane(); // Компонент для визуального редактирования html
    JEditorPane plainTextPane = new JEditorPane(); // Компонент для редактирования html в виде текста

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init(){
        createNewDocument();
    }
    public void resetDocument(){
        if(document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){ // Записывает переданный текст с html тегами в документ document
        resetDocument();
        Reader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(stringReader,document,0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){ // Получает весь текст документа со свеми html тегами
        Writer stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter,document,0,document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

        return stringWriter.toString();
    }
    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML Editor");
        view.resetUndo();
        currentFile = null;
    };
    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int result = jFileChooser.showOpenDialog(view);
        if(result == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try(Reader fr = new FileReader(currentFile)){
                htmlEditorKit.read(fr,document,0);
                view.resetUndo();
            } catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }
    public void saveDocument(){
        if(currentFile == null){
            saveDocumentAs();
        } else {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try(Writer fw = new FileWriter(currentFile)){
                htmlEditorKit.write(fw,document,0,document.getLength());
            } catch (Exception e){
                ExceptionHandler.log(e);
            }
        }

    }
    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int result = jFileChooser.showSaveDialog(view);
        if(result == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try(Writer fw = new FileWriter(currentFile)){
                htmlEditorKit.write(fw,document,0,document.getLength());
            } catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }
    public void exit(){
        System.exit(0);
    }
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        view.setController(controller);
        view.init();
        controller.init();
    }
}
