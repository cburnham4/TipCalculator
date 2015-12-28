package letshangllc.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText et_billTotal;
    private EditText et_tipPercent;
    private EditText et_taxPercent;
    private EditText et_numPeople;

    private TextView tv_totalCost;
    private TextView tv_costPerPerson;
    private TextView tv_totalTip;
    private TextView tv_tipPerPerson;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setUpToolbar();

        et_billTotal = (EditText) findViewById(R.id.et_billTotal);
        et_tipPercent = (EditText) findViewById(R.id.et_tipPercent);
        et_taxPercent = (EditText) findViewById(R.id.et_taxPercent);
        et_numPeople = (EditText) findViewById(R.id.et_numPeople);

        tv_totalCost = (TextView) findViewById(R.id.tv_totalCost);
        tv_costPerPerson = (TextView) findViewById(R.id.tv_costPerPerson);
        tv_totalTip = (TextView) findViewById(R.id.tv_totalTip);
        tv_tipPerPerson = (TextView) findViewById(R.id.tv_tipPerPerson);

        et_billTotal.addTextChangedListener(new MyTextWatcher());
        et_tipPercent.addTextChangedListener(new MyTextWatcher());
        et_taxPercent.addTextChangedListener(new MyTextWatcher());
        et_numPeople.addTextChangedListener(new MyTextWatcher());

    }

    private void setUpToolbar(){
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        this.setTitle("Tip Calculator"); /* Set the title for toolbar */
    }





    public class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String numString = et_billTotal.getText().toString();
            String tipString = et_tipPercent.getText().toString();
            String taxString = et_taxPercent.getText().toString();
            String peopleString = et_numPeople.getText().toString();
            Log.i("BILL", numString);
            if(!numString.isEmpty() && !numString.equals("")
                    && !tipString.isEmpty() && !tipString.equals("")
                    && !taxString.isEmpty() && !taxString.equals("")
                    && !peopleString.isEmpty() && !peopleString.equals("")){

                try{
                    double cost = Double.parseDouble(numString);
                    double tip = Double.parseDouble(tipString);
                    double tax = Double.parseDouble(taxString);
                    int people = Integer.parseInt(peopleString);

                    double tipCost = cost * (tip/100.0);
                    double taxCost = cost * (tax/100.0);
                    double total = cost + tipCost + taxCost;
                    tv_totalCost.setText(String.format("%.2f",total));
                    tv_costPerPerson.setText(String.format("%.2f",(0.0+total)/(0.0+people)));
                    tv_totalTip.setText(String.format("%.2f",tipCost));
                    tv_tipPerPerson.setText(String.format("%.2f",(0.0+tipCost)/(0.0 + people)));
                } catch (NumberFormatException e){
                    e.printStackTrace();
                }

            }
        }
    }
}
