package vamsee.application.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class Factorial extends Service {
    public Factorial() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int res = 1;
        for (int i = 1; i<=5; i++){
            res *= i;
        }
        Toast.makeText(this, "Factorial of 5 is"+res, Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped !!!", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}