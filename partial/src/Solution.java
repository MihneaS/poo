import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface Nic {

    void run(Packet p);
    void run(UdpPacket p);
    void run(TcpPacket p);
}
class WirelessNic implements Nic {
    public void  run(UdpPacket p) {
        System.out.println("WirelessNic sending UdpPacket");
    }

    public void run(TcpPacket p) {
        System.out.println("WirelessNic sending TcpPacket");
    }

    @Override
    public void run(Packet p) {
    }
}
class EthernetNic implements Nic {
    public void run(UdpPacket p) {
        System.out.println("EthernetNic sending UdpPacket");
    }

    public void run(TcpPacket p) {
        System.out.println("EthernetNic sending TcpPacket");
    }

    @Override
    public void run(Packet p) {
    }
}
class NUllNic implements Nic {

    @Override
    public void run(Packet p) {

    }

    @Override
    public void run(UdpPacket p) {

    }

    @Override
    public void run(TcpPacket p) {

    }
}
class UsbNic implements Nic {
    public void  run(UdpPacket p) {
        System.out.println("UsbNic sending UdpPacket");
    }

    public void run(TcpPacket p) {
        System.out.println("UsbNic sending TcpPacket");
    }

    @Override
    public void run(Packet p) {
    }
}

/*
 * DO NOT MODIFY THIS INTERFACE !
 */
interface Packet {
    void dispatch(Nic nic);
}

class UdpPacket implements Packet {
    public void dispatch(Nic nic) {
        nic.run(this);
    }

    public void dispatch(EthernetNic nic) {
        nic.run(this);
    }
    public void dispatch(WirelessNic nic) {
        nic.run(this);
    }
    public void dispatch(UsbNic nic) {
        nic.run(this);
    }
}


class TcpPacket implements Packet {
    public void dispatch(Nic nic) {
        nic.run(this);
    }
    public void dispatch(EthernetNic nic) {
        nic.run(this);
    }
    public void dispatch(WirelessNic nic) {
        nic.run(this);
    }
    public void dispatch(UsbNic nic) {
        nic.run(this);
    }
}
class NullPacket implements Packet {

    @Override
    public void dispatch(Nic nic) {

    }

    public void dispatch(EthernetNic nic) {

    }

    public void dispatch(WirelessNic nic) {

    }

    public void dispatch(UsbNic nic) {

    }
}

/*
 * DO NOT MODIFY THIS CLASS !
 */
class Client {
    void send (Nic[] nics, Packet[] packets) {
        for (int i = 0; i < packets.length; i++) {
            Packet p = packets[i];
            for (int j = 0; j < nics.length; j++) {
                p.dispatch(nics[j]);
            }
        }
    }
}

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* TODO:
         * Read from stdin, parse the input and instatiate Packets and Nic.
         */

        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        Nic[] nics = new Nic[n];
        for (int i = 0; i < n; ++i) {
            String input = in.next();
            if (input.equals("WirelessNic")) {
                nics[i] = new WirelessNic();
            } else if (input.equals("UsbNic")) {
                nics[i] = new UsbNic();
            } else if (input.equals("EthernetNic")){
                nics[i] = new EthernetNic();
            } else {
                nics[i] = new NUllNic();
            }

        }
        n = in.nextInt();
        Packet[] packets = new Packet[n];
        for (int i = 0; i < n; ++i) {
            String input = in.next();
            if (input.equals("UdbPacket")) {
                packets[i] = new UdpPacket();
            } else if (input.equals("TcpPacket")){
                packets[i] = new TcpPacket();
            } else {
                packets[i] = new NullPacket();
            }

        }



         /* TODO:
         * Instantiate Client and call send with the input that you previously obtained
         */
         Client client = new Client();
         client.send(nics, packets);
    }
}

