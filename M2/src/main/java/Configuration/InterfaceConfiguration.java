package Configuration;

import Interface.Interface;
import Interface.Ports.Ports;

import java.util.ArrayList;

public class InterfaceConfiguration implements Interface {
    private ArrayList<Ports> portsConfig;

    public InterfaceConfiguration() {
        portsConfig= new ArrayList<>();
    }

    public ArrayList<Ports> getPortsConfig() {
        return portsConfig;
    }
}
