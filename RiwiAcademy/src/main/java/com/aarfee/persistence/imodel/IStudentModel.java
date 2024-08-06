package com.aarfee.persistence.imodel;

import com.aarfee.entities.StudentEntity;
import com.aarfee.persistence.crud.*;

public interface IStudentModel
        extends CreateModel<StudentEntity>,
        ReadAllModel<StudentEntity>,
        ReadModel<StudentEntity>,
        ReadEmailModel<StudentEntity>,
        UpdateModel<StudentEntity> {
}
