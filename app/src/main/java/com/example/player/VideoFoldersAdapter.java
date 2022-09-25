package com.example.player;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoFoldersAdapter extends RecyclerView.Adapter<VideoFoldersAdapter.ViewHolder> {
    private ArrayList<MediaFiles> mediaFiles;
    private ArrayList<String> folderPath;
    private Context context ;

    public VideoFoldersAdapter(ArrayList<MediaFiles> mediaFiles, ArrayList<String> folderPath, Context context) {
        this.mediaFiles = mediaFiles;
        this.folderPath = folderPath;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.folder_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int indexPath = folderPath.get(position).lastIndexOf("/");
        String nameofFolder = folderPath.get(position).substring(indexPath+1);
        holder.folder_path.setText(folderPath.get(position));
        holder.folderName.setText(nameofFolder);
        holder.noOffFiles.setText("5 Videos");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,VideoFilesActivity.class);
                intent.putExtra("folderName",nameofFolder);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return folderPath.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView folderName,folder_path,noOffFiles;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            folderName = itemView.findViewById(R.id.folderName);
            folder_path = itemView.findViewById(R.id.folderPath);
            noOffFiles = itemView.findViewById(R.id.noOffFiles);

        }
    }
}
