package bound;
import java.beans.*;

public class BoundExample {
    private String name;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setName(String newName){
        String oldName = this.name;
        this.name = newName;
        pcs.firePropertyChange("name", oldName, newName);
    }

    public void addListener(PropertyChangeListener l){
        pcs.addPropertyChangeListener(l);
    }

    public static void main(String[] args){
        BoundExample obj = new BoundExample();

        obj.addListener(evt ->
            System.out.println("Changed: " + evt.getOldValue() + " -> " + evt.getNewValue())
        );

        obj.setName("ST");
        obj.setName("BB");
    }
}
