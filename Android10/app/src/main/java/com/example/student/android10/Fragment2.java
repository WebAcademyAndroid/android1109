package com.example.student.android10;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment2 extends DialogFragment {

    private static final String EXTRA_STUDENT = "com.example.student.android10.extra.STUDENT";

    private TextView mTextViewFirstName, mTextViewLastName, mTextViewAge;

    private Student mStudent;

    public static Fragment2 newInstance(Student student) {
        Fragment2 fragment = new Fragment2();

        Bundle args = new Bundle();
        args.putParcelable(EXTRA_STUDENT, student);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStudent = getArguments().getParcelable(EXTRA_STUDENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        mTextViewFirstName = view.findViewById(R.id.editTextFirstName);
        mTextViewLastName = view.findViewById(R.id.editTextLastname);
        mTextViewAge = view.findViewById(R.id.editTextAge);

        view.findViewById(R.id.buttonSave).setOnClickListener(saveListener);
        view.findViewById(R.id.buttonCancel).setOnClickListener(cancelListener);

        init();

        return view;
    }


    private View.OnClickListener saveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mStudent.firstName = mTextViewFirstName.getText().toString();
                mStudent.lastName = mTextViewLastName.getText().toString();
                mStudent.age = Integer.parseInt(mTextViewAge.getText().toString());

                mListener.save(mStudent);
            }
        }
    };

    private View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.cancel();
            }
        }
    };

    private void init() {
        mTextViewFirstName.setText(mStudent.firstName);
        mTextViewLastName.setText(mStudent.lastName);
        mTextViewAge.setText(String.valueOf(mStudent.age));
    }

    public interface ActionListener {
        void save(Student student);

        void cancel();
    }

    private ActionListener mListener;

    public void setActionListener(ActionListener listener) {
        mListener = listener;
    }
}
