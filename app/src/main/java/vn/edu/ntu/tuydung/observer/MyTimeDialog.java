package vn.edu.ntu.tuydung.observer;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTimeDialog {
    Context context;
    OnMyTime onMyTime;
    Calendar calendar;

    public MyTimeDialog(Context context, OnMyTime onMyTime, Calendar calendar) {
        this.context = context;
        this.onMyTime = onMyTime;
        this.calendar = calendar;
    }

    public void ShowTimeDialog() {
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(0, 0, 0, minute, hourOfDay);
                if (onMyTime != null) onMyTime.timeUpdate(calendar);

            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, listener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }
    public static interface OnMyTime{
        public void timeUpdate(Calendar newTime);

}

}
