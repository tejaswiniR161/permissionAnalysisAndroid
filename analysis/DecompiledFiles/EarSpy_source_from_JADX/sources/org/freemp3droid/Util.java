package org.freemp3droid;

import android.content.Context;
import android.os.Environment;
import com.microphone.earspy.MP3Recording;
import com.microphone.earspy.MicrophoneActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Util {
    public static final String DATE_STRING = "yyyy-MM-dd-HH_mm_ss";

    public static String createPath(String fileType, String suffix, Context ctx) {
        long dateTaken = System.currentTimeMillis();
        File filesDir = getStorageDir(ctx);
        String filesDirPath = filesDir.getAbsolutePath();
        filesDir.mkdirs();
        return filesDirPath + "/" + new SimpleDateFormat(DATE_STRING).format(new Date(dateTaken)) + fileType + suffix;
    }

    public static String createMP3File(String orig, Context ctx) {
        return getStorageDir(ctx).getAbsolutePath() + "/" + MP3Recording.mp3Filename + ".mp3";
    }

    public static File getStorageDir(Context ctx) {
        File ret = new File(Environment.getExternalStorageDirectory().toString() + "/" + MicrophoneActivity.AUDIO_RECORDER_FOLDER);
        if (!ret.exists()) {
            ret.mkdirs();
        }
        return ret;
    }

    public static ArrayList<File> listFiles(Context ctx) {
        ArrayList<File> ret = new ArrayList<>();
        for (File f : getStorageDir(ctx).listFiles()) {
            if (f.getAbsolutePath().endsWith(".mp3")) {
                ret.add(f);
            }
        }
        return ret;
    }
}
