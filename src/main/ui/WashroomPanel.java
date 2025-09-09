package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Washroom;
import model.exceptions.NoAvailableUrinalException;

// Panel in which the game is played
public class WashroomPanel extends JPanel {
    private UrinalSelectorFrame frame;
    private Washroom washroom;
    private List<UrinalPanel> urinalPanels;

    // REQUIRES: game != null
    // MODIFIES: this
    // EFFECTS: Constructs the panel in which the game is played
    public WashroomPanel(UrinalSelectorFrame frame) {
        this.washroom = new Washroom();
        this.frame = frame;
        this.urinalPanels = new ArrayList<UrinalPanel>();

        setLayout(null);

        addButtons();
        addUrinal();
    }

    // MODIFIES: this
    // EFFECTS: adds all necessary buttons to buttons and this
    private void addButtons() {
        addQuitButton();
        addAddUrinalButton();
        addChooseUrinalButton();
    }

    private void addChooseUrinalButton() {
        JButton chooseUrinalButton = new JButton("Choose Urianl");
        chooseUrinalButton.setBounds(10, 200, 100, 30);
        chooseUrinalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    urinalPanels.get(washroom.chooseUrinal()).choose();
                } catch (NoAvailableUrinalException exception) {
                    // Do nothing
                }
            }
        });

        add(chooseUrinalButton);

    }

    // REQUIRES: buttons != null
    // MODIFIES: this
    // EFFECTS: creates the draw button and adds it to buttons
    private void addAddUrinalButton() {
        JButton addUrianlButton = new JButton("Add Urinal");
        addUrianlButton.setBounds(10, 165, 100, 30);
        addUrianlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUrinal();
            }
        });

        add(addUrianlButton);
    }

    // REQUIRES: buttons != null
    // MODIFIES: this
    // EFFECTS: creates the quit button and adds it to buttons
    private void addQuitButton() {
        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(0, 0, 200, 60);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.quitToMainMenu();
            }
        });

        add(quitButton);
    }

    private void addUrinal() {
        urinalPanels.add(new UrinalPanel(this, washroom.addNewUrinal()));
        resetUrinals();
    }

    private void resetUrinals() {
        for (int i = 0; i < washroom.size(); i++) {
            urinalPanels.get(i).setBounds(700 - washroom.size() * 100 + i * 200, 200, 500, 500);
            add(urinalPanels.get(i));
        }
        repaint();
    }

    public void removeUrinal(UrinalPanel panel) {
        urinalPanels.remove(panel);
        remove(panel);
        washroom.remove(panel.getUrinal());
        resetUrinals();
    }
}
