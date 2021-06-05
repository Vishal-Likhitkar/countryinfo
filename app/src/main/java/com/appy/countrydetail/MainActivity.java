package com.appy.countrydetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mukesh.countrypicker.Country;
import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.OnCountryPickerListener;

public class MainActivity extends AppCompatActivity implements OnCountryPickerListener {

    private TextView countryname,countryiso,countrydialcode,countrycurrency;
    private ImageView countryflag;
    private Button pickcountrybtn;
    private CountryPicker countryPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialize();
        setListener();
    }
    private void setListener() {
        pickcountrybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryPicker.showDialog(getFragmentManager());
            }
        });
    }
    private  void intialize() {
        countryname = findViewById(R.id.selectedcountryname);
        countryiso = findViewById(R.id.Selectedcountryisocode);
        countrydialcode = findViewById(R.id.Selectedcountrydialcode);
        pickcountrybtn = findViewById(R.id.countrypickerbutton);
        countryflag = findViewById(R.id.country_flag);
        countrycurrency = findViewById(R.id.Selectedcountrycurrency);
        countryPicker = new CountryPicker.Builder().with(this)
                .listener(this)
                .build();
    }
    @Override
    public void onSelectCountry(Country country){
        countryflag.setImageResource(country.getFlag());
        countrydialcode.setText(country.getDialCode());
        countryiso.setText(country.getCode());
        countryname.setText(country.getName());
        countrycurrency.setText(country.getCurrency());
    }
}