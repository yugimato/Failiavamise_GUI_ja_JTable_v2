//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Model {
    private String filename;
    private ArrayList<Filedata> filedata = new ArrayList();
    private String[] columnNames;

    public Model() {
    }

    public String[] getColumnNames() {
        return this.columnNames;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ArrayList<Filedata> getFiledata() {
        return this.filedata;
    }

    public void readFromFile() {
        this.filedata = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.filename), "UTF-8"));

            String line;
            try {
                for(int r = 0; (line = br.readLine()) != null; ++r) {
                    String[] parts;
                    if (r > 0) {
                        parts = line.split(";");
                        LocalDate birth = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        LocalDate death;
                        if (parts.length == 8) {
                            death = null;
                            this.filedata.add(new Filedata(parts[0], parts[1], parts[2], birth, death, parts[5], parts[6], parts[7]));
                        } else {
                            death = LocalDate.parse(parts[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            this.filedata.add(new Filedata(parts[0], parts[1], parts[2], birth, death, "", "", ""));
                        }
                    } else {
                        parts = line.split(";");
                        this.columnNames = new String[parts.length];
                        this.columnNames = parts;
                    }
                }
            } catch (Throwable var8) {
                try {
                    br.close();
                } catch (Throwable var7) {
                    var8.addSuppressed(var7);
                }

                throw var8;
            }

            br.close();
        } catch (IOException var9) {
            JOptionPane.showMessageDialog((Component)null, "Faili lugemisega probleeme");
        }

    }
}
