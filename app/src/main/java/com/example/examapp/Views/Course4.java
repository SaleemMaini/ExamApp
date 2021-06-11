package com.example.examapp.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examapp.Controller.RecyclerViewAdapter;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course4 extends Fragment {
    View v;
    RecyclerView course4_RecyclerView;
    List<Data_Question> course4QuestionList;
    RecyclerViewAdapter recyclerViewAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Course4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Course4.
     */
    // TODO: Rename and change types and number of parameters
    public static Course4 newInstance(String param1, String param2) {
        Course4 fragment = new Course4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        course4QuestionList = new ArrayList<Data_Question>();
//      Add Data Here
        course4QuestionList.add(new Data_Question("4444",40));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_course4,container,false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Recycler
        course4_RecyclerView = (RecyclerView) v.findViewById(R.id.rvCourse4);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        course4_RecyclerView.setLayoutManager(llm);
        course4_RecyclerView.setHasFixedSize(true);

        //Adapter
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),course4QuestionList);
        course4_RecyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

    }

}