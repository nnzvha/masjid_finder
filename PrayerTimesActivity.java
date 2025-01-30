package com.example.masjidfinder;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class PrayerTimesActivity extends AppCompatActivity {
 Button open_zon1, open_zon2, open_zon3;
 @SuppressLint("MissingInflatedId")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 EdgeToEdge.enable(this);
 setContentView(R.layout.activity_prayer_times);
 ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
 Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
 v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
 return insets;
 });
 open_zon1 = (Button) findViewById(R.id.button1);
 open_zon2 = (Button) findViewById(R.id.button2);
 open_zon3 = (Button) findViewById(R.id.button3);
 }
 public void open_zon1(View view) {
 Intent intent = new Intent(this, List_Zon1.class);
 startActivity(intent);
 }
 public void open_zon2(View view) {
 Intent intent = new Intent(this, List_Zon2.class);
 startActivity(intent);
 }
 public void open_zon3(View view) {
 Intent intent = new Intent(this, List_Zon3.class);
 startActivity(intent);
 }
}
