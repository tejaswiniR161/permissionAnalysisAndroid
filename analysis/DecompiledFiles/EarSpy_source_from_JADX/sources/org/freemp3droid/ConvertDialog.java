package org.freemp3droid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.microphone.earspy.C1206R;

public class ConvertDialog extends Activity {
    Spinner compressSpin;
    Spinner recSpin;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    public void initUI() {
        setContentView(C1206R.layout.convert_dialog);
        System.out.println("ertertert");
        System.out.println("dfFile nan " + getIntent().getExtras().getString("chosenFile"));
        final String chosenFile = getIntent().getExtras().getString("chosenFile");
        ((TextView) findViewById(C1206R.C1208id.convert_file_display)).setText("Path : " + chosenFile);
        this.recSpin = (Spinner) findViewById(C1206R.C1208id.rec_spin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, C1206R.array.rec_quality, 17367048);
        adapter.setDropDownViewResource(17367049);
        this.recSpin.setAdapter(adapter);
        this.compressSpin = (Spinner) findViewById(C1206R.C1208id.compress_spin);
        ArrayAdapter<CharSequence> compAdapter = ArrayAdapter.createFromResource(this, C1206R.array.compress_quality, 17367048);
        compAdapter.setDropDownViewResource(17367049);
        this.compressSpin.setAdapter(compAdapter);
        this.compressSpin.setSelection(6);
        this.recSpin.setSelection(0);
        ((Button) findViewById(C1206R.C1208id.convert_go_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent convIntent = new Intent(ConvertDialog.this, Main.class);
                convIntent.setAction("org.freemp3droid.CONVERT");
                convIntent.putExtra("convertFile", chosenFile);
                convIntent.putExtra("bitRate", Integer.parseInt((String) ConvertDialog.this.compressSpin.getSelectedItem()));
                convIntent.putExtra("sampleRate", Integer.parseInt((String) ConvertDialog.this.recSpin.getSelectedItem()));
                ConvertDialog.this.startActivity(convIntent);
                ConvertDialog.this.finish();
            }
        });
    }
}
