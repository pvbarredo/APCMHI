package com.pobreng.pedro;

import com.pobreng.pedro.controller.MainWindowController;
import com.pobreng.pedro.view.MainWindow;

public class App {

    public static void main(String[] args) {
        MainWindowController mainwindowController = new MainWindowController(new MainWindow());
    }
}
