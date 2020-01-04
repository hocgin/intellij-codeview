package in.hocg.intellij.codeview.ui;

import com.google.common.base.Strings;
import com.intellij.openapi.project.ProjectManager;
import in.hocg.intellij.codeview.service.AppsService;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author hocgin
 */
public class TitleDialog extends JDialog {
    private JPanel contentPane;
    private JButton okButton;
    private JButton cancelButton;
    private JEditorPane titleEditor;
    private final String content;

    public TitleDialog(final String content) {
        this.content = content;
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
        final String title = titleEditor.getText();
        if (Strings.isNullOrEmpty(title)) {
            return;
        }

        AppsService.INSTANCE.shareTextAndNotify(title, content, ProjectManager.getInstance().getDefaultProject());
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
