package sur.cas.edu.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "sur.cas.edu.courses.extra.REPLY";
    TextView textView;
    public static ArrayList<String> mycourses = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        String majorName = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE);

        textView = findViewById(R.id.majorHeader);
        textView.setText(majorName);

        Button addCourses = findViewById(R.id.buttonAddCourses);
        final EditText course1 = findViewById(R.id.editText1);
        final EditText course2 = findViewById(R.id.editText2);
        final EditText course3 = findViewById(R.id.editText3);
        final EditText course4 = findViewById(R.id.editText4);

        addCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstCourse = course1.getText().toString();
                String SecondCourse = course2.getText().toString();
                String thirdCourse = course3.getText().toString();
                String fourthCourse = course4.getText().toString();
                //adding all courses to the array List
                mycourses.add(firstCourse);
                mycourses.add(SecondCourse);
                mycourses.add(thirdCourse);
                mycourses.add(fourthCourse);


                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                intent.putExtra("firstCourse", firstCourse);
                intent.putExtra("secondCourse", SecondCourse);
                intent.putExtra("thirdCourse", thirdCourse);
                intent.putExtra("fourthCourse", fourthCourse);
                startActivity(intent);


            }
        });


    }

    public static ArrayList<String> getCourses() {
        return mycourses;
    }


}
