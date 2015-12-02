package Resources;

/**
 * Created by Dmytro_Moskalenko2 on 11/10/2015.
 */
public class ConfigValues {
    public static final int SHORT_DELAY_MSEC = 100;
    public static final int LONG_DELAY_SEC = 5;
    public static final int DEFAULT_COOLDOWN_FOR_DRIVER_MSEC = 20;
    public static final String BROWSER_TYPE = "Chrome";

    public static  final String SELENIUM_HUB_URL ="http://localhost:4444/wd/hub";
    public static final String TARGET_SERVER_URL = "http://localhost:8080/sdc.samples.selenium";

/*    @BeforeClass
    public static void initEnvironment() {
        SELENIUM_HUB_URL = getConfigurationProperty(
                "SELENIUM_HUB_URL",
                "test.selenium.hub.url",
                "http://localhost:4444/wd/hub");

        TARGET_SERVER_URL = getConfigurationProperty(
                "TARGET_SERVER_URL",
                "test.target.server.url",
                "http://localhost:8080/sdc.samples.selenium");
    }

    private static String getConfigurationProperty(
            String envKey, String sysKey, String defValue) {
        String retValue = defValue;
        String envValue = System.getenv(envKey);
        String sysValue = System.getProperty(sysKey);
        // system property prevails over environment variable
        if (sysValue != null) {
            retValue = sysValue;
        } else if (envValue != null) {
            retValue = envValue;
        }
        return retValue;
    }*/
}