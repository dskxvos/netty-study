package nio;

public class TimerServer {

    public static void main(String[] args) {
        int port = 8080;

        MultiplexerTimerServer multiplexerTimerServer = new MultiplexerTimerServer(81);
        new Thread(multiplexerTimerServer,"multiplexerTimerServer").start();
    }
}
