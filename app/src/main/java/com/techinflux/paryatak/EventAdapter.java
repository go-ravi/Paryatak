package com.techinflux.paryatak;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    List<MainActivity.Event> events;
    Context context;

    // Provide a suitable constructor (depends on the kind of dataset) context is reqd for onclick listener
    public EventAdapter(Context context, List<MainActivity.Event> events) {
        this.context = context;
        this.events = events;
    }
    // Create new views (invoked by the layout manager)

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_main, parent, false);
        // create ViewHolder
        EventViewHolder evh = new EventViewHolder(v);
        return evh;
    }
    // Replace the contents of a view (invoked by the layout manager)

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        holder.eventName.setText(events.get(position).name);
        holder.eventDate.setText(events.get(position).date);
        holder.eventPlace.setText(events.get(position).place);
        //get the current activity context to add onclicklistener
        holder.eventInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventInfoActivity.class);
                context.startActivity(intent);
            }
        });
        holder.eventShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:share
            }
        });

    }
    // Return the size of your dataset (invoked by the layout manager)

    @Override
    public int getItemCount() {
        return events.size();
    }
    // inner class to hold a reference to each item of RecyclerView

    public class EventViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventName, eventDate, eventPlace, eventShare, eventInfo;
        ImageView eventPhoto;


        public EventViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            eventName = (TextView) itemView.findViewById(R.id.event_name);
            eventDate = (TextView) itemView.findViewById(R.id.event_date);
            eventPlace = (TextView) itemView.findViewById(R.id.event_place);
            eventShare = (TextView) itemView.findViewById(R.id.event_share);
            eventInfo = (TextView) itemView.findViewById(R.id.event_info);
            eventPhoto = (ImageView) itemView.findViewById(R.id.event_photo_main);

        }
    }
}
