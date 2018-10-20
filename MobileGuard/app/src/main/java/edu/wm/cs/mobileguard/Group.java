package edu.wm.cs.mobileguard;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EmmaLiu on 4/17/2018.
 */

public class Group {

    public ApplicationInfo app_info;
    public String app_name;
    public String package_name;
    public Drawable icon;
    public final List<String> children = new ArrayList<String>();


    public Group(ApplicationInfo applicationInfo, PackageManager packageManager) {
        this.app_info = applicationInfo;
        this.app_name = (String)applicationInfo.loadLabel(packageManager);
        this.package_name = applicationInfo.packageName;
        this.icon = applicationInfo.loadIcon(packageManager);
    }

}
