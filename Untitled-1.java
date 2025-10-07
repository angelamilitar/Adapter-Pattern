#!/bin/bash

# Remote Control Adapter Pattern - Quick Setup Script
# This script creates all necessary Java files for the project

echo "=========================================="
echo "Remote Control Adapter Pattern Setup"
echo "=========================================="
echo ""

# Create directory if it doesn't exist
DIRECTORY="remoteControlAdapter"

if [ -d "$DIRECTORY" ]; then
    echo "⚠️  Directory '$DIRECTORY' already exists!"
    read -p "Do you want to overwrite? (y/n): " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo "Setup cancelled."
        exit 1
    fi
    rm -rf "$DIRECTORY"
fi

mkdir -p "$DIRECTORY"
cd "$DIRECTORY"

echo "📁 Created directory: $DIRECTORY"
echo ""

# Create RemoteControllerFunction.java
echo "Creating RemoteControllerFunction.java..."
cat > RemoteControllerFunction.java << 'EOF'
public interface RemoteControllerFunction {
    void powerOn();
    void powerOff();
    void pressPlusButton();
    void pressMinusButton();
}
EOF

# Create TV.java
echo "Creating TV.java..."
cat > TV.java << 'EOF'
public class TV {
    public void switchOn() {
        System.out.println("TV is switched ON");
    }
    
    public void switchOff() {
        System.out.println("TV is switched OFF");
    }
    
    public void channelUp() {
        System.out.println("TV channel UP");
    }
    
    public void channelDown() {
        System.out.println("TV channel DOWN");
    }
}
EOF

# Create AirCon.java
echo "Creating AirCon.java..."
cat > AirCon.java << 'EOF'
public class AirCon {
    public void turnOn() {
        System.out.println("Air Conditioner is turned ON");
    }
    
    public void turnOff() {
        System.out.println("Air Conditioner is turned OFF");
    }
    
    public void tempUp() {
        System.out.println("Air Conditioner temperature increased");
    }
    
    public void tempDown() {
        System.out.println("Air Conditioner temperature decreased");
    }
}
EOF

# Create Speaker.java
echo "Creating Speaker.java..."
cat > Speaker.java << 'EOF'
public class Speaker {
    public void speakerOn() {
        System.out.println("Speaker is turned ON");
    }
    
    public void speakerOff() {
        System.out.println("Speaker is turned OFF");
    }
    
    public void volumeUp() {
        System.out.println("Speaker volume increased");
    }
    
    public void volumeDown() {
        System.out.println("Speaker volume decreased");
    }
}
EOF

# Create TvAdapter.java
echo "Creating TvAdapter.java..."
cat > TvAdapter.java << 'EOF'
public class TvAdapter implements RemoteControllerFunction {
    private TV tv;
    
    public TvAdapter(TV tv) {
        this.tv = tv;
    }
    
    @Override
    public void powerOn() {
        tv.switchOn();
    }
    
    @Override
    public void powerOff() {
        tv.switchOff();
    }
    
    @Override
    public void pressPlusButton() {
        tv.channelUp();
    }
    
    @Override
    public void pressMinusButton() {
        tv.channelDown();
    }
}
EOF

# Create AirconAdapter.java
echo "Creating AirconAdapter.java..."
cat > AirconAdapter.java << 'EOF'
public class AirconAdapter implements RemoteControllerFunction {
    private AirCon airCon;
    
    public AirconAdapter(AirCon airCon) {
        this.airCon = airCon;
    }
    
    @Override
    public void powerOn() {
        airCon.turnOn();
    }
    
    @Override
    public void powerOff() {
        airCon.turnOff();
    }
    
    @Override
    public void pressPlusButton() {
        airCon.tempUp();
    }
    
    @Override
    public void pressMinusButton() {
        airCon.tempDown();
    }
}
EOF

# Create SpeakerAdapter.java
echo "Creating SpeakerAdapter.java..."
cat > SpeakerAdapter.java << 'EOF'
public class SpeakerAdapter implements RemoteControllerFunction {
    private Speaker speaker;
    
    public SpeakerAdapter(Speaker speaker) {
        this.speaker = speaker;
    }
    
    @Override
    public void powerOn() {
        speaker.speakerOn();
    }
    
    @Override
    public void powerOff() {
        speaker.speakerOff();
    }
    
    @Override
    public void pressPlusButton() {
        speaker.volumeUp();
    }
    
    @Override
    public void pressMinusButton() {
        speaker.volumeDown();
    }
}
EOF

# Create ApplianceApp.java
echo "Creating ApplianceApp.java..."
cat > ApplianceApp.java << 'EOF'
import java.util.ArrayList;
import java.util.List;

public class ApplianceApp {
    private List<RemoteControllerFunction> appliances;
    
    public ApplianceApp() {
        this.appliances = new ArrayList<>();
    }
    
    public void addAppliance(RemoteControllerFunction appliance) {
        appliances.add(appliance);
        System.out.println("Appliance added to the remote control system.");
    }
    
    public void controlAppliance(int index, String command) {
        if (index < 0 || index >= appliances.size()) {
            System.out.println("Invalid appliance index!");
            return;
        }
        
        RemoteControllerFunction appliance = appliances.get(index);
        
        switch (command.toLowerCase()) {
            case "on":
                appliance.powerOn();
                break;
            case "off":
                appliance.powerOff();
                break;
            case "plus":
                appliance.pressPlusButton();
                break;
            case "minus":
                appliance.pressMinusButton();
                break;
            default:
                System.out.println("Unknown command!");
        }
    }
    
    public void controlAllAppliances(String command) {
        System.out.println("\n=== Controlling all appliances: " + command.toUpperCase() + " ===");
        for (int i = 0; i < appliances.size(); i++) {
            controlAppliance(i, command);
        }
    }
    
    public int getApplianceCount() {
        return appliances.size();
    }
}
EOF

# Create Main.java
echo "Creating Main.java..."
cat > Main.java << 'EOF'
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Remote Control Adapter Pattern Demo ===\n");
        
        TV tv = new TV();
        AirCon airCon = new AirCon();
        Speaker speaker = new Speaker();
        
        TvAdapter tvAdapter = new TvAdapter(tv);
        AirconAdapter airconAdapter = new AirconAdapter(airCon);
        SpeakerAdapter speakerAdapter = new SpeakerAdapter(speaker);
        
        ApplianceApp app = new ApplianceApp();
        
        System.out.println("Setting up home appliances:\n");
        app.addAppliance(tvAdapter);
        app.addAppliance(airconAdapter);
        app.addAppliance(speakerAdapter);
        
        app.controlAllAppliances("on");
        
        System.out.println("\n=== Individual Appliance Controls ===");
        
        System.out.println("\nControlling TV:");
        app.controlAppliance(0, "plus");
        app.controlAppliance(0, "minus");
        
        System.out.println("\nControlling Air Conditioner:");
        app.controlAppliance(1, "plus");
        app.controlAppliance(1, "minus");
        
        System.out.println("\nControlling Speaker:");
        app.controlAppliance(2, "plus");
        app.controlAppliance(2, "minus");
        
        app.controlAllAppliances("off");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("All appliances successfully controlled via remote!");
        System.out.println("Total appliances managed: " + app.getApplianceCount());
    }
}
EOF

echo ""
echo "✅ All files created successfully!"
echo ""
echo "📋 Files created:"
ls -1

echo ""
echo "=========================================="
echo "🚀 To run the project:"
echo "=========================================="
echo "1. Compile:  javac *.java"
echo "2. Run:      java Main"
echo "=========================================="
echo ""

# Optional: Auto-compile and run
read -p "Do you want to compile and run now? (y/n): " -n 1 -r
echo
if [[ $REPLY =~ ^[Yy]$ ]]; then
    echo ""
    echo "Compiling..."
    javac *.java
    
    if [ $? -eq 0 ]; then
        echo "✅ Compilation successful!"
        echo ""
        echo "Running Main.java..."
        echo ""
        java Main
    else
        echo "❌ Compilation failed!"
    fi
fi

echo ""
echo "Setup complete! 🎉"