package com.kstenschke.referencer.referencers.goTo;

import com.intellij.ide.bookmarks.Bookmark;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.kstenschke.referencer.resources.StaticTexts;
import com.kstenschke.referencer.utils.UtilsString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoToReferencerBookmarks extends GoToReferencer {

    /**
     * @return  String[]
     */
    public static String[] getBookmarkItems(Project project, Document document, VirtualFile file) {
        String[] referencesArr = null;

        com.intellij.ide.bookmarks.BookmarkManager bookmarkManager = com.intellij.ide.bookmarks.BookmarkManager.getInstance(project);

        List<String> bookmarkItems= new ArrayList<String>();
        bookmarkItems.add( StaticTexts.POPUP_SECTION_BOOKMARKS );

        List<Bookmark> bookmarks  = bookmarkManager.getValidBookmarks();
        String documentText = document.getText();

        List<Integer> bookmarkLineNumbers = new ArrayList<Integer>();
        for( Bookmark curBookmark : bookmarks ) {
            if( curBookmark.getFile().equals(file) ) {
                bookmarkLineNumbers.add(curBookmark.getLine());
            }
        }

        if( bookmarkLineNumbers.size() > 0 ) {
            int digits  = Collections.max(bookmarkLineNumbers).toString().length();
            Integer[] lineNumbersArr= bookmarkLineNumbers.toArray( new Integer[bookmarkLineNumbers.size()] );
            Arrays.sort(lineNumbersArr);

            int index   = 1;
            for( Integer curLineNum : lineNumbersArr ) {
                if( curLineNum > 0 ) {
                    int offsetLineStart = document.getLineStartOffset(curLineNum);
                    int offsetLineEnd   = document.getLineEndOffset(curLineNum);
                    String lineSummary  = getLineSummary(documentText.substring(offsetLineStart, offsetLineEnd));
                    bookmarkItems.add(index, UtilsString.makeMinLen(Integer.toString(curLineNum), digits) + ": " + lineSummary);
                    index++;
                }
            }

            referencesArr = bookmarkItems.toArray( new String[bookmarkItems.size()] );
        }

        return referencesArr;
    }

}