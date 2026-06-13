package ui;

import service.GradeTracker;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {

    private JLabel avgLabel;
    private JLabel highLabel;
    private JLabel lowLabel;

    private GradeTracker tracker;

    public StatsPanel(GradeTracker tracker) {

        this.tracker = tracker;

        setLayout(new GridLayout(3,1,20,20));

        avgLabel = new JLabel();
        highLabel = new JLabel();
        lowLabel = new JLabel();

        add(avgLabel);
        add(highLabel);
        add(lowLabel);

        JButton refresh =
                new JButton("Refresh Statistics");

        add(refresh);

        refresh.addActionListener(e -> updateStats());
    }

    public void updateStats() {

        avgLabel.setText(
                "Average Grade : "
                        + tracker.getAverage());

        highLabel.setText(
                "Highest Grade : "
                        + tracker.getHighest());

        lowLabel.setText(
                "Lowest Grade : "
                        + tracker.getLowest());
    }
}