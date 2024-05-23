package view;

import dao.UserDAO;
import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrm extends JFrame implements ActionListener {
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private UserDAO userDAO;
    private MainApplication mainApp;

    public LoginFrm(UserDAO userDAO, MainApplication mainApp) {
        super("Login");
        this.userDAO = userDAO;
        this.mainApp = mainApp;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(400, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Login");
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitle.setFont(lblTitle.getFont().deriveFont(20.0f));
        add(lblTitle);

        JPanel pnUsername = new JPanel(new FlowLayout());
        pnUsername.add(new JLabel("Username:"));
        txtUserName = new JTextField(15);
        pnUsername.add(txtUserName);
        add(pnUsername);

        JPanel pnPassword = new JPanel(new FlowLayout());
        pnPassword.add(new JLabel("Password:"));
        txtPassword = new JPasswordField(15);
        pnPassword.add(txtPassword);
        add(pnPassword);

        btnLogin = new JButton("Login");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.addActionListener(this);
        add(btnLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            User user = new User();
            user.setUsername(txtUserName.getText());
            user.setPassword(new String(txtPassword.getPassword()));

            if (userDAO.checkLogin(user)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                mainApp.setUser(user);
                mainApp.showReceptionistHome();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        }
    }

    public static void main(String[] args) {
        new LoginFrm(new UserDAO(), new MainApplication());
    }
}
