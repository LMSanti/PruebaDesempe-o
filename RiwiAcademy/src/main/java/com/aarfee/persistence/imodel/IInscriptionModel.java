package com.aarfee.persistence.imodel;

import com.aarfee.entities.InscriptionEntity;
import com.aarfee.persistence.crud.*;

public interface IInscriptionModel
        extends CreateModel<InscriptionEntity>,
        DeleteModel<Boolean>,
        ReadAllModel<InscriptionEntity>,
        ReadModel<InscriptionEntity>,
        UpdateModel<InscriptionEntity> {
}
