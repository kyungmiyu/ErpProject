package com.oracle.erpProject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = -271683517L;

    public static final QEmployee employee = new QEmployee("employee");

    public final NumberPath<Integer> dept_no = createNumber("dept_no", Integer.class);

    public final StringPath emp_address = createString("emp_address");

    public final StringPath emp_birth = createString("emp_birth");

    public final StringPath emp_email = createString("emp_email");

    public final StringPath emp_enabled = createString("emp_enabled");

    public final StringPath emp_gender = createString("emp_gender");

    public final StringPath emp_hiredate = createString("emp_hiredate");

    public final NumberPath<Integer> emp_job_comm = createNumber("emp_job_comm", Integer.class);

    public final NumberPath<Integer> emp_job_name = createNumber("emp_job_name", Integer.class);

    public final StringPath emp_name = createString("emp_name");

    public final NumberPath<Integer> emp_no = createNumber("emp_no", Integer.class);

    public final StringPath emp_password = createString("emp_password");

    public final StringPath emp_phone = createString("emp_phone");

    public final StringPath emp_postcode = createString("emp_postcode");

    public final StringPath emp_retired_date = createString("emp_retired_date");

    public final StringPath emp_role = createString("emp_role");

    public final StringPath emp_status = createString("emp_status");

    public final DateTimePath<java.util.Date> emp_wdate = createDateTime("emp_wdate", java.util.Date.class);

    public QEmployee(String variable) {
        super(Employee.class, forVariable(variable));
    }

    public QEmployee(Path<? extends Employee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployee(PathMetadata metadata) {
        super(Employee.class, metadata);
    }

}

