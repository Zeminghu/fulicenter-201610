package cn.ucai.fulicenter.controller.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.FuLiCenterApplication;
import cn.ucai.fulicenter.application.I;
import cn.ucai.fulicenter.controller.adapter.CartAdapter;
import cn.ucai.fulicenter.model.bean.CartBean;
import cn.ucai.fulicenter.model.bean.GoodsDetailsBean;
import cn.ucai.fulicenter.model.bean.User;
import cn.ucai.fulicenter.model.net.IModelUser;
import cn.ucai.fulicenter.model.net.ModelUser;
import cn.ucai.fulicenter.model.net.OnCompleteListener;
import cn.ucai.fulicenter.model.utils.CommonUtils;
import cn.ucai.fulicenter.model.utils.ConvertUtils;
import cn.ucai.fulicenter.view.MFGT;
import cn.ucai.fulicenter.view.SpaceItemDecoration;

import static cn.ucai.fulicenter.R.id.rv;
import static cn.ucai.fulicenter.R.id.srl;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {


    @BindView(R.id.tv_refresh)
    TextView mTvRefresh;
    @BindView(rv)
    RecyclerView mRv;
    @BindView(srl)
    SwipeRefreshLayout mSrl;

    LinearLayoutManager gm;
    CartAdapter mAdapter;
    IModelUser model;
    @BindView(R.id.tv_nothing)
    TextView mTvNomore;
    User user;
    ArrayList<CartBean> cartList = new ArrayList<>();
    @BindView(R.id.tv_cart_sum_price)
    TextView mTvCartSumPrice;
    @BindView(R.id.tv_cart_save_price)
    TextView mTvCartSavePrice;
    UpdateCartReceiver mReceiver;
    int sumPrice = 0;
    int payPrice = 0;

    private void initData(final int action) {
        if (user != null) {
            model.getCart(getContext(), user.getMuserName(), new OnCompleteListener<CartBean[]>() {
                @Override
                public void onSuccess(CartBean[] result) {
                    mSrl.setRefreshing(false);
                    mTvRefresh.setVisibility(View.GONE);
                    mSrl.setVisibility(View.VISIBLE);
                    mTvNomore.setVisibility(View.GONE);
                    if (result != null && result.length > 0) {
                        ArrayList<CartBean> list = ConvertUtils.array2List(result);
                        cartList.addAll(list);
                        if (action == I.ACTION_DOWNLOAD || action == I.ACTION_PULL_DOWN) {
                            mAdapter.initData(list);
                        } else {
                            mAdapter.addData(list);
                        }
                    } else {
                        mSrl.setVisibility(View.GONE);
                        mTvNomore.setVisibility(View.VISIBLE);
                    }
                }


                @Override
                public void onError(String error) {
                    mSrl.setRefreshing(false);
                    mTvRefresh.setVisibility(View.GONE);
                    mSrl.setVisibility(View.GONE);
                    mTvNomore.setVisibility(View.VISIBLE);
                    CommonUtils.showShortToast(error);
                    // L.e(TAG, "error=" + error);
                }

            });
        }
    }

    private void initView() {
        mSrl.setColorSchemeColors(
                getResources().getColor(R.color.google_blue),
                getResources().getColor(R.color.google_green),
                getResources().getColor(R.color.google_yellow),
                getResources().getColor(R.color.google_red));
        gm = new LinearLayoutManager(getContext());
        //  mRv.addItemDecoration(new SpaceItemDecoration(12));
        mRv.addItemDecoration(new SpaceItemDecoration(15));
        mRv.setLayoutManager(gm);
        mRv.setHasFixedSize(true);
        mAdapter = new CartAdapter(getContext(), cartList);
        mRv.setAdapter(mAdapter);
        mSrl.setVisibility(View.GONE);
        mTvNomore.setVisibility(View.VISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_cart, container, false);
        ButterKnife.bind(this, layout);
        initView();
        model = new ModelUser();
        user = FuLiCenterApplication.getUser();
        initData(I.ACTION_DOWNLOAD);
        setPullDownListener();
        setReceiverListener();
        return layout;
    }

    private void setReceiverListener() {
        mReceiver = new UpdateCartReceiver();
        IntentFilter filter = new IntentFilter(I.BROADCAST_UPDATA_CART);
        getContext().registerReceiver(mReceiver, filter);
    }


    private void setPullDownListener() {
        mSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSrl.setRefreshing(true);
                mTvRefresh.setVisibility(View.VISIBLE);
                initData(I.ACTION_PULL_DOWN);
            }
        });
    }

    @OnClick(R.id.tv_nothing)
    public void onClick() {
        initData(I.ACTION_DOWNLOAD);
    }

    @Override
    public void onResume() {
        super.onResume();
        setPrice();
    }

    private void setPrice() {
        sumPrice = 0;
        payPrice = 0;
        int savePrice = 0;
        if (cartList != null && cartList.size() > 0) {
            for (CartBean cart : cartList) {
                GoodsDetailsBean goods = cart.getGoods();
                if (cart.isChecked() && goods != null) {
                    sumPrice += cart.getCount() * getPrice(goods.getCurrencyPrice());
                    savePrice += cart.getCount() * (getPrice(goods.getCurrencyPrice()) - getPrice(goods.getRankPrice()));
                    goods.getRankPrice();
                }
            }
        }
        mTvCartSumPrice.setText("合计: ¥" + sumPrice);
        mTvCartSavePrice.setText("节省: ¥" + savePrice);
        mAdapter.notifyDataSetChanged();
        payPrice = sumPrice - savePrice;
    }


    int getPrice(String price) {
        int p = 0;
        p = Integer.valueOf(price.substring(price.indexOf("￥") + 1));
        return p;
    }

    class UpdateCartReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            setPrice();
        }
    }

    @OnClick(R.id.tv_cart_buy)
    public void onBuyClick() {
        if (sumPrice > 0) {
            MFGT.gotoOrder(getActivity(), payPrice);
        } else {
            CommonUtils.showLongToast(R.string.order_nothing);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mReceiver != null) {
            getContext().unregisterReceiver(mReceiver);
        }
    }
}




   /* public CartFragment() {
        // Required empty public constructor
    }*/

