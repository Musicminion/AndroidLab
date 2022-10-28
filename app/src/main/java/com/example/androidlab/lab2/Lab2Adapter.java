package com.example.androidlab.lab2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlab.R;

import java.util.ArrayList;
import java.util.List;

public class Lab2Adapter extends RecyclerView.Adapter<Lab2Adapter.Lab2TextViewHolder> {


    private List<String> mItems = new ArrayList<>();
    private Context mContext;


    public Lab2Adapter(Context context) {
        this.mContext = context;
    }


    @NonNull
    @Override
    public Lab2TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Lab2TextViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.component_lab2_item_textview,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull Lab2Adapter.Lab2TextViewHolder holder, int position) {
        holder.bind(mItems.get(position));
        holder.setTextViewIndex(position);
        holder.setOnClickIndex(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void notifyItems(@NonNull List<String> items){
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void singleItemUpdate(int index, String value){
        mItems.set(index,value);
        notifyItemChanged(index);
    }


    public class Lab2TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;


        public Lab2TextViewHolder (@NonNull View itemView){
            super(itemView);
            mTextView = itemView.findViewById(R.id.component_lab2_linearLayout_textview);
        }

        public void bind(String text){
            mTextView.setText(text);
        }

        public void setTextViewIndex(int index){
            mTextView.setTag(index);
        }

        public void setOnClickIndex(int index){
            mTextView.setOnClickListener(view -> {
                TextView textView = (TextView) view;
                Intent intent = new Intent(mContext, Lab2EditActivity.class);
                System.out.println(view.getTag());
                intent.putExtra("textViewIndex", String.valueOf(view.getTag()));
                ((Activity) mContext).startActivityForResult(intent,200);
            });
        }


        @Override
        public void onClick(View view) {
        }
    }

}

