package beaninfo;
import java.beans.*;
import beans.Person;

public class PersonBeanInfo extends SimpleBeanInfo {
    public PropertyDescriptor[] getPropertyDescriptors(){
        try{
            PropertyDescriptor name = new PropertyDescriptor("name", Person.class);
            PropertyDescriptor age = new PropertyDescriptor("age", Person.class);
            return new PropertyDescriptor[]{name, age};
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
