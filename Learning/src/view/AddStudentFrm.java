package view;

import dao.StudentDAO;
import model.Student;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddStudentFrm extends JFrame implements ActionListener {
    private JTextField txtStudentID;
    private JTextField txtFullName;
    private JTextField txtAge;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JButton btnSave;
    private JButton btnCancel;
    private User user;
    private StudentDAO studentDAO;

    public AddStudentFrm(User user) {
        super("Add Student");
        this.user = user;
        this.studentDAO = new StudentDAO();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(400, 400);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
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
        panel.add(new JLabel("Phone:"));
        txtPhone = new JTextField(20);
        panel.add(txtPhone);
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
            Student student = new Student();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dob = null;
            try {
                dob = sdf.parse(txtAge.getText());
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            student.setDob(dob);
            student.setEmail(txtEmail.getText());
            student.setFullName(txtFullName.getText());
            student.setPhone(txtPhone.getText());
            studentDAO.addStudent(student);

            (new SearchProgramFrm(user, student)).setVisible(true);
            dispose();
        } else if (e.getSource() == btnCancel) {
            (new SearchStudentFrm(user)).setVisible(true);
            dispose();
        }
    }
}
