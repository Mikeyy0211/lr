package view;

import dao.StudentDAO;
import model.Student;
import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddStudentFrm extends JFrame implements ActionListener {
    private JTextField txtFullName;
    private JTextField txtDob;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JButton btnSave;
    private JButton btnBack;
    private User user;
    private StudentDAO studentDAO;
    private MainApplication mainApp;

    public AddStudentFrm(User user, StudentDAO studentDAO, MainApplication mainApp) {
        super("Add Student");
        this.user = user;
        this.studentDAO = studentDAO;
        this.mainApp = mainApp;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Full Name:"));
        txtFullName = new JTextField(20);
        panel.add(txtFullName);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Date of Birth:"));
        txtDob = new JTextField(20);
        panel.add(txtDob);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Phone:"));
        txtPhone = new JTextField(20);
        panel.add(txtPhone);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField(20);
        panel.add(txtEmail);
        add(panel);

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        add(btnSave);

        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showSearchStudent();
                dispose();
            }
        });
        add(btnBack);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            Student student = new Student();
            student.setFullName(txtFullName.getText());
            student.setDob(Date.valueOf(txtDob.getText())); // Convert string to date
            student.setPhone(txtPhone.getText());
            student.setEmail(txtEmail.getText());

            if (studentDAO.addStudent(student)) {
                JOptionPane.showMessageDialog(this, "Student added successfully!");
                mainApp.showSearchStudent();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add student!");
            }
        }
    }
}
