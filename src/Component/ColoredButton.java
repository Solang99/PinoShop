package Component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColoredButton  extends JButton{
    private Color pressedColor = Color.GREEN;
    private Color rolloverColor = Color.RED;
    private Color normalColor = Color.BLUE;

    public ColoredButton (String text) {
        super(text);
        setBorderPainted(false);
        setFocusPainted(false);

        setContentAreaFilled(false);
        setOpaque(true);

        setBackground(normalColor);
        setForeground(Color.WHITE);
        setFont(new Font("Tahoma", Font.BOLD, 12));
        setText(text);

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                if (getModel().isPressed()) {
                    setBackground(pressedColor);
                } else if (getModel().isRollover()) {
                    setBackground(rolloverColor);
                } else {
                    setBackground(normalColor);
                }
            }
        });
    }
}

