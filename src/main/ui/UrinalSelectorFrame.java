package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Represents the window in which the app is run
public class UrinalSelectorFrame extends JFrame {
    private JPanel currentPanel;
    private MainMenuPanel mainMenu;
    private WashroomPanel washroomPanel;

    // MODIFIES: this
    // EFFECTS: Creates the window that runs the game
    public UrinalSelectorFrame() {
        super("Urinal Selector");

        mainMenu = new MainMenuPanel(this);
        add(mainMenu);
        currentPanel = mainMenu;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
    }

    // MODIFIES: this
    // EFFECTS: Sets frame to new GamePanel with Game with given maxCardValue
    public void startWashroom() {
        washroomPanel = new WashroomPanel(this);
        remove(currentPanel);
        add(washroomPanel);
        currentPanel = washroomPanel;
        validate();
        repaint();
    }

    // MODIFIES: this
    // EFFECTS: removes currentPanel, adds mainMenu, and sets currentPanel to
    // mainMenu
    public void quitToMainMenu() {
        remove(currentPanel);
        mainMenu = new MainMenuPanel(this);
        add(mainMenu);
        currentPanel = mainMenu;
        validate();
        repaint();
    }
}
