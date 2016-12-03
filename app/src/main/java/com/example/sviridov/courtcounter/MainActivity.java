package com.example.sviridov.courtcounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    int Team1Score = 0;
    int Team2Score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayScore();

    }

    private void displayScore() {
        TextView team1ScoreTextView = (TextView) findViewById(R.id.scoreTeam1);
        TextView team2ScoreTextView = (TextView) findViewById(R.id.scoreTeam2);
        team1ScoreTextView.setText(String.valueOf(Team1Score));
        team2ScoreTextView.setText(String.valueOf(Team2Score));
        if (Team1Score == Team2Score) {
            team1ScoreTextView.setTextColor(Color.parseColor("#AAAAAA"));
            team2ScoreTextView.setTextColor(Color.parseColor("#AAAAAA"));
        } else if (Team1Score > Team2Score) {
            team1ScoreTextView.setTextColor(Color.parseColor("#76EE00"));
            team2ScoreTextView.setTextColor(Color.parseColor("#FF0000"));
        } else if (Team1Score < Team2Score) {
            team1ScoreTextView.setTextColor(Color.parseColor("#FF0000"));
            team2ScoreTextView.setTextColor(Color.parseColor("#76EE00"));
        }
    }

    public void addingPoints(View view) {
        String tag = view.getTag().toString();
        Boolean team = Boolean.parseBoolean(tag.split(",")[0]);
        int scoreAdd = Integer.parseInt(tag.split(",")[1]);
        if (team) {
            Team1Score = Team1Score + scoreAdd;
        } else {
            Team2Score = Team2Score + scoreAdd;
        }
        displayScore();
    }
    public void reset(View view) {
        Team1Score = 0;
        Team2Score = 0;
        displayScore();
    }

}
