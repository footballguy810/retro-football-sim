package io.retrofootballfuture.sim.ui;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.retrofootballfuture.sim.engine.MatchSimulator;
import io.retrofootballfuture.sim.model.Team;

public class MatchSimulatorUI extends AppCompatActivity {

    private TextView matchLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        matchLog = new TextView(this);
        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(matchLog);

        setContentView(scrollView);

        Team homeTeam = new Team("Hawks");
        Team awayTeam = new Team("Tigers");

        // Add test players (replace with real teams in production)
        homeTeam.autoGenerateRoster(22);
        awayTeam.autoGenerateRoster(22);

        MatchSimulator simulator = new MatchSimulator();
        String result = simulator.simulateGame(homeTeam, awayTeam);

        matchLog.setText(result);
    }
}
