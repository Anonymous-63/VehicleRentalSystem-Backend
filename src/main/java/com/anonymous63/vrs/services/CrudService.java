package com.anonymous63.vrs.services;

import java.util.List;

public interface CrudService<REQ, RES, ID> {
    RES create(REQ request);

    RES getById(ID id);

    List<RES> getAll();

    RES update(ID id, REQ request);

    void delete(ID id);

    void multiDelete(List<ID> ids);
}
