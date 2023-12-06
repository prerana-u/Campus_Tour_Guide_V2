package org.pytorch.demo.objectdetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import com.squareup.picasso.Picasso;

import org.pytorch.demo.objectdetection.data.DatabaseHandler;
import org.pytorch.demo.objectdetection.models.Building_Info;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DisplayActivity extends AppCompatActivity {

    ImageView capimg;

    VrPanoramaView panoramaView;
    ImageButton arrow, arrow1, arrow2, arrowd;
    LinearLayout hiddenView, hiddenView2;
    LinearLayout hiddenView1, hiddenViewd;
    CardView cardView, cardView1, cardView2, cardViewd;
    ArrayList<ListData> modelArrayList;

    public String type = "";
    TextView title, estabinfo, floorinfo, history, loctext;
    DatabaseHandler db;
    RecyclerView rv, rv1, rv2;
    String blockname = "";
    MyListAdapter ml;
    TextToSpeech textToSpeech;
    ImageButton cb;
    SQLiteDatabase db1;
    Button vrbtn;

    private static final String TAG = "DisplayActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        blockname = intent.getStringExtra("blockname");
        title = findViewById(R.id.title);
        title.setText(blockname);
        cb = findViewById(R.id.camerabtn);
        estabinfo = findViewById(R.id.estab_info);
        floorinfo = findViewById(R.id.floor_info);
        vrbtn=findViewById(R.id.vrbutton);
//        ra=findViewById(R.id.rightarrow);
//        la=findViewById(R.id.leftarrow);
//        ua=findViewById(R.id.uparrow);
//        da=findViewById(R.id.downarrow);
//        loctext=findViewById(R.id.loctext);
//        relocate=findViewById(R.id.relocate);
//        expand=findViewById(R.id.expand);
        Pronunciation p = new Pronunciation(getApplicationContext());

        db = new DatabaseHandler(this);
        db1 = db.getWritableDatabase();
        db.onUpgrade(db1, 1, 2);


// Inserting data into the database
        db.addData(new Building_Info(101, "Office of Examinations", "001", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(102, "Office of International Affairs", "013", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(103, "Scholarship and Fellowship Support Cell", "014", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(104, "Department of Life Sciences", "014", "department", "ground floor", "block 1"));
        db.addData(new Building_Info(105, "Department of Chemistry", "009", "department", "ground floor", "block 1"));
        db.addData(new Building_Info(106, "IT Services", "012", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(107, "Associate Director Office of International Affairs", "015", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(108, "Deans Office -School of Arts and Humanities", "016", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(109, "Deans Office -School of Science", "017", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(110, "Reception", "018", "office", "ground floor", "block 1"));
        db.addData(new Building_Info(111, "Department of Languages", "103", "department", "first floor", "block 1"));
        db.addData(new Building_Info(112, "Department of Psychology", "104", "department", "first floor", "block 1"));
        db.addData(new Building_Info(113, "Department of English", "107", "department", "first floor", "block 1"));
        db.addData(new Building_Info(114, "Department of life sciences-2", "111", "department", "first floor", "block 1"));
        db.addData(new Building_Info(115, "Counsellor Office", "117", "office", "first floor", "block 1"));
        db.addData(new Building_Info(116, "Center for Counselling and Health Services", "203", "office", "second floor", "block 1"));
        db.addData(new Building_Info(117, "Department of Physical Education", "204", "department", "second floor", "block 1"));
        db.addData(new Building_Info(118, "Department of Sociology", "211", "department", "second floor", "block 1"));
        db.addData(new Building_Info(119, "Center for Social Action Office", "212", "office", "second floor", "block 1"));
        db.addData(new Building_Info(120, "Mini Auditorium", "213", "others", "second floor", "block 1"));
        db.addData(new Building_Info(121, "Knowledge Center", "N/A", "others", "sixth floor", "central block"));
        db.addData(new Building_Info(122, "Office of Accounts", "N/A", "office", "ground floor", "central block"));
        db.addData(new Building_Info(123, "IBM", "N/A", "office", "ground floor", "central block"));
        db.addData(new Building_Info(124, "Office of Admissions", "N/A", "office", "ground floor", "central block"));
        db.addData(new Building_Info(125, "Reception", "N/A", "office", "ground floor", "central block"));
        db.addData(new Building_Info(126, "Internal Quality Assurance Cell", "N/A", "office", "first floor", "central block"));
        db.addData(new Building_Info(127, "Documentation Room", "112", "office", "first floor", "central block"));
        db.addData(new Building_Info(128, "School of Business and Management", "N/A", "department", "second floor", "central block"));
        db.addData(new Building_Info(129, "School of Law", "N/A", "department", "fourth floor", "central block"));
        db.addData(new Building_Info(130, "Department of International Studies, Political Science and History", "N/A", "department", "sixth floor", "central block"));
        db.addData(new Building_Info(131, "Department of Sociology and Social Work", "N/A", "department", "sixth floor", "central block"));
        db.addData(new Building_Info(132, "Department of PG Computer Science", "N/A", "department", "eighth floor", "central block"));
        db.addData(new Building_Info(133, "Skyview", "N/A", "others", "tenth floor", "central block"));
        db.addData(new Building_Info(134, "Campus View", "N/A", "others", "tenth floor", "central block"));
        db.addData(new Building_Info(135, "Department of Commerce Office", "508", "office", "ground floor", "block 2"));
        db.addData(new Building_Info(136, "Centre for Mathematical Need", "518", "Office", "ground floor", "block 2"));
        db.addData(new Building_Info(137, "Seminar Hall", "526", "others", "ground floor", "block 2"));
        db.addData(new Building_Info(138, "Department of Commerce", "528", "department", "ground floor", "block 2"));
        db.addData(new Building_Info(139, "Department of Computer Science Staff Room", "622", "department", "first floor", "block 2"));
        db.addData(new Building_Info(140, "Department of Computer Science", "628", "department", "first floor", "block 2"));
        db.addData(new Building_Info(141, "Centre for Counseling and Health Services", "711", "office", "second floor", "block 2"));
        db.addData(new Building_Info(142, "Assoc. Dean School of Science", "711A", "office", "second floor", "block 2"));
        db.addData(new Building_Info(143, "Centre for Placement and Career Guidance", "721B", "office", "second floor", "block 2"));
        db.addData(new Building_Info(144, "Department of Life Science III", "714", "department", "second floor", "block 2"));
        db.addData(new Building_Info(145, "Department of Statistics", "709B", "department", "second floor", "block 2"));
        db.addData(new Building_Info(146, "Department of Statistics and Data Science", "709A", "department", "second floor", "block 2"));
        db.addData(new Building_Info(147, "Department of Life Science", "708", "department", "second floor", "block 2"));
        db.addData(new Building_Info(148, "School of Education", "NA", "department", "third floor", "block 2"));
        db.addData(new Building_Info(149, "Panel Room", "729", "others", "second floor", "block 2"));
        db.addData(new Building_Info(150, "Assembly Hall", "NA", "others", "third floor", "block 2"));
        db.addData(new Building_Info(151, "Hotel Management Training Restaurant", "NA", "others", "ground floor", "block 4"));
        db.addData(new Building_Info(152, "Center for Innovation", "NA", "office", "first floor", "block 4"));
        db.addData(new Building_Info(153, "Department of Professional Studies", "NA", "department", "second floor", "block 4"));
        db.addData(new Building_Info(154, "Health Centre", "475", "others", "fourth floor", "block 4"));
        db.addData(new Building_Info(155, "K.E Auditorium", "NA", "others", "sixth floor", "block 4"));
        db.addData(new Building_Info(156, "Bloomberg Lab", "105", "others", "first floor", "r&d block"));
        db.addData(new Building_Info(157, "Department of Statistics and Data Science", "NA", "department", "first floor", "r&d block"));
        db.addData(new Building_Info(158, "Department of Life Sciences", "NA", "department", "second floor", "r&d block"));
        db.addData(new Building_Info(159, "Department of Chemical Sciences", "NA", "department", "third floor", "r&d block"));
        db.addData(new Building_Info(159, "Department of Physical Sciences", "NA", "department", "fourth floor", "r&d block"));
        db.addData(new Building_Info(160, "Department of Behavorial Sciences", "NA", "department", "fifth floor", "r&d block"));
        db.addData(new Building_Info(161, "Christ Incubation Center", "NA", "office", "seventh floor", "r&d block"));
        db.addData(new Building_Info(162, "Christ Consulting", "NA", "office", "seventh floor", "r&d block"));
        db.addData(new Building_Info(163, "Center for Digital Innovation", "NA", "office", "seventh floor", "r&d block"));

        rv = findViewById(R.id.officedatarv);
        rv1 = findViewById(R.id.officedatarv1);
        rv2 = findViewById(R.id.officedatarv2);

        rv.setHasFixedSize(false);

        modelArrayList = new ArrayList<ListData>();

        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.arrow_button);
        hiddenView = findViewById(R.id.hidden_view);
        cardView1 = findViewById(R.id.base_cardview1);
        arrow1 = findViewById(R.id.arrow_button1);
        hiddenView1 = findViewById(R.id.hidden_view1);
        cardView2 = findViewById(R.id.base_cardview2);
        arrow2 = findViewById(R.id.arrow_button2);
        hiddenView2 = findViewById(R.id.hidden_view2);
        cardViewd = findViewById(R.id.desc_cardview);
        arrowd = findViewById(R.id.arrow_button_d);
        hiddenViewd = findViewById(R.id.hidden_view_d);
        history = findViewById(R.id.history);
        // mapimg=findViewById(R.id.mapimg);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Your code to run after a delay. in my case in another handler
                p.speak("You are in front of " + blockname + ". To know more about the block, please refer to the details below.", TextToSpeech.QUEUE_FLUSH);
            }
        }, 3000);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if (i != TextToSpeech.ERROR) {
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });



//        relocate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Picasso
//                        .get()
//                        .load("https://firebasestorage.googleapis.com/v0/b/mobile-app-da42b.appspot.com/o/block2.png?alt=media&token=812f4a39-b71f-4ea7-a37d-86ae9d9c857c")
//                        .into(mapimg);
//
//                ra.setVisibility(View.VISIBLE);
//                la.setVisibility(View.VISIBLE);
//                da.setVisibility(View.VISIBLE);
//                ua.setVisibility(View.VISIBLE);
//            }
//
//        });
//
//
//
//        ra.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ra.setAlpha((float)1.0);
//                return false;
//            }
//        });
//
//        ra.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Picasso
//                        .get()
//                        .load("https://firebasestorage.googleapis.com/v0/b/mobile-app-da42b.appspot.com/o/christ_football_ground.jpg?alt=media&token=9f9e3498-62c1-4bd4-9943-222f3492d102")
//                        .into(mapimg);
//
//                loctext.setText("Football Ground");
//                loctext.setVisibility(View.VISIBLE);
//                ra.setVisibility(View.GONE);
//                la.setVisibility(View.VISIBLE);
//                p.speak("To your right is the football ground", TextToSpeech.QUEUE_FLUSH);
//            }
//        });
//
//        la.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Picasso
//                        .get()
//                        .load("https://firebasestorage.googleapis.com/v0/b/mobile-app-da42b.appspot.com/o/kiosk.jpeg?alt=media&token=cb1da068-7556-414c-834d-40885503de6b")
//                        .into(mapimg);
//
//                loctext.setText("Kiosk");
//                loctext.setVisibility(View.VISIBLE);
//                la.setVisibility(View.GONE);
//                ra.setVisibility(View.VISIBLE);
//                p.speak("To your left is the kiosk, which serves a variety of refreshments", TextToSpeech.QUEUE_FLUSH);
//
//            }
//        });
//        panoramaView = findViewById(R.id.viewPanaroma);
//        loadPanoramaImage();

        //dropdown code

        arrowd.setOnClickListener(view -> {
            // If the CardView is already expanded, set its visibility
            // to gone and change the expand less icon to expand more.
            //speakData();
            if (hiddenViewd.getVisibility() == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardViewd, new AutoTransition());
                hiddenViewd.setVisibility(View.GONE);
                arrowd.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);

            }

            // If the CardView is not expanded, set its visibility to
            // visible and change the expand more icon to expand less.
            else {
                TransitionManager.beginDelayedTransition(cardViewd, new AutoTransition());
                hiddenViewd.setVisibility(View.VISIBLE);
                hiddenView1.setVisibility(View.GONE);
                hiddenView2.setVisibility(View.GONE);
                arrowd.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
                arrow1.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                arrow2.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);

            }
        });
        arrow.setOnClickListener(view -> {
            // If the CardView is already expanded, set its visibility
            // to gone and change the expand less icon to expand more.
            //speakData();
            if (hiddenView.getVisibility() == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                hiddenView.setVisibility(View.GONE);
                arrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);

            }

            // If the CardView is not expanded, set its visibility to
            // visible and change the expand more icon to expand less.
            else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                hiddenView.setVisibility(View.VISIBLE);
                hiddenView1.setVisibility(View.GONE);
                type = "office";
                hiddenView2.setVisibility(View.GONE);
                arrow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
                arrow1.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                arrow2.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                setData(type);
            }
        });

        arrow1.setOnClickListener(view -> {

            if (hiddenView1.getVisibility() == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                hiddenView1.setVisibility(View.GONE);
                arrow1.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);

            }

            // If the CardView is not expanded, set its visibility to
            // visible and change the expand more icon to expand less.
            else {
                TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                hiddenView1.setVisibility(View.VISIBLE);
                hiddenView.setVisibility(View.GONE);
                hiddenView2.setVisibility(View.GONE);
                arrow1.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
                arrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                arrow2.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                type = "department";
                setData(type);
            }
        });

        arrow2.setOnClickListener(view -> {

            if (hiddenView2.getVisibility() == View.VISIBLE) {
                // The transition of the hiddenView is carried out by the TransitionManager class.
                // Here we use an object of the AutoTransition Class to create a default transition
                TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                hiddenView2.setVisibility(View.GONE);
                arrow2.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);

            }

            // If the CardView is not expanded, set its visibility to
            // visible and change the expand more icon to expand less.
            else {
                TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                hiddenView2.setVisibility(View.VISIBLE);
                hiddenView1.setVisibility(View.GONE);
                hiddenView.setVisibility(View.GONE);
                arrow2.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
                arrow1.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                arrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                type = "others";
                setData(type);
            }
        });

        Bitmap bitmap = BitmapData.getInstance().getBitmap();
        capimg = findViewById(R.id.capimg);
        capimg.setImageBitmap(bitmap);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayActivity.this, ObjectDetectionActivity.class);
                startActivity(i);
            }
        });

        if (blockname.equals("Central Block")) {
            estabinfo.setText("2010");
            history.setText("The Central Block is one of the most important buildings in the main campus of the university. It was inaugurated in the year 2010. This building houses some of the important infrastructure provided by the university such as the Knowledge Centre (PG Library) and Chapel, established in 2011. The block houses the cafeteria 'Gourmet' that provides various eateries to choose from.");
            floorinfo.setText("10");
        } else if (blockname.equals("Block 1")) {
            estabinfo.setText("1969");
            floorinfo.setText("2");
            history.setText("Block 1 was constructed and inaugurated in the year 1969. This marked a momentous occasion as it was blessed in preparation for the commencement of the first academic year on July 15 at 9:30 AM. The institution proudly initiated its educational journey by introducing one-year Pre-University Courses (PUC) under Bangalore University, setting the stage for a promising and enriching academic experience for the incoming students.");
        } else if (blockname.equals("Block 2")) {
            estabinfo.setText("1990");
            history.setText("Block 2 was constructed and inaugurated in the year 1990. It houses various departments and offices including the National Cadet Corps office.");
            floorinfo.setText("3");


        }
        else if (blockname.equals("Block 4")) {
            estabinfo.setText("2015");
            history.setText("Block IV of the central campus was established and inaugurated in the year 2015. It houses some of the important facilities of the campus such as the Center for Digital Innovation and the K.E Auditorium. The basement of the block also houses a cafeteria with a variety of eateries. ");
            floorinfo.setText("6");

        }

        else if (blockname.equals("R&D Block")) {
            estabinfo.setText("2021");
            history.setText("Research and Development Block was inaugurated in the year 2021. It houses the Central Instrumentation Facility, Data Analysis Center and various labs such as the  Bloomberg Facility, Life Sciences - Biotechnology Research, Synthetic Chemistry - Analytical and Physical Chemistry Research, Physics and Electronics Research etc.");
            floorinfo.setText("7");

        }

//        expand.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(DisplayActivity.this, Surrounding_Activity.class);
//                startActivity(i);
//            }
//        });

        vrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DisplayActivity.this, PanaromaTrial.class);
                i.putExtra("blockname",blockname);
                startActivity(i);
            }
        });


    }

    void setData(String type) {

        List<Building_Info> data = db.getAllBuilding_Info(blockname.toLowerCase(), type);
        modelArrayList.clear();
        //Toast.makeText(getApplicationContext(),blockname.toLowerCase()+type,Toast.LENGTH_SHORT).show();
        for (Building_Info cn : data) {

            //   Toast.makeText(getApplicationContext(),cn.getName(),Toast.LENGTH_SHORT).show();
            modelArrayList.add(new ListData(cn.getName(), cn.getRoomNo()));
            ml = new MyListAdapter(modelArrayList);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            if (type.equals("office")) {
                rv.setLayoutManager(linearLayoutManager);
                rv.setAdapter(ml);
            } else if (type.equals("department")) {
                rv1.setLayoutManager(linearLayoutManager);
                rv1.setAdapter(ml);
            } else {
                rv2.setLayoutManager(linearLayoutManager);
                rv2.setAdapter(ml);
            }

        }
    }

    //    public  void speakData()
//    {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            textToSpeech.speak(blockname,TextToSpeech.QUEUE_FLUSH,null,null);
//        } else {
//            textToSpeech.speak(blockname, TextToSpeech.QUEUE_FLUSH, null);
//        }
//    }
//    private void loadPanoramaImage() {
//        VrPanoramaView.Options options = new VrPanoramaView.Options();
//        panoramaView.setPureTouchTracking(true);
//        panoramaView.setStereoModeButtonEnabled(false);
//        panoramaView.setFullscreenButtonEnabled(true);
//        panoramaView.setVerticalFadingEdgeEnabled(false);
//        panoramaView.setVerticalScrollBarEnabled(false);
//        try {
//            options.inputType = VrPanoramaView.Options.TYPE_MONO;
////            Picasso
////                    .get()
////                    .load("https://firebasestorage.googleapis.com/v0/b/mobile-app-da42b.appspot.com/o/christ_football_ground.jpg?alt=media&token=9f9e3498-62c1-4bd4-9943-222f3492d102")
////                    .into(panoramaView);
//            panoramaView.loadImageFromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.block2_surroundings), options);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        plManager.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        plManager.onPause();
//        super.onPause();
//    }
//    @Override
//    protected void onDestroy() {
//        plManager.onDestroy();
//        super.onDestroy();
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return plManager.onTouchEvent(event);
//    }

}