package edu.weber.cs.w01378454.cs3270a3;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreFragment extends Fragment {

    private View root;
    private TextView gamesPlayedTotal;
    private TextView phoneWinScore;
    private TextView myWinScore;
    private TextView tiedGamesScore;

    private scoreButtonListener mCallBack;

    public interface scoreButtonListener{
        void resetScoreButtonPressed(int gamesPlayed, int phoneWins, int myWins, int tieGames);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        try {
            mCallBack=(ScoreFragment.scoreButtonListener) activity;

        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "Must implement scoreButtonListener");
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScoreFragment newInstance(String param1, String param2) {
        ScoreFragment fragment = new ScoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_score, container, false);
    }



    @Override
    public void onStart()
    {
        super.onStart();

        gamesPlayedTotal = root.findViewById(R.id.gamesPlayedTotal);
        phoneWinScore = root.findViewById(R.id.phoneWinScore);
        myWinScore = root.findViewById(R.id.myWinScore);
        tiedGamesScore = root.findViewById(R.id.tiedGamesScore);

        Button btnResetCounts = root.findViewById(R.id.btnResetCounts);
        btnResetCounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gamesPlayedTotal = 0;
                int phoneWinScore = 0;
                int myWinScore=0;
                int tiedGamesScore=0;

                mCallBack.resetScoreButtonPressed(gamesPlayedTotal,phoneWinScore,myWinScore,tiedGamesScore);
            }
        });


    }
    public void updateScore(int gamesPlayed, int phoneWins,int myWins ,int tieGames)
    {
        gamesPlayedTotal.setText(""+gamesPlayed);
        phoneWinScore.setText(""+phoneWins);
        myWinScore.setText(""+myWins);
        tiedGamesScore.setText(""+tieGames);
    }

    public void resetScore(int gamesPlayed, int phoneWins,int myWins ,int tieGames)
    {
        gamesPlayedTotal.setText(""+0);
        phoneWinScore.setText(""+0);
        myWinScore.setText(""+0);
        tiedGamesScore.setText(""+0);


    }


}