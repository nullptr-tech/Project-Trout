package ptr.anull.project_trout;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;

public class WelcomeActivity extends AppCompatActivity {
    private VideoView video_content;
    private Button login, signup;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(WelcomeActivity.this, SwipingActivity.class));
            finish();
        }
        setContentView(R.layout.activity_welcome);

        // assigns the button and video to a variable

        video_content = (VideoView) findViewById(R.id.videoContent);
        login = (Button) findViewById(R.id.rd_login);
        signup = (Button) findViewById(R.id.rd_signup);
        // gets the video path
        String videoPath = "android.resource://ptr.anull.project_trout/"+ R.raw.welcomevideo;
        Uri videoUri = Uri.parse(videoPath);
        video_content.setVideoURI(videoUri);
        video_content.start();

        video_content.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slidein_right, R.anim.slideout_left);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, SignupActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slidein_left, R.anim.slideout_right);
            }
        });
    }

    @Override
    protected void onResume(){
        video_content.start();
        super.onResume();
    }

    @Override
    protected void onPause(){
        video_content.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        video_content.stopPlayback();
        super.onDestroy();
    }
}
