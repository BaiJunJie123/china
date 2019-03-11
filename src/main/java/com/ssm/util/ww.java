package com.ssm.util;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import com.aliyun.oss.common.utils.HttpUtil;

public class ww {
 
	   
	public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
		String buff = "";
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(paraMap.entrySet());
			// 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
			Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
				@Override
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});
			// 构造URL 键值对的格式
			StringBuilder buf = new StringBuilder();
			for (Map.Entry<String, String> item : infoIds) {
				if (StringUtils.isNotBlank(item.getKey())) {
					String key = item.getKey();
					String val = item.getValue();
					if (urlEncode) {
						val = URLEncoder.encode(val, "utf-8");
					}
					if (keyToLower) {
						buf.append(key.toLowerCase() + "=" + val);
					} else {
						buf.append(key + "=" + val);
					}
					buf.append("&");
				}
 
			}
			buff = buf.toString();
			if (buff.isEmpty() == false) {
				buff = buff.substring(0, buff.length() - 1);
			}
		} catch (Exception e) {
			return null;
		}
		return buff;
	}
}
