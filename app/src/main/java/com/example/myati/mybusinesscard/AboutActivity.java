package com.example.myati.mybusinesscard;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AboutActivity extends AppCompatActivity {
    TextView sendMessage;
    EditText editText;
    String textFromEditText;
    ImageView instagram;
    ImageView telegram;
    ImageView vk;

    private static final String[] EMAIL_ADDRESS = {"myatiy963@gmail.com"};
    private static final String EMAIL_SUBJECT = "Здравствуй,Никита";
    private  static final String titleAboutActivity = "Nikita Matveev";
    public final String urlVk = "https://vk.com/vol.vesovoy";
    public final String urlTelegram = "https://t.me/babambigalo";
    public final String urlInstagram = "https://www.instagram.com/babambigalo/?hl=ru";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(titleAboutActivity);

        sendMessage = findViewById(R.id.send_message);
        instagram = findViewById(R.id.instagram);
        editText = findViewById(R.id.edit_text);
        telegram = findViewById(R.id.telegram);
        vk = findViewById(R.id.vk);

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInstagram();

            }
        });
        vk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVk();
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTelegram();
            }
        });
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textFromEditText = editText.getText().toString();
                sendEmail(EMAIL_ADDRESS, EMAIL_SUBJECT, textFromEditText);
            }
        });


    }

    public void sendEmail(String[] address, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setType("text/plain");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        } else {
            Toast.makeText(this, R.string.email_app_not_found, Toast.LENGTH_SHORT).show();
        }

    }

    public void goToInstagram() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlInstagram));
        startActivity(intent);

    }

    public void goToTelegram() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlTelegram));
        startActivity(intent);

    }

    public void goToVk() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlVk));
        startActivity(intent);

    }


}
