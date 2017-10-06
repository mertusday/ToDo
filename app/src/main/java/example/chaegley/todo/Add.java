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

        final EditText title = (EditText)findViewById(R.id.EditTitle);
        final EditText date = (EditText)findViewById(R.id.EditDate);
        final EditText des = (EditText)findViewById(R.id.EditDescription);
        final EditText notes = (EditText)findViewById(R.id.EditNotes);
        final EditText comp = (EditText)findViewById(R.id.EditCompletion);
        final EditText weight = (EditText)findViewById(R.id.EditWeight);

        Button go = (Button) findViewById(R.id.AddNewTask);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = title.getText().toString();
                String da = date.getText().toString();
                String de = des.getText().toString();
                String n = notes.getText().toString();

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


                ScheduleItem input = new ScheduleItem(t, da, de, n, c, w);

                ActivityList lis = ActivityList.getInstance();
                lis.addTask(input);

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
