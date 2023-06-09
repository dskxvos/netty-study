package aio;

public class TimeServer {

    public static void main(String[] args) {

        int port = 8080;

        AsyncTimeServerHandler serverHandler = new AsyncTimeServerHandler(port);
        new Thread(serverHandler,"AsyncServer").start();

    }

}
