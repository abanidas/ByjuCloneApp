package com.abani.exercise.android.byjuclone;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.abani.exercise.android.byjuclone.adapters.MyChapterAdapter;

public class ChapterActivity extends AppCompatActivity {

    TextView title;
    private RecyclerView mRecyclerView;
    private MyChapterAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        title = findViewById(R.id.tv_title);

        Shader textShader=new LinearGradient(0, 0, 200, 20,
                new int[]{Color.BLUE, Color.parseColor("#00BCD4")},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        title.getPaint().setShader(textShader);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_chapter_cards);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyChapterAdapter(new String[]{"0", "1", "2", "3", "4", "5"}, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
