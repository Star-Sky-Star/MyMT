package star.com.mymt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/10/15.
 */
public class HomeFastGridAdapter extends BaseAdapter {
    private List<FastShopData.DataBean> mDatas;

    public void setDatas(List<FastShopData.DataBean> datas) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fast_grid_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if ((i+1)<mDatas.size()){
         viewHolder.mFastGridTitle.setText(mDatas.get(i+1).getDeputytitle());
            viewHolder.mFastGridDesc.setText(mDatas.get(i+1).getMaintitle());
           // viewHolder.mFastGridDesc.setTextColor(Integer.parseInt(mDatas.get(i+1)
                   // .getTypeface_color()));
            BitmapUtils bitmapUtils=new BitmapUtils(viewGroup.getContext());
            bitmapUtils.display(viewHolder.mProfileImage,mDatas.get(i+1).getImageurl());
        }
        return view;
    }

    static class ViewHolder {
        protected TextView mFastGridTitle;
        protected TextView mFastGridDesc;
        protected CircleImageView mProfileImage;

        ViewHolder(View rootView) {
            initView(rootView);
        }
        private void initView(View rootView) {
            mFastGridTitle = (TextView) rootView.findViewById(R.id.fast_grid_title);
            mFastGridDesc = (TextView) rootView.findViewById(R.id.fast_grid_desc);
            mProfileImage = (CircleImageView) rootView.findViewById(R.id.profile_image);

        }
    }
}
