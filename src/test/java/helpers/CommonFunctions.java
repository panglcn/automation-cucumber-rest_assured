package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class CommonFunctions {

    public static String getRandomString(int length) {
        char[] chars = "QWERTYUIPASDFGHJKLZXCVBNM".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output.trim();
    }


    public static String getCurrentDate(String format) {
        String date;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat(format);
        date = formater.format(calendar.getTime());
        return date;
    }

    public static String convertDateWithoutDelimiter(String date) {
        String newValue;
        if(date.contains("/")){
            newValue = date.replaceAll("/", "");
        }else{
            newValue = date.replaceAll("-", "");
        }

        return newValue;
    }


    public static String removeSpecialCharacter(String text){
        Pattern pt = Pattern.compile("[£$&+,:;=?@#|'<>.^*()%!]");
        Matcher match= pt.matcher(text);
        while(match.find())
        {
            String s= match.group();
            text=text.replaceAll("\\"+s, "");
        }
        return text;
    }
}
