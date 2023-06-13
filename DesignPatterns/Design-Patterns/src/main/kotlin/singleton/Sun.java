package singleton;

public class Sun {
    private static Sun instance;

    private Sun() {
    }

    // Method to get a single instance
    public static Sun getInstance() {
        if (instance == null) {
            synchronized (Sun.class) {
                if (instance == null) {
                    instance = new Sun();
                }
            }
        }
        return instance;
    }

    public void sunRise() {
        System.out.println("Sunrise");
    }

    public void sunSet(){
        System.out.println("Sunset");
    }
}