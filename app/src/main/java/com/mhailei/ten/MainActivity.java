package com.mhailei.ten;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mhailei.ten.fragment.CriticFragment;
import com.mhailei.ten.fragment.DiagramFragment;
import com.mhailei.ten.fragment.NovelFragment;
import com.mhailei.ten.fragment.PersonalFragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements  RadioGroup.OnCheckedChangeListener {


    private RadioGroup mRadioGroup;
    private ArrayList<android.support.v4.app.Fragment> frags = new ArrayList<>();
    private FragmentManager manager;
    private android.support.v4.app.Fragment lastFragment;
    /**
     * 是否退出
     */
    private boolean isExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragments();

        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.fragment_container,frags.get(0));
        ft.commit();
        lastFragment = frags.get(0);
    }

    private void initFragments() {
        frags.add(new CriticFragment());
        frags.add(new NovelFragment());
        frags.add(new DiagramFragment());
        frags.add(new PersonalFragment());
    }

    private void initView() {
        mRadioGroup = ((RadioGroup) findViewById(R.id.rg_bottom));

        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        RadioButton rb = ((RadioButton) findViewById(checkedId));

        int tag = Integer.parseInt(rb.getTag().toString());

        if(!frags.get(tag).isAdded()){
            manager.beginTransaction().add(R.id.fragment_container,frags.get(tag)).commit();

        }else{
            manager.beginTransaction().show(frags.get(tag)).commit();
        }
        manager.beginTransaction().hide(lastFragment).commit();

        lastFragment = frags.get(tag);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                isExit = true;

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 3 * 1000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
