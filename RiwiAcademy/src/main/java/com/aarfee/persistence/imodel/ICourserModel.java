package com.aarfee.persistence.imodel;

import com.aarfee.entities.CourseEntity;
import com.aarfee.persistence.crud.*;

public interface ICourserModel
        extends CreateModel<CourseEntity>,
        DeleteModel<Boolean>,
        ReadAllModel<CourseEntity>,
        ReadModel<CourseEntity>,
        UpdateModel<CourseEntity> {
}
