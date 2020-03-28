package com.akgcloud.java.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class GenerateLocationSqlFromCSVFile {

    private static int          TYPE          = 100;
    private static final String FILEPATH      = "C:/Users/Anil/Desktop/airport_timezone.csv";
    private static final String CREATE_FILE   = "C:/Users/Anil/Desktop/airport_timezone_query.sql";
    private static int          IATA_CODE_COL = 1;
    private static int          DT_ZONE_COL   = 2;
    private static Set<String>  iataSet       = new HashSet<String>();

    protected static void createLocationUpdateSql(StringBuilder content, String[] data, StringBuilder sql) {
        String iataCode = data[IATA_CODE_COL - 1];
        String zoneName = data[DT_ZONE_COL - 1];
        if (zoneName == null || zoneName.isEmpty() || zoneName.equals("\\N")) {
            return;
        }
        if (iataCode != null && !iataSet.contains(iataCode)) {
            sql.append("update location set dt_zone =\"").append(zoneName).append("\"");
            sql.append(" where type=").append(TYPE).append(" and iata_code=\"").append(iataCode).append("\";");

            content.append(sql.toString()).append("\n");
            iataSet.add(iataCode);
        }
    }

    public static void main(String[] args) {

        try {
            System.out.println("sql query writing started !");
            File file = new File(CREATE_FILE);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            BufferedReader br = new BufferedReader(new FileReader(FILEPATH));
            String line;
            boolean readLine = false;
            StringBuilder content = new StringBuilder(20024);
            while ((line = br.readLine()) != null) {
                if (readLine) {
                    String data[] = line.replaceAll("['|\"]", "").split(",", -1);
                    StringBuilder sql = new StringBuilder(1024);
                    createLocationUpdateSql(content, data, sql);
                    data = null;
                    sql = null;
                }
                readLine = true;
            }

            bw.write(content.toString());
            bw.close();
            System.out.println("sql query written successfully !");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
