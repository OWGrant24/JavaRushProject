package HTML_Editor;

import HTML_Editor.listeners.FrameListener;
import HTML_Editor.listeners.TabbedPaneChangeListener;
import HTML_Editor.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
9.1. Реализуй метод initMenuBar(). Он должен:
9.1.1. Создавать новый объект типа JMenuBar. Это и будет наша панель меню.
9.1.2. С помощью MenuHelper инициализировать меню в следующем порядке: Файл,
Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
9.1.3. Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому,
 как это мы делали с панелью вкладок.
9.2. Добавь конструктор класса View. Он должен устанавливать внешний вид и поведение (look and feel)
 нашего приложения такими же, как это определено в системе.
Конструктор не должен кидать исключений, только логировать их с помощью ExceptionHandler.

Подсказа: для реализации задания используй класс UIManager.

Запусти приложение, теперь ты должен видеть панель с меню вверху окна. Некоторые из пунктов
меню (например: Вырезать, Копировать, Вставить, Стиль (частично), Выравнивание, Цвет, Шрифт)
должны уже работать. Убедись, что все работает и только затем продолжи разработку.
Требования:
В методе initMenuBar() должно создаваться новое меню (объект типа JMenuBar).
В методе initMenuBar() c помощью MenuHelper должно быть проинициализировано меню в следующем порядке: Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
В методе initMenuBar() должно добавляться новосозданное меню в верхнюю часть панели контента текущего фрейма, используя метод getContentPane().
В конструкторе класса View, через класс UIManager, должен устанавливаться внешний вид и поведение (look and feel).
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }


    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }
    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html"); //6.1
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane); //6.2
        tabbedPane.add("HTML",jScrollPane); //6.3
        JScrollPane jScrollPane2 = new JScrollPane(plainTextPane); //6.4
        tabbedPane.add("Текст", jScrollPane2); // 6.5
        tabbedPane.setPreferredSize(new Dimension(200,220)); //6.6
        tabbedPane.addChangeListener((new TabbedPaneChangeListener(this)));
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }
    public void initGui() {  // Инициализация графического интерфейса
        initMenuBar();
        initEditor();
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Новый" :
                controller.createNewDocument();
                break;
            case "Открыть" :
                controller.openDocument();
                break;
            case "Сохранить" :
                controller.saveDocument();
                break;
            case "Сохранить как..." :
                controller.saveDocumentAs();
                break;
            case "Выход" :
                controller.exit();
                break;
            case "О программе" :
                showAbout();
        }
    }
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }
    public void undo(){
        try {
            undoManager.undo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try {
            undoManager.redo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    };
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(this,"Автор программы\n Шабельский Александр",
                "О программе",JOptionPane.INFORMATION_MESSAGE);
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }
    public void selectedTabChanged(){
        if(tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(controller.plainTextPane.getText());
        } else if (tabbedPane.getSelectedIndex() == 1) {
            controller.plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }
    public void exit(){
        controller.exit();
    }
}
