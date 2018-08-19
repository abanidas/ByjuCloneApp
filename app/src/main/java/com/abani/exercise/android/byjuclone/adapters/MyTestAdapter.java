package com.abani.exercise.android.byjuclone.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.abani.exercise.android.byjuclone.ChapterActivity;
import com.abani.exercise.android.byjuclone.R;
import com.abani.exercise.android.byjuclone.TestStartActivity;
import com.abani.exercise.android.byjuclone.utils.CommonUtils;

public class MyTestAdapter extends RecyclerView.Adapter<MyTestAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout, llStartTest;
        ProgressBar progressBarStart;
        TextView textViewTest;
        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.ll_card_test);
            llStartTest = itemView.findViewById(R.id.ll_start_test);
            progressBarStart = itemView.findViewById(R.id.progress_load_test);
            textViewTest = itemView.findViewById(R.id.text_test);
        }
    }

    public MyTestAdapter(String[] myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public MyTestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if (holder.getAdapterPosition() == 0){
            holder.textViewTest.setTextColor(Color.BLACK);
            holder.textViewTest.setTypeface(null, Typeface.BOLD);
            holder.textViewTest.setText("Tests");
            holder.llStartTest.setVisibility(View.GONE);
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.getAdapterPosition() != 0) {
                    holder.llStartTest.setVisibility(View.GONE);
                    holder.progressBarStart.setVisibility(View.VISIBLE);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            holder.progressBarStart.setVisibility(View.GONE);
                            holder.llStartTest.setVisibility(View.VISIBLE);
                            mContext.startActivity(new Intent(mContext, TestStartActivity.class));
                        }
                    }, 2000);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}