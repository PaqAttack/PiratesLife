package paqattack.pirateslife.util;

import java.io.*;

public class Configuration {

    static LoadableProperties config = new LoadableProperties();
    static String configPath = getConfigPath();

    static {
        try {
            config.load(new FileInputStream(configPath));
            System.out.println("Loaded from " + configPath);
        } catch (Exception e) {
            File f = new File(configPath);
            new File(f.getParent()).mkdirs();
            /*DEBUG*/
            System.out.println("New configuration created: " + configPath);
            try {
                config.load(Configuration.class.getResourceAsStream("/util/PiratesLife.default.properties"));
                saveConfig();
            } catch (Exception e2) {
                System.out.println("Failed to load default configuration from resources.");
                config = null;
            }
        }
    }

    /**
     * Get the configuration path.
     * @return The configuration path.
     */
    static String getConfigPath() {
        String p = Util.getEnvDir() + "PiratesLife.properties";
        File configFile = new File(p);

        if (configFile.exists()) {
            return p;
        } else {
            // If it doesn't exist, make it.
            System.out.println(p + " not found.");
            try {
                // Ensure the parent directory exists
                File parentDir = configFile.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    if (parentDir.mkdirs()) {
                        System.out.println("Parent directory created: " + parentDir.getAbsolutePath());
                    } else {
                        System.out.println("Failed to create parent directory: " + parentDir.getAbsolutePath());
                    }
                }

                if (configFile.createNewFile()) {
                    System.out.println("New configuration created: " + p);

                    try (FileWriter writer = new FileWriter(configFile)) {
                        writer.write(getDefaultConfig());
                    }

                    return configFile.getAbsolutePath();
                } else {
                    System.out.println("Failed to create a new configuration file: " + p);
                }
            } catch (IOException e) {
                System.out.println("Error creating new configuration file. " + e.getMessage());
            }
        }
        return null;
    }


    /**
     * Save the configuration.
     */
    public static void saveConfig() {
        try {
            config.save(new FileOutputStream(configPath));
        } catch (Exception e) {
            System.out.println("Failed to save a configuration file:<br>" + configPath);
        }
    }

    /**
     * Get a configuration value.
     * @param key The key to get the value for.
     * @return The value for the key.
     */
    public static Object get(String key) {
        if ((config.get(key)) == null) {
            return "";
        }
        return config.get(key);
    }

    public static double getDouble(String key) {
        return Double.parseDouble((String) get(key));
    }

    /**
     * Put a configuration value.
     * @param key The key to put the value for.
     * @param value The value to put.
     */
    public static void put(String key, Object value) {
        config.put(key, value);
    }

    private static String getDefaultConfig() {
        return "VERSION=0.1A\n" +
                "DEFAULT_CONFIG=1\n";
    }
}
