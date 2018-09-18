package jpa.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.model.Orderdetail;
import jpa.model.Productline;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T12:27:25")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> productscale;
    public static volatile SingularAttribute<Product, Productline> productline;
    public static volatile SingularAttribute<Product, String> productcode;
    public static volatile SingularAttribute<Product, String> productvendor;
    public static volatile SingularAttribute<Product, String> productdescription;
    public static volatile SingularAttribute<Product, BigDecimal> buyprice;
    public static volatile SingularAttribute<Product, Short> quantityinstock;
    public static volatile SingularAttribute<Product, BigDecimal> msrp;
    public static volatile ListAttribute<Product, Orderdetail> orderdetailList;
    public static volatile SingularAttribute<Product, String> productname;

}