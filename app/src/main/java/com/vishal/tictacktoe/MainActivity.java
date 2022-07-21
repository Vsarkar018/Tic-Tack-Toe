package com.vishal.tictacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
// O -----  O
// 1 ------- X

    int activePlayer = 0 ;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    //Game State
    // 0 =  O
    // 1 = X
    // 2 = Blank
  int co = 0 ;
    int[][] winPos = {
                      {0,1,2},{3,4,5},{6,7,8},
                      {0,3,6},{1,4,7},{2,5,8},
                      {0,4,8},{2,4,6}
    };
 public void playerTap(View view){
     ImageView img =  (ImageView)view;
     if(!gameActive){
         gameReset(view);
     }
 int tappedImage = Integer.parseInt(img.getTag().toString());
     TextView status = findViewById(R.id.status);

  if(gameState[tappedImage] == 2 && gameActive){
   gameState[tappedImage] = activePlayer ;
   status.setText("O's Turn");
   img.setTranslationY(-1000f);
   if(activePlayer == 0){
       img.setImageResource(R.drawable.cross);
       activePlayer = 1 ;
        status.setText("O's Turn");
   }else{
       img.setImageResource(R.drawable.circle);
       activePlayer = 0 ;
       status.setText("X's Turn");

   }
      img.animate().translationYBy(1000f).setDuration(300);
  }else{
      gameActive = true;
  }

     TextView status2 = findViewById(R.id.status2);
      if(gameState[0] == 0 || gameState[0] == 1){
          if(gameState[1] == 0 || gameState[1] == 1) {
              if(gameState[2] == 0 || gameState[2] == 1) {
                  if(gameState[3] == 0 || gameState[3] == 1) {
                      if(gameState[4] == 0 || gameState[4] == 1) {
                          if(gameState[5] == 0 || gameState[5] == 1) {
                              if(gameState[6] == 0 || gameState[6] == 1) {
                                  if(gameState[7] == 0 || gameState[7] == 1) {
                                      if(gameState[8] == 0 || gameState[8] == 1) {
                                        gameActive = false;
                                       status2.setText("Game Draw");
                                       status.setText("Tap again to Play");
                                      }
                                  }
                              }
                          }
                      }
                  }
              }

          }
       }

      //Check if player has won

      for(int[] winning : winPos) {
          if (gameState[winning[0]] == gameState[winning[1]] && gameState[winning[2]] == gameState[winning[1]]
                  && gameState[winning[0]] != 2) {
              // Now check x has won or Y has won
              if(gameState[winning[0]] == 0) {
                  status2.setText("X Wins");
              } else {
                  status2.setText("O Wins");
              }
              status.setText("Tap again to Play");
              gameActive = false;
          }

      }


 }
 public void gameReset(View view){
activePlayer =  0;
for(int i =  0; i < gameState.length ; i++){
    gameState[i] = 2 ;
}
     ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
     ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
     TextView status2 = findViewById(R.id.status2);
     status2.setText(" ");
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}