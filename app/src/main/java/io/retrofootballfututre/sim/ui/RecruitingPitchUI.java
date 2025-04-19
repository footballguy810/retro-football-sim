package io.retrofootballfuture.sim.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.retrofootballfuture.sim.recruiting.RecruitingPitch;
import io.retrofootballfuture.sim.model.Player;
import io.retrofootballfuture.sim.model.College;

public class RecruitingPitchUI extends AppCompatActivity {

    private Player recruit;
    private College college;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recruit = new Player("Brandon Blaze", 17);
        college = new College("East Central Tigers", "Division I", "Large");

        RecruitingPitch pitch = new RecruitingPitch(college, recruit);
        String pitchText = pitch.generatePitch();

        ScrollView scrollView = new ScrollView(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView pitchView = new TextView(this);
        pitchView.setText(pitchText);

        layout.addView(pitchView);
        scrollView.addView(layout);
        setContentView(scrollView);
    }
}
