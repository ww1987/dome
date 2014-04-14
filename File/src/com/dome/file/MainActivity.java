package com.dome.file;

import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    private static final String TAG = "MainActivity";
	private Button writeRom;
	private Button writeSD;
	private String name;
	private String context;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeRom = (Button) findViewById(R.id.btn_mian_rom);
        writeSD = (Button) findViewById(R.id.btn_mian_sd);

        writeRom.setOnClickListener(this);
        writeSD.setOnClickListener(this);
    }

	
	
	protected void onResume() {
		super.onResume();
		
		writeSD.setEnabled(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED));
	}



	@Override
	public void onClick(View view) {
		FileService service = new FileService(this);
        name = ((EditText) findViewById(R.id.et_main_fileName)).getText().toString();
        context = ((EditText) findViewById(R.id.et_main_context)).getText().toString();
		switch (view.getId()) {
		case R.id.btn_mian_rom:
			Log.i(TAG, "写入ROM");
			service.writeFileToRom(name,context);
			break;
		case R.id.btn_mian_sd:
			Log.i(TAG, "写入SD");
			try {
				service.writeFileToSDCard(name,context);
				Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				Toast.makeText(getApplicationContext(), "保存失败", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
			
			
			break;
		}
	}
}
