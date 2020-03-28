package com.akgcloud.java.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PGPFileProcessor {

    private String  passphrase;

    private String  keyFile;

    private String  inputFile;

    private String  outputFile;

    private boolean asciiArmored   = false;

    private boolean integrityCheck = true;

    public PGPFileProcessor(String passphrase, String keyFile, String inputFile, String outputFile,
            boolean asciiArmored, boolean integrityCheck) {
        super();
        this.passphrase = passphrase;
        this.keyFile = keyFile;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.asciiArmored = asciiArmored;
        this.integrityCheck = integrityCheck;
    }

    public boolean encrypt() throws Exception {
        FileInputStream keyIn = new FileInputStream(keyFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        PGPUtil.encryptFile(out, inputFile, PGPUtil.readPublicKey(keyIn), asciiArmored, integrityCheck);
        out.close();
        keyIn.close();
        return true;
    }

    public boolean decrypt() throws Exception {
        FileInputStream in = new FileInputStream(inputFile);
        FileInputStream keyIn = new FileInputStream(keyFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        PGPUtil.decryptFile(in, out, keyIn, passphrase.toCharArray());
        in.close();
        out.close();
        keyIn.close();
        return true;
    }

    public boolean isAsciiArmored() {
        return asciiArmored;
    }

    public void setAsciiArmored(boolean asciiArmored) {
        this.asciiArmored = asciiArmored;
    }

    public boolean isIntegrityCheck() {
        return integrityCheck;
    }

    public void setIntegrityCheck(boolean integrityCheck) {
        this.integrityCheck = integrityCheck;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public static void main(String args[]) throws Exception {
//        PGPFileProcessor fileProcessor = new PGPFileProcessor("12345678", "yatra.pgp", "wb.csv", "enc_wb.csv", true,
//                true);
//        fileProcessor.encrypt();

         PGPFileProcessor decryptFile = new PGPFileProcessor("12345678",
         "wb_key.gpg", "data.gpg", "wb_out2.csv", true,
         true);
        
         decryptFile.decrypt();
    }

}
