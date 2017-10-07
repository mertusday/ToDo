package example.chaegley.todo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final EditText title = (EditText)findViewById(R.id.EditTitle);
        final TextView  date = (TextView)findViewById(R.id.EditDate);
        final EditText des = (EditText)findViewById(R.id.EditDescription);
        final EditText notes = (EditText)findViewById(R.id.EditNotes);
        final EditText comp = (EditText)findViewById(R.id.EditCompletion);
        final EditText weight = (EditText)findViewById(R.id.EditWeight);

        /*
        date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentManager fragmentManager = getSupportFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.show(fragmentManager, "Dialog Date");
            }
        });
        */

        Button go = (Button) findViewById(R.id.AddNewTask);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = title.getText().toString();
                String de = des.getText().toString();
                String n = notes.getText().toString();
                String da = date.getText().toString();


                int c;
                try
                {
                    Integer.parseInt(comp.getText().toString());
                    c=Integer.parseInt(comp.getText().toString());
                } catch (NumberFormatException ex)
                {
                    c=0;
                }

                int w;
                try
                {
                    Integer.parseInt(weight.getText().toString());
                    w=Integer.parseInt(comp.getText().toString());
                } catch (NumberFormatException ex)
                {
                    w=1;
                }

                //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

               // ScheduleItem input2 = new ScheduleItem(t, null, de, n, 15, 2);

                //ScheduleItem input3 = new ScheduleItem(t, null, de, n, 78, 5);



                ScheduleItem input = new ScheduleItem(t, da, de, n, c, w);

                ActivityList lis = ActivityList.getInstance();
                lis.addTask(input);

                //lis.addTask(input1);
               // lis.addTask(input2);
               // lis.addTask(input3);

                Intent intent = new Intent(Add.this, ToDoList.class);
                startActivity(intent);
            }
        });

        Button back = (Button) findViewById(R.id.CancelAdd);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add.this, ToDoList.class);
                startActivity(intent);
            }
        });
    }

}
