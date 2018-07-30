package helpers;

import org.apache.log4j.Logger;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class Log {

    private static Logger Log = Logger.getLogger(Log.class.getName());

    public static void info(String message)
    {
        Log.info(message);
    }
}
