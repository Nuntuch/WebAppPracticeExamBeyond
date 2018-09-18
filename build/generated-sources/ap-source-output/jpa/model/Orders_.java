package jpa.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.model.Customer;
import jpa.model.Orderdetail;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T12:27:25")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Customer> customernumber;
    public static volatile SingularAttribute<Orders, String> comments;
    public static volatile ListAttribute<Orders, Orderdetail> orderdetailList;
    public static volatile SingularAttribute<Orders, Integer> ordernumber;
    public static volatile SingularAttribute<Orders, Date> shippeddate;
    public static volatile SingularAttribute<Orders, Date> orderdate;
    public static volatile SingularAttribute<Orders, Date> requireddate;
    public static volatile SingularAttribute<Orders, String> status;

}