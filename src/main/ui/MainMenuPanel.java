package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Represents the main menu which the app starts on
public class MainMenuPanel extends JPanel {
    private UrinalSelectorFrame frame;
    private JLabel label;
    private JButton newGameButton;
    private JButton quitButton;

    // MODIFIES: this
    // EFFECTS: Constructs the main menu with title and buttons to either start a
    // new game or load a game
    public MainMenuPanel(UrinalSelectorFrame frame) {
        this.frame = frame;

        setLabel();
        setNewGameButton();
        setQuitButton();

        setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        setLayout(new GridLayout(0, 1));
        add(label);
        add(newGameButton);
        add(quitButton);
    }

    // MODIFIES: this
    // EFFECTS: creates and sets up label
    private void setLabel() {
        label = new JLabel("Urinal Selector", SwingConstants.CENTER);
        label.setFont(getFont().deriveFont(100f));
    }

    // MODIFIES: this
    // EFFECTS: creates and sets up newGameButton
    private void setNewGameButton() {
        newGameButton = new JButton("New Washroom");
        newGameButton.setFont(getFont().deriveFont(100f));
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.startWashroom();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: creates and sets up quitButton
    private void setQuitButton() {
        quitButton = new JButton("Quit");
        quitButton.setFont(getFont().deriveFont(100f));
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }
}
