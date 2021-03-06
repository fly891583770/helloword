package com.helloword.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.service.NetworkService;
import com.helloword.service.UserService;

public class LoginActivity extends BaseActivity {

    // private Button loginBtn;
    // private Button regBtn;

    private EditText userNameET;
    private EditText passwordET;

    private CheckBox remember;
    private boolean isRemembered;

    UserService userService;
    String userName;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameET = (EditText) findViewById(R.id.login_username);
        passwordET = (EditText) findViewById(R.id.login_password);

        remember = (CheckBox) findViewById(R.id.login_auto);
        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                isRemembered = isChecked;
            }
        });
    }

    public void loginHandler(View view) {
        userName = userNameET.getText().toString().trim();
        password = passwordET.getText().toString().trim();

        if (userName.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "please input your username or password",
                    Toast.LENGTH_SHORT).show();
        } else {

            // ==========test test===========
            // Intent intent = new Intent(this, PVPModeActivity.class);
            // startActivity(intent);
            // finish();
            // ================================

            // Log.d(DEBUGTAG, userName + " " + password);
            NetworkService networkService = new NetworkService(this);
            if (networkService.isConnected()) {
                new LoginInBackground(LoginActivity.this).execute(userName, password);
            } else {
                Toast.makeText(getApplicationContext(),R.string.connect_to_network,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    public void registerHandler(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private class LoginInBackground extends AsyncTaskWithProgressDialog {
        public LoginInBackground(Context progressDialogContext) {
			super(progressDialogContext);
		}

		@Override
        protected String doInBackground2(String... params) {
            UserService userService = new UserService(getApplication());
            if (isRemembered) {
                userService.turnAutoLoginOn();
                userService.saveUserInfo(params[0], params[1]);
            }
            return userService.login(params[0], params[1]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute2(String result) {
            if (result.equals("success")) {
                Intent intent = new Intent(getApplicationContext(),
                        PVPModeActivity.class);
//            	Intent intent = new Intent(getApplicationContext(),
//            			PVPEndActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "失败",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
