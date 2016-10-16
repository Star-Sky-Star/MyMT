package star.com.mymt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.weiqianghu.grid_dot_view_pager.ConvertView;
import com.weiqianghu.grid_dot_view_pager.GridDotViewpager;
import com.weiqianghu.grid_dot_view_pager.ViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/10/15.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    protected View rootView;
    protected TextView mCityPicker;
    protected LinearLayout mTopCity;
    protected LinearLayout mHomeBtnTopSearch;
    protected ImageView mHomeTopMenu;
    protected ImageView mHomeTopMessage;
    protected ListView mHomeList;
    protected GridDotViewpager mHomeGridTop;
    protected TextView mFastShop;
    protected TextView mFastShopDesc;
    protected ImageView mFastShopPicture;
    protected GridView mFastGrid;
    private GridDotViewpager mGridViewPager;
    private List<Demo> mDemos = new ArrayList<>();
    private String[] mTitle = {"美食", "健康", "娱乐", "热门", "酒店", "丽人", "电影", "最新", "其他", "超市", "旅游", "所有"};
    private int[] mPicture = {R.drawable.ic_category_food_for_map, R.drawable.ic_category_health_for_map
            , R.drawable.ic_category_entertainment_for_map
            , R.drawable.ic_category_hot_for_map, R.drawable.ic_category_hotel_for_map, R.drawable
            .ic_category_live_for_map, R.drawable.ic_category_movie_for_map, R.drawable
            .ic_category_new_for_map, R.drawable.ic_category_other_for_map, R.drawable
            .ic_category_shop_for_map, R.drawable.ic_category_travel_for_map, R.drawable.ic_category_all_for_map};

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_fragment_layout, null, false);
        initData();
        initView(rootView);
        return rootView;
    }

    private void initData() {
String topUrl="http://api.meituan.com/group/v3/cate/menu/android/7.3.1?city=73" +
        "&extendHomepage=true&client=android&hasGroup=true&__vhost=" +
        "api.mobile.meituan.com&utm_source=haoyou&utm_medium=android&utm_term=" +
        "431&version_name=7.3.1&utm_content=133524547667948&utm_campaign=AgroupBgrou" +
        "pC8214700635326840064_c25_eb55cac709b7a8f98407b6291e1371ac6_f33022128E0Ghom" +
        "epage_allcate&ci=73&msid=1335245476679481476441039598&uuid=ADD3922BA08F586" +
        "A43B16A4330788122CF69CE7879C3C62FDBBD0E2102AE75D0&userid=-1&__reqTraceID=f7" +
        "528445-b08c-4aad-837a-e";
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, topUrl, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Gson gson=new Gson();
                HomeTopData homeTopData = gson.fromJson(result, HomeTopData.class);
                HomeTopData.DataBean data = homeTopData.getData();
                List<HomeTopData.DataBean.HomepageBean> homepage = data.getHomepage();
                for (int i = 0; i < homepage.size(); i++) {
                    Demo demo = new Demo(homepage.get(i).getName(), homepage.get(i).getIconUrl());
                    mDemos.add(demo);
                }

            }

            @Override
            public void onFailure(HttpException error, String msg) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.city_picker) {

        } else if (view.getId() == R.id.home_btn_top_search) {

        } else if (view.getId() == R.id.home_top_menu) {

        } else if (view.getId() == R.id.home_top_message) {

        }
    }

    private void initView(View rootView) {
        mCityPicker = (TextView) rootView.findViewById(R.id.city_picker);
        mCityPicker.setOnClickListener(HomeFragment.this);
        mTopCity = (LinearLayout) rootView.findViewById(R.id.top_city);
        mHomeBtnTopSearch = (LinearLayout) rootView.findViewById(R.id.home_btn_top_search);
        mHomeBtnTopSearch.setOnClickListener(HomeFragment.this);
        mHomeTopMenu = (ImageView) rootView.findViewById(R.id.home_top_menu);
        mHomeTopMenu.setOnClickListener(HomeFragment.this);
        mHomeTopMessage = (ImageView) rootView.findViewById(R.id.home_top_message);
        mHomeTopMessage.setOnClickListener(HomeFragment.this);
        mHomeList = (ListView) rootView.findViewById(R.id.home_list);

       //头部标签
        mHomeList.addHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.guid_view_layout, null));
        mHomeGridTop = (GridDotViewpager) rootView.findViewById(R.id.home_grid_top);
         mHomeGridTop.setDataAndView(mDemos, R.layout.dot_gridview_item, new ConvertView<Demo>() {
            @Override
            public void setConvertView(ViewHolder helper, Demo item) {
                helper.setText(R.id.title, item.title);
                String imgUrl = item.imgUrl;
                ImageView img = (ImageView) mHomeGridTop.findViewById(R.id.img);
                BitmapUtils bitmapUtils=new BitmapUtils(getContext());
                bitmapUtils.display(img,item.imgUrl);
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "点击了当前的item", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
   String url="http://api.meituan.com/group/v1/deal/topic/discount/city/73?version_name=7.3." +
        "1&limit=7&latlng=34.75547243764185%2C113.6557194655159&__vhost=api.mobile.meituan" +
        ".com&utm_source=haoyou&utm_medium=android&utm_term=431&utm_content=133524744247726&utm_" +
        "campaign=AgroupBgroupC0E0&ci=73&msid=1335247442477261476436335309&uuid=6228E4D7AACA9BF" +
        "801D1071FE78061F7907BF0AB64D31D2608DEBB6DCBF191C7&userid=-1&__reqTraceID=13748b03-2e86" +
        "-4540-88cb-850055b39e20&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1476437066314&" +
        "__skua=8ab24003f768ad839edb8c02607d8a9f&__skno=eee12ae6-0e27-498e-b1f6-e06032ebfa14&__" +
        "skcy=0END%2FGvxMA1VRF%2BjLZciXijEQUo%3D";
        //新人专享头部
        mHomeList.addHeaderView(LayoutInflater.from(getContext()).inflate(R.layout
                .home_list_head, null));
        mFastShop = (TextView) rootView.findViewById(R.id.fast_shop);
        mFastShopDesc = (TextView) rootView.findViewById(R.id.fast_shop_desc);
        mFastShopPicture = (ImageView) rootView.findViewById(R.id.fast_shop_picture);
        mFastGrid = (GridView) rootView.findViewById(R.id.fast_grid);
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Gson gson=new Gson();
                FastShopData fastShopData = gson.fromJson(result, FastShopData.class);
                List<FastShopData.DataBean> data = fastShopData.getData();
                HomeFastGridAdapter adapter = new HomeFastGridAdapter();
                adapter.setDatas(data);
                mFastShop.setText(data.get(0).getDeputytitle());
                mFastShopDesc.setText(data.get(0).getMaintitle());
               // mFastShopDesc.setTextColor(Integer.parseInt(data.get(0).getTypeface_color()));
                BitmapUtils bitmapUtils=new BitmapUtils(getContext());
                bitmapUtils.display(mFastShopPicture,data.get(0).getImageurl());
                mFastGrid.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.e("error",error.getMessage()+"新人特权");
            }
        });


        //HttpUtils httpUtils=new HttpUtils();
        String urlList="http://api.meituan.com/group/v2/recommend/homepage/city/73?position=34.755428%2C113.655805&supportId=1&wifi-cur=0&wifi-mac=01%3A80%3Ac2%3A00%3A00%3A03%08&wifi-name=MEmuWiFi%08&wifi-strength=-55%08&fields=imageUrl%2Ctitle%2CimageTitle%2CsubTitle%2CsubTitle2%2CmainMessage%2CmainMessage2%2CsubMessage%2CtopRightInfo%2CbottomRightInfo%2C_type%2C_from%2C_id%2C_iUrl%2C_jumpNeed%2Ccolor%2Ccampaign%2CglobalId&client=android&__vhost=api.mobile.meituan.com&utm_source=yingyonghui&utm_medium=android&utm_term=431&version_name=7.3.1&utm_content=133524916285256&utm_campaign=AgroupBgroupC0E0&ci=73&msid=1335249162852561476511281275&uuid=27557731D5C269FC8D8D8C73704714E050A52091F7E75BF28AB5BEC1B92C4D48&userid=-1&__reqTraceID=56a3fc4a-56b7-4966-bfa8-5e99505b8900&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1476515125987&__skua=8a2d735f025b2940d2cc407188cc3c33&__skno=62c95b43-c194-419b-943f-01cf565497d1&__skcy=jiIgCto7D5RTSRzcXsY9fNTT9vI%3D";
        httpUtils.send(HttpRequest.HttpMethod.GET, urlList, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Gson gson=new Gson();
                HomeListData homeListData = gson.fromJson(result, HomeListData.class);
                List<HomeListData.DataBean> data = homeListData.getData();
                HomeListAdapter adapter = new HomeListAdapter();
                adapter.setDatas((ArrayList<HomeListData.DataBean>) data);
                mHomeList.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(HttpException error, String msg) {
            Log.e("error",error.getMessage());
            }
        });
    }
}
