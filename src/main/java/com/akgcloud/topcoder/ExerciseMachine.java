package com.akgcloud.topcoder;

public class ExerciseMachine {

    public int getPercentages(String time) {
        int percent = 0;
        String[] times = time.split(":");
        int seconds = 3600 * Integer.parseInt(times[0]) + 60 * Integer.parseInt(times[1]) + Integer.parseInt(times[2]);
        for (int i = 1; i < 100; i++) {
            if ((seconds * i) % 100 == 0) {
                percent++;
            }
        }
        return percent;
    }

    public static void main(String[] args) {
        ExerciseMachine em = new ExerciseMachine();
        System.out.println(em.getPercentages("00:30:00"));
    }

}
