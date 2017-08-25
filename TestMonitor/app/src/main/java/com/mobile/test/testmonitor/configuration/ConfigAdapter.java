package com.mobile.test.testmonitor.configuration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobile.test.testmonitor.R;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */

public class ConfigAdapter extends RecyclerView.Adapter<ConfigAdapter.ViewHolder> {

    private List<ConfigItem> mConfigList;


    static class ViewHolder extends RecyclerView.ViewHolder {
        View configView;
        TextView configName;
        TextView configStatus;

        public ViewHolder(View view) {
            super(view);
            configView = view;
            configName = (TextView) view.findViewById(R.id.config_item_name);
            configStatus = (TextView) view.findViewById(R.id.config_item_status);
        }
    }

    public ConfigAdapter(List<ConfigItem> configItemList) {
        mConfigList = configItemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.config_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.configView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                ConfigItem configItem = mConfigList.get(position);
                if (configItem.getStatus().equals("ON")) {
                    configItem.setStatus("OFF");
                } else {
                    configItem.setStatus("ON");
                }
                notifyItemChanged(position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ConfigItem configItem = mConfigList.get(position);
        holder.configName.setText(configItem.getName());
        holder.configStatus.setText(configItem.getStatus());
    }

    @Override
    public int getItemCount() {
        return mConfigList.size();
    }
}
