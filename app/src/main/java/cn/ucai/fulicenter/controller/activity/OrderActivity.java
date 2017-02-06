package cn.ucai.fulicenter.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.I;
import cn.ucai.fulicenter.view.DisplayUtils;

public class OrderActivity extends AppCompatActivity implements
          PaymentHandler{
    private static String URL = "http://218.244.151.190/demo/charge";

    int payPrice = 0;
    @BindView(R.id.ed_order_name)
    EditText mEdOrderName;
    @BindView(R.id.ed_order_phone)
    EditText mEdOrderPhone;
    @BindView(R.id.spin_order_province)
    Spinner mSpinOrderProvince;
    @BindView(R.id.ed_order_street)
    EditText mEdOrderStreet;
    @BindView(R.id.tv_order_price)
    TextView mTvOrderPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        payPrice = getIntent().getIntExtra(I.Cart.PAY_PRICE, 0);
        DisplayUtils.initBackWithTitle(this,"填写收货地址");
    //    setView();
    }

    /*private void initPingPP() {
        //设置需要使用的支付方式
        PingppOne.enableChannels(new String[]{"wx", "alipay", "upacp", "bfb", "jdpay_wap"});

        // 提交数据的格式，默认格式为json
        // PingppOne.CONTENT_TYPE = "application/x-www-form-urlencoded";
        PingppOne.CONTENT_TYPE = "application/json";

        PingppLog.DEBUG = true;
    }

    private void setView() {
        mTvOrderPrice.setText("合计: ¥ "+payPrice);
    }

    //壹收款: 创建支付通道
    PingppOne.showPaymentChannels(getSupportFragmentManager(), bill.toString(), null, URL, new PaymentHandler() {

        // 返回支付结果
        // @param data

        @Override
        public void handlePaymentResult(Intent data) {
        }
    });*/
}
