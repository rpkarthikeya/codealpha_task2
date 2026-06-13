package ui;

import model.Student;
import service.GradeTracker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentPanel extends JPanel {

    private GradeTracker tracker;

    private JTextField idField;
    private JTextField nameField;
    private JTextField gradeField;

    private JTable table;
    private DefaultTableModel model;

    public StudentPanel(GradeTracker tracker) {

        this.tracker = tracker;

        setLayout(new BorderLayout());

        JPanel top = new JPanel();

        idField = new JTextField(5);
        nameField = new JTextField(10);
        gradeField = new JTextField(5);

        JButton addBtn = new JButton("Add");

        top.add(new JLabel("ID"));
        top.add(idField);

        top.add(new JLabel("Name"));
        top.add(nameField);

        top.add(new JLabel("Grade"));
        top.add(gradeField);

        top.add(addBtn);

        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"ID","Name","Grade"},0);

        table = new JTable(model);

        add(new JScrollPane(table),BorderLayout.CENTER);

        addBtn.addActionListener(e -> addStudent());
    }

    private void addStudent() {

        try {

            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double grade = Double.parseDouble(gradeField.getText());

            Student student =
                    new Student(id,name,grade);

            tracker.addStudent(student);

            model.addRow(new Object[]{
                    id,
                    name,
                    grade
            });

            idField.setText("");
            nameField.setText("");
            gradeField.setText("");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input");
        }
    }
}