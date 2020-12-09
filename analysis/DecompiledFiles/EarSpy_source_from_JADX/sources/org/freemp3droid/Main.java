//./DecompiledFiles/EarSpy_source_from_JADX/sources/com/google/android/gms/common/apiGoogleApiActivity.java
package org.freemp3droid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.microphone.earspy.C1206R;
import java.io.File;
import java.util.ArrayList;

public class Main extends Activity {
    ListView fileList;
    LayoutInflater layoutInflater;
    Converter mBoundConvService;
    ProgressDialog progressDialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, Converter.class));
        initUI();
    }

    public void initUI() {
        setContentView(C1206R.layout.main);
        this.layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.fileList = (ListView) findViewById(C1206R.C1208id.file_list);
        refreshFileList();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public ProgressDialog initConvertingDialog() {
        String message = getString(C1206R.string.prog_msg);
        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setProgressStyle(1);
        pDialog.setProgress(0);
        pDialog.setTitle(getString(C1206R.string.prog_title));
        pDialog.setMessage(message);
        pDialog.setCancelable(false);
        pDialog.setMax(100);
        pDialog.setButton(getString(C1206R.string.convert_later), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Main.this.killConversion();
            }
        });
        return pDialog;
    }

    public void killConversion() {
        if (this.mBoundConvService != null) {
            this.mBoundConvService.killedByUser = true;
            this.mBoundConvService.killConvert();
        }
    }

    public void refreshFileList() {
        final ArrayList<File> files = Util.listFiles(this);
        final ArrayList<File> arrayList = files;
        this.fileList.setAdapter(new ArrayAdapter<File>(this, 17367043, files) {
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView i = (TextView) Main.this.layoutInflater.inflate(17367043, (ViewGroup) null).findViewById(16908308);
                i.setText(((File) arrayList.get(position)).getName());
                i.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                return i;
            }
        });
        this.fileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View arg1, int pos, long rid) {
                Main.this.initFileActionMenu((File) files.get(pos));
            }
        });
    }

    public void initFileActionMenu(final File inFile) {
        ListView ret = new ListView(this);
        final AlertDialog d = new AlertDialog.Builder(this).create();
        d.setTitle(inFile.getName());
        final Integer[] listImages = {17301540, 17301564};
        ret.setAdapter(new ArrayAdapter(this, 17367043, new String[]{"Play", "Delete"}));
        ret.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View arg1, int pos, long arg3) {
                if (listImages[pos].intValue() == 17301540) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse("file://" + inFile.getAbsolutePath()), "audio/mp3");
                    Main.this.startActivity(intent);
                } else if (listImages[pos].intValue() == 17301564) {
                    inFile.delete();
                }
                Main.this.refreshFileList();
                d.dismiss();
            }
        });
        d.setView(ret);
        d.show();
    }

    public void onConversionComplete() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
        refreshFileList();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && data.hasExtra("chosenFile")) {
            Intent convDialog = new Intent(this, ConvertDialog.class);
            convDialog.putExtra("chosenFile", data.getExtras().getString("chosenFile"));
            startActivity(convDialog);
            finish();
        }
    }
}
