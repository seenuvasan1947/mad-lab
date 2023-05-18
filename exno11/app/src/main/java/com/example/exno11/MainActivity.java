package com.example.exno11;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // define objects for edit text and button
    Button button;
    EditText sendto, subject, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting instance of edittext and button
        sendto = findViewById(R.id.editText1);
        subject = findViewById(R.id.editText2);
        body = findViewById(R.id.editText3);
        button = findViewById(R.id.button);

        // attach setOnClickListener to button with Intent object define in it
        button.setOnClickListener(view -> {
            String emailsend = sendto.getText().toString();
            String emailsubject = subject.getText().toString();
            String emailbody = body.getText().toString();

            // define Intent object with action attribute as ACTION_SEND
            Intent intent = new Intent(Intent.ACTION_SEND);

            // add three fields to intent using putExtra function
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
            intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailbody);

            // set type of intent
            intent.setType("message/rfc822");

            // startActivity with intent with chooser as Email client using createChooser function
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });
    }
}























































//package com.example.exno11;
//import android.content.Intent;
////import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import androidx.appcompat.app.AppCompatActivity;
//public class MainActivity extends AppCompatActivity {
//    private EditText eTo;
//    private EditText eSubject;
//    private EditText eMsg;
//    private Button btn;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        eTo = (EditText)findViewById(R.id.txtTo);
//        eSubject = (EditText)findViewById(R.id.txtSub);
//        eMsg = (EditText)findViewById(R.id.txtMsg);
//        btn = (Button)findViewById(R.id.btnSend);
//        btn.setOnClickListener(v -> {
//            Intent it = new Intent(Intent.ACTION_SEND);
//            it.putExtra(Intent.EXTRA_EMAIL, new String[]{eTo.getText().toString()});
//            it.putExtra(Intent.EXTRA_SUBJECT,eSubject.getText().toString());
//            it.putExtra(Intent.EXTRA_TEXT,eMsg.getText());
//            it.setType("message/rfc822");
//            startActivity(Intent.createChooser(it,"Choose Mail App"));
//        });
//    }
//}