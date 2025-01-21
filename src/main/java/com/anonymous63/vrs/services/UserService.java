package com.anonymous63.vrs.services;

import com.anonymous63.vrs.models.dtos.requestDtos.UserReqDto;
import com.anonymous63.vrs.models.dtos.responseDtos.UserResDto;

public interface UserService extends CrudService<UserReqDto, UserResDto, Long>{
}
