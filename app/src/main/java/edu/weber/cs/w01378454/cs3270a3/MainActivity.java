package edu.weber.cs.w01378454.cs3270a3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements GameFragment.onButtonListener,ScoreFragment.scoreButtonListener {

    private ScoreFragment scoreFragment;
    private GameFragment gameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void gameFragmentButtonPressed(int gamesPlayed, int phoneWins, int myWins, int tieGames)
    {
        if(scoreFragment == null)
        {
            FragmentManager fm = getSupportFragmentManager();
            scoreFragment = (ScoreFragment)fm.findFragmentById(R.id.scorefragment);

        }
            scoreFragment.updateScore(gamesPlayed,phoneWins,myWins,tieGames);

        Log.d("gamesPlayed", "Score gamesPlayed: " + gamesPlayed);
        Log.d("phoneWins", "Score phoneWins: " + phoneWins);
        Log.d("myWins", "Score myWins: " + myWins);
        Log.d("tieGames", "Score tieGames: " + tieGames);
    }


    @Override
    public void resetScoreButtonPressed(int gamesPlayed, int phoneWins, int myWins, int tieGames) {
        if(gameFragment == null)
        {
            FragmentManager fm = getSupportFragmentManager();
            gameFragment = (GameFragment) fm.findFragmentById(R.id.gamefragment);
        }

        gameFragment.resetScore(gamesPlayed, phoneWins, myWins,tieGames);

        Log.d("gamesPlayed", "Reset gamesPlayed: " + gamesPlayed);
        Log.d("phoneWins", "Reset phoneWins: " + phoneWins);
        Log.d("myWins", "Reset myWins: " + myWins);
        Log.d("tieGames", "Reset tieGames: " + tieGames);
    }
}