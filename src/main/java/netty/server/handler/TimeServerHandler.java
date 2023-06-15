package netty.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {


    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        final ByteBuf time = ctx.alloc().buffer(4);
//        System.out.println((int) (System.currentTimeMillis()/1000L+2208988800L));
//        time.writeInt((int) (System.currentTimeMillis()/1000L+2208988800L));
//        final ChannelFuture future = ctx.writeAndFlush(time);
//        future.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture f) throws Exception {
//                assert future == f;
//                ctx.close();
//            }
//        });

        String currentTime = new Date(System.currentTimeMillis()).toString();
        currentTime = currentTime+System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, StandardCharsets.UTF_8);
//        body = body.substring(0,req.length-System.getProperty("line.separator").length());
        String body = (String) msg;
        System.out.println("The time server receive order: "+body+" the count is "+ ++count );
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
        currentTime = currentTime+System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);




    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
