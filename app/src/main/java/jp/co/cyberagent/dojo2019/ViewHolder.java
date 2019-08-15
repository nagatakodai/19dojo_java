package jp.co.cyberagent.dojo2019;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView nameView;
    public TextView twitterView;
    public TextView githubView;
    public ViewHolder(View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
        twitterView = itemView.findViewById(R.id.twitter);
        githubView = itemView.findViewById(R.id.github);
    }
}
