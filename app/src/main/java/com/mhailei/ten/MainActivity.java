package com.mhailei.ten;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mhailei.ten.fragment.DiagramFragment;
import com.mhailei.ten.fragment.HomeFragment;
import com.mhailei.ten.fragment.NovelFragment;
import com.mhailei.ten.fragment.PersonalFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements  RadioGroup.OnCheckedChangeListener {


    private RadioGroup mRadioGroup;
    private ArrayList<Fragment> frags = new ArrayList<>();
    private FragmentManager manager;
    private Fragment lastFragment;

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
        frags.add(new HomeFragment());
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
}
