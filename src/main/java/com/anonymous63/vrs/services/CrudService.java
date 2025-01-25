package com.anonymous63.vrs.services;

import java.util.List;

public interface CrudService<REQ, RES, ID> {
    RES create(REQ request);

    RES update(ID id, REQ request);

    RES getById(ID id);

    List<RES> getAll();

    void delete(ID id);

    void multiDelete(List<ID> ids);
}
