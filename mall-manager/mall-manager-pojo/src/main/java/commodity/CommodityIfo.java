package commodity;

public class CommodityIfo {
    private int commodityId;
    private String commodityName;
    private double commodityPrice;
    private int commodityStock;
    private int commodityCapacity;
    private String imageUrl;
    private int commodityYears;
    private double commodityDegree;
    private String commodityDistributor;
    private int commoditySort;

    public int getCommoditySort() {
        return commoditySort;
    }

    public void setCommoditySort(int commoditySort) {
        this.commoditySort = commoditySort;
    }

    public CommodityIfo(){
        super();
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public int getCommodityStock() {
        return commodityStock;
    }

    public void setCommodityStock(int commodityStock) {
        this.commodityStock = commodityStock;
    }

    public int getCommodityCapacity() {
        return commodityCapacity;
    }

    public void setCommodityCapacity(int commodityCapacity) {
        this.commodityCapacity = commodityCapacity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCommodityYears() {
        return commodityYears;
    }

    public void setCommodityYears(int commodityYears) {
        this.commodityYears = commodityYears;
    }

    public double getCommodityDegree() {
        return commodityDegree;
    }

    public void setCommodityDegree(double commodityDegree) {
        this.commodityDegree = commodityDegree;
    }

    public String getCommodityDistributor() {
        return commodityDistributor;
    }

    public void setCommodityDistributor(String commodityDistributor) {
        this.commodityDistributor = commodityDistributor;
    }

    @Override
    public String toString() {
        return "CommodityIfo{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", commodityStock=" + commodityStock +
                ", commodityCapacity=" + commodityCapacity +
                ", imageUrl='" + imageUrl + '\'' +
                ", commodityYears=" + commodityYears +
                ", commodityDegree=" + commodityDegree +
                ", commodityDistributor='" + commodityDistributor + '\'' +
                ", commoditySort=" + commoditySort +
                '}';
    }
}
