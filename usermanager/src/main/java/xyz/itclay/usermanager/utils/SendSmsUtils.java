package xyz.itclay.usermanager.utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.*;;

/**
 * 随机验证码
 *
 * @author ZhangSenmiao
 * @date 2021/2/8 13:09
 **/
public class SendSmsUtils {
    private SendSmsUtils() {
    }

    public static void sendTheVerificationCode(String telephone, String code) throws TencentCloudSDKException {

        Credential cred = new Credential("AKIDRcW5PhkfIKAi01PfDVosd8LVP1f2nI2V", "85nEcjbEagV5NfhUeaGfqmjQovkIZcN1");

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("sms.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        SmsClient client = new SmsClient(cred, "", clientProfile);

        SendSmsRequest req = new SendSmsRequest();
        String[] phoneNumberSet1 = {"+86" + telephone};
        req.setPhoneNumberSet(phoneNumberSet1);


        String[] templateParamSet1 = {code, "10"};
        req.setTemplateParamSet(templateParamSet1);

        req.setTemplateID("837777");
        req.setSmsSdkAppid("1400471985");
        req.setSign("itcaly");

        SendSmsResponse resp = client.SendSms(req);

        System.out.println(SendSmsResponse.toJsonString(resp));

    }

}
