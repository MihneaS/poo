/*
 * POO - tema1
 * SERBAN Mihnea
 * 321CA
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package decodedfileio.implementations;

import decodedfileio.interfaces.IWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public final class FileWriter implements IWriter {
    private java.io.FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    public FileWriter(final String filePath) throws IOException {
        this.fileWriter = new java.io.FileWriter(filePath);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);
    }

    public void writeCharacter(final char variableToWrite) throws IOException {
        this.bufferedWriter.write(variableToWrite);
    }

    public void writeBool(final boolean variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeInt(final int variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeLong(final long variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeFloat(final float variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeDouble(final double variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeWord(final String variableToWrite) throws IOException {
        this.bufferedWriter.write(variableToWrite);
    }

    public void writeNewLine() throws IOException {
        this.bufferedWriter.newLine();
    }

    public void close() throws IOException {
        this.bufferedWriter.close();
        this.fileWriter.close();
    }
}

