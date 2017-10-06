package example.chaegley.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button go = (Button) findViewById(R.id.AddNewTask);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText title = (EditText)view.findViewById(R.id.EditTitle);
                String t = title.getText().toString();
                EditText date = (EditText)view.findViewById(R.id.EditDate);
                String da = date.getText().toString();
                EditText des = (EditText)view.findViewById(R.id.EditDescription);
                String de = des.getText().toString();
                EditText notes = (EditText)view.findViewById(R.id.EditNotes);
                String n = notes.getText().toString();
                EditText comp = (EditText)view.findViewById(R.id.EditCompletion);
                int c = Integer.parseInt(comp.getText().toString());
                EditText weight = (EditText)view.findViewById(R.id.EditWeight);
                int w = Integer.parseInt(weight.getText().toString());

                System.out.println(t);
                System.out.println(da);
                System.out.println(de);
                System.out.println(n);
                System.out.println(c);
                System.out.println(w);


                /*
                ScheduleItem input = new ScheduleItem(title.getText().toString(),
                        date.getText().toString(),
                        des.getText().toString(),
                        notes.getText().toString(),
                        Integer.parseInt(comp.getText().toString()),
                        Integer.parseInt(weight.getText().toString()));

                ActivityList lis = ActivityList.getInstance();
                lis.addTask(input);
                */

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
