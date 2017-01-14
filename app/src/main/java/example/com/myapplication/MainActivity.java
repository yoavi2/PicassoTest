package example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNewActivity;
    Button btnImage;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewActivity = (Button) findViewById(R.id.btn_new_activity);
        btnNewActivity.setOnClickListener(this);

        btnImage = (Button) findViewById(R.id.btn_image);
        btnImage.setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.image);

        Picasso.with(this).setIndicatorsEnabled(true);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case (R.id.btn_new_activity):
                Intent intent = new Intent(this, AnotherActivity.class);
                startActivity(intent);
                break;
            case (R.id.btn_image):

                Picasso.with(this)
                        .load("http://rn2016.most.gov.il/images/openu/openu.jpg")
                        .placeholder(R.mipmap.download)
                        .error(R.mipmap.error)
                        .into(imageView);

                break;
            default:
                break;
        }

    }
}
