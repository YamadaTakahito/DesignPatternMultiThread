package DesignPatternMultiThread.chap9.practice;

import java.io.DataInputStream;
import java.io.EOFException;
import java.net.URL;

public class FetchingData {
    private byte[] content;

    public FetchingData(String urlStr) {
        try {
            var url = new URL(urlStr);
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
                    System.out.println("Getting " + idx + " bytes from " + urlStr);
                }
            } catch (EOFException ignored) {
            } finally {
                in.close();
            }
            content = new byte[idx];
            System.arraycopy(buffer, 0, content, 0, idx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getContent() {
        return this.content;
    }
}
