package ui;

import service.GradeTracker;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        GradeTracker tracker =
                new GradeTracker();

        setTitle(
                "Student Grade Tracker Dashboard");

        setSize(1000,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel sidebar =
                new JPanel();

        sidebar.setBackground(
                new Color(80,40,180));

        sidebar.setPreferredSize(
                new Dimension(200,600));

        sidebar.setLayout(
                new GridLayout(10,1));

        JButton studentBtn =
                new JButton("Students");

        JButton statsBtn =
                new JButton("Statistics");

        sidebar.add(studentBtn);
        sidebar.add(statsBtn);

        add(sidebar,BorderLayout.WEST);

        CardLayout cardLayout =
                new CardLayout();

        JPanel content =
                new JPanel(cardLayout);

        StudentPanel studentPanel =
                new StudentPanel(tracker);

        StatsPanel statsPanel =
                new StatsPanel(tracker);

        content.add(studentPanel,
                "STUDENTS");

        content.add(statsPanel,
                "STATS");

        add(content,
                BorderLayout.CENTER);

        studentBtn.addActionListener(e ->
                cardLayout.show(
                        content,
                        "STUDENTS"));

        statsBtn.addActionListener(e -> {

            statsPanel.updateStats();

            cardLayout.show(
                    content,
                    "STATS");
        });
    }
}