package jp.co.cyberagent.dojo2019;

import android.content.Intent;
import android.net.Uri;
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

        holder.nameView.setText(Uri.decode(list.get(position).getName()));
        holder.twitterView.setText(Uri.decode("TwitterID:"+list.get(position).getTw().substring(23)));
        holder.githubView.setText(Uri.decode("GithubID:"+list.get(position).getGh().substring(22)));
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
