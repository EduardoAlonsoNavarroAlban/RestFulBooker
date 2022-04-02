package com.continousTesting.base.Utils;



import java.io.FileWriter;
import java.io.PrintWriter;

public class DataFileWriter {

    public static void Writer(String line, String filename) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {

            fileWriter = new FileWriter("src/main/java/Files/" + filename,true);
            printWriter = new PrintWriter(fileWriter,true);
            String lineSeparator = System.getProperty("line.separator");
            printWriter.print(line);
            printWriter.write(lineSeparator);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


}
