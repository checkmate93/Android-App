package com.example.relaxingsleepingsound;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.ViewHolder> {
    private List<SoundItem> sounds;
    private OnSoundClickListener listener;

    public interface OnSoundClickListener { void onSoundClick(SoundItem item); }

    public SoundAdapter(List<SoundItem> sounds, OnSoundClickListener listener) {
        this.sounds = sounds;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SoundItem item = sounds.get(position);
        boolean isGreek = Locale.getDefault().getLanguage().equals("el");
        holder.textView.setText(item.getName(isGreek));
        holder.itemView.setOnClickListener(v -> listener.onSoundClick(item));
    }

    @Override
    public int getItemCount() { return sounds.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ViewHolder(View v) { super(v); textView = v.findViewById(android.R.id.text1); }
    }
}