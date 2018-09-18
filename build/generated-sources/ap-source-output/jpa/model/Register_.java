package jpa.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T12:27:25")
@StaticMetamodel(Register.class)
public class Register_ { 

    public static volatile SingularAttribute<Register, Date> activatedate;
    public static volatile SingularAttribute<Register, String> password;
    public static volatile SingularAttribute<Register, Date> regdate;
    public static volatile SingularAttribute<Register, Date> reqdate;
    public static volatile SingularAttribute<Register, String> email;
    public static volatile SingularAttribute<Register, String> activatekey;

}