package jpa.model;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.model.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T12:27:25")
@StaticMetamodel(Productline.class)
public class Productline_ { 

    public static volatile SingularAttribute<Productline, String> productline;
    public static volatile SingularAttribute<Productline, Serializable> image;
    public static volatile SingularAttribute<Productline, String> htmldescription;
    public static volatile SingularAttribute<Productline, String> textdescription;
    public static volatile ListAttribute<Productline, Product> productList;

}