package logic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;

/**
 * Created by jeppe on 21-11-2017.
 */
public class PacketLogic {
    public String readMsg(DatagramPacket packet){
        try {
            byte[] buf = packet.getData();

            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            InputStreamReader isr = new InputStreamReader(bais);
            BufferedReader br = new BufferedReader(isr);
            String msg = br.readLine();
            return msg;
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Can't reach packet";
    }
}
