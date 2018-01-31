package org.pindad.aftersalepindad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuisionerActivity extends AppCompatActivity {

    private RadioGroup rGroup1,rGroup2, rGroup3, rGroup4, rGroup5,rGroup6, rGroup7;
    private RadioButton radioButtonQuiz;
    private Button btnSQuiz;

    private boolean isChecking = true;
    private int mCheckedId = R.id.skor1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quisioner);

        rGroup1 = (RadioGroup) findViewById(R.id.rGroup1);
        rGroup2 = (RadioGroup) findViewById(R.id.rGroup2);
        rGroup3 = (RadioGroup) findViewById(R.id.rGroup3);
        rGroup4 = (RadioGroup) findViewById(R.id.rGroup4);
        rGroup5 = (RadioGroup) findViewById(R.id.rGroup5);
        rGroup6 = (RadioGroup) findViewById(R.id.rGroup6);
        rGroup7 = (RadioGroup) findViewById(R.id.rGroup7);
        btnSQuiz = (Button) findViewById(R.id.btnSQuiz);
//        addListenerOnButtonJawab();

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i  != -1 && isChecking){
                    isChecking = false;
                    rGroup2.clearCheck();
                    rGroup3.clearCheck();
                    rGroup4.clearCheck();
                    rGroup5.clearCheck();
                    rGroup6.clearCheck();
                    rGroup7.clearCheck();
                    mCheckedId = i;

                }
                isChecking = true;
            }
        });

        rGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i  != -1 && isChecking){
                    isChecking = false;
                    rGroup1.clearCheck();
                    rGroup3.clearCheck();
                    rGroup4.clearCheck();
                    rGroup5.clearCheck();
                    rGroup6.clearCheck();
                    rGroup7.clearCheck();
                    mCheckedId = i;

                }
                isChecking = true;
            }
        });

        rGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i  != -1 && isChecking){
                    isChecking = false;
                    rGroup1.clearCheck();
                    rGroup2.clearCheck();
                    rGroup4.clearCheck();
                    rGroup5.clearCheck();
                    rGroup6.clearCheck();
                    rGroup7.clearCheck();
                    mCheckedId = i;

                }
                isChecking = true;
            }
        });

        rGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i  != -1 && isChecking){
                    isChecking = false;
                    rGroup1.clearCheck();
                    rGroup2.clearCheck();
                    rGroup3.clearCheck();
                    rGroup5.clearCheck();
                    rGroup6.clearCheck();
                    rGroup7.clearCheck();
                    mCheckedId = i;

                }
                isChecking = true;
            }
        });

        rGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i  != -1 && isChecking){
                    isChecking = false;
                    rGroup1.clearCheck();
                    rGroup2.clearCheck();
                    rGroup3.clearCheck();
                    rGroup4.clearCheck();
                    rGroup6.clearCheck();
                    rGroup7.clearCheck();
                    mCheckedId = i;

                }
                isChecking = true;
            }
        });

        rGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i  != -1 && isChecking){
                    isChecking = false;
                    rGroup1.clearCheck();
                    rGroup2.clearCheck();
                    rGroup3.clearCheck();
                    rGroup4.clearCheck();
                    rGroup5.clearCheck();
                    rGroup7.clearCheck();
                    mCheckedId = i;

                }
                isChecking = true;
            }
        });

        rGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i  != -1 && isChecking){
                    isChecking = false;
                    rGroup1.clearCheck();
                    rGroup2.clearCheck();
                    rGroup3.clearCheck();
                    rGroup4.clearCheck();
                    rGroup5.clearCheck();
                    rGroup6.clearCheck();
                    mCheckedId = i;

                }
                isChecking = true;
            }
        });
    }

    public void showType(View view) {
        if (mCheckedId == R.id.skor1) {
            Toast.makeText(this, "type1", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor2) {
            Toast.makeText(this, "type2", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor3) {
            Toast.makeText(this, "type3", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor4) {
            Toast.makeText(this, "type4", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor5) {
            Toast.makeText(this, "type5", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor21) {
            Toast.makeText(this, "type21", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor22) {
            Toast.makeText(this, "type22", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor23) {
            Toast.makeText(this, "type23", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor24) {
            Toast.makeText(this, "type24", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor25) {
            Toast.makeText(this, "type25", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor31) {
            Toast.makeText(this, "type31", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor32) {
            Toast.makeText(this, "type32", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor33) {
            Toast.makeText(this, "type33", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor34) {
            Toast.makeText(this, "type34", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor35) {
            Toast.makeText(this, "type35", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor41) {
            Toast.makeText(this, "type41", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor42) {
            Toast.makeText(this, "type42", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor43) {
            Toast.makeText(this, "type43", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor44) {
            Toast.makeText(this, "type44", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor45) {
            Toast.makeText(this, "type45", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor51) {
            Toast.makeText(this, "type51", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor52) {
            Toast.makeText(this, "type52", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor53) {
            Toast.makeText(this, "type53", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor54) {
            Toast.makeText(this, "type54", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor55) {
            Toast.makeText(this, "type55", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor61) {
            Toast.makeText(this, "type61", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor62) {
            Toast.makeText(this, "type62", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor63) {
            Toast.makeText(this, "type63", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor64) {
            Toast.makeText(this, "type64", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor65) {
            Toast.makeText(this, "type65", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor71) {
            Toast.makeText(this, "type71", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor72) {
            Toast.makeText(this, "type72", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor73) {
            Toast.makeText(this, "type73", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor74) {
            Toast.makeText(this, "type74", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.skor75) {
            Toast.makeText(this, "type75", Toast.LENGTH_SHORT).show();
        }
    }



//    public void addListenerOnButtonJawab() {
//
//        btnSQuiz.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                //pilih radio button yang ada di radio button group
//                int selectedId = rGroup1.getCheckedRadioButtonId();
//                int selectedId1 = rGroup1.getCheckedRadioButtonId();
//                int selectedId2 = rGroup1.getCheckedRadioButtonId();
//                int selectedId3 = rGroup1.getCheckedRadioButtonId();
//                int selectedId4 = rGroup1.getCheckedRadioButtonId();
//                int selectedId5 = rGroup1.getCheckedRadioButtonId();
//                int selectedId6 = rGroup1.getCheckedRadioButtonId();
//
//                // mencari radio button
//                radioButtonQuiz = (RadioButton) findViewById(selectedId);
//                radioButtonQuiz = (RadioButton) findViewById(selectedId1);
//                radioButtonQuiz = (RadioButton) findViewById(selectedId2);
//                radioButtonQuiz = (RadioButton) findViewById(selectedId3);
//                radioButtonQuiz = (RadioButton) findViewById(selectedId4);
//                radioButtonQuiz = (RadioButton) findViewById(selectedId5);
//                radioButtonQuiz = (RadioButton) findViewById(selectedId6);
//                //menampilkan pesan teks / toast
//                Toast.makeText(getBaseContext(),
//                        "Kamu Memilih Notebook " + radioButtonQuiz.getText(),
//                        Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
//
//    }
}
