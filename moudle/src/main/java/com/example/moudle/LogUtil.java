package com.example.moudle;

import android.content.Context;
import android.widget.Toast;

public class LogUtil {
    private static boolean sDebug = true;

    private static final int CURRENT_STACK = 5;
    private static final int PREVIOUS_STACK = 4;

    /**
     * verbose log.
     * @param msg Log message
     */
    public static void verbose(String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            android.util.Log.v(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * verbose log.
     * @param tag Log Tag
     * @param msg Log message
     */
    public static void verbose(String tag, String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            infos[0] = tag;
            android.util.Log.v(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * debug log.
     * @param msg Log message
     */
    public static void debug(String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            android.util.Log.d(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }
    public static void toast(Context context) {
        Toast.makeText(context,"我是從 SDK 庫裡來的！",Toast.LENGTH_LONG).show();
    }

    /**
     * debug log.
     * @param tag Log Tag
     * @param msg Log message
     */
    public static void debug(String tag, String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            infos[0] = tag;
            android.util.Log.d(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * info log.
     * @param msg Log message
     */
    public static void info(String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            android.util.Log.i(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * info log.
     * @param tag Log Tag
     * @param msg Log message
     */
    public static void info(String tag, String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            infos[0] = tag;
            android.util.Log.i(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * warning log.
     * @param msg Log message
     */
    public static void warning(String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            android.util.Log.w(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * warning log.
     * @param tag Log Tag
     * @param msg Log message
     */
    public static void warning(String tag, String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            infos[0] = tag;
            android.util.Log.w(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * error log.
     * @param msg Log message
     */
    public static void error(String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            android.util.Log.e(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    /**
     * error log.
     * @param tag Log Tag
     * @param msg Log message
     */
    public static void error(String tag, String msg) {
        if (sDebug) {
            String[] infos = getAutoJumpLogInfos();
            infos[0] = tag;
            android.util.Log.e(infos[0], msg + " : " + infos[1] + infos[2]);
        }
    }

    private static String[] getAutoJumpLogInfos() {
        String[] infos = new String[]{"", "", ""};
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements.length < CURRENT_STACK) {
            return infos;
        } else {
            infos[0] = elements[PREVIOUS_STACK].getClassName().substring(
                    elements[PREVIOUS_STACK].getClassName().lastIndexOf(".") + 1);
            infos[1] = elements[PREVIOUS_STACK].getMethodName() + "()";
            infos[2] = " at (" + elements[PREVIOUS_STACK].getClassName() + ".java:"
                    + elements[PREVIOUS_STACK].getLineNumber() + ")";
            return infos;
        }
    }

}
