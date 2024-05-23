package view;

import dao.InvoiceDAO;
import model.Invoice;
import main.MainApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceFrm extends JFrame implements ActionListener {
    private JTextArea invoiceTextArea;
    private JButton btnSave;
    private JButton btnBack;
    private Invoice invoice;
    private InvoiceDAO invoiceDAO;

    public InvoiceFrm(Invoice invoice) {
        super("Invoice");
        this.invoice = invoice;
        this.invoiceDAO = new InvoiceDAO();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(600, 400);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        invoiceTextArea = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(invoiceTextArea);
        add(scrollPane);

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        add(btnSave);

        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new ReceptionistHomeFrm(invoice.getUser())).setVisible(true);
                dispose();
            }
        });
        add(btnBack);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            if (invoiceDAO.saveInvoice(invoice)) {
                JOptionPane.showMessageDialog(this, "Invoice saved successfully!");
                (new ReceptionistHomeFrm(invoice.getUser())).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save invoice!");
            }
        }
    }
}
