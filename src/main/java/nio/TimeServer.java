package nio;

public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;

        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(81);
        new Thread(multiplexerTimeServer,"multiplexerTimerServer").start();
    }
}
