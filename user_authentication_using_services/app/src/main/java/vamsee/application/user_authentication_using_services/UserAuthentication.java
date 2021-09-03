package vamsee.application.user_authentication_using_services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.net.URISyntaxException;

public class UserAuthentication extends Service {
    public UserAuthentication() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


            String username = intent.getExtras().getString("username");
            String password = intent.getExtras().getString("password");

//            Toast.makeText(getApplicationContext(), username + password, Toast.LENGTH_SHORT).show();

            //username = vamseevk2001
            // Password = vamseevk

            if(username.equals("vamseevk2001") && password.equals("vamseevk")){
                Intent next = new Intent(getApplicationContext(), Dashboard.class);
                next.putExtra("name", username);
                next.putExtra("login", "Login Successful  ✅ ");
                next.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(next);
            }
            else {
                Intent next = new Intent(getApplicationContext(), Dashboard.class);
                next.putExtra("login", "Login Failed ❌ ");
                next.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(next);
            }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}