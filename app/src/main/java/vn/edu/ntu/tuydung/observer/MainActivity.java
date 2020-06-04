package vn.edu.ntu.tuydung.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MyDateDialog.OnMyDate ,MyTimeDialog.OnMyTime {
    EditText edttime,edtdate;
    ImageView imvdate,imvtime;
    Context contextDate, contextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }
    private void addView()
    {
        //Date
        edtdate = findViewById(R.id.edtDate);
        edtdate.setEnabled(false);
        imvdate= findViewById(R.id.imvDate);

        //Time
        edttime = findViewById(R.id.edtTime);
        edttime.setEnabled(false);
        edtdate.setEnabled(false);
        imvtime= findViewById(R.id.imvTime);


    }
    private void addEvent(){
        imvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDateDialog dateDialog =new MyDateDialog(
                    MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance());
                dateDialog.ShowDate();
            }
        });

        imvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTimeDialog dialog =new MyTimeDialog(
                        MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance());
                dialog.ShowTimeDialog();
            }
        });

    }

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder builder= new StringBuilder();
        builder.append(newDate.get(Calendar.DAY_OF_MONTH)).append("/")
                .append(newDate.get(Calendar.MONTH)).append("/")
                .append(newDate.get(Calendar.YEAR));
        edtdate.setText(builder.toString());

    }

    @Override
    public void timeUpdate(Calendar newTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(newTime.get(Calendar.HOUR_OF_DAY)).append("h")
                .append(newTime.get(Calendar.MINUTE)).append("m");
        edttime.setText(builder.toString());


    }
}
