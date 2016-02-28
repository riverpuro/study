package bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileDisplayImpl extends DisplayImpl {
    private String filename;

    public TextFileDisplayImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public void rawPrint() {
        try {
            BufferedReader reader =  Files.newBufferedReader(Paths.get(filename), Charset.defaultCharset());
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawOpen() {
        // nop
    }

    @Override
    public void rawClose() {
        // nop
    }
}
