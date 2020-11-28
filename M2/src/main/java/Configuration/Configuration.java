package Configuration;
import Interface.Components.Components;
import Interface.Connectors.Connectors;

import java.util.ArrayList;

public class Configuration {
    private ArrayList<Components> componentsList;
    private ArrayList<Connectors> connectorsList;
    private InterfaceConfiguration interConfig;

    public Configuration() {
        componentsList = new ArrayList<>();
        connectorsList = new ArrayList<>();
        interConfig= new InterfaceConfiguration();
    }

    public ArrayList<Components> getComponentsList() {
        return componentsList;
    }

    public ArrayList<Connectors> getConnectorsList() {
        return connectorsList;
    }

    public InterfaceConfiguration getInterConfig() {
        return interConfig;
    }
}
