package com.example.masjidfinder;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class ZikrActivity extends AppCompatActivity {
 private MediaPlayer mediaPlayer;
 private int[] zkirAudios = {
 R.raw.zkir1,
 R.raw.zkir11,
 R.raw.zkir2,
 R.raw.zkir10,
 R.raw.zkir3,
 R.raw.zkir4,
 R.raw.zkir7,
 R.raw.zkir8,
 R.raw.zkir9,
 R.raw.zkir6
 };
 private String[] zkirNames = {
 "Zikir Penenang Hati Dan Jiwa",
 "Zikir Keamanan",
 "Zikir Tasbih Fatimah",
 "Zikir Hasbunallah",
 "Zikir Taubat",
 "Zikir Tahmid",
 "Zikir Tahlil",
 "Zikir Tasbih",
 "Zikir Takbir",
 "Asmaul Husna"
 };
 private Button playButton, pauseButton, stopButton;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_zikr);
 ListView zkirList = findViewById(R.id.zkir_list);
 playButton = findViewById(R.id.play_button);
 pauseButton = findViewById(R.id.pause_button);
 stopButton = findViewById(R.id.stop_button);
 // Set up ListView with Zkir names
 ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
android.R.layout.simple_list_item_1, zkirNames);
 zkirList.setAdapter(adapter);
 zkirList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
 // Stop current audio if playing
 if (mediaPlayer != null) {
 mediaPlayer.stop();
 mediaPlayer.release();
 }
 // Initialize MediaPlayer with selected Zkir audio
 mediaPlayer = MediaPlayer.create(ZikrActivity.this, zkirAudios[position]);
 Toast.makeText(ZikrActivity.this, "Selected: " + zkirNames[position], 
Toast.LENGTH_SHORT).show();
 }
 });
 playButton.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 if (mediaPlayer != null) {
 mediaPlayer.start();
 } else {
 Toast.makeText(ZikrActivity.this, "Select a Zkir first", Toast.LENGTH_SHORT).show();
 }
 }
 });
 pauseButton.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 if (mediaPlayer != null && mediaPlayer.isPlaying()) {
 mediaPlayer.pause();
 }
 }
 });
 stopButton.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 if (mediaPlayer != null) {
 mediaPlayer.stop();
 mediaPlayer.release();
 mediaPlayer = null;
 }
 }
 });
 }
 @Override
 protected void onDestroy() {
 super.onDestroy();
 if (mediaPlayer != null) {
 mediaPlayer.release();
 mediaPlayer = null;
 }
 }
}
