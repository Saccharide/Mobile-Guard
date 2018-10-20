package edu.wm.cs.mobileguard;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class StatusReciever extends ResultReceiver {

    private MainActivity.Status _status;
    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public StatusReciever(Handler handler) {
        super(handler);
    }

    public StatusReciever() {
        super(new Handler());
    }
    public StatusReciever(MainActivity.Status status){
        super(new Handler());
        _status = status;
    }

    protected void onReceiveResult( int resultCode, Bundle resultData){
        _status.displayStatus(resultCode,resultData);
    }
}

