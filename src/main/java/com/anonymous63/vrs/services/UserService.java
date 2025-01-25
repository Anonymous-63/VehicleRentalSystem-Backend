package com.anonymous63.vrs.services;

import com.anonymous63.vrs.models.dtos.reqDtos.UserReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.UserResDto;
import com.anonymous63.vrs.payloads.requests.AuthRequest;
import com.anonymous63.vrs.payloads.responses.AuthResponse;


public interface UserService extends CrudService<UserReqDto, UserResDto, Long>{
}
