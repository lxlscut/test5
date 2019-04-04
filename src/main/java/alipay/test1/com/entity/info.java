package alipay.test1.com.entity;

/**
 * 存放交易信息的类
 */
public class info {
    private int id;
    private  String out_trade_no;
    private  String trade_no;
    private  String trade_status;
    private String gmt_payment;


    public info() {
    }

    public info(String out_trade_no, String trade_no, String trade_status, String gmt_payment) {
        this.out_trade_no = out_trade_no;
        this.trade_no = trade_no;
        this.trade_status = trade_status;
        this.gmt_payment = gmt_payment;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(String gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "info{" +
                "id=" + id +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", gmt_payment='" + gmt_payment + '\'' +
                '}';
    }
}

