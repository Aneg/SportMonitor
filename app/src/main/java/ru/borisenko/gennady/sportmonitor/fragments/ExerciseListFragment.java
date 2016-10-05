package ru.borisenko.gennady.sportmonitor.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import ru.borisenko.gennady.sportmonitor.R;
import ru.borisenko.gennady.sportmonitor.models.HelperFactory;


public class ExerciseListFragment extends ListFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HelperFactory.setHelper(getContext());
        return inflater.inflate(R.layout.exercise_list_fragment, container, false);
    }

    String data[] = new String[] { "one", "two", "three", "four" };


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AdapterView.OnItemLongClickListener listener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Toast.makeText( getActivity().getBaseContext()  , "Long Clicked " + data[position] , Toast.LENGTH_SHORT).show();
                return false;
            }
        };

        getListView().setOnItemLongClickListener(listener);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        HelperFactory.releaseHelper();
        super.onDestroyView();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(getContext(), item + " selected", Toast.LENGTH_LONG).show();
    }
}
