package com.angelmsger.wings;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

public class MainActivity extends AppCompatActivity
        implements DrawerMenuFragment.OnListFragmentInteractionListener,
        CircleRefreshLayout.OnCircleRefreshListener {
    LeftDrawerLayout mLeftDrawerLayout;
    FlowingView mFlowingView;
    CircleRefreshLayout mRefreshLayout;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftDrawerLayout = (LeftDrawerLayout) findViewById(R.id.id_drawerlayout);
        FragmentManager fm = getSupportFragmentManager();
        DrawerMenuFragment mDrawerMenuFragment =
                (DrawerMenuFragment) fm.findFragmentById(R.id.id_container_menu);
        mFlowingView = (FlowingView) findViewById(R.id.sv);
        if (mDrawerMenuFragment == null) {
            fm.beginTransaction().add(R.id.id_container_menu,
                    mDrawerMenuFragment = new DrawerMenuFragment()).commit();
        }
        mLeftDrawerLayout.setFluidView(mFlowingView);
        mLeftDrawerLayout.setMenuFragment(mDrawerMenuFragment);

        mRefreshLayout = (CircleRefreshLayout)findViewById(R.id.refresh_layout);
        mRefreshLayout.setOnRefreshListener(this);

        mListView = (ListView)findViewById(R.id.list);
        mListView.setAdapter(new MissionItemBaseAdapter(MissionItemContent.ITEMS,
                LayoutInflater.from(this)));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, 0);
        }
    }

    @Override
    public void onListFragmentInteraction(DrawerMenuContent.DrawerMenuItem item) {

    }

    @Override
    public void completeRefresh() {

    }

    @Override
    public void refreshing() {

    }
}
