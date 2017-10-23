package com.example.navigationdrawer;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.database.sqlite.*;
 
/*public class FragmentThree extends Fragment {
 
	  public static Fragment newInstance(Context context) {
    	FragmentThree f = new FragmentThree();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_three, null);
        return root;
    }


    
 
}*/

public class FragmentThree extends Fragment  implements
GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener,
LocationListener,OnMarkerClickListener
{
	
	GoogleMap map;
    LatLng latlng;
    private LocationRequest lr;
    private LocationClient lc;
    MapFragment mapFragment;
    ImageView iv;
    private static View view;

    public FragmentThree() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }

        try {
            view = inflater.inflate(R.layout.fragment_three, container,
                    false);

            mapFragment = ((MapFragment) this.getActivity()
                    .getFragmentManager().findFragmentById(R.id.map));
            iv = (ImageView) view.findViewById(R.id.iv);

            map = mapFragment.getMap();
            map.getUiSettings().setAllGesturesEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(false);
            map.setMyLocationEnabled(true);
            map.getUiSettings().setZoomControlsEnabled(false);

            MapsInitializer.initialize(this.getActivity());
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.setMyLocationEnabled(true);
            map.setTrafficEnabled(true);
            map.setOnMarkerClickListener(this);
        } 
         catch (InflateException e) {
            Toast.makeText(getActivity(), "Problems inflating the view !",
                    Toast.LENGTH_LONG).show();
        } catch (NullPointerException e) {
            Toast.makeText(getActivity(), "Google Play Services missing !",
                    Toast.LENGTH_LONG).show();
        }

        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lr = LocationRequest.create();
        lr.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        lc = new LocationClient(this.getActivity().getApplicationContext(),
                this, this);
        lc.connect();
    }

    @Override
    public void onLocationChanged(Location l2) {
      // CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
       //         new LatLng(l2.getLatitude(), l2.getLongitude()), 15);
       // map.animateCamera(cameraUpdate);
    	Time today = new Time(Time.getCurrentTimezone());
    	today.setToNow();
        map.addMarker(new MarkerOptions()
        .position(new LatLng(l2.getLatitude(), l2.getLongitude()))
        .title("You")
        .snippet("You")
        .flat(false));
        
    }
	
	
	
	/*
	 private SupportMapFragment map;
	// private GoogleMap googleMap;
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
         ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_three, null);
         return root;
     }


  @Override
   public void onActivityCreated(Bundle savedInstanceState) {
       // TODO Auto-generated method stub
       super.onActivityCreated(savedInstanceState);
       
       
       
       android.support.v4.app.FragmentManager fm = getChildFragmentManager();
       map = (SupportMapFragment) fm.findFragmentById(R.id.map);
       if (map == null) {
           map = SupportMapFragment.newInstance();
           fm.beginTransaction().replace(R.id.map, map).commit();

       }
          try{
       googleMap = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
       }
       catch(Exception e)
       {
    	    e.printStackTrace();
                   
       }
      Location myLocation = googleMap.getMyLocation();
      LatLng myLatLng = new LatLng(myLocation.getLatitude(),
              myLocation.getLongitude());
      googleMap.addMarker(new MarkerOptions()
      .position(myLatLng)
      .title("You"));*/
      
  


@Override
public void onConnectionFailed(ConnectionResult arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void onConnected(Bundle arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void onDisconnected() {
	// TODO Auto-generated method stub
	
}





@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
	// TODO Auto-generated method stub
	
}


@Override
public void onProviderEnabled(String provider) {
	// TODO Auto-generated method stub
	
}


@Override
public void onProviderDisabled(String provider) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean onMarkerClick(Marker arg0) {
	// TODO Auto-generated method stub
	arg0.showInfoWindow();
	return false;
}


   
}

