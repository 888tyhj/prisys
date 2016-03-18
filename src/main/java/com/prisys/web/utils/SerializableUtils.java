package com.prisys.web.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具
 * @author yangl
 * @version 2015年12月18日
 * @see SerializableUtils
 * @since 1.0
 */
public class SerializableUtils {

	/**
	 * 序列化
	 * @author yangl
	 * @version 2015年12月18日
	 * @param session
	 * @return
	 * @see 1.0
	 */
    public static String serialize(Session session) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(session);
            return Base64.encodeToString(bos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("serialize session error", e);
        }
    }
    /**
     * 反序列化
     * @author yangl
     * @version 2015年12月18日
     * @param sessionStr
     * @return
     * @see 1.0
     */
    public static Session deserialize(String sessionStr) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(sessionStr));
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Session)ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("deserialize session error", e);
        }
    }
}
