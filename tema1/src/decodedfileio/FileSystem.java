//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package decodedfileio;

import decodedfileio.implementations.FileReader;
import decodedfileio.implementations.FileWriter;
import decodedfileio.interfaces.IReader;
import decodedfileio.interfaces.IWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class FileSystem implements IReader, IWriter {
    private FileReader fileReader;
    private FileWriter fileWriter;

    public FileSystem(String inputFile, String outputFile) throws IOException {
        this.initReader(inputFile);
        this.initWriter(outputFile);
    }

    private void initReader(String inputFile) throws FileNotFoundException {
        this.fileReader = new FileReader(inputFile);
    }

    private void initWriter(String outputFile) throws IOException {
        this.fileWriter = new FileWriter(outputFile);
    }

    public boolean nextBool() throws IOException {
        return this.fileReader.nextBool();
    }

    public int nextInt() throws IOException {
        return this.fileReader.nextInt();
    }

    public long nextLong() throws IOException {
        return this.fileReader.nextLong();
    }

    public float nextFloat() throws IOException {
        return this.fileReader.nextFloat();
    }

    public double nextDouble() throws IOException {
        return this.fileReader.nextDouble();
    }

    public String nextWord() throws IOException {
        return this.fileReader.nextWord();
    }

    private void closeReader() throws IOException {
        this.fileReader.close();
    }

    public void writeCharacter(char variableToWrite) throws IOException {
        this.fileWriter.writeCharacter(variableToWrite);
    }

    public void writeBool(boolean variableToWrite) throws IOException {
        this.fileWriter.writeBool(variableToWrite);
    }

    public void writeInt(int variableToWrite) throws IOException {
        this.fileWriter.writeInt(variableToWrite);
    }

    public void writeLong(long variableToWrite) throws IOException {
        this.fileWriter.writeLong(variableToWrite);
    }

    public void writeFloat(float variableToWrite) throws IOException {
        this.fileWriter.writeFloat(variableToWrite);
    }

    public void writeDouble(double variableToWrite) throws IOException {
        this.fileWriter.writeDouble(variableToWrite);
    }

    public void writeWord(String variableToWrite) throws IOException {
        this.fileWriter.writeWord(variableToWrite);
    }

    public void writeNewLine() throws IOException {
        this.fileWriter.writeNewLine();
    }

    private void closeWriter() throws IOException {
        this.fileWriter.close();
    }

    public void close() throws IOException {
        this.closeReader();
        this.closeWriter();
    }
}
