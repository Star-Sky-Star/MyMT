package star.com.mymt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/15.
 */
public class HomeListAdapter extends BaseAdapter {
    private ArrayList<HomeListData.DataBean> mDatas;

    public void setDatas(ArrayList<HomeListData.DataBean> datas) {
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (view == null || !(view.getTag() instanceof ViewHolder)) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_list_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        BitmapUtils bitmapUtils=new BitmapUtils(viewGroup.getContext());
        bitmapUtils.display(viewHolder.mListItemImage,mDatas.get(i).getImageUrl());
        HomeListData.DataBean dataBean = mDatas.get(i);
        viewHolder. mListItemTitle.setText(dataBean.getTitle());
        viewHolder.mSubTitle.setText(dataBean.getSubTitle());
        String subTitle2 = dataBean.getSubTitle2();
            viewHolder.mSubTitle2.setText(subTitle2);
        viewHolder.mSubMessage.setText(dataBean.getSubMessage());
        viewHolder.mReason.setText(dataBean.getReason());
viewHolder.mMainMessage.setText(dataBean.getMainMessage());
        viewHolder.mMainMessage2.setText(dataBean.getMainMessage2());
       // viewHolder.mTag.setText(dataBean.get);
        return view;
    }

    static class ViewHolder {
        protected ImageView mListItemImage;
        protected TextView mListItemTitle;
        protected TextView mSubTitle;
        protected TextView mSubTitle2;
        protected TextView mSubMessage;
        protected TextView mReason;
        protected TextView mMainMessage;
        protected TextView mMainMessage2;
        protected TextView mTag;
        protected TextView mTopRightInfo;
        protected TextView mBottomRightInfo;

        ViewHolder(View rootView) {
            initView(rootView);
        }

        private void initView(View rootView) {
            mListItemImage = (ImageView) rootView.findViewById(R.id.list_item_image);
            mListItemTitle = (TextView) rootView.findViewById(R.id.list_item_title);
            mSubTitle = (TextView) rootView.findViewById(R.id.subTitle);
            mSubTitle2 = (TextView) rootView.findViewById(R.id.subTitle2);
            mSubMessage = (TextView) rootView.findViewById(R.id.subMessage);
            mReason = (TextView) rootView.findViewById(R.id.reason);
            mMainMessage = (TextView) rootView.findViewById(R.id.mainMessage);
            mMainMessage2 = (TextView) rootView.findViewById(R.id.mainMessage2);
            mTag = (TextView) rootView.findViewById(R.id.tag);
            mTopRightInfo = (TextView) rootView.findViewById(R.id.topRightInfo);
            mBottomRightInfo = (TextView) rootView.findViewById(R.id.bottomRightInfo);
        }
    }
}
