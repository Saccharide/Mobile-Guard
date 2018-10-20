package edu.wm.cs.mobileguard;

import android.content.pm.ApplicationInfo;

import java.util.ArrayList;

/**
 * Created by Linyong on 4/22/2018.
 */

public class SelectedAppList {
    private static ArrayList<ApplicationInfo> selectedAppInfoList;

    public static ArrayList<ApplicationInfo> getAppList(){
        return selectedAppInfoList;
    }

    public static void setAppList(ArrayList<ApplicationInfo> selectedAppInfoList){
        SelectedAppList.selectedAppInfoList = selectedAppInfoList;
    }

}
