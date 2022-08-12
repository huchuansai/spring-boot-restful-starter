package com.hucs.top.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: huchuansai
 * @Date: 2021/5/6 1:24 下午
 */
@Slf4j
public class StringUtil {
    /**
     * \\s 空格、\t 水平制表符、\s 空格\\n 回车
     */
    private static final Pattern BLANK_TAG = Pattern.compile("\\s*|\t|\r|\n");

    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 去除字符串空格
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Matcher m = BLANK_TAG.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 去除字符串中的空格
     *
     * @param origin 源字符串
     * @return
     */
    public static String replaceSpace(String origin) {
        if (origin != null) {
            return origin.replace(" ", "");
        }
        return null;
    }

    public static String trim(String str) {
        if (str != null) {
            return str.trim();
        } else {
            return null;
        }
    }

    /**
     * 手机号脱敏
     *
     * @param phone
     * @return
     */
    public static String desensitizePhone(String phone) {
        String re = phone;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(phone)) {
            if (phone.length() > 7) {
                int starsLength = phone.length() - 7;
                int i = 0;
                StringBuffer stars = new StringBuffer();
                while (i < starsLength) {
                    stars.append("*");
                    i++;
                }
                StringBuffer newPhone = new StringBuffer(phone);
                re = newPhone.replace(3, phone.length() - 4, stars.toString()).toString();
            }
        }
        return re;
    }

    /**
     * 证件号脱敏
     *
     * @param identityId
     * @return
     */
    public static String desensitizeIdentityId(String identityId) {
        String re = identityId;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(identityId)) {
            if (identityId.length() > 6) {
                int starsLength = identityId.length() - 6;
                int i = 0;
                StringBuffer stars = new StringBuffer();
                while (i < starsLength) {
                    stars.append("*");
                    i++;
                }
                StringBuffer newPhone = new StringBuffer(identityId);
                re = newPhone.replace(3, identityId.length() - 3, stars.toString()).toString();
            }
        }

        if (org.apache.commons.lang3.StringUtils.isBlank(re)) {
            return "无";
        }

        return re;
    }

    /**
     * 祛除sql中like的特殊字符
     *
     * @param param
     * @return
     */
    public static String SqlLikeReplace(String param) {
        return replaceBlank(param)
                .replace("_", "\\_")
                .replace("%", "\\%");
    }

    public static String replaceEsWildcard(String originStr) {
        return originStr.replace("*", "\\*")
                .replace("?", "\\?");
    }

    public static String getLikeSqlString(String param) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(param)) return "";
        return "%" + SqlLikeReplace(param) + "%";
    }

    public static String getEsWildcardString(String originStr) {
        return "*" + replaceEsWildcard(originStr) + "*";
    }

    /**
     * 获取租客姓名
     *
     * @param userName 租客姓名
     * @return userName 为空则返回"未实名"，否则返回 userName
     */
    public static String getUserName(String userName) {
        if (org.apache.commons.lang3.StringUtils.isBlank(userName)) {
            return "未实名";
        }
        return userName;
    }

    public static String formatPriceToString(int finalLength, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int need = finalLength - str.length();
        if (need > 0) {
            for (int i = 0; i < need; i++) {
                stringBuffer.append("0");
            }
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    public static String getTextContentFromRich(String richText) {
        if (isEmpty(richText)) return "";

        String regx = "(<.+?>)|(</.+?>)";
        Matcher matcher = Pattern.compile(regx).matcher(richText);
        while (matcher.find()) {
            // 替换图片
            richText = matcher.replaceAll("").replace(" ", "");
        }
        // 替换 &nbsp和制表符;
        return richText.replaceAll("&nbsp;", "").replaceAll("\\\\t", "");
    }

    public static boolean isJson(String content) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(content)) {
            return false;
        }
        boolean isJsonObject = true;
        boolean isJsonArray = true;
        try {
            JSONObject.parseObject(content);
        } catch (Exception e) {
            isJsonObject = false;
        }
        try {
            JSONObject.parseArray(content);
        } catch (Exception e) {
            isJsonArray = false;
        }
        //不是json格式
        return isJsonObject || isJsonArray;
    }

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, Object> xmlToMap(String strXML) {
        Map<String, Object> data = new HashMap<>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes(StandardCharsets.UTF_8));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            stream.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }
}
