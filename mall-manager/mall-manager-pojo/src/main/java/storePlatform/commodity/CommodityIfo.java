package storePlatform.commodity;
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
    private int sjsort;

    public CommodityIfo() {

    }

    public CommodityIfo(int commodityId, String commodityName, double commodityPrice, int commodityStock, int commodityCapacity, String imageUrl, int commodityYears, double commodityDegree, String commodityDistributor, int commoditySort, int sjsort) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.commodityStock = commodityStock;
        this.commodityCapacity = commodityCapacity;
        this.imageUrl = imageUrl;
        this.commodityYears = commodityYears;
        this.commodityDegree = commodityDegree;
        this.commodityDistributor = commodityDistributor;
        this.commoditySort = commoditySort;
        this.sjsort = sjsort;
    }

    public int getCommoditySort() {
        return commoditySort;
    }

    public void setCommoditySort(int commoditySort) {
        this.commoditySort = commoditySort;
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

    public int getSjsort() {
        return sjsort;
    }

    public void setSjsort(int sjsort) {
        this.sjsort = sjsort;
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
                ", sjsort=" + sjsort +
                '}';
    }


}
