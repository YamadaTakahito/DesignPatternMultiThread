package DesignPatternMultiThread.chap9.practice;

import java.io.DataInputStream;
import java.io.EOFException;
import java.net.URL;

public class SynContentImpl implements Content {
    private byte[] contentBytes;

    public SynContentImpl(String urlstr) {
        System.out.println(Thread.currentThread().getName() + ": Getting " + urlstr);

        try {
            var url = new URL(urlstr);
            var in = new DataInputStream(url.openStream());
            var buffer = new byte[1];
            int idx = 0;

            try {
                while (true) {
                    var c = in.readUnsignedByte();
                    if (buffer.length <= idx) {
                        var largerbuffer = new byte[buffer.length * 2];
                        System.arraycopy(buffer, 0, largerbuffer, 0, idx);
                        buffer = largerbuffer;
//                        System.out.println("Enlarging buffer to " + buffer.length);
                    }
                    buffer[idx++] = (byte) c;
                    System.out.println("Getting " + idx + " bytes from " + urlstr);
                }
            } catch (EOFException ignored) {
            } finally {
                in.close();
            }
            contentBytes = new byte[idx];
            System.arraycopy(buffer, 0, contentBytes, 0, idx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getBytes() {
        return contentBytes;
    }
}
