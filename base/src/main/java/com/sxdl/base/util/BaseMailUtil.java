package com.sxdl.base.util;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

/**
 * 邮件工具类,继承与hutool-MailUtil,经过简单加工
 * @see cn.hutool.extra.mail.MailUtil
 */
public class BaseMailUtil extends MailUtil {
    public static MailAccount account = new MailAccount();

    static {
        account.setHost("smtp.163.com");
        account.setPort(25);
        account.setFrom("山西雕龙<sxdlylsjyxgs@163.com>");
        account.setPass("NRACZLZGUUTKSDQG"); //密码
    }

    /**
     * 发送邮件给多人
     *
     * @param tos     收件人列表
     * @param subject 标题
     * @param content 正文
     * @return String message-id
     */
    public static String sendEmail(Collection<String> tos, String subject, String content) {
        return send(account, tos, subject, content, null, false, new File[0]);
    }

    /**
     * 发送邮件给多人
     *
     * @param tos      收件人列表
     * @param subject  标题
     * @param content  正文
     * @param imageMap 图片与占位符，占位符格式为cid:$IMAGE_PLACEHOLDER
     * @param isHtml   是否为HTML格式
     * @param files    附件列表
     * @return message-id
     */
    public static String sendEmail(Collection<String> tos, String subject, Map<String, InputStream> imageMap, String content, boolean isHtml, File... files) {
        return send(account, tos, subject, content, imageMap, isHtml, files);
    }

    /**
     * 发送邮件给多人
     *
     * @param to       收件人
     * @param subject  标题
     * @param content  正文
     * @param imageMap 图片与占位符，占位符格式为cid:$IMAGE_PLACEHOLDER
     * @param isHtml   是否为HTML格式
     * @param files    附件列表
     * @return message-id
     */
    public static String sendEmail(String to, String subject, Map<String, InputStream> imageMap, String content, boolean isHtml, File... files) {
        return send(account, to, subject, content, imageMap, isHtml, files);
    }
}
