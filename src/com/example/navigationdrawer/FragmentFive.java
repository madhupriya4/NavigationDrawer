package com.example.navigationdrawer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
 
public class FragmentFive extends Fragment implements OnClickListener{
	ImageButton getmap;
    public static Fragment newInstance(Context context) {
    	FragmentFive f = new FragmentFive();
 
        return f;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_five, null);
        getmap  =(ImageButton) root.findViewById(R.id.button1);
        // getmap=(Button)findViewById(R.id.button1);
        getmap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i=new Intent("android.intent.action.DIRECTIONS");
			startActivity(i);
			}
		});
        return root;
    }

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		 Toast.makeText(getActivity(), "Google Play Services missing !",
                 Toast.LENGTH_LONG).show();
		
	}
 
}