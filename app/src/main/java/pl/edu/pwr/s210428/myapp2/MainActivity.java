package pl.edu.pwr.s210428.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import pl.edu.pwr.s210428.myapp2.Player;

public class MainActivity extends AppCompatActivity {
    private Button[] buttons;
    private int[] win;
    private TextView text;
    private Player p1;
    private Player p2;
    private Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wygr = null;
        buttons = new Button[9];
        win = new int[9];
        for(int i=0;i<=8;i++)
        {
            win[i]=0;
        }
        text = (TextView)findViewById(R.id.textView);

        buttons[0] = (Button)findViewById(getResources().getIdentifier("button","id",getPackageName()));
        for(int i=1;i<=8;i++)
        {
            buttons[i] = (Button)findViewById(getResources().getIdentifier("button"+i,"id",getPackageName()));
        }
//        Inicjalizacja zmiennych
        init();
//        Tworzenie planszy i graczy
        newgame();



        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[0].setText(game.active.znak);
                changeplayer(game);
                buttons[0].setEnabled(false);
                win[0]=game.active.val;
            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[1].setText(game.active.znak);
                changeplayer(game);
                buttons[1].setEnabled(false);
                win[1]=game.active.val;

            }
        });


        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[2].setText(game.active.znak);
                changeplayer(game);
                buttons[2].setEnabled(false);
                win[2]=game.active.val;

            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[3].setText(game.active.znak);
                changeplayer(game);
                buttons[3].setEnabled(false);
                win[3]=game.active.val;

            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[4].setText(game.active.znak);
                changeplayer(game);
                buttons[4].setEnabled(false);
                win[4]=game.active.val;
            }
        });

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[5].setText(game.active.znak);
                changeplayer(game);
                buttons[5].setEnabled(false);
                win[5]=game.active.val;
            }
        });


        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[6].setText(game.active.znak);
                changeplayer(game);
                buttons[6].setEnabled(false);
                win[6]=game.active.val;
            }
        });

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[7].setText(game.active.znak);
                changeplayer(game);
                buttons[7].setEnabled(false);
                win[7]=game.active.val;
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[8].setText(game.active.znak);
                changeplayer(game);
                buttons[8].setEnabled(false);
                win[8]=game.active.val;
            }
        });


        Button newgame = (Button)findViewById(R.id.button10);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newgame();

            }
        });

    }

    private void init() {
        game = new Game();
        p1 = new Player("Player 1","X",true,1);
        p2 = new Player("Player 2","O",false,2);
    }


    private void newgame()
    {
        init();
        for(int i= 0;i<=8;i++)
        {
            buttons[i].setText(" ");
            buttons[i].setEnabled(true);
        }
        initgameplayers();
    }

    private void initgameplayers()
    {
        game.active=p1;
        whoplayer(game.active);
    }

    public void whoplayer(Player p) {
        text.setText("Ruch Gracza "+p.name);
    }

    private void changeplayer(Game game)
    {
        if(game.active == p1)
        {
            game.active = p2;
            whoplayer(game.active);
        }
        else{
            game.active = p1;
            whoplayer(game.active);
        }

    }





}
