package com.inspur.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 用户权限服务接口
 * @author 迟钰沛
 * @date 2014-9-10
 * @version 1.0
 * @description 用户权限服务管理
 * @data:
 * 	{code:"响应码(成功:200,失败:300)",rows:[
 * 						{
 * 							code:"AA"
 * 							item:[
 * 								{id:"",name:""},
 * 								{id:"",name:""}]
 * 						},
 *							{
 * 							code:"BB"
 * 							item:[
 * 								{id:"",name:""},
 * 								{id:"",name:""}]
 * 						}
 * 				],error:"错误信息，成功时候可省略!"}
 */
public interface UserAuthorityService {

	/**
	 * 用户登录
	 * @param account 登录账号
	 * @param password 登录密码（md5加密）
	 * @param appCode 应用编码
	 * @param flag 是否获取菜单
	 * @return
	 * @throws Exception 
	 */
	public JSONObject userLogin(String account, String password, String appCode, boolean flag);

	/**
	 * 用户退出
	 * @param userId
	 * @return
	 */
	public JSONObject userLogout(String userId);

}

