package com.pobreng.pedro.util;

import com.pobreng.pedro.model.Device;

import javax.swing.*;
import java.awt.*;

public class ListRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Device) {
            Device device = (Device)value;
            setText(device.getName());
            setToolTipText(device.getDescription());

        }
        return this;
    }
}
