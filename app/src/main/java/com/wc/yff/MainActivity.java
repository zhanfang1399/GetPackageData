package com.wc.yff;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wc.yff.adapter.MyBaseAdapter;
import com.wc.yff.adapter.ViewHolder;
import com.wc.yff.bean.AppInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView mListView;
    private List<AppInfo> listInfo;
    private List<PackageInfo> listPackage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignViews();
        getMyPackageName();

        MyBaseAdapter<AppInfo> adapter = new MyBaseAdapter<AppInfo>(listInfo, R.layout.list_item, this) {
            @Override
            protected void convert(ViewHolder viewHolder, AppInfo appInfo) {
                View view = viewHolder.getmContentView();
                assignViewItem(view);
                mListItemImg.setBackgroundDrawable(appInfo.getDrawableIcon());
                mListItemName.setText(appInfo.getName());
                mListItemPackageName.setText(appInfo.getPackageName());
                mListItemVersion.setText(appInfo.getPackageVerson());

            }
        };
        mListView.setAdapter(adapter);

    }

    private ImageView mListItemImg;
    private TextView mListItemName;
    private TextView mListItemPackageName;
    private TextView mListItemVersion;

    private void assignViewItem(View view) {
        mListItemImg = (ImageView) view.findViewById(R.id.list_item_img);
        mListItemName = (TextView) view.findViewById(R.id.list_item_name);
        mListItemPackageName = (TextView) view.findViewById(R.id.list_item_package_name);
        mListItemVersion = (TextView) view.findViewById(R.id.list_item_version);
    }


    public void getMyPackageName() {

        listInfo = new ArrayList<>();
        listPackage = getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < listPackage.size(); i++) {
            PackageInfo packageInfo = listPackage.get(i);
            //只显示非系统应用
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){
                AppInfo appInfo = new AppInfo();
                appInfo.setName(packageInfo.applicationInfo.loadLabel(getPackageManager()).toString());
                appInfo.setPackageName(packageInfo.packageName);
                appInfo.setPackageVerson(packageInfo.versionName + "");
                appInfo.setDrawableIcon(packageInfo.applicationInfo.loadIcon(getPackageManager()));
                listInfo.add(appInfo);
            }
        }


    }


    private void assignViews() {
        mListView = (ListView) findViewById(R.id.listView);
    }

}
