package io.retrofootballfuture.sim.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.retrofootballfuture.sim.engine.MatchSimulator;
import io.retrofootballfuture.sim.model.Team;

public class GameDayUI extends AppCompatActivity {

    private Team homeTeam;
    private Team awayTeam;
    private TextView gameSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeTeam = new Team("Dragons");
        awayTeam = new Team("Panthers");

        homeTeam.autoGenerateRoster(22);
        awayTeam.autoGenerateRoster(22);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        gameSummary = new TextView(this);
        Button simulateButton = new Button(this);
        simulateButton.setText("Simulate Game");

        simulateButton.setOnClickListener(v -> {
            MatchSimulator simulator = new MatchSimulator();
            String result = simulator.simulateGame(homeTeam, awayTeam);
            gameSummary.setText(result);
        });

        layout.addView(simulateButton);
        layout.addView(gameSummary);
        setContentView(layout);
    }
}
