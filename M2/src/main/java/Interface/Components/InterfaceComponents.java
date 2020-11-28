package Interface.Components;

import Interface.Ports.Ports;

import java.util.ArrayList;

public class InterfaceComponents {
    private ArrayList<Ports> portsList;

    public InterfaceComponents() {
        portsList=new ArrayList<>();
    }

    public ArrayList<Ports> getPortsList() {
        return portsList;
    }
}
