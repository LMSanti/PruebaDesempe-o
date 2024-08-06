package com.aarfee.persistence.imodel;

import com.aarfee.entities.RatingEntity;
import com.aarfee.persistence.crud.*;

public interface IRatingModel
        extends CreateModel<RatingEntity>,
        ReadAllModel<RatingEntity>,
        ReadModel<RatingEntity>,
        UpdateModel<RatingEntity> {
}
