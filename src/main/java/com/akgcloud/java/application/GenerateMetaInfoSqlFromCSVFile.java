/**
 * 
 */
package com.akgcloud.java.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GenerateMetaInfoSqlFromCSVFile {

    // vapt-kuoni airtel : 82
    private static int          RESELLER_ID        = 76679;
    private static String       INFO_TYPE          = "B";
    private static int          IS_ENABLED         = 1;
    private static final String FILEPATH           = "D:/Zillious/work/Airtel/KUONIDUMP_6July.csv";
    private static final String CREATE_FILE        = "D:/Zillious/work/Airtel/band_query.sql";
    private static int          META_INFO_CODE_COL = 1;
    private static int          META_INFO_NAME_COL = 14;
    private static Set<String>  metaInfoSet        = new HashSet<String>();

    /**
     * @param args
     */

    protected static int createMetaInfoSqlWithForeignCodeAndName(int i, StringBuilder content, String[] data,
            StringBuilder sql) {
        String metaInfoCd = data[META_INFO_CODE_COL - 1];
        String metaInfoNm = data[META_INFO_NAME_COL - 1];
        if (!metaInfoSet.contains(metaInfoNm)) {
            sql.append("insert into user_subuser_meta_info (reseller_id, info_type, code, foreign_code, name, is_enabled ) values (");
            sql.append(RESELLER_ID).append(",\"").append(INFO_TYPE).append("\",").append(i++).append(",\"")
                    .append(metaInfoCd).append("\"").append(",\"").append(metaInfoNm).append("\",").append(IS_ENABLED)
                    .append(");");
            content.append(sql.toString()).append("\n");
            metaInfoSet.add(metaInfoNm);
        }
        return i;
    }

    protected static int createMetaInfoSqlWithName(int i, StringBuilder content, String[] data, StringBuilder sql) {
        String metaInfoNm = data[META_INFO_NAME_COL - 1];
        if (!metaInfoSet.contains(metaInfoNm)) {
            sql.append("insert into user_subuser_meta_info (reseller_id, info_type, code, name, is_enabled ) values (");
            sql.append(RESELLER_ID).append(",\"").append(INFO_TYPE).append("\",").append(i++).append(",\"")
                    .append(metaInfoNm).append("\",").append(IS_ENABLED).append(");");
            content.append(sql.toString()).append("\n");
            metaInfoSet.add(metaInfoNm);
        }
        return i;
    }

    protected static int createMetaInfoSqlWithNameWithSearchCriteria(int i, StringBuilder content, String[] data,
            StringBuilder sql) {
        String metaInfoNm = data[META_INFO_NAME_COL - 1];
        if (!metaInfoSet.contains(metaInfoNm)) {
            sql.append("insert into user_subuser_meta_info (reseller_id, info_type, code, name, search_criteria, is_enabled ) values (");
            sql.append(RESELLER_ID).append(",\"").append(INFO_TYPE).append("\",").append(i++).append(",\"")
                    .append(metaInfoNm).append("\",").append("\"").append(metaInfoNm).append("\",").append(IS_ENABLED)
                    .append(");");
            content.append(sql.toString()).append("\n");
            metaInfoSet.add(metaInfoNm);
        }

        return i;
    }

    public static void main(String[] args) {
        String line = null;
        try {
            File file = new File(CREATE_FILE);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            BufferedReader br = new BufferedReader(new FileReader(FILEPATH));

            boolean readLine = false;
            int i = 1;
            StringBuilder content = new StringBuilder(20024);
            while ((line = br.readLine()) != null) {
                if (readLine) {
                    String data[] = line.replaceAll("['|\"]", "").split(",", -1);
                    StringBuilder sql = new StringBuilder(1024);
                    try {
                        i = createMetaInfoSqlWithName(i, content, data, sql);
                    } catch (Exception e) {
                        System.out.println(line);
                    }
                    data = null;
                    sql = null;
                }
                readLine = true;
            }

            bw.write(content.toString());
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
