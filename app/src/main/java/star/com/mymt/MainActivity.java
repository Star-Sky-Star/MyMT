package star.com.mymt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    protected RadioButton mHome;
    protected RadioButton mNearby;
    protected RadioButton mOwn;
    protected RadioGroup mTabGroup;
    protected FrameLayout mContent;
    private HomeFragment mHomeFragment;
    private Fragment mFragment;
    private NearByFragment mNearByFragment;
    private UserFragment mUserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(R.id.content,mHomeFragment).commit();
        mFragment= mHomeFragment;
        mHome.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.home:
                mHome.setChecked(true);
                mNearby.setChecked(false);
                mOwn.setChecked(false);
                switchFragment(mHomeFragment);
                break;
            case R.id.nearby:
                mHome.setChecked(false);
                mNearby.setChecked(true);
                mOwn.setChecked(false);
                switchFragment(mNearByFragment);
                break;
            case R.id.own:
                mHome.setChecked(false);
                mNearby.setChecked(false);
                mOwn.setChecked(true);
                switchFragment(mUserFragment);
                break;
        }
    }


    private void initView() {
        mHome = (RadioButton) findViewById(R.id.home);
        mNearby = (RadioButton) findViewById(R.id.nearby);
        mOwn = (RadioButton) findViewById(R.id.own);
        mTabGroup = (RadioGroup) findViewById(R.id.tab_group);
        mContent = (FrameLayout) findViewById(R.id.content);

        //加载三个fragment
        mHomeFragment = HomeFragment.newInstance();
        mNearByFragment = NearByFragment.newInstance();
        mUserFragment = UserFragment.newInstance();
        //为 RadioGroup设置监听事件
        mTabGroup.setOnCheckedChangeListener(this);
    }


    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if(mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment)
                        .add(R.id.content,fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

}
