package game.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface Button extends ActionListener {
    void actionPerformed(ActionEvent e);
}
