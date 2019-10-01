package com.nightowltechnology.asimyaz.nileconnect;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by asimbyazid on 03/03/2016.
 */
public class DirectoryDialogue extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.fragment_dir,null);
        builder.setTitle("Lecture Info");
        builder.setIcon(R.drawable.staffs);
        builder.setView(view);
        Dialog dialog = builder.create();
        return dialog;
    }
}
