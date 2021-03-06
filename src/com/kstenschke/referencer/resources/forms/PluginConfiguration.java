/*
 * Copyright 2012-2017 Kay Stenschke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kstenschke.referencer.resources.forms;

import com.kstenschke.referencer.Preferences;

import javax.swing.*;

public class PluginConfiguration {

    private JTextArea textAreaGoToPatterns;
    private JCheckBox regExCheckBox;
    private JPanel rootPanel;

    public PluginConfiguration() {
        textAreaGoToPatterns.setText( Preferences.getGoToPatterns() );
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isModified() {
        return ! getGoToPatterns().equals( Preferences.getGoToPatterns() );
    }

    public String getGoToPatterns() {
        String text = textAreaGoToPatterns.getText().trim();
        textAreaGoToPatterns.setText(text);

        return text;
    }
}