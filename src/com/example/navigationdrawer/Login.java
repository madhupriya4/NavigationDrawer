package com.example.navigationdrawer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener{
Button b1;
TextView t1,t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_login);
		 b1=(Button)findViewById(R.id.button1);
		 t1=(TextView)findViewById(R.id.username);
		 t2=(TextView)findViewById(R.id.password);
		 b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				String a= t1.getText().toString();
				String b=t2.getText().toString();
				if((a.equals("madhupriya")&&b.equals("madhu"))||(a.equals("himanshu")&&b.equals("himanshu")))
				{
					try{Intent i=new Intent("android.intent.action.MAINACTIVITY");
					startActivity(i);}
					catch(Exception e)
					{
						Toast.makeText(getApplicationContext(), "Invalid id/password", Toast.LENGTH_LONG).show();
					}
					
				}
				else
					Toast.makeText(getApplicationContext(), "Invalid id/password", Toast.LENGTH_LONG).show();
				}
			});


	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}

}
