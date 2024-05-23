package view;

import dao.SubjectClassDAO;
import model.Program;
import model.SubjectClass;
import model.User;
import main.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchSubjectClassFrm extends JFrame implements ActionListener {
    private JTextField txtClassKey;
    private JButton btnSearch;
    private JTable tblListSubjectClass;
    private User user;
    private Program program;
    private SubjectClassDAO subjectClassDAO;
    private MainApplication mainApp;

    public SearchSubjectClassFrm(User user, Program program, SubjectClassDAO subjectClassDAO, MainApplication mainApp) {
        super("Search Subject Class");
        this.user = user;
        this.program = program;
        this.subjectClassDAO = subjectClassDAO;
        this.mainApp = mainApp;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(600, 400);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Class Key:"));
        txtClassKey = new JTextField(20);
        panel.add(txtClassKey);
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        panel.add(btnSearch);
        add(panel);

        tblListSubjectClass = new JTable(); // Set up your table model
        JScrollPane scrollPane = new JScrollPane(tblListSubjectClass);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            int programId = program.getId();
            SubjectClass[] subjectClasses = subjectClassDAO.searchAvailableSubjectClass(programId);
            // Update your table model with the search results
        }
    }
}
