package miniproject.entity;

public class Entity {  
    private double weight;
    private double high;
    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 0) {
            this.weight = weight;
        }
    }
    
    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        if (high >= 0 ) {
            this.high = high;
        } else if (high < 0) {
            this.high = 0.0f;
        }
    }

}
