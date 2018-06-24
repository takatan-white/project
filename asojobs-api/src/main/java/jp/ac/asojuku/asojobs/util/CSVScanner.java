package jp.ac.asojuku.asojobs.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVScanner {

    Scanner scan_;

    // Constructor
    public CSVScanner(File source) {
        try {
            this.scan_ = new Scanner(source);
        } catch (FileNotFoundException fnex) {
            fnex.printStackTrace();
        }
    }

    public CSVScanner(String source) {
        this.scan_ = new Scanner(source);
    }

    public CSVScanner(InputStream source) {
        this.scan_ = new Scanner(source);
    }

    public ArrayList<String[]> read() {
        ArrayList<String[]> csv_list = new ArrayList<String[]>();
        String[] line_str_arr;
        
        synchronized (this.scan_) {
            while (this.scan_.hasNext()) {
                line_str_arr = this.scan_.nextLine().split(",");
                csv_list.add(line_str_arr);
            }
        }
        return csv_list;
    }

    public void close() {
        this.scan_.close();
    }

}