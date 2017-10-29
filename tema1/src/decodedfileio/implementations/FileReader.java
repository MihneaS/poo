//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package decodedfileio.implementations;

import decodedfileio.interfaces.IReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public final class FileReader implements IReader {
    private static final String DELIMITER = " ";
    private java.io.FileReader fileReader;
    private BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    public FileReader(final String filePath) throws FileNotFoundException {
        this.fileReader = new java.io.FileReader(filePath);
        this.bufferedReader = new BufferedReader(this.fileReader);
    }

    private void readLine() throws IOException {
        this.stringTokenizer = new StringTokenizer(this.bufferedReader.readLine(), " ");
    }

    private String nextToken() throws IOException {
        if (this.stringTokenizer == null || !this.stringTokenizer.hasMoreTokens()) {
            this.readLine();
        }

        return this.stringTokenizer.nextToken();
    }

    public boolean nextBool() throws IOException {
        return Boolean.parseBoolean(this.nextToken());
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(this.nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(this.nextToken());
    }

    public float nextFloat() throws IOException {
        return Float.parseFloat(this.nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(this.nextToken());
    }

    public String nextWord() throws IOException {
        return this.nextToken();
    }

    public void close() throws IOException {
        this.bufferedReader.close();
        this.fileReader.close();
    }
}

