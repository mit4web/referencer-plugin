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
package com.kstenschke.referencer.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @todo change into PSI based parser one day
 */
public class ParserPhp {

    /**
     * Get all PHP variable names in the order of their appearance in the given text, but each item only once
     *
     * @param    text    Source code to be searched
     * @return All found PHP variables
     */
    public static List<String> getAllVariablesInText(String text) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("\\$[a-zA-Z0-9_]+").matcher(text);

        while (m.find()) {
            if (!allMatches.contains(m.group())) {
                allMatches.add(m.group());
            }
        }

        return allMatches;
    }

    /**
     * Get all PHP method names in the order of their appearance in the given text, but each item only once
     *
     * @param  text Source code to be searched
     * @return All found PHP method names
     */
    public static List<String> getAllMethodsInText(String text) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("function\\s*[a-zA-Z0-9_]+\\s*\\(").matcher(text);

        while (m.find()) {
            if (!allMatches.contains(m.group())) {
                allMatches.add(m.group());
            }
        }

        return allMatches;
    }

    /**
     * Get all PHP class names in the order of their appearance in the given text, but each item only once
     *
     * @param  text Source code to be searched
     * @return All found PHP class names
     */
    public static List<String> getAllClassNamesInText(String text) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("class\\s*[a-zA-Z0-9_]+").matcher(text);

        while (m.find()) {
            if (!allMatches.contains(m.group())) {
                allMatches.add(m.group());
            }
        }

        return allMatches;
    }
}