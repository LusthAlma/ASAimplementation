package Interface.Components;

import java.util.ArrayList;

public class Components {
    private ArrayList<Composites> compositesList;
    private InterfaceComponents interCompoFrom;
    private InterfaceComponents interCompoTo;

    public Components() {
        compositesList= new ArrayList<>();
        interCompoFrom = new InterfaceComponents();
        interCompoTo = new InterfaceComponents();
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
}
