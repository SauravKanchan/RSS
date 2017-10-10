package com.example.naveenchandra.rss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        TextView tvName = (TextView) convertView.findViewById(tvName);
//        TextView tvArtist = (TextView) convertView.findViewById(R.id.tvDEscription);
//        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);

        FeedEntry currentApp = applications.get(position);

        //viewHolder pattern

        viewHolder.tvTitle.setText(currentApp.getTitle());
        viewHolder.tvDescription.setText(currentApp.getDescription());

        return convertView;
    }

    private class ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;

        ViewHolder(View v) {
            this.tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            this.tvDescription = (TextView) v.findViewById(R.id.tvDescription);
        }
    }
}
