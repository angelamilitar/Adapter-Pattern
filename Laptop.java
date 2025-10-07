public class Laptop {
    private String brand;
    
    public Laptop(String brand) {
        this.brand = brand;
    }
    
    public void charge() {
        System.out.println(brand + " laptop is now charging...");
    }
    
    public String getBrand() {
        return brand;
    }
}
