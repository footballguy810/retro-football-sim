package io.retrofootballfuture.sim.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.retrofootballfuture.sim.model.Player;
import io.retrofootballfuture.sim.model.Team;

public class RosterViewerUI extends AppCompatActivity {

    private Team currentTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentTeam = new Team("Sharks");
        currentTeam.autoGenerateRoster(22);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        for (Player p : currentTeam.getRoster()) {
            TextView playerInfo = new TextView(this);
            playerInfo.setText(p.getFullProfileSummary());
            layout.addView(playerInfo);
        }

        scrollView.addView(layout);
        setContentView(scrollView);
    }
}
