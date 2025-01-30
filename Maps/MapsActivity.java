package com.example.masjidfinder;
import androidx.fragment.app.FragmentActivity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.masjidfinder.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
 private GoogleMap mMap;
 private ActivityMapsBinding binding;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 binding = ActivityMapsBinding.inflate(getLayoutInflater());
 setContentView(binding.getRoot());
 // Obtain the SupportMapFragment and get notified when the map is ready to be used.
 SupportMapFragment mapFragment = (SupportMapFragment) 
getSupportFragmentManager()
 .findFragmentById(R.id.map);
 mapFragment.getMapAsync(this);
 }
 @Override
 public void onMapReady(GoogleMap googleMap) {
 mMap = googleMap;
 // List of mosque locations in Selangor, including Klang and Shah Alam
 List<LatLng> mosqueLocations = Arrays.asList(
 new LatLng(3.0738, 101.5183), // Masjid Sultan Salahuddin Abdul Aziz Shah, Shah 
Alam
 new LatLng(3.0648, 101.4851), // Masjid Tengku Ampuan Jemaah, Shah Alam
 new LatLng(3.1560, 101.6890), // Masjid Negara
 new LatLng(3.0201, 101.4468), // Masjid Puncak Alam
 new LatLng(2.9434, 101.7916), // Masjid Al-Azhar, Bangi
 new LatLng(3.0315, 101.4461), // Masjid Bandar Diraja Klang, Klang
 new LatLng(3.0350, 101.4543), // Masjid Jamek Sultan Sulaiman, Klang
 new LatLng(3.0866, 101.5051) // Masjid Al-Falah, Shah Alam
 );
 // Add markers for each mosque
 for (LatLng location : mosqueLocations) {
 mMap.addMarker(new MarkerOptions()
 .position(location)
 .title("Masjid Location"));
 }
 // Center the map on Selangor and adjust the zoom level
 LatLng selangorCenter = new LatLng(3.0738, 101.5183);
 mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(selangorCenter, 10));
 }
 public void onMapSearch(View view) {
 EditText locationSearch = (EditText) findViewById(R.id.editText);
 String location = locationSearch.getText().toString();
 List<Address> addressList = null;
 if (location != null || !location.equals("")) {
 Geocoder geocoder = new Geocoder(this);
 try {
 addressList = geocoder.getFromLocationName(location, 1);
 } catch (IOException e) {
 e.printStackTrace();
 }
 Address address = addressList.get(0);
 LatLng latLng = new LatLng(address.getLatitude(),
 address.getLongitude());
 mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
 mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
 }
 }
}
