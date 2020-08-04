package com.dotin.dotintasktwo.utility;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;

public class DateFormatUtility {

    public static String formatIntoWords() {
        ULocale locale = new ULocale("fa_IR@calendar=persian");

        Calendar calendar = Calendar.getInstance(locale);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);

        return df.format(calendar);
    }

}





