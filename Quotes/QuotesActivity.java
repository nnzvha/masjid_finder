package com.example.masjidfinder;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class QuotesActivity extends AppCompatActivity {
 ListView listView;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 EdgeToEdge.enable(this);
 setContentView(R.layout.activity_quotes);
 listView = (ListView) findViewById(R.id.listView1);
 String[] values = new String[]{
 "Do not sell your conscience for anything but Jannah.",
 "Truth lifts the heart like water refreshes thirst.",
 "Every soul shall taste death.",
 "When love of this world enters the heart, the fear of the hereafter exits from it.",
 "Knowledge is not what is memorised. Knowledge is what benefits.",
 "Knowledge is the life the mind.",
 "Know that you cannot love Allah until you love obeying him!",
 "The bravest heart is the one that stay close to ''Allah', even when it's in pain.",
 "Tears are prayer too, they travel to Allah when we can't speak.",
 "Don't be sad Allah is with you.",
 "Nothing in this world is permanent.",
 "The dua on your tongue tells about the love in your secret."
 };
 ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, 
android.R.layout.simple_expandable_list_item_1, android.R.id.text1, values);
 listView.setAdapter(adapter);
 ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
 Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
 v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
 return insets;
 });
 }
}
