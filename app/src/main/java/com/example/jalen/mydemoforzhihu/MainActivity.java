package com.example.jalen.mydemoforzhihu;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.jalen.adapter.MainViewPagerAdapter;
import com.example.jalen.adapter.SuperAwesomeCardFragment;
import com.example.jalen.common.ConstansZhihu;
import com.example.jalen.fragment.main.MainHotCollectionFrag;
import com.example.jalen.fragment.main.MainHotDayNoticeFrag;
import com.example.jalen.fragment.main.MainHotNoticeFrag;
import com.example.jalen.fragment.main.MainHotRecommendFrag;
import com.example.jalen.util.LogUtils;
import com.example.jalen.util.SteepColorUtils;


public class MainActivity extends BaseActivity {

    private Fragment frags[];
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;

    /***
     * 点击事件  onClick for weight
     * @param v
     */
    @Override
    public void weightClick(View v) {

    }


    /***
     * only initialization views and toolbar
     */
    @Override
     void initViews() {
        setContentView(R.layout.activity_main);
        //改变沉浸栏的颜色
        SteepColorUtils.setStatusBarContext(this);
        initFrag();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mToolbar.setTitle("首页");
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(mToolbar);
        //setting left-top is showing?
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
//        Uri uri = Uri.parse("https://raw.githubusercontent.com/liaohuqiu/fresco-docs-cn/docs/static/fresco-logo.png");
//        img = (SimpleDraweeView) findViewById(R.id.img);
//        img.setImageURI(uri);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        mViewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(),frags));
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        initPageTab();
    }


    /***
     * 初始化Fragment
     */
    private void initFrag() {
        frags = new Fragment[4];
        frags[0]= new MainHotRecommendFrag();
        frags[1]= new MainHotCollectionFrag();
        frags[2]= new MainHotNoticeFrag();
        frags[3]= new MainHotDayNoticeFrag();

    }


    /***
     * opreate tabstrip
     */
    private void initPageTab() {
        mPagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
            colorChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 底部游标颜色
          mPagerSlidingTabStrip.setIndicatorColor(Color.BLUE);
           // tab的分割线颜色
           mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
          // tab背景
           mPagerSlidingTabStrip.setBackgroundColor(Color.parseColor("#4876FF"));
          // tab底线高度
          mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                  1, getResources().getDisplayMetrics()));
          // 游标高度
         mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                 5, getResources().getDisplayMetrics()));
          // 选中的文字颜色
         mPagerSlidingTabStrip.setSelectedTextColor(Color.WHITE);
          // 正常文字颜色
          mPagerSlidingTabStrip.setTextColor(Color.BLACK);

    }

    @Override
    void initDates() {
        ConstansZhihu.getDate(this, "http://91baisong.com/banben.php", Request.Method.GET, null, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LogUtils.d(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.d(error.toString());
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     */
    @SuppressLint("NewApi")
    private void colorChange(int position) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                SuperAwesomeCardFragment.getBackgroundBitmapPosition(position));
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            /**
             */
            @Override
            public void onGenerated(android.support.v7.graphics.Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                mPagerSlidingTabStrip.setBackgroundColor(vibrant.getRgb());
                mPagerSlidingTabStrip.setTextColor(vibrant.getTitleTextColor());
                mPagerSlidingTabStrip.setIndicatorColor(colorBurn(vibrant.getRgb()));
//            SteepColorUtils.compat(MainActivity.this,colorBurn(vibrant.getRgb()));
                mToolbar.setBackgroundColor(vibrant.getRgb());
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    Window window = getWindow();
                    window.setStatusBarColor(colorBurn(vibrant.getRgb()));
                    window.setNavigationBarColor(colorBurn(vibrant.getRgb()));
                }
            }
        });
    }

    private int colorBurn(int RGBValues) {
        int alpha = RGBValues >> 24;
        int red = RGBValues >> 16 & 0xFF;
        int green = RGBValues >> 8 & 0xFF;
        int blue = RGBValues & 0xFF;
        red = (int) Math.floor(red * (1 - 0.1));
        green = (int) Math.floor(green * (1 - 0.1));
        blue = (int) Math.floor(blue * (1 - 0.1));
        return Color.rgb(red, green, blue);
    }
}
