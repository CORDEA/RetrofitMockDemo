package jp.cordea.retrofitmockdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import jp.cordea.retrofitmockdemo.api.response.Event;
import jp.cordea.retrofitmockdemo.databinding.ListItemMainBinding;

/**
 * Created by Yoshihiro Tanaka on 16/05/19.
 */
public class MainListAdapter extends ArrayAdapter<Event> {

    private ObservableArrayList<Event> events;

    public MainListAdapter(Context context, int resource, ObservableArrayList<Event> events) {
        super(context, resource);
        this.events = events;
    }

    public void refreshItems(ObservableArrayList<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Event getItem(int position) {
        return events.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemMainBinding binding = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.list_item_main, parent, false);
            convertView = binding.getRoot();
        }
        if (binding == null) {
            binding = DataBindingUtil.getBinding(convertView);
        }

        binding.setVm(new MainListItemViewModel(getItem(position)));

        return convertView;
    }
}
