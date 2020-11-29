package Interface.Components;

import Configuration.Configuration;

import java.util.ArrayList;

public class Components {
    private ArrayList<Composites> compositesList;
    private InterfaceComponents interCompoFrom;
    private InterfaceComponents interCompoTo;
    private Configuration config;

    public Components() {
        compositesList= new ArrayList<>();
        interCompoFrom = new InterfaceComponents();
        interCompoTo = new InterfaceComponents();
    }

    public Components(Configuration config) {
        compositesList= new ArrayList<>();
        interCompoFrom = new InterfaceComponents();
        interCompoTo = new InterfaceComponents();
        this.config=config;
    }

    public ArrayList<Composites> getCompositesList() {
        return compositesList;
    }

    public InterfaceComponents getInterCompoFrom() {
        return interCompoFrom;
    }

    public InterfaceComponents getInterCompoTo() {
        return interCompoTo;
    }

    public Configuration getConfig() {
            return config;
    }
}
