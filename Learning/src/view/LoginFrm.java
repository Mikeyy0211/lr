package view;

import dao.UserDAO;
import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrm extends JFrame implements ActionListener {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private UserDAO userDAO;
    private MainApplication mainApp;

    public LoginFrm() {
        super("Login");
        this.userDAO = new UserDAO();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(400, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        txtUsername = new JTextField(20);
        panel.add(txtUsername);
        add(panel);

        panel = new JPanel();
        panel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField(20);
        panel.add(txtPassword);
        add(panel);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        add(btnLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            User user = new User();
            user.setUsername(txtUsername.getText());
            user.setPassword(new String(txtPassword.getPassword()));

            if (userDAO.checkLogin(user)) {
                (new ReceptionistHomeFrm(user)).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password.");
            }
        }
    }
}
