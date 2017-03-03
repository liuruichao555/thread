package webpower;


import com.webpower.AddRecipientsResultType;
import com.webpower.ArrayOfIntType;
import com.webpower.NewRecipientArrayType;
import com.webpower.NewRecipientType;
import com.webpower.RecipientNameValuePairType;
import com.webpower.WebpowerLoginType;
import com.webpower.WebpowerSoapAPI;
import com.webpower.WebpowerSoapAPIPort;

/**
 * Test1
 *
 * @author liuruichao
 *         Created on 2016-05-10 15:57
 */
public class Test1 {
    public static void main(String[] args) {
        AddRecipientsResultType result = null;
        String username = "";
        String password = "";
        int campaignID = 5;           //campaign id
        int mailingID = 57;             //which mail you'll send

//login
        WebpowerLoginType login = new WebpowerLoginType();
        login.setUsername(username);
        login.setPassword(password);

//group
        ArrayOfIntType groupIDs = new ArrayOfIntType();
        groupIDs.getInt().add(81);              // which group you will send

        WebpowerSoapAPI API = new WebpowerSoapAPI();
        WebpowerSoapAPIPort service = API.getWebpowerSoapAPIPort();


//recipient 1
        NewRecipientType newrecip1 = new NewRecipientType();
        RecipientNameValuePairType datavalue_1_1 = new RecipientNameValuePairType();
//field1 email
        datavalue_1_1.setName("email");
        datavalue_1_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_1_1);

//field2 name
        RecipientNameValuePairType datavalue_1_2 = new RecipientNameValuePairType();
        datavalue_1_2.setName("name");
        datavalue_1_2.setValue("liuruichao");
        newrecip1.getFields().add(datavalue_1_2);


        RecipientNameValuePairType datavalue_1_3 = new RecipientNameValuePairType();
        datavalue_1_3.setName("email_verify_code");
        datavalue_1_3.setValue("12345");
        newrecip1.getFields().add(datavalue_1_3);


//you can add custom field..
//...

        NewRecipientArrayType recipientDatas = new NewRecipientArrayType();
        recipientDatas.getRecipients().add(newrecip1);

//recipient 2

        /*NewRecipientType newrecip2 = new NewRecipientType();
        RecipientNameValuePairType datavalue_2_1 = new RecipientNameValuePairType();

//field1 email
        datavalue_2_1.setName("email");
        datavalue_2_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_2_1);

//field2 name

        String text2 = "this is the content in fields2";

        RecipientNameValuePairType datavalue_2_2 = new RecipientNameValuePairType();
        datavalue_2_2.setName("fields2");
        datavalue_2_2.setValue(text2);
        newrecip1.getFields().add(datavalue_2_2);*/

//you can add custom field..
//...
        //recipientDatas.getRecipients().add(newrecip2);

        result = service.addRecipientsSendMailing(
                login,              //use
                campaignID,         //campaign
                mailingID,          //which mailings to send
                groupIDs,           //groups
                recipientDatas,     //recipient datas
                true,           //overwrite if email has existed
                true
        );

        System.out.println(result.getStatus());

        if (result.getStatus().equals("OK")) {
            System.out.println("add recepients and send successfully");
        } else if (result.getStatus().equals("DUPLICATE")) {
            System.out.println("overwrite and send successfully");
        } else {
            System.out.println(result.getStatusMsg());
        }

    }

    /**
     * 找回密码
     */
    private static void forgetPwd() {
        AddRecipientsResultType result = null;
        String username = "liuruichao";
        String password = "Liuruichao1027_";
        int campaignID = 5;           //campaign id
        int mailingID = 54;             //which mail you'll send

//login
        WebpowerLoginType login = new WebpowerLoginType();
        login.setUsername(username);
        login.setPassword(password);

//group
        ArrayOfIntType groupIDs = new ArrayOfIntType();
        groupIDs.getInt().add(81);              // which group you will send

        WebpowerSoapAPI API = new WebpowerSoapAPI();
        WebpowerSoapAPIPort service = API.getWebpowerSoapAPIPort();


//recipient 1
        NewRecipientType newrecip1 = new NewRecipientType();
        RecipientNameValuePairType datavalue_1_1 = new RecipientNameValuePairType();
//field1 email
        datavalue_1_1.setName("email");
        datavalue_1_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_1_1);

//field2 name
        RecipientNameValuePairType datavalue_1_2 = new RecipientNameValuePairType();
        datavalue_1_2.setName("name");
        datavalue_1_2.setValue("liuruichao");
        newrecip1.getFields().add(datavalue_1_2);


        RecipientNameValuePairType datavalue_1_3 = new RecipientNameValuePairType();
        datavalue_1_3.setName("reset_password_url");
        datavalue_1_3.setValue("http://www.baidu.com");
        newrecip1.getFields().add(datavalue_1_3);


//you can add custom field..
//...

        NewRecipientArrayType recipientDatas = new NewRecipientArrayType();
        recipientDatas.getRecipients().add(newrecip1);

//recipient 2

        /*NewRecipientType newrecip2 = new NewRecipientType();
        RecipientNameValuePairType datavalue_2_1 = new RecipientNameValuePairType();

//field1 email
        datavalue_2_1.setName("email");
        datavalue_2_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_2_1);

//field2 name

        String text2 = "this is the content in fields2";

        RecipientNameValuePairType datavalue_2_2 = new RecipientNameValuePairType();
        datavalue_2_2.setName("fields2");
        datavalue_2_2.setValue(text2);
        newrecip1.getFields().add(datavalue_2_2);*/

//you can add custom field..
//...
        //recipientDatas.getRecipients().add(newrecip2);

        result = service.addRecipientsSendMailing(
                login,              //use
                campaignID,         //campaign
                mailingID,          //which mailings to send
                groupIDs,           //groups
                recipientDatas,     //recipient datas
                true,           //overwrite if email has existed
                true
        );

        System.out.println(result.getStatus());

        if (result.getStatus().equals("OK")) {
            System.out.println("add recepients and send successfully");
        } else if (result.getStatus().equals("DUPLICATE")) {
            System.out.println("overwrite and send successfully");
        } else {
            System.out.println(result.getStatusMsg());
        }
    }

    private static void emailVerifyCode() {
        AddRecipientsResultType result = null;
        String username = "liuruichao";
        String password = "Liuruichao1027_";
        int campaignID = 5;           //campaign id
        int mailingID = 57;             //which mail you'll send

//login
        WebpowerLoginType login = new WebpowerLoginType();
        login.setUsername(username);
        login.setPassword(password);

//group
        ArrayOfIntType groupIDs = new ArrayOfIntType();
        groupIDs.getInt().add(81);              // which group you will send

        WebpowerSoapAPI API = new WebpowerSoapAPI();
        WebpowerSoapAPIPort service = API.getWebpowerSoapAPIPort();


//recipient 1
        NewRecipientType newrecip1 = new NewRecipientType();
        RecipientNameValuePairType datavalue_1_1 = new RecipientNameValuePairType();
//field1 email
        datavalue_1_1.setName("email");
        datavalue_1_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_1_1);

//field2 name
        RecipientNameValuePairType datavalue_1_2 = new RecipientNameValuePairType();
        datavalue_1_2.setName("name");
        datavalue_1_2.setValue("liuruichao");
        newrecip1.getFields().add(datavalue_1_2);


        RecipientNameValuePairType datavalue_1_3 = new RecipientNameValuePairType();
        datavalue_1_3.setName("email_verify_code");
        datavalue_1_3.setValue("12345");
        newrecip1.getFields().add(datavalue_1_3);


//you can add custom field..
//...

        NewRecipientArrayType recipientDatas = new NewRecipientArrayType();
        recipientDatas.getRecipients().add(newrecip1);

//recipient 2

        /*NewRecipientType newrecip2 = new NewRecipientType();
        RecipientNameValuePairType datavalue_2_1 = new RecipientNameValuePairType();

//field1 email
        datavalue_2_1.setName("email");
        datavalue_2_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_2_1);

//field2 name

        String text2 = "this is the content in fields2";

        RecipientNameValuePairType datavalue_2_2 = new RecipientNameValuePairType();
        datavalue_2_2.setName("fields2");
        datavalue_2_2.setValue(text2);
        newrecip1.getFields().add(datavalue_2_2);*/

//you can add custom field..
//...
        //recipientDatas.getRecipients().add(newrecip2);

        result = service.addRecipientsSendMailing(
                login,              //use
                campaignID,         //campaign
                mailingID,          //which mailings to send
                groupIDs,           //groups
                recipientDatas,     //recipient datas
                true,           //overwrite if email has existed
                true
        );

        System.out.println(result.getStatus());

        if (result.getStatus().equals("OK")) {
            System.out.println("add recepients and send successfully");
        } else if (result.getStatus().equals("DUPLICATE")) {
            System.out.println("overwrite and send successfully");
        } else {
            System.out.println(result.getStatusMsg());
        }
    }

    /**
     * 欢迎邮件
     */
    private static void welcome() {
        AddRecipientsResultType result = null;
        String username = "liuruichao";
        String password = "Liuruichao1027_";
        int campaignID = 5;           //campaign id
        int mailingID = 55;             //which mail you'll send

//login
        WebpowerLoginType login = new WebpowerLoginType();
        login.setUsername(username);
        login.setPassword(password);

//group
        ArrayOfIntType groupIDs = new ArrayOfIntType();
        groupIDs.getInt().add(81);              // which group you will send

        WebpowerSoapAPI API = new WebpowerSoapAPI();
        WebpowerSoapAPIPort service = API.getWebpowerSoapAPIPort();


//recipient 1
        NewRecipientType newrecip1 = new NewRecipientType();
        RecipientNameValuePairType datavalue_1_1 = new RecipientNameValuePairType();
//field1 email
        datavalue_1_1.setName("email");
        datavalue_1_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_1_1);

//field2 name
        RecipientNameValuePairType datavalue_1_2 = new RecipientNameValuePairType();
        datavalue_1_2.setName("name");
        datavalue_1_2.setValue("liuruichao");
        newrecip1.getFields().add(datavalue_1_2);


        //RecipientNameValuePairType datavalue_1_3 = new RecipientNameValuePairType();
        //datavalue_1_3.setName("reset_password_url");
        //datavalue_1_3.setValue("http://www.baidu.com");
        //newrecip1.getFields().add(datavalue_1_3);


//you can add custom field..
//...

        NewRecipientArrayType recipientDatas = new NewRecipientArrayType();
        recipientDatas.getRecipients().add(newrecip1);

//recipient 2

        /*NewRecipientType newrecip2 = new NewRecipientType();
        RecipientNameValuePairType datavalue_2_1 = new RecipientNameValuePairType();

//field1 email
        datavalue_2_1.setName("email");
        datavalue_2_1.setValue("liuruichao555@126.com");
        newrecip1.getFields().add(datavalue_2_1);

//field2 name

        String text2 = "this is the content in fields2";

        RecipientNameValuePairType datavalue_2_2 = new RecipientNameValuePairType();
        datavalue_2_2.setName("fields2");
        datavalue_2_2.setValue(text2);
        newrecip1.getFields().add(datavalue_2_2);*/

//you can add custom field..
//...
        //recipientDatas.getRecipients().add(newrecip2);

        result = service.addRecipientsSendMailing(
                login,              //use
                campaignID,         //campaign
                mailingID,          //which mailings to send
                groupIDs,           //groups
                recipientDatas,     //recipient datas
                true,           //overwrite if email has existed
                true
        );

        System.out.println(result.getStatus());

        if (result.getStatus().equals("OK")) {
            System.out.println("add recepients and send successfully");
        } else if (result.getStatus().equals("DUPLICATE")) {
            System.out.println("overwrite and send successfully");
        } else {
            System.out.println(result.getStatusMsg());
        }
    }
}
