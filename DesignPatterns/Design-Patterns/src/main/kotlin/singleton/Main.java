package singleton;

public class Main {
    public static void main(String[] args){
        Sun sun = Sun.getInstance();
        sun.sunRise();
        sun.sunSet();
    }
}
