package info.dabu.learnslidemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {
//    声明一个SlidingMenu实例
    private SlidingMenu mSlidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlidingMenu = new SlidingMenu(this);
//        设置SlidingMenu从左侧滑出
        mSlidingMenu.setMode(SlidingMenu.LEFT);
//        设置SlidingMenu的宽度,注意值是相对于最后侧与屏幕最右侧的距离
//        值越小，SlidingMenu滑出来越多
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmeu_margin);
//        设置全屏都可以滑出SlidingMenu
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        附加到当前Activity
        mSlidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
//        设置SlidingMenu布局资源
        mSlidingMenu.setMenu(R.layout.layout_slidingmenu);

    }


//设置按下物理菜单按钮时候，也滑出SlidingMenu
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_MENU:
                mSlidingMenu.toggle(true);
                break;
            default:
                break;

        }
        return super.onKeyDown(keyCode, event);
    }
//因为现在很多物理菜单按键要长按才会出菜单
    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_MENU:
                mSlidingMenu.toggle(true);
                break;
            default:
                break;

        }
        return super.onKeyLongPress(keyCode, event);
    }
}
