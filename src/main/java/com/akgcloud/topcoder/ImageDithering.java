package com.akgcloud.topcoder;

public class ImageDithering {
    public int count(String dithered, String[] screen) {
        int count = 0;
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length(); j++) {
                if (dithered.contains("" + screen[i].charAt(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ImageDithering id = new ImageDithering();
        String[] screen = { "BBBBBBBB", "BBWBWBWB", "BWBWBWBB", "BBWBWBWB", "BWBWBWBB", "BBBBBBBB" };
        System.out.println(id.count("BW", screen));
    }
}
