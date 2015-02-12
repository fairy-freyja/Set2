package com.example.fairy.set;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private TextView mSelectText;
    private TextView mSetsOnField;
    private List<Card> selectedCards;
    private Game game;
    GridView gridview;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSelectText = (TextView) findViewById(R.id.info);
        mSetsOnField = (TextView) findViewById(R.id.setsOnField);
        selectedCards = new ArrayList<Card>();
        gridview = (GridView) findViewById(R.id.gridView1);
        try {
            game = new Game();
            gridview.setAdapter(new ImageAdapter(this, game));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // gridview.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);

        gridview.setNumColumns(3);
        gridview.setColumnWidth(80);

        gridview.setVerticalSpacing(5);
        gridview.setHorizontalSpacing(5);
        gridview.setOnItemClickListener(gridviewOnItemClickListener);

        mSetsOnField.setText("Thee are " + Game.findNumberSet(game.getField()) + " sets on the field now");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        //Log.i(TAG, "onRestart()");
    }

    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
                                long id) {
            // TODO Auto-generated method stub
            // выводим номер позиции
            mSelectText.setText("You choose card number" + String.valueOf(position));
            selectedCards.add(game.getCardFromField(position));
            if (selectedCards.size() == 3) {
                if (Game.isSet(selectedCards.get(0), selectedCards.get(1), selectedCards.get(2))) {
                    mSelectText.setText("Greate, it was set. " + String.valueOf(position));
                    game.makeStep(selectedCards);
                    // ((ImageAdapter) gridview.getAdapter()).notifyDataSetChanged();


                    try {
                        gridview.setAdapter(new ImageAdapter(gridview.getContext(), game));
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }


                    mSetsOnField.setText("Thee are " + Game.findNumberSet(game.getField()) + " sets on the field now");
                } else {
                    mSelectText.setText("OMG, it is not set. Try again, man.");
                }
                selectedCards.clear();
            }
        }
    };


    public void addThreeCardsOnClick(View view) {
        if (game.getField().getField().size() < 12){
            mSetsOnField.setText("game.getField().getField().size() < 12" + " And " + Game.findNumberSet(game.getField()) + " sets");

            if( Game.findNumberSet(game.getField()) == 0) {
                mSetsOnField.setText("Game.findNumberSet(game.getField()) == 0");
                game.addThreeCards();

            // ((ImageAdapter) gridview.getAdapter()).notifyDataSetChanged();

            try {
                gridview.setAdapter(new ImageAdapter(gridview.getContext(), game));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            mSetsOnField.setText("Thee are " + Game.findNumberSet(game.getField()) + " sets on the field now");
        }
        }
    }

    public void restartOnClick(View view) {
        try {
            game = new Game();
            gridview.setAdapter(new ImageAdapter(this, game));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mSetsOnField.setText("Thee are " + Game.findNumberSet(game.getField()) + " sets on the field now");
    }
}