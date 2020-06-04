package vn.edu.ntu.tuydung.observer;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.sip.SipSession;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDateDialog {
    Context context;
    OnMyDate onMyDate;

    Calendar calendar;

    public MyDateDialog(Context context, OnMyDate onMyDate, Calendar calendar) {
        this.context = context;
        this.onMyDate = onMyDate;
        this.calendar = calendar;
    }
    public  void ShowDate(){
        DatePickerDialog.OnDateSetListener listener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
               if(onMyDate!= null) onMyDate.dateUpdate(calendar);

            }
        };
        DatePickerDialog datePickerDialog =new DatePickerDialog(context, listener, calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }


public  static interface  OnMyDate{
            public  void dateUpdate(Calendar newDate);
}

}
