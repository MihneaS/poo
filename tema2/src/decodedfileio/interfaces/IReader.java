/*
 * POO - tema2
 * SERBAN Mihnea
 * 321CA
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package decodedfileio.interfaces;

import java.io.IOException;

public interface IReader {
    boolean nextBool() throws IOException;

    int nextInt() throws IOException;

    long nextLong() throws IOException;

    float nextFloat() throws IOException;

    double nextDouble() throws IOException;

    String nextWord() throws IOException;

    String[] restOfTheLine();

    void close() throws IOException;
}

