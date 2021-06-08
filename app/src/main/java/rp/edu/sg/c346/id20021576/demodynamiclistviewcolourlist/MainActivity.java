package rp.edu.sg.c346.id20021576.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    EditText etIndexElement;
    Button btnRmv;
    Button btnUpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnRmv = findViewById(R.id.buttonRemoveItem);
        btnUpd = findViewById(R.id.buttonUpdateItem);

        ArrayList<String> alColours;
        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((etIndexElement.getText().toString().isEmpty()) == false)){
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    String addCol = etElement.getText().toString();
                    alColours.add(pos, addCol);
                    aaColour.notifyDataSetChanged();
                }
                else {
                    String addCol = etElement.getText().toString();
                    alColours.add(addCol);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addCol = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addCol = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, addCol);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selCol = alColours.get(position);
                Toast.makeText(MainActivity.this, selCol, Toast.LENGTH_SHORT).show();
            }
        });

    }
}