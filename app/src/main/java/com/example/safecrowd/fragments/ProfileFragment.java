package com.example.safecrowd.fragments;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.safecrowd.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.parse.Parse;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.internal.http2.Header;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Profile Fragment";

    private ProgressBar pb;

    public long userId;
    public String screenName;
    private TextView tvUserNameP;
    private TextView tvSinceP;
    private TextView tvUserDescription;
    private FloatingActionButton ivProfileImageP;

    private ParseUser user;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pb = (ProgressBar) view.findViewById(R.id.pbLoading);

        userId = getActivity().getIntent().getLongExtra("user_uid", -1);
        screenName = getActivity().getIntent().getStringExtra("screenName");
//        if (userId == -1){
//            onError(0, null);
//        } else if (screenName == null) {
//            onError(0, "Screen name was null");
//        }

        tvUserNameP = (TextView) view.findViewById(R.id.tvUserNameP);
        tvSinceP = (TextView) view.findViewById(R.id.tvSinceP);
        tvUserDescription = (TextView) view.findViewById(R.id.tvUserDescription);

        ivProfileImageP = (FloatingActionButton) view.findViewById(R.id.ivProfileImageP);

        user = ParseUser.getCurrentUser();
        populateUserHeadline(user);
    }

    public void populateUserHeadline(final ParseUser user) {
        // populate the screen with info gathered
        tvUserNameP.setText(user.getUsername());
        tvSinceP.setText("On SafeCrowd since " + user.getCreatedAt());
//        tvUserDescription.setText(user.getEmail()); // dont have description
//        if (user.getEmail().length() <= 1) { // if description is short dont show
//            tvUserDescription.setVisibility(View.GONE);
//        }
        // add the images
//        Glide.with(getActivity().getBaseContext()).load(user.getProfileImage())
//                .placeholder(R.drawable.ic_profile)
//                .error(R.drawable.ic_profile)
//                .into(ivProfileImageP);
        }

//    public void onError(int code, String message) {
//        String onErrorString = "onError error occurred";
//        switch (code) {
//            case 0: {
//                // error while parsing the userId
//                Toast.makeText(getActivity().getBaseContext(), String.format("Error occurred while parsing the userId. %s", message), Toast.LENGTH_LONG).show();
//                break;
//            }
//            case 1: {
//                // error while parsing the json from twitter server response
//                Toast.makeText(getActivity().getBaseContext(), String.format("Error occurred while while parsing the json from the twitter server response. %s", message), Toast.LENGTH_LONG).show();
//                break;
//            }
//            case 2: {
//                // error while sending a request to twitter server
//                Toast.makeText(getActivity().getBaseContext(), String.format("Error occurred while while sending a request to the twitter server. %s", message), Toast.LENGTH_LONG).show();
//                break;
//            }
//            default: {
//                // unidentified error
//                Toast.makeText(getActivity().getBaseContext(), String.format("Unidentified error occured."), Toast.LENGTH_LONG).show();
//                break;
//            }
//        }
//        Log.e(TAG, String.format("%s at %s: %s", onErrorString, code, message));
//        getActivity().finish(); // finish because bad error
//    }
}