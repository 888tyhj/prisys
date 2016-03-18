/*
 * 文件名：MySessionDao.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.shiro.session.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import com.prisys.web.entity.Sessions;
import com.prisys.web.service.SessionsService;
import com.prisys.web.utils.SerializableUtils;

@SuppressWarnings("all")
public class MySessionDao extends CachingSessionDAO {
	
	@Resource
	private SessionsService sessionsService;
	
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        Sessions sessions=new Sessions(sessionId.toString(), SerializableUtils.serialize(session));
        sessionsService.insert(sessions);
		return session.getId();
	}

	@Override
	protected void doUpdate(Session session) {
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
        Sessions sessions=new Sessions(session.getId().toString(), SerializableUtils.serialize(session));
        sessionsService.updateByPrimaryKey(sessions);
	}

	@Override
	protected void doDelete(Session session) {
        sessionsService.deleteByPrimaryKey(session.getId().toString());
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
        Sessions sessions=sessionsService.selectByPrimaryKey(sessionId.toString());
        if(sessions == null){
        	return null;
        }else{
        	return SerializableUtils.deserialize(sessions.getSession());
        }
	}

}
