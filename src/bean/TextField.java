/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * All rights reserved The source code is protected to its owner
 *
 * @author Abed
 */
public class TextField extends Component {

    public TextField() {
    }

    public TextField(String name, Container father) {
        super(name, father);
    }

    @Override
    public String toString() {
        return "TextField{" + '}';
    }

}
