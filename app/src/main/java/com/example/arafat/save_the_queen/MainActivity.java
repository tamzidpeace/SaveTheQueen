package com.example.arafat.save_the_queen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //const
    private static final String TAG = "MainActivity";

    //member variable
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
    private TextView result;
    private int x1, y1, x2, y2;
    private Button btn[];
    private StringBuilder mVisitedNodes = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*start of variable work*/
        mVisitedNodes.append("Visited Nodes: ");
        result = findViewById(R.id.result_tv);

        Button saveBtn = findViewById(R.id.save_btn);
        Button resetBtn = findViewById(R.id.reset_btn);

        buttonInitialization();

        btn = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16};


        /*end of variables works*/


        // reset queen  and robot position
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // random number for new position
                Random randomNum = new Random();
                x1 = randomNum.nextInt(4);
                y1 = randomNum.nextInt(4);
                x2 = randomNum.nextInt(4);
                y2 = randomNum.nextInt(4);

                refreshBtn();

                positioning(x1, y1, x2, y2);
                Log.d(TAG, "onClick: " + String.valueOf(x1) + " " + String.valueOf(y1) + " " + String.valueOf(x2) + " " + String.valueOf(y2));
            }
        });

        //save queen handling
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "saveBtn " + String.valueOf(x1) + " " + String.valueOf(y1) + " " + String.valueOf(x2) + " " + String.valueOf(y2));

                posXofR();
                posYofR();

                result.setText(mVisitedNodes.toString());
                mVisitedNodes.delete(0, mVisitedNodes.length());
                mVisitedNodes.append("Visited Nodes: ");

            }
        });


    }

    private void buttonInitialization() {
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
        btn10 = findViewById(R.id.button_10);
        btn11 = findViewById(R.id.button_11);
        btn12 = findViewById(R.id.button_12);
        btn13 = findViewById(R.id.button_13);
        btn14 = findViewById(R.id.button_14);
        btn15 = findViewById(R.id.button_15);
        btn16 = findViewById(R.id.button_16);
    }

    private void posXofR() {
        if (x1 < x2 && y1 != y2) {
            while (x1 != x2) {
                x2--;
                posX(x2, y2);
                Log.d(TAG, "onClick:x " + String.valueOf(x2));

                visitedNodes();
                //visitedNodes.append("(" + String.valueOf(x2) + ", " + String.valueOf(y2) + "), ");

            }
        } else if (x2 < x1 && y1 != y2) {
            while (x1 != x2) {
                x2++;
                posX(x2, y2);
                Log.d(TAG, "onClick:x " + String.valueOf(x2));
                visitedNodes();
            }
        } else if (y1 == y2 && x1 + 1 < x2) {
            while (x1 + 1 != x2) {
                x2--;
                posX(x2, y2);
                Log.d(TAG, "onClick:x " + String.valueOf(x2));
                visitedNodes();
            }
        } else if (y1 == y2 && x2 + 1 < x1) {
            while (x1 != x2 + 1) {
                x2++;
                posX(x2, y2);
                Log.d(TAG, "onClick:x " + String.valueOf(x2));
                visitedNodes();
            }
        }
    }

    private void posYofR() {
        if (y1 + 1 < y2) {
            while (y1 + 1 != y2) {
                y2--;
                posX(x2, y2);
                Log.d(TAG, "onClick:y " + String.valueOf(y2));
                visitedNodes();
            }
        } else if (y2 + 1 < y1) {
            while (y1 != y2 + 1) {
                y2++;
                posX(x2, y2);
                Log.d(TAG, "onClick:y " + String.valueOf(y2));
                visitedNodes();
            }
        }
    }

    private void refreshBtn() {
        // refreshing button
        for (int i = 0; i < 16; i++) {
            btn[i].setText("");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: called");
        positioning(x1, y1, 3, 3);
    }

    private void positioning(int x1, int y1, int x2, int y2) {

        /*for (int i = 0, k =0; i < 4; i++, k++) {
            for (int j = 0; j < 4; j++) {
                if(x1 == i && y1 == j) {
                    btn[k].setText("Q");
                }
            }
        }*/

        // queen position
        if (x1 == 0 && y1 == 0) {
            btn1.setText("Q");
        } else if (x1 == 0 && y1 == 1) {
            btn2.setText("Q");
        } else if (x1 == 0 && y1 == 2) {
            btn3.setText("Q");
        } else if (x1 == 0 && y1 == 3) {
            btn4.setText("Q");
        } else if (x1 == 1 && y1 == 0) {
            btn5.setText("Q");
        } else if (x1 == 1 && y1 == 1) {
            btn6.setText("Q");
        } else if (x1 == 1 && y1 == 2) {
            btn7.setText("Q");
        } else if (x1 == 1 && y1 == 3) {
            btn8.setText("Q");
        } else if (x1 == 2 && y1 == 0) {
            btn9.setText("Q");
        } else if (x1 == 2 && y1 == 1) {
            btn10.setText("Q");
        } else if (x1 == 2 && y1 == 2) {
            btn11.setText("Q");
        } else if (x1 == 2 && y1 == 3) {
            btn12.setText("Q");
        } else if (x1 == 3 && y1 == 0) {
            btn12.setText("Q");
        } else if (x1 == 3 && y1 == 1) {
            btn14.setText("Q");
        } else if (x1 == 3 && y1 == 2) {
            btn15.setText("Q");
        } else if (x1 == 3 && y1 == 3) {
            btn16.setText("Q");
        }

        // robot position

        if (x2 == 0 && y2 == 0) {
            btn1.setText("R");
        } else if (x2 == 0 && y2 == 1) {
            btn2.setText("R");
        } else if (x2 == 0 && y2 == 2) {
            btn3.setText("R");
        } else if (x2 == 0 && y2 == 3) {
            btn4.setText("R");
        } else if (x2 == 1 && y2 == 0) {
            btn5.setText("R");
        } else if (x2 == 1 && y2 == 1) {
            btn6.setText("R");
        } else if (x2 == 1 && y2 == 2) {
            btn7.setText("R");
        } else if (x2 == 1 && y2 == 3) {
            btn8.setText("R");
        } else if (x2 == 2 && y2 == 0) {
            btn9.setText("R");
        } else if (x2 == 2 && y2 == 1) {
            btn10.setText("R");
        } else if (x2 == 2 && y2 == 2) {
            btn11.setText("R");
        } else if (x2 == 2 && y2 == 3) {
            btn12.setText("R");
        } else if (x2 == 3 && y2 == 0) {
            btn13.setText("R");
        } else if (x2 == 3 && y2 == 1) {
            btn14.setText("R");
        } else if (x2 == 3 && y2 == 2) {
            btn15.setText("R");
        } else if (x2 == 3 && y2 == 3) {
            btn16.setText("R");
        }
    }

    private void posX(int x2, int y2) {


        if (x2 == 0 && y2 == 0) {
            btn1.setText("R");
        } else if (x2 == 0 && y2 == 1) {
            btn2.setText("R");
        } else if (x2 == 0 && y2 == 2) {
            btn3.setText("R");
        } else if (x2 == 0 && y2 == 3) {
            btn4.setText("R");
        } else if (x2 == 1 && y2 == 0) {
            btn5.setText("R");
        } else if (x2 == 1 && y2 == 1) {
            btn6.setText("R");
        } else if (x2 == 1 && y2 == 2) {
            btn7.setText("R");
        } else if (x2 == 1 && y2 == 3) {
            btn8.setText("R");
        } else if (x2 == 2 && y2 == 0) {
            btn9.setText("R");
        } else if (x2 == 2 && y2 == 1) {
            btn10.setText("R");
        } else if (x2 == 2 && y2 == 2) {
            btn11.setText("R");
        } else if (x2 == 2 && y2 == 3) {
            btn12.setText("R");
        } else if (x2 == 3 && y2 == 0) {
            btn13.setText("R");
        } else if (x2 == 3 && y2 == 1) {
            btn14.setText("R");
        } else if (x2 == 3 && y2 == 2) {
            btn15.setText("R");
        } else if (x2 == 3 && y2 == 3) {
            btn16.setText("R");
        }
    }

    private void visitedNodes() {
        mVisitedNodes.append("(").append(String.valueOf(x2)).append(", ").append(String.valueOf(y2)).append("), ");
    }

    private void mSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
