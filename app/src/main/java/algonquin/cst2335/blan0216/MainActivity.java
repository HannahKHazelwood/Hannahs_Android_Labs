package algonquin.cst2335.blan0216;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView myText;
    Button myButton;
    EditText myEdit;
    String editString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.myButton = findViewById(R.id.button);
        this.myText = findViewById(R.id.textview);
        this.myEdit = findViewById(R.id.edittext);
        this.editString = "";

        myText.setText(String.format("Your edit text has: %s", editString));

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editString = myEdit.getText().toString();
                myText.setText(String.format("Your edit text has: %s", editString));
            }
        });
    }

}