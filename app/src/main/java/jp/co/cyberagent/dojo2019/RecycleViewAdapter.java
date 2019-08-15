package jp.co.cyberagent.dojo2019;

import android.content.Intent;
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.nameView.setText(list.get(position).getName());
        holder.twitterView.setText(list.get(position).getTw());
        holder.githubView.setText(list.get(position).getGh());
        holder.imageViewTw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.putExtra("url",list.get(position).getTw());
                v.getContext().startActivity(intent);
            }
        });
        holder.imageViewGh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.putExtra("url",list.get(position).getGh());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
