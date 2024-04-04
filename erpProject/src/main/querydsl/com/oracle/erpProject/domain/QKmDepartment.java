package com.oracle.erpProject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKmDepartment is a Querydsl query type for KmDepartment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKmDepartment extends EntityPathBase<KmDepartment> {

    private static final long serialVersionUID = 871567721L;

    public static final QKmDepartment kmDepartment = new QKmDepartment("kmDepartment");

    public final StringPath dept_enabled = createString("dept_enabled");

    public final StringPath dept_name = createString("dept_name");

    public final NumberPath<Integer> dept_no = createNumber("dept_no", Integer.class);

    public final StringPath dept_phone = createString("dept_phone");

    public QKmDepartment(String variable) {
        super(KmDepartment.class, forVariable(variable));
    }

    public QKmDepartment(Path<? extends KmDepartment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKmDepartment(PathMetadata metadata) {
        super(KmDepartment.class, metadata);
    }

}

