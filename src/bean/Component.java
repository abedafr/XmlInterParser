/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

/**
 * All rights reserved 
 * The source code is protected to its owner
 *
 * @author Abed
 */
public class Component {
    
    protected String name;
    protected Container father;

    public Component() {
    }

    public Component(String name, Container father) {
        this.name = name;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Container getFather() {
        return father;
    }

    public void setFather(Container father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "Component{" + "name=" + name + ", father=" + father + '}';
    }
    
        
    

}
