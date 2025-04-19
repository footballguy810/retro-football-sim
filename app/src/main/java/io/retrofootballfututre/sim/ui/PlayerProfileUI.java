package io.retrofootballfuture.sim.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.retrofootballfuture.sim.model.Player;

public class PlayerProfileUI extends AppCompatActivity {

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        player = new Player("Jordan Steel", 19);
        player.generateStartingAttributes();

        ScrollView scrollView = new ScrollView(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView name = new TextView(this);
        name.setText("Name: " + player.getName());

        TextView age = new TextView(this);
        age.setText("Age: " + player.getAge());

        TextView stats = new TextView(this);
        stats.setText(player.getFullProfileSummary());

        layout.addView(name);
        layout.addView(age);
        layout.addView(stats);

        scrollView.addView(layout);
        setContentView(scrollView);
    }
}
