package com.oracle.erpProject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKmEmployee is a Querydsl query type for KmEmployee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKmEmployee extends EntityPathBase<KmEmployee> {

    private static final long serialVersionUID = -1295888763L;

    public static final QKmEmployee kmEmployee = new QKmEmployee("kmEmployee");

    public final NumberPath<Integer> dept_no = createNumber("dept_no", Integer.class);

    public final StringPath emp_address = createString("emp_address");

    public final DatePath<java.util.Date> emp_birth = createDate("emp_birth", java.util.Date.class);

    public final StringPath emp_email = createString("emp_email");

    public final StringPath emp_enabled = createString("emp_enabled");

    public final StringPath emp_gender = createString("emp_gender");

    public final DatePath<java.util.Date> emp_hiredate = createDate("emp_hiredate", java.util.Date.class);

    public final NumberPath<Integer> emp_job_comm = createNumber("emp_job_comm", Integer.class);

    public final NumberPath<Integer> emp_job_name = createNumber("emp_job_name", Integer.class);

    public final StringPath emp_name = createString("emp_name");

    public final NumberPath<Integer> emp_no = createNumber("emp_no", Integer.class);

    public final StringPath emp_password = createString("emp_password");

    public final StringPath emp_phone = createString("emp_phone");

    public final StringPath emp_postcode = createString("emp_postcode");

    public final DatePath<java.util.Date> emp_retired_date = createDate("emp_retired_date", java.util.Date.class);

    public final StringPath emp_role = createString("emp_role");

    public final StringPath emp_status = createString("emp_status");

    public final DateTimePath<java.util.Date> emp_wdate = createDateTime("emp_wdate", java.util.Date.class);

    public QKmEmployee(String variable) {
        super(KmEmployee.class, forVariable(variable));
    }

    public QKmEmployee(Path<? extends KmEmployee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKmEmployee(PathMetadata metadata) {
        super(KmEmployee.class, metadata);
    }

}

