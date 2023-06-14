package aio;

public class TimeServer {

    public static void main(String[] args) {

        int port = 9091;

        AsyncTimeServerHandler serverHandler = new AsyncTimeServerHandler(port);
        new Thread(serverHandler,"AsyncServer").start();

    }

}
