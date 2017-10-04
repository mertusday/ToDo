package example.chaegley.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

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

        toDoRecyclerView = view.findViewById(R.id.recycler_view);
        toDoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //update();

        return view;
    }

    private void update(){
        //check database
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
