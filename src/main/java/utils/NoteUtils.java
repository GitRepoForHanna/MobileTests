package utils;

import org.apache.commons.lang3.StringUtils;

public class NoteUtils {

    public static String getDifferenceBetweenNoteData(String currentDataStr, String newDataStr) {
        String resultStr = StringUtils.remove(newDataStr.toLowerCase(), currentDataStr.toLowerCase());
        return resultStr.substring(0,1).toUpperCase() + resultStr.substring(1);
    }
}
