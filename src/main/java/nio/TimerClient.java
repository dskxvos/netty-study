package nio;

public class TimerClient {
    public static void main(String[] args) {
        TimerClientHandler timerClientHandler = new TimerClientHandler("127.0.0.1",81);
        new Thread(timerClientHandler,"timerClient").start();
    }
}
