import java.util.ArrayList;
import java.util.List;

public class PowerManagementSystem {
    private List<PowerOutlet> devices;
    
    public PowerManagementSystem() {
        this.devices = new ArrayList<>();
    }
    
    public void addDevice(PowerOutlet device) {
        devices.add(device);
        System.out.println("Device added to power management system.");
    }
    
    public void powerOnAllDevices() {
        System.out.println("\n=== Powering on all devices ===");
        for (PowerOutlet device : devices) {
            device.plugIn();
        }
    }
    
    public int getDeviceCount() {
        return devices.size();
    }
}
