package paqattack.pirateslife.util;

import java.io.*;
import java.util.*;

public class LoadableProperties extends HashMap<String, Object> {
    public LoadableProperties() {
        super();
    }
    String charSet = "UTF-8";

    /**
     * Load the properties from the config file.
     * @param inStream The input stream to read from.
     * @throws IOException If an error occurs while reading from the stream.
     */
    public void load(InputStream inStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream, charSet));

        String aKey;
        String aValue;
        int index;
        String line = getNextLine(in);
        while (line != null) {
            line = line.trim();
            if (isValid(line)) {
                index = line.indexOf("=");
                aKey = line.substring(0, index).trim();
                aValue = line.substring(index + 1).trim();
                put(aKey.toUpperCase(), aValue);
            }
            line = getNextLine(in);
        }
    }

    /**
     * Save the properties to the config file.
     * @param outStream The output stream to write to.
     * @param sorted True if the properties should be sorted, false otherwise.
     * @throws IOException If an error occurs while writing to the stream.
     */
    public void save(OutputStream outStream, boolean sorted) throws IOException {
        if (!sorted) {
            save(outStream);
            return;
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outStream, charSet));
        String aKey;
        Object aValue;
        TreeMap<String, Object> tm = new TreeMap<>(this);
        for (String s : tm.keySet()) {
            aKey = s;
            aValue = get(aKey);
            out.write(aKey + " = " + aValue);
            out.newLine();
        }
        out.flush();
        out.close();
    }

    /**
     * Save the properties to the config file.
     * @param outStream The output stream to write to.
     * @throws IOException If an error occurs while writing to the stream.
     */
    public void save(OutputStream outStream) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outStream, charSet));
        String aKey;
        Object aValue;
        for (String e : keySet()) {
            aKey = e;
            aValue = get(aKey);
            out.write(aKey + " = " + aValue);
            out.newLine();
        }
        out.flush();
        out.close();
    }

    /**
     * Verifies the configuration file is valid
     * @param str The string to verify
     * @return True if the string is valid, false otherwise.
     */
    private boolean isValid(String str) {
        if (str == null)
            return false;
        if (!str.isEmpty()) {
            if (str.startsWith("#") || str.startsWith("!")) {
                return false;
            }
        } else {
            return false;
        }

        int index = str.indexOf("=");
        // Ensures the string is in the format key=value
        return index > 0 && str.length() > index;
    }

    /**
     * Get the next line from the buffered reader.
     * @param br The buffered reader to read from.
     * @return The next line from the buffered reader.
     */
    private String getNextLine(BufferedReader br) {
        try {
            return br.readLine();
        } catch (Exception e) {
            return null;
        }
    }
}
