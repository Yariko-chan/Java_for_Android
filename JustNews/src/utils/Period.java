package utils;

import java.util.Date;
import java.util.Locale;

/**
 * Period consists of two dates.
 */
public class Period {
    private Date fromDate;
    private Date toDate;

    private Period() {

    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getTodate() {
        return toDate;
    }

    public boolean isDateInside(Date date) {
        if (date.after(fromDate) && date.before(toDate)) {
            return true;
        }
        return false;
    }

    public static PeriodBuilder newBuilder() {
        return new Period().new PeriodBuilder();
    }

    public class PeriodBuilder {

        private PeriodBuilder() {

        }

        public PeriodBuilder setFromDate(Date from) {
            Period.this.fromDate = from;
            return this;
        }

        public PeriodBuilder setToDate(Date to) {
            Period.this.toDate = to;
            return this;
        }

        public Period build() throws IncorrectPeriodException {
            // if one or both dates missing, period can't be constructed
            if (null == Period.this.fromDate
                || null == Period.this.toDate) {
                throw new IncorrectPeriodException("One of two arguments is null.");
            } else if (toDate.before(fromDate)) { // incorrect period
                throw new IncorrectPeriodException("toDate is before fromDate");
            } else {
                return Period.this;
            }
        }
    }

    public static class IncorrectPeriodException extends Exception {

        public IncorrectPeriodException() {
            super("Unable to create period. ");
        }

        public IncorrectPeriodException(String s) {
            super("Unable to create period: " + s);
        }
    }
}
