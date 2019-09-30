package utils;

import org.apache.commons.lang3.StringUtils;

public class NoteUtils {

    public static String getDifferenceBetweenNoteData(String currentTitle, String newTitle) {
        String resultStr = StringUtils.remove(newTitle.toLowerCase(), currentTitle.toLowerCase());
        return resultStr.substring(0,1).toUpperCase() + resultStr.substring(1);
    }
}
