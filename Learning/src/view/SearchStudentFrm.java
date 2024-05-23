package view;

import dao.StudentDAO;
import model.Student;
import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudentFrm extends JFrame implements ActionListener {
    private JTextField txtStudentKey;
    private JButton btnSearch;
    private JButton btnAddStudent;
    private JTable tblListStudent;
    private User user;
    private StudentDAO studentDAO;

    public SearchStudentFrm(User user) {
        super("Search Student");
        this.user = user;
        this.studentDAO = new StudentDAO();

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
        add(panel);

        btnAddStudent = new JButton("Add Student");
        btnAddStudent.addActionListener(this);
        add(btnAddStudent);

        tblListStudent = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblListStudent);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            // Implement search functionality here
        } else if (e.getSource() == btnAddStudent) {
//            mainApp.showAddStudent();
            (new AddStudentFrm(user)).setVisible(true);
            dispose();
        }
    }
}
