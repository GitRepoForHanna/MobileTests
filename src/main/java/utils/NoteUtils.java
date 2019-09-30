package utils;

import org.apache.commons.lang3.StringUtils;

public class NoteUtils {

    public static String updateNoteData(String currentTitle, String newTitle) {
        return StringUtils.remove(newTitle, currentTitle);
    }
}
