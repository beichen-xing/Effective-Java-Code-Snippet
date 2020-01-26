import java.io.*;

public class rule09 {

    static void copy(String src, String dst) throws IOException {
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[10];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}
