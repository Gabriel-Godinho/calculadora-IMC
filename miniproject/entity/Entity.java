package miniproject.entity;

public class Entity {  
    private float weight;
    private float high;
    
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        if(weight >= 0)
            this.weight = weight;
    }
    
    public float getHigh() {
        return high;
    }
    public void setHigh(float high) {
        if (high > 0 ) {
            this.high = high;
        } else if (high < 0) {
            this.high = 0.0f;
        }
    }
}
