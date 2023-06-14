package aio;

public class TimeClient {

    public static void main(String[] args) {
        new Thread(new AsyncTimeClientHandler("127.0.0.1",9091),"TimeClient").start();
    }
}
