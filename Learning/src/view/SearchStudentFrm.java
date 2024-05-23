package view;

import dao.StudentDAO;
import model.Student;
import model.User;
import main.MainApplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudentFrm extends JFrame implements ActionListener {
    private JTextField txtStudentKey;
    private JButton btnSearch;
    private JButton btnAddStudent;
    private JTable tblStudent;
    private User user;
    private StudentDAO studentDAO;
    private MainApplication mainApp;

    public SearchStudentFrm(User user, StudentDAO studentDAO, MainApplication mainApp) {
        super("Search Student");
        this.user = user;
        this.studentDAO = studentDAO;
        this.mainApp = mainApp;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(600, 400);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Student Key:"));
        txtStudentKey = new JTextField(20);
        panel.add(txtStudentKey);
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        panel.add(btnSearch);
        btnAddStudent = new JButton("Add Student");
        btnAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showAddStudent();
            }
        });
        panel.add(btnAddStudent);
        add(panel);

        tblStudent = new JTable(); // Set up your table model
        JScrollPane scrollPane = new JScrollPane(tblStudent);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String key = txtStudentKey.getText();
            Student[] students = studentDAO.searchStudent(key);
            // Update your table model with the search results
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID", "Full Name", "DOB", "Phone", "Email"});
            for (Student student : students) {
                model.addRow(new Object[]{
                        student.getId(),
                        student.getFullName(),
                        student.getDob(),
                        student.getPhone(),
                        student.getEmail()
                });
            }
            tblStudent.setModel(model);
        }
    }
}
