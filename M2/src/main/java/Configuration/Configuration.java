package Configuration;
import Interface.Components.Components;
import Interface.Connectors.Connectors;
import Interface.Liens.Liens;

import java.util.ArrayList;

public class Configuration {
    private ArrayList<Components> componentsList;
    private ArrayList<Connectors> connectorsList;
    private InterfaceConfiguration interConfig;
    private ArrayList<Liens> linkLists;

    public Configuration() {
        componentsList = new ArrayList<>();
        connectorsList = new ArrayList<>();
        interConfig= new InterfaceConfiguration();
        linkLists = new ArrayList<>();
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

    public ArrayList<Liens> getLinkLists() {
        return linkLists;
    }
}
