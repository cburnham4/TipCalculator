package letshangllc.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_billTotal = (EditText) findViewById(R.id.et_billTotal);
        EditText et_tipPercent = (EditText) findViewById(R.id.et_tipPercent);
        EditText et_taxPercent = (EditText) findViewById(R.id.et_taxPercent);
        EditText et_numPeople = (EditText) findViewById(R.id.et_numPeople);
        EditText et_totalCost = (EditText) findViewById(R.id.et_totalCost);
        EditText et_costPerPerson = (EditText) findViewById(R.id.et_costPerPerson);
        
    }
}
