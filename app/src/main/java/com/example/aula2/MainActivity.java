package com.example.aula2;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        packageManager = getPackageManager();
        listView = findViewById(R.id.listview_apps);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<ApplicationInfo> packageInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        AppAdapter appAdapter = new AppAdapter(this,R.layout.item_lista, packageInfoList);
        listView.setAdapter(appAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> onItemClick(parent, view, position, id));

    }

    public class AppAdapter extends ArrayAdapter<ApplicationInfo> {
        public AppAdapter(MainActivity mainActivity, int item_lista, List<ApplicationInfo> packageInfoList) {
            super(mainActivity, item_lista, packageInfoList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.item_lista, parent, false);

            ApplicationInfo applicationInfo = getItem(position);

            TextView textViewAppName = view.findViewById(R.id.app_name);
            ImageView imageViewAppIcon = view.findViewById(R.id.app_icon);

            imageViewAppIcon.setImageDrawable(applicationInfo.loadIcon(getContext().getPackageManager()));
            textViewAppName.setText(applicationInfo.loadLabel(getContext().getPackageManager()));

            return view;
        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ApplicationInfo applicationInfo = (ApplicationInfo) parent.getItemAtPosition(position);
        String packageName = applicationInfo.packageName;
        Toast.makeText(MainActivity.this, "Abrindo: " + applicationInfo.loadLabel(getPackageManager()), Toast.LENGTH_SHORT).show();

        Intent intent = packageManager.getLaunchIntentForPackage(packageName);
        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
        }
    }

}