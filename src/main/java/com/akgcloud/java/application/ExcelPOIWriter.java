package com.akgcloud.java.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPOIWriter {

    public static void main(String args[]) throws Exception {
        generateExcelChart();
    }

    private static void generateExcelChart() throws Exception {

        int deface = 1;
        int rowNum = 7;
        // Load sample excel file
        // Workbook workbook = new XSSFWorkbook(OPCPackage.open(new
        // FileInputStream("D:/ChartSample.xlsx")));
        Workbook workbook = WorkbookFactory.create(new FileInputStream("D:/ChartSample.xls"));

        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sh = workbook.getSheetAt(0);
        String sheetName = sh.getSheetName();

        // create cell style for date format
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yyyy"));

        // Clear dummy values
//        sh.getRow(1).getCell(0).setCellValue("");
//        sh.getRow(1).getCell(1).setCellValue("");

        // Set headers for the data
//        sh.createRow(0).createCell(2).setCellValue("Date");
//        sh.getRow(0).createCell(3).setCellValue("Sales");

        Cell datecell = null;
        Cell salescell = null;

        // Populate C2 to C8 and D2 to D8 with chart data
        for (int i = 1; i <= 7; i++) {
            Row r = sh.getRow(i);
            if (r == null)
                r = sh.createRow(i);
            datecell = r.getCell(2);
            salescell = r.getCell(3);
            switch (i) {

            case 1:
                if (datecell == null) {
                    datecell = r.createCell(2);
                    datecell.setCellValue("1/1/2012");
                    datecell.setCellStyle(cellStyle);
                } else {

                    datecell.setCellValue("1/1/2012");
                    datecell.setCellStyle(cellStyle);
                }
                if (salescell == null)
                    r.createCell(3).setCellValue(2000);
                else
                    salescell.setCellValue(2000);
                break;
            case 2:
                if (datecell == null) {
                    datecell = r.createCell(2);
                    datecell.setCellValue("1/2/2012");
                    datecell.setCellStyle(cellStyle);
                } else {
                    datecell.setCellValue("1/2/2012");
                    datecell.setCellStyle(cellStyle);
                }
                if (salescell == null)
                    r.createCell(3).setCellValue(1000);
                else
                    salescell.setCellValue(1000);
                break;
            case 3:
                if (datecell == null) {
                    datecell = r.createCell(2);
                    datecell.setCellValue("1/3/2012");
                    datecell.setCellStyle(cellStyle);
                } else {
                    datecell.setCellValue("1/3/2012");
                    datecell.setCellStyle(cellStyle);
                }

                if (salescell == null)
                    r.createCell(3).setCellValue(4000);
                else
                    salescell.setCellValue(4000);
                break;
            case 4:
                if (datecell == null) {
                    datecell = r.createCell(2);
                    datecell.setCellValue("1/4/2012");
                    datecell.setCellStyle(cellStyle);
                } else {
                    datecell.setCellValue("1/4/2012");
                    datecell.setCellStyle(cellStyle);
                }
                if (salescell == null)
                    r.createCell(3).setCellValue(2500);
                else
                    salescell.setCellValue(2500);
                break;
            case 5:
                if (datecell == null) {
                    datecell = r.createCell(2);

                    datecell.setCellValue("1/5/2012");
                    datecell.setCellStyle(cellStyle);
                } else {

                    datecell.setCellValue("1/5/2012");
                    datecell.setCellStyle(cellStyle);
                }
                if (salescell == null)
                    r.createCell(3).setCellValue(3000);
                else
                    salescell.setCellValue(3000);
                break;
            case 6:
                if (datecell == null) {
                    datecell = r.createCell(2);

                    datecell.setCellValue("1/6/2012");
                    datecell.setCellStyle(cellStyle);
                } else {

                    datecell.setCellValue("1/6/2012");
                    datecell.setCellStyle(cellStyle);
                }
                if (salescell == null)
                    r.createCell(3).setCellValue(4000);
                else
                    salescell.setCellValue(4000);
                break;
            case 7:
                if (datecell == null) {
                    datecell = r.createCell(2);
                    datecell.setCellStyle(cellStyle);
                    datecell.setCellValue("1/8/2012");
                } else {

                    datecell.setCellValue("1/8/2012");
                    datecell.setCellStyle(cellStyle);
                }
                if (salescell == null)
                    r.createCell(3).setCellValue(5000);
                else
                    salescell.setCellValue(5000);
                break;

            default:
                System.out.println("Invalid Input");
                break;
            }

        }

        // Search for named range
        /*Name rangeCell = workbook.getName("Date");
        // Set new range for named range
        String reference = sheetName + "!$C$" + (deface + 1) + ":$C$" + (rowNum + deface);
        // Assigns range value to named range
        rangeCell.setRefersToFormula(reference);

        rangeCell = workbook.getName("Sales");
        reference = sheetName + "!$D$" + (deface + 1) + ":$D$" + (rowNum + deface);
        rangeCell.setRefersToFormula(reference);*/

        FileOutputStream f = new FileOutputStream("D:/Monthly_Sales5.xls");
        workbook.write(f);
        f.close();

        System.out.println("Number Of Sheets" + workbook.getNumberOfSheets());
        Sheet s = workbook.getSheetAt(0);
        System.out.println("Number Of Rows:" + s.getLastRowNum());
    }
}
