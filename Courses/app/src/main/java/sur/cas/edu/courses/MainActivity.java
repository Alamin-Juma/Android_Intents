package sur.cas.edu.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button displayCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayCourses = findViewById(R.id.buttonCourses);

        Intent intent = getIntent();
        final String course1 = intent.getStringExtra("firstCourse");
        final String course2 = intent.getStringExtra("secondCourse");
        final String course3 = intent.getStringExtra("thirdCourse");
        final String course4 = intent.getStringExtra("fourthCourse");

        final TextView textView = findViewById(R.id.textView);
        textView.setText("course1: "+course1+"\ncourse2: "+ course2+
                "\ncourse3: "+ course3 + "\ncourse4: "+ course4
                );

        displayCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> courses = ThirdActivity.getCourses();


                for(int i=0; i < courses.size(); i++){

                    textView.setText(textView.getText() + courses.get(i) + " , ");
                }

            }
        });

    }




    public void addCourses(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
