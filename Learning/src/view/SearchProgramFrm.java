package view;

import dao.ProgramDAO;
import model.Program;
import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchProgramFrm extends JFrame implements ActionListener {
    private JTextField txtProgramKey;
    private JButton btnSearch;
    private JTable tblListProgram;
    private User user;
    private ProgramDAO programDAO;
    private MainApplication mainApp;

    public SearchProgramFrm(User user, ProgramDAO programDAO, MainApplication mainApp) {
        super("Search Program");
        this.user = user;
        this.programDAO = programDAO;
        this.mainApp = mainApp;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(600, 400);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Program Key:"));
        txtProgramKey = new JTextField(20);
        panel.add(txtProgramKey);
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        panel.add(btnSearch);
        add(panel);

        tblListProgram = new JTable(); // Set up your table model
        JScrollPane scrollPane = new JScrollPane(tblListProgram);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String key = txtProgramKey.getText();
            Program[] programs = programDAO.searchProgram(key);
            // Update your table model with the search results
        }
    }
}
