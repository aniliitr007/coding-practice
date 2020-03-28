package com.akgcloud.java.application;


public class ICalendarExample {

//    public static void main(String[] args) throws IOException, ValidationException, ParserException {
//
//        String calFile = "mycalendar.ics";
//
//        // Creating a new calendar
//        net.fortuna.ical4j.model.Calendar calendar = new net.fortuna.ical4j.model.Calendar();
//        calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
//        calendar.getProperties().add(Version.VERSION_2_0);
//        calendar.getProperties().add(CalScale.GREGORIAN);
//
//        // Creating an event
//        java.util.Calendar cal = java.util.Calendar.getInstance();
//        cal.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
//        cal.set(java.util.Calendar.DAY_OF_MONTH, 25);
//
//        VEvent christmas = new VEvent(new Date(cal.getTime()), "Christmas Day");
//        // initialise as an all-day event..
//        christmas.getProperties().getProperty(Property.DTSTART).getParameters().add(Value.DATE);
//
//        UidGenerator uidGenerator = new UidGenerator("1");
//        christmas.getProperties().add(uidGenerator.generateUid());
//
//        calendar.getComponents().add(christmas);
//
//        // Saving an iCalendar file
//        FileOutputStream fout = new FileOutputStream(calFile);
//
//        CalendarOutputter outputter = new CalendarOutputter();
//        outputter.setValidating(false);
//        outputter.output(calendar, fout);
//
//        // Now Parsing an iCalendar file
//        FileInputStream fin = new FileInputStream(calFile);
//
//        CalendarBuilder builder = new CalendarBuilder();
//
//        calendar = builder.build(fin);
//
//        // Iterating over a Calendar
//        for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
//            Component component = (Component) i.next();
//            System.out.println("Component [" + component.getName() + "]");
//
//            for (Iterator j = component.getProperties().iterator(); j.hasNext();) {
//                Property property = (Property) j.next();
//                System.out.println("Property [" + property.getName() + ", " + property.getValue() + "]");
//            }
//        }// for
//    }
}
