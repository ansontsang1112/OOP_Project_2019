package com.gordon.main;

import java.io.*;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;


public class DisplayRecordGUI {
        public static void DisplayRecordGUIEXE() {
                try {
                        String datafile = "G42LoginRecord.csv";
                        FileReader fin = new FileReader(datafile);
                        DefaultTableModel m = createTableModel(fin, null);
                        JFrame f = new JFrame();
                        f.getContentPane().add(new JScrollPane(new JTable(m)));
                        f.setSize(800, 600);
                        f.setVisible(true);

                        FileWriter out = new FileWriter("G42LoginRecord.csv");
                        defaultTableModelToStream(m, out);
                        out.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public static void defaultTableModelToStream(DefaultTableModel dtm, Writer out) throws IOException {
                final String LINE_SEP = System.getProperty("line.separator");
                int numCols = dtm.getColumnCount();
                int numRows = dtm.getRowCount();

                // Write headers
                String sep = "";

                for (int i = 0; i < numCols; i++) {
                        out.write(sep);
                        out.write(dtm.getColumnName(i));
                        sep = ",";
                }

                out.write(LINE_SEP);

                for (int r = 0; r < numRows; r++) {
                        sep = "";

                        for (int c = 0; c < numCols; c++) {
                                out.write(sep);
                                out.write(dtm.getValueAt(r, c).toString());
                                sep = ",";
                        }

                        out.write(LINE_SEP);
                }
        }
        public static DefaultTableModel createTableModel(Reader in, Vector<Object> headers) {
                DefaultTableModel model = null;
                Scanner s = null;
                try {
                        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
                        s = new Scanner(in);

                        while (s.hasNextLine()) {
                                rows.add(new Vector<Object>(Arrays.asList(s.nextLine()
                                        .split("\\s*,\\s*",
                                                -1))));
                        }

                        if (headers == null) {
                                headers = rows.remove(0);
                                model = new DefaultTableModel(rows, headers);
                        } else {
                                model = new DefaultTableModel(rows, headers);
                        }

                        return model;
                } finally {
                        s.close();
                }
        }
}
