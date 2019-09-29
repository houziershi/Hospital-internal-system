package com.baoan.hospital.system.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baoan.hospital.system.R;
import com.baoan.hospital.system.UI.adapter.ContactsAdapter;
import com.baoan.hospital.system.UI.data.XH;
import com.baoan.hospital.system.UI.presenter.HomeContract;
import com.baoan.hospital.system.UI.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Discription:
 * Created by guokun on 2019/9/29.
 */
public class PageFragment extends Fragment implements HomeContract.View {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private ContactsAdapter adapter;
    private HomeContract.Presenter presenter;
    private List<XH> data = new ArrayList<>();

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        new HomePresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_page);
        recyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 4));
        adapter = new ContactsAdapter(data);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void showData(List<XH> xhs) {
        data.clear();
        data.addAll(xhs);
        adapter.notifyDataSetChanged();
    }
}
