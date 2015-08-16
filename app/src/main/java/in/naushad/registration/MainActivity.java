package in.naushad.registration;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.telephony.SmsManager;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.util.IllegalFormatException;

public class MainActivity extends AppCompatActivity {


    TextView TName;
    EditText EName;
    TextView TAge;
    EditText EAge;
    TextView TEmail;
    EditText EEmail;
    TextView TPhone;
    EditText EPhone;
    Button SubmitBtn;
    RadioGroup RGGender;
    RadioButton RMale;
    RadioButton RFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TName = (TextView) findViewById(R.id.tvName);
        EName = (EditText) findViewById(R.id.etName);
        TAge = (TextView) findViewById(R.id.tvAge);
        EAge = (EditText) findViewById(R.id.etAge);
        RGGender = (RadioGroup) findViewById(R.id.RGGender);
        RMale = (RadioButton) findViewById(R.id.rbMale);
        RFemale = (RadioButton) findViewById(R.id.rbFemale);
        TEmail = (TextView) findViewById(R.id.tvEmail);
        EEmail = (EditText) findViewById(R.id.etEmail);
        TPhone = (TextView) findViewById(R.id.tvPhone);
        EPhone = (EditText) findViewById(R.id.etPhone);
        SubmitBtn = (Button) findViewById(R.id.bSubmit);

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }
    protected void sendSMSMessage() throws IllegalArgumentException{
        Log.i("Send SMS", "");
        String phoneNo = EPhone.getText().toString();
        String nameOnly = EName.getText().toString();
        String message = "Dear "+nameOnly+",You have been successfully registered with us." ;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "Thanks for registering.Confirmation SMS has been sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed to send, please enter proper phone number and try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


    @Override
    public void onBackPressed() {
            super.onBackPressed();
            this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
