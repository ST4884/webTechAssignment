package constrained;
import java.beans.*;

public class ConstrainedExample {
    private int age;
    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    public void setAge(int newAge) throws PropertyVetoException{
        vcs.fireVetoableChange("age", this.age, newAge);
        this.age = newAge;
        System.out.println("Age set: " + newAge);
    }

    public void addListener(VetoableChangeListener l){
        vcs.addVetoableChangeListener(l);
    }

    public static void main(String[] args){
        ConstrainedExample obj = new ConstrainedExample();

        obj.addListener(evt -> {
            if((int)evt.getNewValue() < 18){
                throw new PropertyVetoException("Age must be 18+");
            }
        });

        try{
            obj.setAge(20);
            obj.setAge(15);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
