public class SmartphoneCharger {
    private String phoneType;
    
    public SmartphoneCharger(String phoneType) {
        this.phoneType = phoneType;
    }
    
    public void chargePhone() {
        System.out.println(phoneType + " smartphone is now charging...");
    }
    
    public String getPhoneType() {
        return phoneType;
    }
}
