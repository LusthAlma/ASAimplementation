package Interface.Liens;

import Configuration.ToPortConfig;
import Interface.Components.ToPort;

public class BindingTo implements Binding {
    private ToPort toPortComponents;
    private ToPortConfig toPortConfiguration;

    public BindingTo(ToPort toPortComponents, ToPortConfig toPortConfiguration) {
        this.toPortComponents = toPortComponents;
        this.toPortConfiguration = toPortConfiguration;
    }

    public ToPort getToPortComponents() {
        return toPortComponents;
    }

    public ToPortConfig getToPortConfiguration() {
        return toPortConfiguration;
    }

    public void setToPortConfiguration(ToPortConfig toPortConfiguration) {
        this.toPortConfiguration = toPortConfiguration;
    }

    public void setToPortComponents(ToPort toPortComponents) {
        this.toPortComponents = toPortComponents;
    }
}
