package com.example.masjidfinder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 // Navigate to Map page
 Button btnMap = findViewById(R.id.map_button);
 btnMap.setOnClickListener(v -> {
 Intent intent = new Intent(MainActivity.this, MapsActivity.class);
 startActivity(intent);
 });
 // Navigate to Prayer Times page
 Button btnPrayerTimes = findViewById(R.id.prayer_times_button);
 btnPrayerTimes.setOnClickListener(v -> {
 Intent intent = new Intent(MainActivity.this, PrayerTimesActivity.class);
 startActivity(intent);
 });
 // Navigate to Zikr page
 Button btnZikr = findViewById(R.id.zikr_button);
 btnZikr.setOnClickListener(v -> {
 Intent intent = new Intent(MainActivity.this, ZikrActivity.class);
 startActivity(intent);
 });
 // Navigate to Quotes page
 Button btnQuotes = findViewById(R.id.quotes_button);
 btnQuotes.setOnClickListener(v -> {
 Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
 startActivity(intent);
 });
 // Navigate to About Us page
 Button btnAboutUs = findViewById(R.id.about_us_button);
 btnAboutUs.setOnClickListener(v -> {
 Intent intent = new Intent(MainActivity.this, AboutUs.class);
 startActivity(intent);
 });
 Button btnLogOut = findViewById(R.id.logout_button);
 btnLogOut.setOnClickListener(v -> {
 Intent intent = new Intent(MainActivity.this, AuthenticationMasjid.class);
 startActivity(intent);
 });
 }
}

