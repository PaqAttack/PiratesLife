package paqattack.pirateslife.util;

import java.io.File;

public class Util {

    private Util() {
        // Block instantiation
    }

    public static String getEnvDir() {
        return System.getProperty("user.home") + File.separator
                + ".PiratesLife" + File.separator;
    }
}
