/*
 * POO - tema2
 * SERBAN Mihnea
 * 321CA
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package decodedfileio.implementations;

import decodedfileio.interfaces.IReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public final class FileReader implements IReader {
    private static final String DELIMITER = " ";
    private java.io.FileReader fileReader;
    private BufferedReader bufferedReader;
    private String[] words;
    private int i;

    public FileReader(final String filePath) throws FileNotFoundException {
        this.fileReader = new java.io.FileReader(filePath);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    private void readLine() throws IOException {
        words = bufferedReader.readLine().split(DELIMITER);
        i = 0;
    }

    private String nextToken() throws IOException {
        if (words == null || i >= words.length) {
            readLine();
        }

        return words[i++];
    }

    public boolean nextBool() throws IOException {
        return Boolean.parseBoolean(nextToken());
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public float nextFloat() throws IOException {
        return Float.parseFloat(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public String nextWord() throws IOException {
        return nextToken();
    }

    public String[] restOfTheLine() {
        String[] restOfTheWords = Arrays.copyOfRange(words, i, words.length);
        words = new String[0];
        return restOfTheWords;
    }

    public void close() throws IOException {
        this.bufferedReader.close();
        this.fileReader.close();
    }
}

