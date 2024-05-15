package config;

public class Config {
    // WebDriver configuration
    public static final String CHROME_DRIVER_PATH = "C:\\Users\\marlito.borrozo\\Desktop\\AUTOMATION\\JAVA_AUTOMATION\\demo\\resources\\chromedriver.exe";
    public static final String BASE_URL = "https://demoblaze.com";

    // Login credentials
    public static final String USERNAME = "jrbarrozo";
    public static final String PASSWORD = "password";

    // XPATH
    public static final String LOGIN_LINK = "//li/a[text()='Log in']";
    public static final String LOGIN_MODAL = "//*[@id='logInModal']";
    public static final String LOGIN_USERNAME = "//input[@id='loginusername']";
    public static final String LOGIN_PASSWORD = "//input[@id='loginpassword']";
    public static final String LOGIN_BUTTON = "//button[text()='Log in']";
    public static final String LOGOUT_LINK = "//li/a[text()='Log out']";
}
