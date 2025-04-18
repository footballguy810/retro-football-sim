package io.retrofootballfuture.sim;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Player p1 = new Player("Alex", 20);
        Player p2 = new Player("Blake", 22);

        Team teamA = new Team("Sharks");
        Team teamB = new Team("Wolves");

        teamA.addPlayer(p1);
        teamB.addPlayer(p2);

        GameEngine gameEngine = new GameEngine(teamA, teamB);
        String result = gameEngine.simulateGame();

        TextView tv = new TextView(this);
        tv.setText(result);
        setContentView(tv);
    }
}