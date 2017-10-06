package example.chaegley.todo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class sort extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        //from online android api on how to make a spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sorts, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button sort = (Button)findViewById(R.id.sortButton);

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sort();
                Intent intent = new Intent(sort.this,ToDoList.class);
                startActivity(intent);
            }
        });
    }

    private void sort(){
        ArrayList<ScheduleItem> act = ActivityList.getInstance().getTaskList();
        ScheduleItem[] returnList= new ScheduleItem[act.size()];
        int length = act.size();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        int choice = spinner.getSelectedItemPosition();


        if(choice == 2){
            //sort by completion
            int[] count = new int[101];
            for(int i=0;i<act.size();i++){
                count[act.get(i).getWeight()]++;
            }
            for(int i=1; i<count.length; i++){
                count[i]=count[i]+count[i-1];
            }
            for(int i=0;i<act.size();i++){
                returnList[count[act.get(i).getWeight()]]=act.get(i);
                count[act.get(i).getWeight()]++;
            }

        }else if(choice == 1){
            //sort by weight

            int[] count = new int[5];
            for(int i=0;i<act.size();i++){
                count[act.get(i).getWeight()-1]++;
            }
            for(int i=1; i<=count.length; i++){
                count[i]=count[i]+count[i-1];
            }
            for(int i=0;i<act.size();i++){
                returnList[count[act.get(i).getWeight()]-1]=act.get(i);
                count[act.get(i).getWeight()-1]++;
            }
        }else {
            //sort by date
        }
        ArrayList<ScheduleItem> finalList = new ArrayList<ScheduleItem>(Arrays.asList(returnList));
        ActivityList.getInstance().updateList(finalList);

    }



    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}
