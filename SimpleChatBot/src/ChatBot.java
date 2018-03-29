import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBot extends JFrame implements ActionListener {

    final String TITLE = "ChatBot ";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialog; //area for dialog
    JCheckBox ai; //enable/disable AI
    JTextField messageField; //field for entering message
    SimpleBot sbot; //chat-bot class (in bot pakage)

    public static void main(String[] args) {
        new ChatBot();
    }
    ChatBot(){
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);

        //area for dialog
        dialog = new JTextArea();
        dialog.setLineWrap(true);
        JScrollPane scrollBar = new JScrollPane(dialog);

        //panel for checkbox, message and button
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox("AI");
        //ai.doClick();
        messageField = new JTextField();
        messageField.addActionListener(this);
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(this);

        // adding all elements to the window
        bp.add(ai);
        bp.add(messageField);
        bp.add(enterButton);

        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
        sbot = new SimpleBot(); //creating a bot

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (messageField.getText().trim().length() > 0){
            dialog.append(messageField.getText() + "\n");
            dialog.append(TITLE.substring(0) +
                    sbot.sayInReturn(messageField.getText(), ai.isSelected()) + "\n");
        }
        messageField.setText("");
        messageField.requestFocusInWindow();
    }
}
