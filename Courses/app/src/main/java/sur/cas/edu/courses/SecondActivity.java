package sur.cas.edu.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "sur.cas.edu.courses.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView majors = findViewById(R.id.majors);
        final String items[] = new String[]{"Software Development major", "IT Security major ",
                "IT Networking major","Machine Learning major", "Artificial Intelligence major"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        majors.setAdapter(adapter);

        majors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                String majorName = (String) adapterView.getItemAtPosition(i);
                intent.putExtra(EXTRA_MESSAGE, majorName);

                startActivity(intent);
            }
        });

    }
}
