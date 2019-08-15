package jp.co.cyberagent.dojo2019;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<User> list;

    public RecycleViewAdapter(List<User> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        ViewHolder vh = new ViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameView.setText(list.get(position).getName());
        holder.twitterView.setText(list.get(position).getTw());
        holder.githubView.setText(list.get(position).getGh());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
