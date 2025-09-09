package ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Urinal;

public class UrinalPanel extends JPanel {
    private WashroomPanel washroomPanel;
    private Urinal urinal;
    private boolean chosen;
    private ImageIcon defaultUrinalImage;
    private ImageIcon chosenUrinalImage;
    private ImageIcon urinalImage;
    private JLabel urinalLabel;
    private JLabel personLabel;

    public UrinalPanel(WashroomPanel washroomPanel, Urinal urinal) {
        this.washroomPanel = washroomPanel;
        this.urinal = urinal;
        this.chosen = false;

        setLayout(null);

        addImages();
        addOccupyButton();
        addRemoveButton();
        repaint();
    }

    private void addRemoveButton() {
        JButton removeButton = new JButton("remove");
        removeButton.setBounds(40, 360, 234, 30);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });

        add(removeButton);
    }

    private void remove() {
        washroomPanel.removeUrinal(this);
    }

    private void addOccupyButton() {
        JButton occupyButton = new JButton("Occupy");
        occupyButton.setBounds(40, 330, 234, 30);
        occupyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                urinal.switchOccupied();
                personLabel.setVisible(urinal.isOccupied());
            }
        });

        add(occupyButton);
    }

    // MODIFIES: this
    // EFFECTS: sets images up to have all classic cards in it
    private void addImages() {
        ImageIcon personImage = new ImageIcon("./data/person.png");
        personImage = new ImageIcon(personImage.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH));
        personLabel = new JLabel(personImage);
        personLabel.setBounds(0, 0, 300, 300);
        personLabel.setVisible(false);
        add(personLabel);

        defaultUrinalImage = new ImageIcon("./data/urinal.png");
        // defaultUrinalImage = new ImageIcon(
        //         defaultUrinalImage.getImage().getScaledInstance(100, 145, java.awt.Image.SCALE_SMOOTH));

        FilteredImageSource source = new FilteredImageSource(defaultUrinalImage.getImage().getSource(),
                new GreenFilter());
        chosenUrinalImage = new ImageIcon(Toolkit.getDefaultToolkit().createImage(source));

        urinalImage = new ImageIcon(defaultUrinalImage.getImage());
        urinalLabel = new JLabel(urinalImage);
        urinalLabel.setBounds(40, 20, 234, 234);
        add(urinalLabel);
    }

    public void choose() {
        chosen = true;
        urinalImage.setImage(chosenUrinalImage.getImage());
        urinalLabel.repaint();
    }

    public void removeChoice() {
        urinalImage.setImage(defaultUrinalImage.getImage());
        urinalLabel.repaint();
    }

    public Urinal getUrinal() {
        return urinal;
    }

    @Override
    public void repaint() {
        if (chosen)
            removeChoice();
        super.repaint();
    }

    static class GreenFilter extends RGBImageFilter {
        public GreenFilter() {
            canFilterIndexColorModel = true;
        }

        public int filterRGB(int x, int y, int rgb) {
            return rgb & 0xff00ff00;
        }
    }
}
