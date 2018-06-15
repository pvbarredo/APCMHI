package com.pobreng.pedro.controller;

import com.google.gson.Gson;
import com.pobreng.pedro.model.Device;
import com.pobreng.pedro.model.Property;
import com.pobreng.pedro.util.Client;
import com.pobreng.pedro.util.Config;
import com.pobreng.pedro.util.ListRenderer;
import com.pobreng.pedro.util.Util;
import com.pobreng.pedro.view.MainWindow;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainWindowController {

    MainWindow mainWindow;
    private final static Logger logger = Logger.getLogger(MainWindowController.class);
    Config config;
    Device selectedDevice;
    private Map<String, JTextField> dynamicDataTextField;

    public MainWindowController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        config = Util.getConfig();
        initController();

    }

    private void initController() {
        DefaultListModel<Device> model = new DefaultListModel<>();
        ListRenderer cellRenderer = new ListRenderer();
        final JList deviceList = this.mainWindow.getDeviceList();
        final JPanel devicePanel = mainWindow.getDevicePanel();
        final JPanel propertyPanel = mainWindow.getPropertyPanel();
        propertyPanel.setLayout(new BoxLayout(propertyPanel, BoxLayout.PAGE_AXIS));

        final List<Device> devices = getAllDevices();
        for (Device device : devices) {
            model.addElement(device);
        }

        deviceList.setModel(model);
        deviceList.setCellRenderer(cellRenderer);

        deviceList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selectedDevice = devices.get(deviceList.locationToIndex(e.getPoint()));
                    displayDeviceInfo(selectedDevice);
                }
            }

            private void displayDeviceInfo(Device selectedDevice) {
                propertyPanel.removeAll();
                dynamicDataTextField = new HashMap<String, JTextField>();
                propertyPanel.revalidate();
                propertyPanel.repaint();

                mainWindow.getUsernameTextField().setText(selectedDevice.getUsername());
                mainWindow.getNameTextField().setText(selectedDevice.getName());
                for (Property property : selectedDevice.getType().getProperty()) {
                    propertyPanel.add(new JLabel(property.getName()));
                    JTextField newDataTextField = new JTextField();
                    propertyPanel.add(newDataTextField);
                    dynamicDataTextField.put(String.valueOf(property.getId()), newDataTextField);
                }
                propertyPanel.revalidate();
                propertyPanel.repaint();
            }
        });

        mainWindow.getSubmitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSubmit();
            }
        });

    }

    private void onSubmit() {
        System.out.println(selectedDevice.getName());
        System.out.println(mainWindow.getLatitudeTextField().getText());
        System.out.println(mainWindow.getLongitudeTextField().getText());
        System.out.println(mainWindow.getDateTimeTextField().getDatePicker().getDate());
        System.out.println(mainWindow.getDateTimeTextField().getTimePicker().getTime());

        for (Map.Entry<String, JTextField> entry : dynamicDataTextField.entrySet()) {
            JTextField dataValue = entry.getValue();
            System.out.println("Key = " + entry.getKey() + ", Value = " + dataValue.getText());
            submit(entry, dataValue);
        }
    }

    private void submit(Map.Entry<String, JTextField> entry, JTextField dataValue) {
        try {

            String URL = String.format("device_id=%d&property_id=%s&value=%s&latitude=%s&longitude=%s&date=%s&time=%s", selectedDevice.getId(), entry.getKey(), dataValue.getText(), mainWindow.getLatitudeTextField().getText(), mainWindow.getLongitudeTextField().getText(), mainWindow.getDateTimeTextField().getDatePicker().getDate(), mainWindow.getDateTimeTextField().getTimePicker().getTime());
            HttpResponse response = Client.get(config.getAppURL() + "/deviceData/addDeviceData?" + URL);

            BufferedReader rd = null;
            if (response != null) {
                rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
            }

            StringBuilder result = new StringBuilder();
            String output;
            while ((output = rd.readLine()) != null) {
                result.append(output);

                JSONArray array = new JSONArray(output);
                Gson gson = new Gson();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject labelObject = array.getJSONObject(i);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private List<Device> getAllDevices() {

        try {
            List<Device> devices = new ArrayList<>();
            HttpResponse response = Client.get(config.getAppURL() + "/device/getAllDevices");

            BufferedReader rd = null;
            if (response != null) {
                rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
            }

            StringBuilder result = new StringBuilder();
            String output;
            while ((output = rd.readLine()) != null) {
                result.append(output);

                JSONArray array = new JSONArray(output);
                Gson gson = new Gson();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject labelObject = array.getJSONObject(i);
                    Device device = gson.fromJson(labelObject.toString(), Device.class);
                    devices.add(device);
                }
            }
            return devices;


        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }

}
