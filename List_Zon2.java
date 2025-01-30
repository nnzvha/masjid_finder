package com.example.masjidfinder;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class List_Zon2 extends AppCompatActivity implements View.OnClickListener {
 private Button button1_sbh, button2_zhr, button3_asr, button4_mgrb, button5_isya;
 public CharSequence title = " ";
 public CharSequence prayerTime = " ";
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 EdgeToEdge.enable(this);
 Log.d("list_zon2", "Activity created");
 setContentView(R.layout.activity_list_zon2);
 // Check and request POST_NOTIFICATIONS permission for Android 13+ (API 33)
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
 if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != 
PackageManager.PERMISSION_GRANTED) {
 requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 100);
 }
 }
 ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
 Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
 v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
 return insets;
 });
 button1_sbh = findViewById(R.id.button1_sbh);
 button2_zhr = findViewById(R.id.button2_zhr);
 button3_asr = findViewById(R.id.button3_asr);
 button4_mgrb = findViewById(R.id.button4_mgrb);
 button5_isya = findViewById(R.id.button5_isya);
 button1_sbh.setOnClickListener(this);
 button2_zhr.setOnClickListener(this);
 button3_asr.setOnClickListener(this);
 button4_mgrb.setOnClickListener(this);
 button5_isya.setOnClickListener(this);
 Log.d("list_zon2", "Button listeners attached");
 }
 @RequiresApi(api = Build.VERSION_CODES.O)
 @Override
 public void onClick(View v) {
 if (v.getId() == R.id.button1_sbh) {
 prayerTime = "Subuh";
 notificationDialog();
 } else if (v.getId() == R.id.button2_zhr) {
 prayerTime = "Zuhur";
 notificationDialog();
 } else if (v.getId() == R.id.button3_asr) {
 prayerTime = "Asar";
 notificationDialog();
 } else if (v.getId() == R.id.button4_mgrb) {
 prayerTime = "Maghrib";
 notificationDialog();
 } else if (v.getId() == R.id.button5_isya) {
 prayerTime = "Isya'";
 notificationDialog();
 }
 }
 @RequiresApi(api = Build.VERSION_CODES.O)
 private void notificationDialog() {
 NotificationManager notificationManager = (NotificationManager) 
getSystemService(Context.NOTIFICATION_SERVICE);
 if (notificationManager == null) {
 Log.e("NotificationError", "NotificationManager is null");
 return;
 }
 String NOTIFICATION_CHANNEL_ID = "tutorialspoint_01";
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
 NotificationChannel notificationChannel = new NotificationChannel(
 NOTIFICATION_CHANNEL_ID,
 "My Notifications",
 NotificationManager.IMPORTANCE_HIGH
 );
 notificationChannel.setDescription("Sample Channel description");
 notificationChannel.enableLights(true);
 notificationChannel.setLightColor(Color.RED);
 notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
 notificationChannel.enableVibration(true);
 notificationManager.createNotificationChannel(notificationChannel);
 }
 NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, 
NOTIFICATION_CHANNEL_ID)
 .setAutoCancel(true)
 .setDefaults(Notification.DEFAULT_ALL)
 .setWhen(System.currentTimeMillis())
 .setSmallIcon(R.mipmap.ic_launcher_round) // Ensure this drawable exists
 .setContentTitle("Zon 2")
 .setContentText( prayerTime + " reminder has been set!")
 .setContentInfo("Info");
 notificationManager.notify(prayerTime.hashCode(), notificationBuilder.build());
 }
}
