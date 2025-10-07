public class Refrigerator {
    private String model;
    
    public Refrigerator(String model) {
        this.model = model;
    }
    
    public void startCooling() {
        System.out.println(model + " refrigerator is now cooling...");
    }
    
    public String getModel() {
        return model;
    }
}
