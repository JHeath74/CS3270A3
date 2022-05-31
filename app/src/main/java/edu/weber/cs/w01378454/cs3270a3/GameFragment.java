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

import org.w3c.dom.Text;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment {

    private View root;

    public int gamesPlayed=0;
    public int phoneWins=0;
    public int myWins=0;
    public int tieGames=0;

    public TextView phonePickChoice;
    public TextView gameWinner;

    public onButtonListener mCallBack;


    public interface onButtonListener{
        void gameFragmentButtonPressed(int gamesPlayed, int phoneWins, int myWins, int tieGames);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
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
        return root = inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            mCallBack=(onButtonListener) activity;

        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "Must implement onButtonListener");
        }
    }

    @Override
    public void onStart()
    {
        super.onStart();

        phonePickChoice = root.findViewById(R.id.phonePickChoice);
        gameWinner = root.findViewById(R.id.gameWinner);


        String[] phoneChoice = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        Button btnRock = root.findViewById(R.id.btnRock);
        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomChoice = random.nextInt(phoneChoice.length);

                if(phoneChoice[randomChoice] == "Paper"){
                    gamesPlayed++;
                    phoneWins++;
                    gameWinner.setText("Phone");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else if(phoneChoice[randomChoice] == "Rock"){
                    gamesPlayed++;
                    tieGames++;
                    gameWinner.setText("Tie");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else if(phoneChoice[randomChoice] == "Scissors"){
                    gamesPlayed++;
                    myWins++;
                    gameWinner.setText("You");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else{

                }

            }
        });

        Button btnPaper = root.findViewById(R.id.btnPaper);
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int randomChoice = random.nextInt(phoneChoice.length);

                if(phoneChoice[randomChoice] == "Paper")
                {
                    tieGames++;
                    gamesPlayed++;
                    gameWinner.setText("Tie");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);

                }else if(phoneChoice[randomChoice] == "Rock"){
                    myWins++;
                    gamesPlayed++;
                    gameWinner.setText("You");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else if(phoneChoice[randomChoice] == "Scissors"){
                    phoneWins++;
                    gamesPlayed++;
                    gameWinner.setText("Phone");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else{

                }

            }
        });

        Button btnScissors = root.findViewById(R.id.btnScissors);
        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomChoice = random.nextInt(phoneChoice.length);

                if(phoneChoice[randomChoice] == "Paper"){
                    gamesPlayed++;
                    myWins++;
                    gameWinner.setText("You");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else if(phoneChoice[randomChoice] == "Rock"){
                    gamesPlayed++;
                    phoneWins++;
                    gameWinner.setText("Phone");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else if(phoneChoice[randomChoice] == "Scissors"){
                    gamesPlayed++;
                    tieGames++;
                    gameWinner.setText("Tie");
                    phonePickChoice.setText(phoneChoice[randomChoice]);
                    mCallBack.gameFragmentButtonPressed(gamesPlayed,phoneWins,myWins, tieGames);
                }else{

                }
            }
        });


    }
    public void resetScore(int gamesPlayed, int phoneWins,int myWins ,int tieGames)
    {
        int gamesPlayedTotal = 0;
        int phoneWinScore = 0;
        int myWinScore=0;
        int tiedGamesScore=0;



        Toast toast = Toast.makeText(getActivity()," Score Reset: ", Toast.LENGTH_SHORT);
        toast.show();
    }
}



