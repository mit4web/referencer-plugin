package com.kstenschke.referencer.resources.forms;

import javax.swing.*;

public class PluginConfiguration {
    private JTextArea textArea1;
    private JCheckBox regExCheckBox;
    private JPanel rootPanel;
    private JCheckBox sortAlphabeticalCheckBox;


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isModified() {
        return false;
    }

}