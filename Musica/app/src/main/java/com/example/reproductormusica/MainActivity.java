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

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Button btnPlay;
    private Button btnPause;
    private TextView tvNombreCancion;
    private TextView tvActual;
    private TextView tvFinal;
    private Handler handler = new Handler();
    private Button btnCounter;
    private Button btnlevelUp;
    private Button btnBrawlStars;
    private Button btnLoading;
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

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        tvNombreCancion = findViewById(R.id.tvNombreCancion);
        tvActual = findViewById(R.id.tvActual);
        tvFinal = findViewById(R.id.tvFinal);
        seekBar = findViewById(R.id.seekbar);
        btnCounter = findViewById(R.id.btnCounter);
        btnlevelUp = findViewById(R.id.btnlevelUp);
        btnBrawlStars = findViewById(R.id.btnBrawlStars);
        btnLoading = findViewById(R.id.btnLoading);

        //Ejercicio 1. Reproductor de música
        tvNombreCancion.setText("Michael Jackson - Billie Jean");

        mediaPlayer = MediaPlayer.create(this, R.raw.michael_jackson_billie_jean);

        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(mp -> {
                if (seekBar != null) {
                    seekBar.setMax(mediaPlayer.getDuration());
                }
                int duracionTotal = mediaPlayer.getDuration();
                int minutos = (duracionTotal / 1000) / 60;
                int segundos = (duracionTotal / 1000) % 60;
                String tiempoFinal = String.format("%02d:%02d", minutos, segundos);
                tvFinal.setText(tiempoFinal);
            });

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
        } else {
            tvNombreCancion.setText("Error: No se pudo cargar la canción");
        }

        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser && mediaPlayer != null) {
                        mediaPlayer.seekTo(progress);
                    }
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }

        //Ejercicio 2. Sonidos con SoundPool
        btnCounter.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(this, R.raw.bomba_counter);
            mediaPlayer.start();
        });
        btnlevelUp.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(this, R.raw.level_up);
            mediaPlayer.start();
        });
        btnBrawlStars.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(this, R.raw.brawl_stars);
            mediaPlayer.start();
        });
        btnLoading.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(this, R.raw.loading_si);
            mediaPlayer.start();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}