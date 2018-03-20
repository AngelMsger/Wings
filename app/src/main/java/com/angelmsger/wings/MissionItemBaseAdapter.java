package com.angelmsger.wings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.angelmsger.wings.MissionItemContent.MissionItemItem;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MissionItemBaseAdapter extends BaseAdapter {
    private final List<MissionItemContent.MissionItemItem> mValues;
    private final LayoutInflater mInflater;

    public MissionItemBaseAdapter(List<MissionItemItem> values, LayoutInflater inflater) {
        this.mValues = values;
        this.mInflater = inflater;
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public Object getItem(int i) {
        return mValues.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mInflater.inflate(R.layout.item_missionitem, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.mAvatar = (CircleImageView) view.findViewById(R.id.avatar);
            viewHolder.mUsername = (TextView) view.findViewById(R.id.username);
            viewHolder.mRequest = (TextView) view.findViewById(R.id.request);
            viewHolder.mResponse = (TextView) view.findViewById(R.id.response);
            viewHolder.mPhone = (TextView) view.findViewById(R.id.phone);
            viewHolder.mDeadline = (TextView) view.findViewById(R.id.deadline);
            viewHolder.mCharge = (TextView) view.findViewById(R.id.charge);
            view.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        MissionItemItem missionItemItem = mValues.get(i);
        Glide.with(mInflater.getContext()).load(missionItemItem.avataruri).into(viewHolder.mAvatar);
        viewHolder.mUsername.setText(missionItemItem.username);
        viewHolder.mRequest.setText(missionItemItem.request);
        viewHolder.mResponse.setText(missionItemItem.response);
        viewHolder.mPhone.setText(missionItemItem.phone);
        viewHolder.mDeadline.setText(missionItemItem.deadline);
        viewHolder.mCharge.setText(missionItemItem.charge);
        return view;
    }

    public class ViewHolder {
        public CircleImageView mAvatar;
        public TextView mUsername;
        public TextView mRequest;
        public TextView mResponse;
        public TextView mPhone;
        public TextView mDeadline;
        public TextView mCharge;
    }
}
