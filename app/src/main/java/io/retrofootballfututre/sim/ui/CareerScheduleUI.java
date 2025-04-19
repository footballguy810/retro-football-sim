package io.retrofootballfuture.sim.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.retrofootballfuture.sim.career.CareerScheduler;
import io.retrofootballfuture.sim.model.Player;

public class CareerScheduleUI extends AppCompatActivity {

    private Player player;
    private CareerScheduler scheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        player = new Player("Alex Hero", 18);
        scheduler = new CareerScheduler(player);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        scheduler.generateWeeklySchedule();

        for (String event : scheduler.getWeeklySchedule()) {
            TextView tv = new TextView(this);
            tv.setText(event);
            layout.addView(tv);
        }

        scrollView.addView(layout);
        setContentView(scrollView);
    }
}
