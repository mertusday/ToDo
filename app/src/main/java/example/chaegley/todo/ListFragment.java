package example.chaegley.todo;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

//Andrew helped me with writing the taskholder and taskadapter class

public class ListFragment extends Fragment {


    private RecyclerView toDoRecyclerView;
    private TaskAdapter taskMaster;

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Button add = (Button)view.findViewById(R.id.add);;
        Button sort = (Button)view.findViewById(R.id.sort);;
        Button search = (Button)view.findViewById(R.id.search);;

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Add.class);
                startActivity(intent);
            }
        });

        toDoRecyclerView = view.findViewById(R.id.recycler_view);
        toDoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ScheduleItem test = new ScheduleItem("title","due","desc","notes",0,0);
        ActivityList act = ActivityList.getInstance();
        act.addTask(test);



        updateUI();

        return view;
    }

    private void updateUI(){
        ActivityList act = ActivityList.getInstance();
        List<ScheduleItem> activities = act.getTaskList();
        taskMaster = new TaskAdapter(activities);
        toDoRecyclerView.setAdapter(taskMaster);
    }

    private void sort(int type){
        // type = 1 sort by date
        // type = 2 sort by priority
    }

    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ScheduleItem item;
        private TextView title;
        private TextView details;

        public TaskHolder(LayoutInflater lf, ViewGroup vg){
            super(lf.inflate(R.layout.single_task,vg, false));
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.taskName);
            details = (TextView) itemView.findViewById(R.id.details);
        }

        public void bind(ScheduleItem si){
            item = si;
            title.setText(item.getTitle());
            details.setText(item.getDescription());
        }

        @Override
        public void onClick(View view){
            System.out.println("toast");
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{
        private List<ScheduleItem> listItem;

        public TaskAdapter(List<ScheduleItem> thing) {
            listItem=thing;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layabout = LayoutInflater.from(getActivity());

            return new TaskHolder(layabout, parent);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
            ScheduleItem sched = listItem.get(position);
            holder.bind(sched);
        }

        @Override
        public int getItemCount() {
            return listItem.size();
        }
    }

}
