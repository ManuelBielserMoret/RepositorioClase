package com.example.reproductormusica;

import android.os.Bundle;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Struct;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Button btnPlay;
    private Button btnPause;
    private TextView tvNombreCancion;
    private TextView tvActual;
    private TextView tvFinal;
    private Handler handler = new Handler();
    private Runnable actualizarTiempo = new Runnable() {
        @Override
        public void run() {
            if (mediaPlayer != null) {
                int posicionActual = mediaPlayer.getCurrentPosition();
                seekBar.setProgress(posicionActual);

                int minutos = (posicionActual / 1000) / 60;
                int segundos = (posicionActual / 1000) % 60;
                String tiempoActual = String.format("%02d:%02d", minutos, segundos);
                tvActual.setText(tiempoActual);
                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.bruno_mars_song);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        tvNombreCancion = findViewById(R.id.tvNombreCancion);
        tvActual = findViewById(R.id.tvActual);
        tvFinal = findViewById(R.id.tvFinal);
        seekBar = findViewById(R.id.seekbar);

        tvNombreCancion.setText("Bruno Mars - That's what I like");

        btnPlay.setOnClickListener(v -> {
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                handler.post(actualizarTiempo);
            }
        });
        btnPause.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                handler.removeCallbacks(actualizarTiempo);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}