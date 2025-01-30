package com.example.masjidfinder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class ProfileActivity extends AppCompatActivity {
 FirebaseAuth auth;
 FirebaseUser user;
 TextView profileText;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 EdgeToEdge.enable(this);
 setContentView(R.layout.activity_authentication_masjid);
 auth = FirebaseAuth.getInstance();
 profileText = (TextView)findViewById(R.id.textView);
 user = auth.getCurrentUser();
 profileText.setText(user.getEmail());
 }
 public void signout(View v){
 auth.signOut();
 finish();
 Intent i = new Intent(this,MainActivity.class);
 startActivity(i);
 }
}
