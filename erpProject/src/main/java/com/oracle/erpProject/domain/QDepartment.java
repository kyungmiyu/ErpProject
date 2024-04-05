package com.oracle.erpProject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartment extends EntityPathBase<Department> {

    private static final long serialVersionUID = 1585298343L;

    public static final QDepartment department = new QDepartment("department");

    public final StringPath dept_enabled = createString("dept_enabled");

    public final StringPath dept_name = createString("dept_name");

    public final NumberPath<Integer> dept_no = createNumber("dept_no", Integer.class);

    public final StringPath dept_phone = createString("dept_phone");

    public QDepartment(String variable) {
        super(Department.class, forVariable(variable));
    }

    public QDepartment(Path<? extends Department> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartment(PathMetadata metadata) {
        super(Department.class, metadata);
    }

}

