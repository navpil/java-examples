package ua.lviv.navpil.collections.real;

import java.util.Arrays;
import java.util.Calendar;

public class Lists {

    public void realStoryWithArrayList() {
        final IAppointment[] apps = getAppointments();
        CalendarEntryType[] tmpResult = new CalendarEntryType[(int) (apps.length * 1.5)];
        int resultIdx = 0;
        for (int i = 0; i < apps.length; i++) {
            // get appointment and date range
            final IAppointment app = apps[i];
            final IDateTimeRange range = app.getDateTimeRange();
            // split range so it doesn't span midnight
            final IDateTimeRange[] ranges = range.split();
            for (int k = 0; k < ranges.length; k++) {
                // convert range element  to calendars
                Calendar calStart = ranges[k].getStart();
                Calendar calEnd = ranges[k].getEnd();

                // create result object
                CalendarEntryType type = new CalendarEntryType();
                type.setStart(calStart);
                type.setEnd(calEnd);

                // set in array (but first see if we need to resize)
                if (resultIdx == tmpResult.length) {
                    CalendarEntryType[] newTmpResult = new CalendarEntryType[(int) Math.ceil(tmpResult.length * 1.5)];
                    System.arraycopy(tmpResult, 0, newTmpResult, 0, tmpResult.length);
                    tmpResult = newTmpResult;
                }
                tmpResult[resultIdx++] = type;
            }
        }

        // remove unused places
        CalendarEntryType[] result = (CalendarEntryType[]) Arrays.copyOfRange(tmpResult, 0, resultIdx);
    }




    private static IAppointment[] getAppointments() {
        return new IAppointment[0];
    }

    private class IAppointment {

        private IDateTimeRange dateTimeRange;
        public IDateTimeRange getDateTimeRange() {
            return dateTimeRange;
        }

    }
    private class CalendarEntryType {

        private Calendar start;
        private Calendar end;
        public void setStart(Calendar start) {
            this.start = start;
        }

        public void setEnd(Calendar end) {
            this.end = end;
        }

    }

    private class IDateTimeRange {

        private Calendar start;
        private Calendar end;

        public IDateTimeRange[] split() {
            return new IDateTimeRange[0];
        }

        public Calendar getStart() {
            return start;
        }

        public Calendar getEnd() {
            return end;
        }
    }

}
