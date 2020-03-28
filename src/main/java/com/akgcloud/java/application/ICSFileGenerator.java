package com.akgcloud.java.application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.GregorianCalendar;

//import net.fortuna.ical4j.data.CalendarOutputter;
//import net.fortuna.ical4j.model.Calendar;
//import net.fortuna.ical4j.model.DateTime;
//import net.fortuna.ical4j.model.TimeZone;
//import net.fortuna.ical4j.model.TimeZoneRegistry;
//import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
//import net.fortuna.ical4j.model.component.VEvent;
//import net.fortuna.ical4j.model.component.VTimeZone;
//import net.fortuna.ical4j.model.property.CalScale;
//import net.fortuna.ical4j.model.property.Organizer;
//import net.fortuna.ical4j.model.property.Uid;
//import net.fortuna.ical4j.util.Configurator;
//import net.fortuna.ical4j.util.UidGenerator;

public class ICSFileGenerator {

/*    public static File createCalEntry() {

        // create a calendar object
        Calendar icsCalendar = new Calendar();

        // create a file object
        File calFile = new File("meeting.ics");

        try {

            // Create a TimeZone
            TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
            TimeZone timezone = registry.getTimeZone("Australia/Melbourne");
            String key = Configurator.getProperty("net.fortuna.ical4j.timezone.update.enabled");
            VTimeZone tz = ((net.fortuna.ical4j.model.TimeZone) timezone).getVTimeZone();

            // Start Date is on: July 17, 2013, 10:00 am
            java.util.Calendar startDate = new GregorianCalendar();
            startDate.setTimeZone(timezone);
            startDate.set(java.util.Calendar.MONTH, java.util.Calendar.JULY);
            startDate.set(java.util.Calendar.DAY_OF_MONTH, 25);
            startDate.set(java.util.Calendar.YEAR, 2013);
            startDate.set(java.util.Calendar.HOUR_OF_DAY, 10);
            startDate.set(java.util.Calendar.MINUTE, 0);
            startDate.set(java.util.Calendar.SECOND, 0);

            // End Date is on: July 17, 2013, 11:00 am
            java.util.Calendar endDate = new GregorianCalendar();
            endDate.setTimeZone(timezone);
            endDate.set(java.util.Calendar.MONTH, java.util.Calendar.JULY);
            endDate.set(java.util.Calendar.DAY_OF_MONTH, 25);
            endDate.set(java.util.Calendar.YEAR, 2013);
            endDate.set(java.util.Calendar.HOUR_OF_DAY, 11);
            endDate.set(java.util.Calendar.MINUTE, 0);
            endDate.set(java.util.Calendar.SECOND, 0);

            // Create the event props
            String eventName = "Some appointment";
            DateTime start = new DateTime(startDate.getTime());
            DateTime end = new DateTime(endDate.getTime());

            // Create the event
            VEvent meeting = new VEvent(start, end, eventName);

            // create Organizer object and add it to vEvent
            Organizer organizer = new Organizer(URI.create("mailto:someone@something"));
            meeting.getProperties().add(organizer);

            // add timezone to vEvent
            meeting.getProperties().add(tz.getTimeZoneId());

            // generate unique identifier and add it to vEvent
            UidGenerator ug = new UidGenerator("uidGen");
            Uid uid = ug.generateUid();
            meeting.getProperties().add(uid);

            // add attendees..
            
             * Attendee dev1 = new Attendee(URI.create("someone@something"));
             * dev1.getParameters().add(Role.REQ_PARTICIPANT);
             * dev1.getParameters().add(new Cn("Developer 1"));
             * meeting.getProperties().add(dev1);
             

            // assign props to calendar object
            icsCalendar.getProperties().add(CalScale.GREGORIAN);

            // Add the event and print
            icsCalendar.getComponents().add(meeting);

            CalendarOutputter outputter = new CalendarOutputter();
            outputter.setValidating(false);

            FileOutputStream fout = new FileOutputStream(calFile);
            outputter.output(icsCalendar, fout);

            return calFile;

        } catch (Exception e) {
            System.err.println("Error in method createCalEntry() " + e);
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        File file = ICSFileGenerator.createCalEntry();

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Anil");
        bw.close();
    }*/

}