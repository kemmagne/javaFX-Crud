/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_7;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author user
 */
public class Person {
     /**
    private String name;
    
    private String surname;

    private String age;

    

    public String getName() {
        return name;
    }

    

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(String age) {
        this.age = age;
    
     
     
    
    private final StringProperty name = new SimpleStringProperty(this, "name"); // NOI18N.
            
    public final String getName() {
        return name.get();
    }
            
    public final void setName(final String value) {
        name.set(value);
    }
            
    public final StringProperty nameProperty() {
        return name;
    }
        
    }
 */  
    
        private StringProperty name = new SimpleStringProperty(this, "name");
         public final String getName(){
             return name.get();
         }
          public final void setName(final String value){
                   name.set(value);
          }

          public final StringProperty nameProperty(){
             return name;
          }


          private StringProperty surname = new SimpleStringProperty(this, "surname");
         public final String getSurname(){
             return surname.get();
         }
          public final void setSurname(final String value){
                   surname.set(value);
          }

          public final StringProperty surnameProperty(){
             return surname;
          }




         private StringProperty age = new SimpleStringProperty(this, "age");
         public final String getAge(){
             return age.get();
         }
          public final void setAge(final String value){
                       age.set(value);
          }

          public final StringProperty ageProperty(){
             return age;
          }
}
