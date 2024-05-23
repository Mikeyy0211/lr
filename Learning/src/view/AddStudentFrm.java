package view;

import dao.StudentDAO;
import model.Student;
import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentFrm extends JFrame implements ActionListener {
    private JTextField txtStudentID;
    private JTextField txtFullName;
    private JTextField txtAge;
    private JTextField txtEmail;
    private JTextField txtAddress;
    private JButton btnSave;
    private JButton btnCancel;
    private User user;
    private StudentDAO studentDAO;
    private MainApplication mainApp;

    public AddStudentFrm(User user, StudentDAO studentDAO, MainApplication mainApp) {
        super("Add Student");
        this.user = user;
        this.studentDAO = studentDAO;
        this.mainApp = mainApp;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(400, 400);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Student ID:"));
        txtStudentID = new JTextField(20);
        panel.add(txtStudentID);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Full Name:"));
        txtFullName = new JTextField(20);
        panel.add(txtFullName);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Age:"));
        txtAge = new JTextField(20);
        panel.add(txtAge);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField(20);
        panel.add(txtEmail);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Address:"));
        txtAddress = new JTextField(20);
        panel.add(txtAddress);
        add(panel);

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        add(btnSave);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(this);
        add(btnCancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            // Implement save functionality here
        } else if (e.getSource() == btnCancel) {
            mainApp.showSearchStudent();
            dispose();
        }
    }
}
