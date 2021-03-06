package com.example.examapp.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examapp.Controller.RecyclerViewAdapter;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course3 extends Fragment {
    View v;
    RecyclerView course3_RecyclerView;
    List<Data_Question> course3QuestionList;
    public static RecyclerViewAdapter recyclerViewAdapter;
    DatabaseHelper1 databaseHelper1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Course3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Course3.
     */
    // TODO: Rename and change types and number of parameters
    public static Course3 newInstance(String param1, String param2) {
        Course3 fragment = new Course3();
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
//        course3QuestionList = new ArrayList<Data_Question>();
////        Add Data Here
//        course3QuestionList.add(new Data_Question("33333",30));

//Adapter
        databaseHelper1 = new DatabaseHelper1(getActivity());
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),databaseHelper1.getCourse3Questions(),databaseHelper1);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        course1_RecyclerView.setLayoutManager(layoutManager);
//        course1_RecyclerView.setItemAnimator(new DefaultItemAnimator());
//        course1_RecyclerView.setAdapter(recyclerViewAdapter);
//
//        List<Data_Question> mydata = databaseHelper1.getAllData();
//        for(Data_Question data : mydata){
//            String myInfo = " Text: "+data.getText()+" Mark : "+data.getMark();
//            Log.d("data", myInfo);
//        }

//        course1QuestionList = databaseHelper1.getAllData();
//        course1QuestionList= new ArrayList<Data_Question>(databaseHelper1.getAllData());


//        Add Data Here

//        course1QuestionList.add(new QuestionController((AppCompatActivity) getActivity()).getQuestionId_course(1));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_course3,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Recycler
        course3_RecyclerView = (RecyclerView) v.findViewById(R.id.rvCourse3);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        course3_RecyclerView.setLayoutManager(llm);
        course3_RecyclerView.setHasFixedSize(true);

        //Adapter
        course3_RecyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

    }
    public static void notifyAdapter(){
        recyclerViewAdapter.notifyDataSetChanged();
    }

}