package storePlatform.order;

public class Order {
    private int id;
    private int userid;
    private String name;
    private String orderno;
    private String shop;
    private double price;
    private String createtime;
    private String refundreason;
    private String paystate;
    private String receiptstate;
    private String discussstate;
    private String refundstate;
    private String discuss;
    private String refundamount;
    private String address;

    public Order(){

    };

    public Order(int id, int userid, String name, String orderno, String shop, double price, String createtime, String refundreason, String paystate, String receiptstate, String discussstate, String refundstate, String discuss, String refundamount, String address) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.orderno = orderno;
        this.shop = shop;
        this.price = price;
        this.createtime = createtime;
        this.refundreason = refundreason;
        this.paystate = paystate;
        this.receiptstate = receiptstate;
        this.discussstate = discussstate;
        this.refundstate = refundstate;
        this.discuss = discuss;
        this.refundamount = refundamount;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRefundreason() {
        return refundreason;
    }

    public void setRefundreason(String refundreason) {
        this.refundreason = refundreason;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public String getReceiptstate() {
        return receiptstate;
    }

    public void setReceiptstate(String receiptstate) {
        this.receiptstate = receiptstate;
    }

    public String getDiscussstate() {
        return discussstate;
    }

    public void setDiscussstate(String discussstate) {
        this.discussstate = discussstate;
    }

    public String getRefundstate() {
        return refundstate;
    }

    public void setRefundstate(String refundstate) {
        this.refundstate = refundstate;
    }

    public String getDiscuss() {
        return discuss;
    }

    public void setDiscuss(String discuss) {
        this.discuss = discuss;
    }

    public String getRefundamount() {
        return refundamount;
    }

    public void setRefundamount(String refundamount) {
        this.refundamount = refundamount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", orderno='" + orderno + '\'' +
                ", shop='" + shop + '\'' +
                ", price=" + price +
                ", createtime='" + createtime + '\'' +
                ", refundreason='" + refundreason + '\'' +
                ", paystate='" + paystate + '\'' +
                ", receiptstate='" + receiptstate + '\'' +
                ", discussstate='" + discussstate + '\'' +
                ", refundstate='" + refundstate + '\'' +
                ", discuss='" + discuss + '\'' +
                ", refundamount='" + refundamount + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
