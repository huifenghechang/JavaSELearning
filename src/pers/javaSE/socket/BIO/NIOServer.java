package pers.javaSE.socket.BIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException{
        // 创建一个 selector 负责轮询是否有新的连接
        Selector serverSelector = Selector.open();
        // clientSelector 负责轮询是否有数据可读。
        Selector clientSelector = Selector.open();

        // NIO 模型中，通常有两个线程。每一个线程绑定一个轮询器Selector。
        new Thread(()->{
            try {
                // 创建一个serverSocketChannel,并向 serverSelector注册
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(8000));
                // 明确配置为非阻塞模式，因为在阻塞模式下，注册操作是不允许操作的。
                listenerChannel.configureBlocking(false);
                // 通过制定Key,告知selector，它关注的是新的链接请求
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true){
                    // 检测是否有新的连接，这里的1是指阻塞的时间为1ms
                    // Selector.select()是阻塞的，选择的一组键，其相应的通道已经为I/O操作准备就绪。
                    // Selector.select(100) 是非阻塞的，最多等待100ms.若还没有就绪，就返回0；
                    if(serverSelector.select(1)>0){
                        // 返回此通道已准备就绪的键集.
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();

                            if(key.isAcceptable()){
                                try{
                                    /* 每来一个请求，不需要创建线程，而是直接注册到clientSelector上;
                                     key.channel() 的作用： 获得对应的ServerSocketChannel;
                                     ServerSocketChannel.accept()
                                     通过ServerSocketChannel.accept()方法监听新进来的连接。
                                    当accept()方法返回的时候，它返回一个包含新进来的连接的SocketChannel
                                    */
                                    ServerSocketChannel  serverSocketChannel = (ServerSocketChannel) key.channel();
                                    SocketChannel clientChannel = serverSocketChannel.accept();
                                    clientChannel.configureBlocking(false);
                                    /*SelectionKey.OP_READ —— 读就绪事件
                                     表示通道中已经有了可读的数据，可以执行读操作了（通道目前有数据，可以进行读操作了）
                                     在此处，表示在clientSelector中，选择注册读就绪事件*/
                                    clientChannel.register(clientSelector,SelectionKey.OP_READ);
                                }finally {
                                    keyIterator.remove();
                                }
                            }

                            if(key.isReadable()){
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    // 批量读取以块为单位的数据
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();// 将buffer的写模式转化为读模式
                                    System.out.println(Charset.defaultCharset().newDecoder().
                                            decode(byteBuffer).toString());
                                }finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // 开启一个线程轮询 clientSelector 选择器。该选择器负责轮询事件。
        /*new Thread(()->{
            try {
                while (true){
                // 批量轮询那些链接的数据可读。这里的1指的是阻塞的时间为1ms
                    if(clientSelector.select(100)>0){
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isReadable()){
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    // 批量读取以块为单位的数据
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();// 将buffer的写模式转化为读模式
                                    System.out.println(Charset.defaultCharset().newDecoder().
                                            decode(byteBuffer).toString());
                                }finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("do something else !!!");
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }

        }).start();*/

    }
}
