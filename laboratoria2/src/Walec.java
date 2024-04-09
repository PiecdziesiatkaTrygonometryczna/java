public class Walec {
    private Double baseRadius;
    private Double height;
    public void setBaseRadius(Double baseRadius) {
        this.baseRadius = baseRadius;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getBaseRadius() {
        return baseRadius;
    }
    public Double getHeight() {
        return height;
    }
    public Walec(Double baseRadius, Double height) {
        this.baseRadius = baseRadius;
        this.height = height;
    }
    public Walec() {
    }
    public double calculateBaseArea() {
        return Math.PI * Math.pow(this.baseRadius, 2);
    }
    public double calculateSideArea() {
        return 2 * Math.PI * this.baseRadius * this.height;
    }
    public double calculateTotalArea() {
        return 2 * calculateBaseArea() + calculateSideArea();
    }
    public double calculateVolume() {
        return calculateBaseArea() * this.height;
    }
}

