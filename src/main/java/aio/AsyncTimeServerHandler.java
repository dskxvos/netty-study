package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable{

    private int port;

    CountDownLatch countDownLatch;

    AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncTimeServerHandler(int port)  {
        this.port = port;
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
        }catch (IOException e){

        }

    }

    @Override
    public void run() {

    }
}
