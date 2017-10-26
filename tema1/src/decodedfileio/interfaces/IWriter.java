//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package decodedfileio.interfaces;

import java.io.IOException;

public interface IWriter {
    void writeCharacter(char var1) throws IOException;

    void writeBool(boolean var1) throws IOException;

    void writeInt(int var1) throws IOException;

    void writeLong(long var1) throws IOException;

    void writeFloat(float var1) throws IOException;

    void writeDouble(double var1) throws IOException;

    void writeWord(String var1) throws IOException;

    void writeNewLine() throws IOException;

    void close() throws IOException;
}

