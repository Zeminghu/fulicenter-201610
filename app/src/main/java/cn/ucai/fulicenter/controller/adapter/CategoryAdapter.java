package cn.ucai.fulicenter.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;

import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.model.bean.CategoryChildBean;
import cn.ucai.fulicenter.model.bean.CategoryGroupBean;

/**
 * Created by Administrator on 2017/1/13.
 */

public class CategoryAdapter extends BaseExpandableListAdapter {
    Context mContext;
    ArrayList<CategoryGroupBean> mGroupBeen;
    ArrayList<ArrayList<CategoryChildBean>> mChildBeen;

    public CategoryAdapter(Context context, ArrayList<CategoryGroupBean> groupBeen, ArrayList<ArrayList<CategoryChildBean>> childBeen) {
        mContext = context;
        mGroupBeen=new ArrayList<>();
        mGroupBeen.addAll(groupBeen);
       mChildBeen=new ArrayList<>();
        mChildBeen.addAll(childBeen);
    }

    @Override
    public int getGroupCount() {
        return mGroupBeen!=null?mGroupBeen.size():0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildBeen!=null && mChildBeen.get(groupPosition)!=null?
                mChildBeen.get(groupPosition).size():0;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
       View inflate= LayoutInflater.from(mContext).inflate(R.layout.item_category_group,null);
        return inflate;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View inflate= LayoutInflater.from(mContext).inflate(R.layout.item_category_child,null);
        return inflate;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
