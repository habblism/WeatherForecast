package hey.forecast.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hey.forecast.R;

/**
 * Created by yhb on 17-12-16.
 */

public abstract class SimpleAdapter<Entity> extends RecyclerView.Adapter<SimpleHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<Entity> mEntities;
    protected LayoutInflater mInflater;


    public SimpleAdapter(Context context, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
    }

    @Override
    public SimpleHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        return SimpleHolder.get(mContext, parent, mLayoutId);
    }

    @Override
    public void onBindViewHolder(SimpleHolder holder, int position) {
        forEachHolder(holder, mEntities.get(position));
    }

    public abstract void forEachHolder(SimpleHolder holder, Entity entity);

    public void performDataChanged(Entity[] entities) {
        if (entities == null) {
            Toast.makeText(mContext, R.string.netError, Toast.LENGTH_SHORT).show();
            return;
        }
        this.mEntities = new ArrayList<>(Arrays.asList(entities));
        notifyItemRangeChanged(0, mEntities.size());
    }

    public void performDataChanged(List<Entity> entities) {
        if (entities == null) {
            Toast.makeText(mContext, R.string.netError, Toast.LENGTH_SHORT).show();
            return;
        }
        this.mEntities = new ArrayList<>();
        this.mEntities.addAll(entities);
        notifyItemRangeChanged(0, mEntities.size());
    }

    public void addSingleData(Entity entity) {
        if (mEntities == null) {
            throw new IllegalArgumentException("performDataChanged() first to create a array inside!");
        }
        mEntities.add(entity);
        notifyItemInserted(mEntities.size() - 1);
    }

    public void removeSingleData(Entity entity) {
        if (mEntities == null) {
            throw new IllegalArgumentException("performDataChanged() first to create a array inside!");
        }
        int position = mEntities.indexOf(entity);
        if (position != -1) {
            mEntities.remove(entity);
        }
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mEntities.size() - position -1);
    }

    @Override
    public int getItemCount() {
        if (mEntities == null) {
            return 0;
        }
        return mEntities.size();
    }
}