package edu.wm.cs.mobileguard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class ApplicationAdapter extends ArrayAdapter<ApplicationInfo> {
    private List<ApplicationInfo> appsList = null;
    private Context context;
    private PackageManager packageManager;
    private ArrayList<ApplicationInfo> user_selected_apps = new ArrayList<ApplicationInfo>();

    public ApplicationAdapter(Context context, int textViewResourceId,
                              List<ApplicationInfo> appsList) {
        super(context, textViewResourceId, appsList);
        this.context = context;
        this.appsList = appsList;
        packageManager = context.getPackageManager();
    }

    @Override
    public int getCount() {
        return ((null != appsList) ? appsList.size() : 0);
    }

    @Override
    public ApplicationInfo getItem(int position) {
        return ((null != appsList) ? appsList.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == view) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.snippet_list_row, null);
        }

        final ApplicationInfo applicationInfo = appsList.get(position);
        if (null != applicationInfo) {
            TextView appName = (TextView) view.findViewById(R.id.app_name);
            TextView packageName = (TextView) view.findViewById(R.id.app_paackage);
            ImageView iconview = (ImageView) view.findViewById(R.id.app_icon);
            Switch app_switch = (Switch) view.findViewById(R.id.switch1);


            ArrayList<ApplicationInfo> temp_list =  SelectedAppList.getAppList();
            if(temp_list != null) {
                System.out.println(temp_list);
                app_switch.setChecked(false);
                for (int i = 0; i < temp_list.size(); i++) {
                    if (temp_list.get(i).packageName.equals(applicationInfo.packageName)) {
                        app_switch.setChecked(true);
                        if(user_selected_apps.indexOf(applicationInfo) < 0) {
                            user_selected_apps.add(applicationInfo);
                        }

                    }
                }
                System.out.println(app_switch.isChecked());

            }


            app_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked){
                        compoundButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(user_selected_apps.indexOf(applicationInfo) < 0) {
                                    user_selected_apps.add(applicationInfo);
                                }
                            }
                        });

                    }else{
                        compoundButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int index_to_remove = 0;
                                index_to_remove = user_selected_apps.indexOf(applicationInfo);
                                if(index_to_remove > -1){
                                    user_selected_apps.remove(index_to_remove);
                                }
                            }
                        });


                    }

                }
            });


            appName.setText(applicationInfo.loadLabel(packageManager));
            packageName.setText(applicationInfo.packageName);
            iconview.setImageDrawable(applicationInfo.loadIcon(packageManager));
        }
        return view;
    }

    public ArrayList<ApplicationInfo> getUserSelectedAppList(){
        return user_selected_apps;
    }

};