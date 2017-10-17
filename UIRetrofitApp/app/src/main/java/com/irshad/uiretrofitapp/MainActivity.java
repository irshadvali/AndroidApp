package com.irshad.uiretrofitapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.irshad.uiretrofitapp.ui.FeedPollsAct;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "MainActivity";

    Activity activity;

    String fb_userId,facebookId = "";
    String bday,location_name,location_id;
    String email,firstName,lastName,business_token;

    CallbackManager callbackManager;


    GoogleApiClient mGoogleApiClient;
    GoogleSignInOptions gso;

    @Bind(R.id.signInTxt)
    TextView signInTxt;
    @Bind(R.id.facebookBtn)
    ImageView facebookBtn;
    @Bind(R.id.googleBtn)
    ImageView googleBtn;
    @Bind(R.id.login_button)
    LoginButton loginButton;
    @Bind(R.id.login_loader_lay)
    RelativeLayout loginLoader;
    @Bind(R.id.login_loader)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activity = MainActivity.this;
        callbackManager = CallbackManager.Factory.create();
        AppEventsLogger.activateApp(this);

        printKeyHash(activity);

        progressBar.setIndeterminate(true);

        // Configure sign-in to request the user's ID, email address, and basic profile. ID and
        // basic profile are included in DEFAULT_SIGN_IN.
         gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to GoogleSignIn.API and the options above.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    PrintO.log("idddddd"+fb_userId+" "+facebookId);
                    if(fb_userId==null) {
                        loginLoader.setVisibility(View.VISIBLE);
                        loginButton.performClick();
                    }else {
                        loginLoader.setVisibility(View.GONE);
//                        loginButton.performClick();
                    }

            }
        });
        // Callback registration
        loginButton.setReadPermissions(Arrays.asList(
                "public_profile","user_status", "email", "user_birthday", "user_friends"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loginLoader.setVisibility(View.GONE);
                String deniedPerm, grantedPerm, appId, prmission, e;
                fb_userId = loginResult.getAccessToken().getUserId();
                String Token = loginResult.getAccessToken().getToken();

                deniedPerm = loginResult.getRecentlyDeniedPermissions().toString();
                grantedPerm = loginResult.getRecentlyGrantedPermissions().toString();
                appId = loginResult.getAccessToken().getApplicationId();
                prmission = loginResult.getAccessToken().getPermissions().toString();

                //=======================//
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) { graphResponseFunc(response);}
                        });

//                /* make the API call */
//                new GraphRequest(AccessToken.getCurrentAccessToken(), facebookId, null, HttpMethod.GET,
//                        new GraphRequest.Callback() {
//                            public void onCompleted(GraphResponse response) {
//                                String tokenBusinedd = response.getRawResponse();
//                                System.out.println("token_business : "+response.toString());
//                            }
//                        }
//                ).executeAsync();

                Bundle parameters = new Bundle();
                parameters.putString("fields", "birthday,email,about,location,first_name,last_name");
                request.setParameters(parameters);
                request.executeAsync();

                PrintO.log("__ " + deniedPerm + "" + grantedPerm + "" + appId + "" + prmission + "");
                // createUserId();
            }

            @Override
            public void onCancel() {
                Toast.makeText(activity, "Canceled", Toast.LENGTH_LONG).show();
                loginLoader.setVisibility(View.GONE);
            }

            @Override
            public void onError(FacebookException exception) {
                loginLoader.setVisibility(View.GONE);
                PrintO.log("FB - User ID - Error" + fb_userId + " : ");
                showToast("Error facebook Exception");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            try {
                handleSignInResult(result);
            } catch (Exception e) {
                e.getLocalizedMessage();
                e.printStackTrace();
            }

        }
    }

    private void facebookSessionCheck() {
        //check login
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken == null) {
            Toast.makeText(getApplicationContext(), "Logged OUT", Toast.LENGTH_SHORT).show();
        } else {
             Toast.makeText(getApplicationContext(), "Logged IN", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.googleBtn)
    public void googleSignIn(){
       signIn();
    }

    @OnClick(R.id.facebookBtn)
    public void facebookSignIn(){
        Toast.makeText(activity,"Facebook coming soon!", Toast.LENGTH_SHORT).show();
    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {

            Toast.makeText(activity, "Sign in success with Google +", Toast.LENGTH_SHORT).show();
            loginLoader.setVisibility(View.GONE);

            String gmailID, full_name, googleplusId, pic_Url, location;
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount gmailData = result.getSignInAccount();

            gmailID = gmailData.getEmail();
            googleplusId = gmailData.getId();
            full_name = gmailData.getDisplayName();


            PrintO.log("__GMAIL EMAIL : " + gmailData.getEmail());
            PrintO.log("__GMAIL NAME : " + gmailData.getDisplayName());
            PrintO.log("__GMAIL ID : " + gmailData.getId());
            PrintO.log("__GMAIL TOKEN : " + gmailData.getIdToken());
            PrintO.log("__GMAIL AUTH_CODE : " + gmailData.getServerAuthCode());
            PrintO.log("__GMAIL GRANTED_SCOPES : " + gmailData.getGrantedScopes());
            PrintO.log("__GMAIL PHOTO_URL : " + gmailData.getPhotoUrl());
            PrintO.log("__GMAIL STATUS_MESSEG : " + result.getStatus().getStatusMessage());
            PrintO.log("__GMAIL STATUS : " + result.getStatus().getStatus());
            PrintO.log("__GMAIL RESOLUTION : " + result.getStatus().getResolution());
            PrintO.log("__GMAIL STATUS_CODE : " + result.getStatus().getStatusCode());
            PrintO.log("__GMAIL isSuccess : " + result.getStatus().isSuccess());
            Intent i=new Intent(this, FeedPollsAct.class);
            startActivity(i);

        } else {
            loginLoader.setVisibility(View.GONE);
            // Signed out, show unauthenticated UI.

        }
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
    }

    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
    }

    public static String printKeyHash(Activity context) {
        PackageInfo packageInfo;
        String key = null;
        try {
            //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();

            //Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                // String key = new String(Base64.encodeBytes(md.digest()));
                System.out.println("Key Hash= "+ key);
                Log.e("Key Hash=", key);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        }
        catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @OnClick(R.id.signInTxt)
    public void signInAct(){
        startActivity(new Intent(activity,SignInActivity.class));
    }

    private void graphResponseFunc(GraphResponse response){
        PrintO.log("Response" + response.toString());
        try {
            email = "";facebookId = "";firstName = "";lastName = ""; bday = "";
            if (!response.getJSONObject().optString("email", "").isEmpty()) {
                email = response.getJSONObject().getString("email");
            }

            if (!response.getJSONObject().optString("id", "").isEmpty()) {
                facebookId = response.getJSONObject().getString("id");
            }

            if (!response.getJSONObject().optString("first_name", "").isEmpty()) {
                firstName = response.getJSONObject().getString("first_name");
            }

            if (!response.getJSONObject().optString("last_name", "").isEmpty()) {
                lastName = response.getJSONObject().getString("last_name");
            }

            if (!response.getJSONObject().optString("birthday", "").isEmpty()) {
                bday = response.getJSONObject().getString("birthday");
            }

            String location_str = "";
            try {
                if (!response.getJSONObject().optString("location", "").isEmpty()) {
                    location_str = response.getJSONObject().getString("location");
                    JSONObject jsonObj = new JSONObject(location_str);
                    location_name = jsonObj.getString("name");
                    location_id = jsonObj.getString("id");
                } else {
                    location_str = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            try{
                if (!response.getJSONObject().optString("token_for_business","").isEmpty()){
                    business_token = response.getJSONObject().getString("token_for_business");

                }
                else {
                    business_token = "";
                }
            }
            catch (Exception e){
                e.getLocalizedMessage();
                e.printStackTrace();
            }

            PrintO.log("Result email:" + email);
            PrintO.log("Result lastName:" + lastName);
            PrintO.log("Result firstName:" + firstName);
            // PrintO.log("Result gender"+gender);
            PrintO.log("Result bday:" + bday);
            PrintO.log("Result location_name:" + location_name);
            PrintO.log("Result location_id:" + location_id);
            PrintO.log("Result id:" + facebookId);
            PrintO.log("Result business_token:" + business_token);
            Toast.makeText(activity, "Sign in success with Facebook!", Toast.LENGTH_LONG).show();
            loginLoader.setVisibility(View.GONE);
            /**
             * Check whether loggedin
             */

            //Call the api and fill up the details
            if (!facebookId.isEmpty()) {
                facebookId = String.valueOf(new Random().nextInt(6));
                PrintO.log("Result id:" + facebookId);
                facebookSessionCheck();
                PrintO.log("FACEBook_DATA : " + firstName + " " + lastName + " " + bday + " " + facebookId);
            } else {
                facebookSessionCheck();
            }
        } catch (Exception e) {
            PrintO.log("(Exception show" + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private void showToast(String toastMsg){
        Toast.makeText(activity, toastMsg , Toast.LENGTH_SHORT).show();
    }
}
