package nio;

public class TimeClient {
    public static void main(String[] args) {
        TimeClientHandler timeClientHandler = new TimeClientHandler("127.0.0.1",81);
        new Thread(timeClientHandler,"timerClient").start();
    }
}
