package algonquin.cst2335.blan0216.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import algonquin.cst2335.blan0216.R;
import algonquin.cst2335.blan0216.data.MainViewModel;
import algonquin.cst2335.blan0216.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;
    TextView myText;
    Button myButton;
    EditText myEdit;
    String editString;
    private ActivityMainBinding varBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.model = new ViewModelProvider(this).get(MainViewModel.class);
        this.myButton = findViewById(R.id.button);
        this.myText = findViewById(R.id.textview);
        this.myEdit = findViewById(R.id.edittext);
        this.editString = "";
        this.varBinding = ActivityMainBinding.inflate(getLayoutInflater());

        myText.setText(String.format("Your edit text has: %s", editString));

        if(myButton != null){
            myButton.setOnClickListener((View view) ->
            {
                model.setEditString(varBinding.edittext.getText().toString());
                varBinding.textview.setText(String.format("Your edit text has: %s", editString));
            });

        }

        this.model.observe(this);

    }
}