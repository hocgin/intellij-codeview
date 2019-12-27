package in.hocg.intellij.codeview.ui;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author hocgin
 */
public class TitleDialog extends JDialog {
    private JPanel contentPane;
    private JButton okButton;
    private JButton cancelButton;
    private JEditorPane titleEditor;

    public TitleDialog() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(okButton);
        _initListener();
    }

    private void _initListener() {
        okButton.addActionListener(e -> onOK());
        cancelButton.addActionListener(e -> onCancel());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void showDialog() {
        this.pack();
        this.setVisible(true);
        this.setModal(false);
        this.setTitle("设置标题");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
    }
}
