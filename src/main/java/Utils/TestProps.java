package Utils;

public class TestProps {
    public static void main(String[] args) {
        System.out.println("URL: " + PropertiesUtil.get("db.url"));
        System.out.println("User: " + PropertiesUtil.get("db.username"));
        System.out.println("Pass: " + PropertiesUtil.get("db.password"));
    }
}
