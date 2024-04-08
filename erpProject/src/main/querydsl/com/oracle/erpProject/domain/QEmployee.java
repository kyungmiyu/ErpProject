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

    public final NumberPath<Integer> deptNo = createNumber("deptNo", Integer.class);

    public final StringPath empAddress = createString("empAddress");

    public final DatePath<java.sql.Date> empBirth = createDate("empBirth", java.sql.Date.class);

    public final StringPath empEmail = createString("empEmail");

    public final StringPath empEnabled = createString("empEnabled");

    public final StringPath empGender = createString("empGender");

    public final DatePath<java.sql.Date> empHireDate = createDate("empHireDate", java.sql.Date.class);

    public final NumberPath<Integer> empJobComm = createNumber("empJobComm", Integer.class);

    public final NumberPath<Integer> empJobName = createNumber("empJobName", Integer.class);

    public final StringPath empName = createString("empName");

    public final NumberPath<Integer> empNo = createNumber("empNo", Integer.class);

    public final StringPath empPassword = createString("empPassword");

    public final StringPath empPhone = createString("empPhone");

    public final StringPath empPostcode = createString("empPostcode");

    public final DatePath<java.sql.Date> empRetiredDate = createDate("empRetiredDate", java.sql.Date.class);

    public final StringPath empRole = createString("empRole");

    public final StringPath empStatus = createString("empStatus");

    public final DateTimePath<java.sql.Timestamp> empWdate = createDateTime("empWdate", java.sql.Timestamp.class);

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

