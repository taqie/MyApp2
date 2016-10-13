package pl.edu.pwr.s210428.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button[] buttons;
    private int[] win;
    private String[] winZ;
    private TextView text;
    private Player p1;
    private Player p2;
    private Game game;
    private int n;
    private TextView textwin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons = new Button[9];
        text = (TextView)findViewById(R.id.textView);
        textwin = (TextView)findViewById(R.id.textView2);

        buttons[0] = (Button)findViewById(getResources().getIdentifier("button","id",getPackageName()));
        for(int i=1;i<=8;i++)
        {
            buttons[i] = (Button)findViewById(getResources().getIdentifier("button"+i,"id",getPackageName()));
        }
//        Inicjalizacja zmiennych
//        init();
//        Tworzenie planszy i graczy
        newgame();



        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[0].setText(game.active.znak);
                addpoint(game,0);
                check_win(game,0);
                changeplayer(game);
                buttons[0].setEnabled(false);

            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[1].setText(game.active.znak);
                addpoint(game,1);
                check_win(game,1);
                changeplayer(game);
                buttons[1].setEnabled(false);

            }
        });


        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[2].setText(game.active.znak);
                addpoint(game,2);
                check_win(game,2);
                changeplayer(game);
                buttons[2].setEnabled(false);

            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[3].setText(game.active.znak);
                addpoint(game,3);
                check_win(game,3);
                changeplayer(game);
                buttons[3].setEnabled(false);

            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[4].setText(game.active.znak);
                addpoint(game,4);
                check_win(game,4);
                changeplayer(game);
                buttons[4].setEnabled(false);
            }
        });

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[5].setText(game.active.znak);
                addpoint(game,5);
                check_win(game,5);
                changeplayer(game);
                buttons[5].setEnabled(false);
            }
        });


        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[6].setText(game.active.znak);
                addpoint(game,6);
                check_win(game,6);
                changeplayer(game);
                buttons[6].setEnabled(false);
            }
        });

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[7].setText(game.active.znak);
                addpoint(game,7);
                check_win(game,7);
                changeplayer(game);
                buttons[7].setEnabled(false);;
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[8].setText(game.active.znak);
                addpoint(game,8);
                check_win(game,8);
                changeplayer(game);
                buttons[8].setEnabled(false);
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
        n=3;
        game = new Game();
        p1 = new Player("Player 1","X",true,1);
        p2 = new Player("Player 2","O",false,2);
        textwin.setText("Wygrał gracz = ");
    }


    private void newgame()
    {
        init();
        setButtonsval(" ");
        setButtonsenab(true);
        initgameplayers();
        initwin();
    }
    private void setButtonsval(String val)
    {
        for(int i= 0;i<=8;i++)
        {
            buttons[i].setText(val);
        }
    }
    private void setButtonsenab(boolean enable)
    {
        for(int i= 0;i<=8;i++)
        {
            buttons[i].setEnabled(enable);
        }
    }


    private void initgameplayers()
    {
        game.active=p1;
        whoplayer(game.active);
    }

    private void initwin()
    {
        winZ = new String[9];
        Arrays.fill(winZ,"");
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

    private void addpoint(Game game, int btn)
    {
        if(game.active.znak == "X")
        {
            winZ[btn]=game.active.znak;
        }
        else
        {
            winZ[btn]=game.active.znak;
        }
    }

    private boolean pion(Game game)
    {
        int sum=0;
        for(int i=0;i<=2;i++)
        {
            for (int j=i;j<(n*3);j+=n)
            {
                if(game.active.znak == winZ[j])
                {
                    Log.d("j = ",""+j);
                    sum = sum +1;
                    Log.d("Sum = ",""+sum);
                }
            }
            if(sum==3)
            {
                return true;
            }
            sum=0;
        }

        return false;
    }


    private boolean allchar(int n, int z, Game game)
    {
        boolean win=false;
        int sum = 0;
        for(int i=((n*z)-n);i<=((z*n)-1);i++)
        {
            if(game.active.znak == winZ[i])
            {

                sum = sum +1;
                win = true;
            }
        }
        if(sum == 3) { // trzeba zmienic na n dla wieszej ilosci pol
            return win;
        }
        return false;
    }


    private void check_win(Game game, int btn)
    {
        for(int z=1;z<=(n+1);z++)// trzeba zmienic na n+1 dla wieszej ilosci pol
        {
            if(btn >= ((n*z)-n) && btn <=((z*n)-1))
            {
                if(allchar(n,z,game))
                {
                    textwin.setText("Wygrał gracz : "+game.active.name);
                    setButtonsenab(false);
                }
            }
        }
        if(pion(game))
        {
            textwin.setText("Wygrał gracz : "+game.active.name);
            setButtonsenab(false);
        }
    }


}
