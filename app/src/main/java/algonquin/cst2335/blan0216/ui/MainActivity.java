package algonquin.cst2335.blan0216.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import algonquin.cst2335.blan0216.R;
import algonquin.cst2335.blan0216.data.MainViewModel;
import algonquin.cst2335.blan0216.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;
    TextView myText;
    Button myButton;
    EditText myEdit;
    String editString;
    RadioButton myRadio;
    Switch mySwitch;
    CheckBox myCheck;
    String toggleToast;
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
        this.myRadio = findViewById(R.id.radioButton);
        this.myCheck = findViewById(R.id.checkBox);
        this.mySwitch = findViewById(R.id.switch1);
        this.toggleToast = "";

        myText.setText(String.format("Your edit text has: %s", editString));

        if(myButton != null){
            myButton.setOnClickListener((View view) ->
            {
                model.setEditString(varBinding.edittext.getText().toString());
                varBinding.textview.setText(String.format("Your edit text has: %s", editString));
            });

        }

        model.editString.observe(this, s -> {
                varBinding.textview.setText(String.format("Your edit text has: %s", editString));
        });

        model.checkBool.observe(this, selected -> {
            varBinding.checkBox.setChecked(selected);
            varBinding.radioButton.setChecked(selected);
            varBinding.switch1.setChecked(selected);
            toggleToast = String.format("The value is now %s", selected.toString());
            Toast.makeText(this, toggleToast, Toast.LENGTH_SHORT).show();
        });

        myRadio.setOnCheckedChangeListener( (btn, isChecked)->{ model.checkBool.postValue(isChecked); });
        myCheck.setOnCheckedChangeListener((btn, isChecked)->{ model.checkBool.postValue(isChecked); });
        mySwitch.setOnCheckedChangeListener((btn, isChecked)->{ model.checkBool.postValue(isChecked); });

    }
}