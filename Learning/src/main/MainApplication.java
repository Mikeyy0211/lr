package main;

import dao.*;
import model.*;
import view.*;

import javax.swing.*;
import java.awt.*;

public class MainApplication{
    public MainApplication() {
        // Initialize login panel
        LoginFrm loginFrm = new LoginFrm();
        loginFrm.setVisible(true);
    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void showReceptionistHome() {
//        ReceptionistHomeFrm receptionistHomeFrm = new ReceptionistHomeFrm(user, this);
//        cardPanel.add(receptionistHomeFrm, "ReceptionistHomeFrm");
//        cardLayout.show(cardPanel, "ReceptionistHomeFrm");
//    }
//
//    public void showSearchStudent() {
//        SearchStudentFrm searchStudentFrm = new SearchStudentFrm(user, studentDAO, this);
//        cardPanel.add(searchStudentFrm, "SearchStudentFrm");
//        cardLayout.show(cardPanel, "SearchStudentFrm");
//    }
//
//    public void showAddStudent() {
//        AddStudentFrm addStudentFrm = new AddStudentFrm(user, studentDAO, this);
//        cardPanel.add(addStudentFrm, "AddStudentFrm");
//        cardLayout.show(cardPanel, "AddStudentFrm");
//    }
//
//    public void showSearchProgram() {
//        SearchProgramFrm searchProgramFrm = new SearchProgramFrm(user, programDAO, this);
//        cardPanel.add(searchProgramFrm, "SearchProgramFrm");
//        cardLayout.show(cardPanel, "SearchProgramFrm");
//    }
//
//    public void showSearchClass() {
//        SearchSubjectClassFrm searchClassFrm = new SearchSubjectClassFrm(user, program, subjectClassDAO, this);
//        cardPanel.add(searchClassFrm, "SearchClassFrm");
//        cardLayout.show(cardPanel, "SearchClassFrm");
//    }
//
//    public void showInvoice() {
//        InvoiceFrm invoiceFrm = new InvoiceFrm(invoice, invoiceDAO, this);
//        cardPanel.add(invoiceFrm, "InvoiceFrm");
//        cardLayout.show(cardPanel, "InvoiceFrm");
//    }

    public static void main(String[] args) {
        new MainApplication();
    }
}
