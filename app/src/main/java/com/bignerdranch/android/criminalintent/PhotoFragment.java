package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

public class PhotoFragment extends DialogFragment {

    private static final String ARG_PHOTO = "photo";

    private ImageView mImageView;

    public static PhotoFragment newInstance(File file) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, file);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // return super.onCreateDialog(savedInstanceState);
        File file = (File)getArguments().getSerializable(ARG_PHOTO);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_photo, null);

        mImageView = (ImageView)v.findViewById(R.id.crime_photo);

        Bitmap bitmap = PictureUtils.getScaledBitmap(file.getPath(), getActivity());
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
