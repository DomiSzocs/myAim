package game.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ExitButton extends JButton implements Button {
    public ExitButton() {
        super("Exit");
        super.setFont(new Font("Times Roman", Font.BOLD, 19));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
