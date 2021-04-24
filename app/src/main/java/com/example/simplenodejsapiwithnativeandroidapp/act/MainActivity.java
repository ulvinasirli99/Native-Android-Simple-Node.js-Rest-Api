package com.example.simplenodejsapiwithnativeandroidapp.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplenodejsapiwithnativeandroidapp.R;
import com.example.simplenodejsapiwithnativeandroidapp.di.Users;
import com.example.simplenodejsapiwithnativeandroidapp.service.ApiClient;
import com.example.simplenodejsapiwithnativeandroidapp.ui.CustomProgress;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Context context;

    public Users usersInterface;

    private CustomProgress customProgress;

    private TextView textLine1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        textLine1 = findViewById(R.id.textLine1);

        customProgress = new CustomProgress(context,"Custom Progress Dialog");

        customProgress.setTitle("Yüklənir...");

        customProgress.setCancelable(false);

        customProgress.show();

        jsonFetchData();

    }

    void jsonFetchData()
    {

        usersInterface = ApiClient.getRetrofit().create(Users.class);

        Call<List<String>> listCall = usersInterface.getCall();

        listCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

                customProgress.dismiss();

                if (response.isSuccessful())
                {

                    List<String> info = response.body();

                  for (String listItem : info)
                  {

                      String content = "";

                      content = listItem.concat("s") + "\n";

                      textLine1.append(content);

                  }

                }
                else
                    {

                        Toast.makeText(context, "Ne ise sef bas verdi....", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}