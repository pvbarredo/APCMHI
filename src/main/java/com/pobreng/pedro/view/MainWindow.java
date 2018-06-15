package com.pobreng.pedro.view;

import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JList deviceList;
    private JTextField usernameTextField;
    private JTextField nameTextField;
    private JTextField latitudeTextField;
    private JTextField longitudeTextField;
    private DateTimePicker dateTimeTextField;
    private JPanel devicePanel;
    private JPanel propertyPanel;
    private JButton submitButton;

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JPanel getPropertyPanel() {
        return propertyPanel;
    }

    public void setPropertyPanel(JPanel propertyPanel) {
        this.propertyPanel = propertyPanel;
    }

    public JPanel getDevicePanel() {
        return devicePanel;
    }

    public void setDevicePanel(JPanel devicePanel) {
        this.devicePanel = devicePanel;
    }

    public MainWindow() {
        setContentPane(mainPanel);
        setTitle("APC MHI Tool by Peter Barredo");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JList getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(JList deviceList) {
        this.deviceList = deviceList;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getLatitudeTextField() {
        return latitudeTextField;
    }

    public void setLatitudeTextField(JTextField latitudeTextField) {
        this.latitudeTextField = latitudeTextField;
    }

    public JTextField getLongitudeTextField() {
        return longitudeTextField;
    }

    public void setLongitudeTextField(JTextField longitudeTextField) {
        this.longitudeTextField = longitudeTextField;
    }

    public DateTimePicker getDateTimeTextField() {
        return dateTimeTextField;
    }

    public void setDateTimeTextField(DateTimePicker dateTimeTextField) {
        this.dateTimeTextField = dateTimeTextField;
    }
}
