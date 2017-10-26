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

    public FileWriter(String filePath) throws IOException {
        this.fileWriter = new java.io.FileWriter(filePath);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);
    }

    public void writeCharacter(char variableToWrite) throws IOException {
        this.bufferedWriter.write(variableToWrite);
    }

    public void writeBool(boolean variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeInt(int variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeLong(long variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeFloat(float variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeDouble(double variableToWrite) throws IOException {
        this.bufferedWriter.write(String.valueOf(variableToWrite));
    }

    public void writeWord(String variableToWrite) throws IOException {
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

