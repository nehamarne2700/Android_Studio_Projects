package com.example.serviceringtone;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class MainService extends Service {
    //@androidx.annotation.Nullable
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MediaPlayer mp=new MediaPlayer().create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mp.setLooping(true);
        mp.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}
