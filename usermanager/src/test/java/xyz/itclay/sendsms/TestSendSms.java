package xyz.itclay.sendsms;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.junit.Test;
import xyz.itclay.usermanager.utils.SendSmsUtils;

public class TestSendSms {
    @Test
    public void test1() throws TencentCloudSDKException {
        SendSmsUtils.sendTheVerificationCode("19993566668","123456");
    }

}
