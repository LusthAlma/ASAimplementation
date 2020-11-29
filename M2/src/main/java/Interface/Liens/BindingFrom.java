package Interface.Liens;

import Configuration.FromPortConfig;
import Interface.Components.FromPort;

public class BindingFrom implements Binding {
    private FromPort fromPortComponents;
    private FromPortConfig fromPortConfiguration;

    public BindingFrom(FromPort fromPortComponents, FromPortConfig fromPortConfiguration) {
        this.fromPortComponents = fromPortComponents;
        this.fromPortConfiguration = fromPortConfiguration;
    }

    public FromPort getFromPortComponents() {
        return fromPortComponents;
    }

    public FromPortConfig getFromPortConfiguration() {
        return fromPortConfiguration;
    }

    public void setFromPortConfiguration(FromPortConfig fromPortConfiguration) {
        this.fromPortConfiguration = fromPortConfiguration;
    }

    public void setFromPortComponents(FromPort fromPortComponents) {
        this.fromPortComponents = fromPortComponents;
    }
}
