package com.akgcloud.java.application;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ExcelJXLReader {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {

            // Create a workbook object from the file at specified location.
            // Change the path of the file as per the location on your computer.
            Workbook wrk1 = Workbook.getWorkbook(new File("D:/ChartSample.xls"));

            // Obtain the reference to the first sheet in the workbook
            Sheet sheet1 = wrk1.getSheet(0);

            // Obtain reference to the Cell using getCell(int col, int row)
            // method of sheet
            Cell colArow1 = sheet1.getCell(0, 0);
            Cell colBrow1 = sheet1.getCell(1, 0);
            Cell colArow2 = sheet1.getCell(0, 1);

            // Read the contents of the Cell using getContents() method, which
            // will return
            // it as a String
            String str_colArow1 = colArow1.getContents();
            String str_colBrow1 = colBrow1.getContents();
            String str_colArow2 = colArow2.getContents();

            // Display the cell contents
            System.out.println("Contents of cell Col A Row 1: \"" + str_colArow1 + "\"");
            System.out.println("Contents of cell Col B Row 1: \"" + str_colBrow1 + "\"");
            System.out.println("Contents of cell Col A Row 2: \"" + str_colArow2 + "\"");

        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
