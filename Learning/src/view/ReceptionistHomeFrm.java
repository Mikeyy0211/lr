package view;

import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistHomeFrm extends JFrame implements ActionListener {
    private JLabel lblFullName;
    private JButton btnRegistration;
    private JButton btnCancelRegistration;
    private User user;
    private MainApplication mainApp;

    public ReceptionistHomeFrm(User user, MainApplication mainApp) {
        super("Receptionist Home");
        this.user = user;
        this.mainApp = mainApp;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblFullName = new JLabel("Welcome, " + user.getFullName());
        lblFullName.setAlignmentX(CENTER_ALIGNMENT);
        add(lblFullName);

        btnRegistration = new JButton("Registration");
        btnRegistration.addActionListener(this);
        add(btnRegistration);

        btnCancelRegistration = new JButton("Cancel Registration");
        btnCancelRegistration.addActionListener(this);
        add(btnCancelRegistration);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistration) {
            mainApp.showSearchStudent();
        } else if (e.getSource() == btnCancelRegistration) {
            // Handle cancel registration logic here
        }
    }
}
