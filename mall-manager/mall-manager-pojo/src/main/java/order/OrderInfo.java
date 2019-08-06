package order;

public class OrderInfo {
    private int orderId;
    private String orderName;
    private String orderNo;
    private String distributor;
    private double orderPrice;
    private String orderCreatTime;
    private String refundReason;
    private String orderPayState;
    private String receipt_state;
    private String discuss_state;
    private String refund_state;
    private String discuss;
    private String orderAddress;
    private int userID;

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderCreatTime() {
        return orderCreatTime;
    }

    public void setOrderCreatTime(String orderCreatTime) {
        this.orderCreatTime = orderCreatTime;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getOrderPayState() {
        return orderPayState;
    }

    public void setOrderPayState(String orderPayState) {
        this.orderPayState = orderPayState;
    }

    public String getReceipt_state() {
        return receipt_state;
    }

    public void setReceipt_state(String receipt_state) {
        this.receipt_state = receipt_state;
    }

    public String getDiscuss_state() {
        return discuss_state;
    }

    public void setDiscuss_state(String discuss_state) {
        this.discuss_state = discuss_state;
    }

    public String getRefund_state() {
        return refund_state;
    }

    public void setRefund_state(String refund_state) {
        this.refund_state = refund_state;
    }

    public String getDiscuss() {
        return discuss;
    }

    public void setDiscuss(String discuss) {
        this.discuss = discuss;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", distributor='" + distributor + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderCreatTime='" + orderCreatTime + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", orderPayState='" + orderPayState + '\'' +
                ", receipt_state='" + receipt_state + '\'' +
                ", discuss_state='" + discuss_state + '\'' +
                ", refund_state='" + refund_state + '\'' +
                ", discuss='" + discuss + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", userID=" + userID +
                '}';
    }
}
