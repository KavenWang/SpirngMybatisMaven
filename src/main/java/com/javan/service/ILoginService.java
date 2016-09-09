package com.javan.service;

import com.javan.entity.UserBean;

public interface ILoginService {
	public UserBean Login(String username,String password);
}
