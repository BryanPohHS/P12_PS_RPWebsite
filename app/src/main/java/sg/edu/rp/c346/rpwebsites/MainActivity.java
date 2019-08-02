package sg.edu.rp.c346.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
  Spinner catSpn, subSpn;
  Button btnGo;
  ArrayList<String> alCat;
  ArrayAdapter<String> aaCat;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    catSpn = findViewById(R.id.catSpinner);
    subSpn = findViewById(R.id.subSpinner);
    btnGo = findViewById(R.id.buttonGo);

    // Init AL
    alCat = new ArrayList<>();

    // Create AA using default spinner and AL
    aaCat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCat);

    // Bind aa to spinner
    subSpn.setAdapter(aaCat);

    catSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
      {
        switch (i)
        {
          case 0:
            alCat.clear();
            String[] RPCategory = getResources().getStringArray(R.array.RPSub);
            //Convert Array to List and add to the ArrayList
            alCat.addAll(Arrays.asList(RPCategory));
            aaCat.notifyDataSetChanged();
            break;
          case 1:
            alCat.clear();
            String[] SOICategory = getResources().getStringArray(R.array.SOISub);
            //Convert Array to List and add to the ArrayList
            alCat.addAll(Arrays.asList(SOICategory));
            aaCat.notifyDataSetChanged();
            break;
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView)
      {

      }
    });

    btnGo.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        /*btnGo.setOnClickListener(new View.OnClickListener()
        {
          @Override
          public void onClick(View view)
          {
            String url = "";
            if(catSpn.getSelectedItem().equals("RP"))
            {
              if(subSpn.getSelectedItem().equals("HomePage"))
              {
                url = "https://www.rp.edu.sg/";
              }
              else if(subSpn.getSelectedItem().equals("Student Life"))
              {
                url = "https://www.rp.edu.sg/student-life";
              }
            }
            else if(catSpn.getSelectedItem().equals("SOI"))
            {
              if(subSpn.getSelectedItem().equals("DMSD"))
              {
                url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
              }
              else if(subSpn.getSelectedItem().equals("DIT"))
              {
                url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
              }
            }
            Intent intentWeb = new Intent(MainActivity.this, DisplayWebsite.class);
            intentWeb.putExtra("url", url);
            startActivity(intentWeb);
          }
        });*/

        String[][] sites = {
                {
                  "http://www.rp.edu.sg",
                        "https://www.rp.edu.sg/student-life",
                },
                {
                        "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                        "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12",
                }
        };

        String url = sites[catSpn.getSelectedItemPosition()][subSpn.getSelectedItemPosition()];

        Intent intentWeb = new Intent(MainActivity.this, DisplayWebsite.class);
        intentWeb.putExtra("url", url);
        startActivity(intentWeb);
      }
    });


  }
}
