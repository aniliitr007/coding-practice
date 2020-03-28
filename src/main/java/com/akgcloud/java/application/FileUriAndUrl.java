package com.akgcloud.java.application;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class FileUriAndUrl {

    public static void main(String[] args) throws IOException {

        File file = new File("D:/task");
        
        URL u = new URL("https://anil.zillious.com/static/img/cust/demo/blue_logo.gif");
        File f = new File(u.getPath());
        
        File f2 = new File(f.toURI());
        
        File f3 = new File(u.getFile());
        

        URI fileUri = file.toURI();
        System.out.println("URI:" + fileUri);

        URL fileUrl = file.toURI().toURL();
        System.out.println("URL:" + fileUrl);

        URL fileUrlWithoutSpecialCharacterHandling = file.toURL();
        System.out.println("URL (no special character handling):" + fileUrlWithoutSpecialCharacterHandling);

    }

}