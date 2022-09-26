package com.missouristate.arnold.color;

//Imports
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import static com.missouristate.arnold.color.R.*;

public class MainActivity extends AppCompatActivity {
    // Set variables
    ConstraintSet set;
    ConstraintLayout layout;
    Button button1;
    Button button2;
    Button button3;
    int button_height = 200;
    int text_height = 400;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("HW3 EX 2"); // Set title of action bar label to "HW3 EX 2"
        layout = (ConstraintLayout) findViewById(id.App_Layout); //Find layout by it's ID
        layout.setBackgroundColor(Color.parseColor("#c89b6d")); // Set layout background color
        set = new ConstraintSet(); // Create a constraint set
        set.clone(layout); // Gets constraints from layout

        //Button 1:
        button1 = new Button(this); // Set button 1 equal to new button
        button1.setText(getString(string.plum)); // Set text equal to string 'plum'
        button1.setBackgroundColor(Color.parseColor("#ac7d50")); // Set background color of button
        button1.setId(View.generateViewId());
        button1.setTag("plum"); // Set tag to "plum"
        button1.setOnClickListener(ShadeListener); // Refer to listener
        layout.addView(button1);
        //Set layout of button
        set.connect(button1.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50); // Constrain to top 50 away
        set.connect(button1.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0); // Constrain to right
        set.connect(button1.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0); // Constrain to left
        set.constrainHeight(button1.getId(), button_height); // Set height
        set.applyTo(layout); // Set constraints to layout

        //Button 2:
        button2 = new Button(this); // Set button 2 equal to new button
        button2.setText(getString(string.blue)); // Set text equal to string 'blue'
        button2.setBackgroundColor(Color.parseColor("#ac7d50")); // Set background color of button
        button2.setId(View.generateViewId());
        button2.setTag("blue"); // Set tag to "blue"
        button2.setOnClickListener(ShadeListener); // Refer to listener on click
        layout.addView(button2); // Add view to layout
        //Set layout of button
        set.connect(button2.getId(), ConstraintSet.TOP, button1.getId(), ConstraintSet.BOTTOM, 20); // Constrain top to bottom button 1 / constrain to bottom
        set.connect(button2.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0); // Constraint to right
        set.connect(button2.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0); //Constrain to left
        set.constrainHeight(button2.getId(), button_height); // Set height
        set.applyTo(layout); //Set constraints to layout

        //Button 3:
        button3 = new Button(this); // Set button 3 equal to new button
        button3.setText(getString(string.gold)); // Set text equal to string 'gold'
        button3.setBackgroundColor(Color.parseColor("#ac7d50")); // Set background color of button
        button3.setId(View.generateViewId());
        button3.setTag("gold"); // Set tag to "gold"
        button3.setOnClickListener(ShadeListener); // Refer to listener on click
        layout.addView(button3); // Add view
        //Set layout of Button
        set.connect(button3.getId(), ConstraintSet.TOP, button2.getId(), ConstraintSet.BOTTOM, 20); // Constrain top to bottom button 2 / bottom of layout
        set.connect(button3.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0); // Constraint to right
        set.connect(button3.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0); //Constrain to left
        set.constrainHeight(button3.getId(), button_height); // Set height
        set.applyTo(layout); // Set to layout
    }

    private View.OnClickListener ShadeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String description = (String) view.getTag();

            // TextView
            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            switch((String) view.getTag()){
                case "plum":
                    textView.setText(string.plum_is); // if button 1 is clicked set textview to string "plum_is"
                    break;
                case "blue":
                    textView.setText(string.blue_is); // if button 2 is clicked set textview to string "blue_is"
                    break;
                case "gold":
                    textView.setText(string.gold_is); // if button 3 is clicked set textview to string "gold_is"
                    break;
            }
            textView.setBackgroundColor(Color.parseColor("#ac7d50")); // Set background color of textview
            textView.setId(View.generateViewId());
            layout.addView(textView);
            //Set layout of textview
            set.connect(textView.getId(), ConstraintSet.TOP, button3.getId(), ConstraintSet.BOTTOM, 50); // Constrain top to bottom of button 3 50 away / constrain to bottom
            set.connect(textView.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0); // Constrain to right
            set.connect(textView.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0); // Constraint to left
            set.constrainHeight(textView.getId(), text_height); // Set height of textview
            set.applyTo(layout); // Set constraints to layout
        }
    };
}