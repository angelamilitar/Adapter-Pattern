public class Main {
    public static void main(String[] args) {
        System.out.println("=== Power Outlet Adapter Pattern Demo ===\n");
        
        Laptop laptop = new Laptop("Dell XPS 15");
        Refrigerator fridge = new Refrigerator("Samsung CoolMax 3000");
        SmartphoneCharger phoneCharger = new SmartphoneCharger("iPhone 15");
        
        LaptopAdapter laptopAdapter = new LaptopAdapter(laptop);
        RefrigeratorAdapter fridgeAdapter = new RefrigeratorAdapter(fridge);
        SmartphoneAdapter phoneAdapter = new SmartphoneAdapter(phoneCharger);
        
        PowerManagementSystem powerSystem = new PowerManagementSystem();
        
        System.out.println("Adding devices to power management system:\n");
        powerSystem.addDevice(laptopAdapter);
        powerSystem.addDevice(fridgeAdapter);
        powerSystem.addDevice(phoneAdapter);
        
        powerSystem.powerOnAllDevices();
        
        System.out.println("\n=== Individual Device Operations ===\n");
        System.out.print("Laptop: ");
        laptopAdapter.plugIn();
        
        System.out.print("Refrigerator: ");
        fridgeAdapter.plugIn();
        
        System.out.print("Smartphone: ");
        phoneAdapter.plugIn();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("All devices successfully managed through adapters!");
        System.out.println("Total devices managed: " + powerSystem.getDeviceCount());
    }
}
