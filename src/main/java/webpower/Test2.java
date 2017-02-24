package webpower;

import com.webpower.ArrayOfIntType;
import com.webpower.WebpowerLoginType;
import com.webpower.WebpowerSoapAPI;
import com.webpower.WebpowerSoapAPIPort;

/**
 * Test2
 *
 * @author liuruichao
 *         Created on 2016-05-10 16:50
 */
public class Test2 {
    public static void main(String[] args) {
        String username = "liuruichao";
        String password = "Liuruichao1027_";
        int campaignID = 7;           //campaign id
        int mailingID = 47;             //which mail you'll send
        int recipientID = 2;       //recipient id, return from addrecipient

        //login
        WebpowerLoginType login = new WebpowerLoginType();
        login.setUsername(username);
        login.setPassword(password);

        //group
        ArrayOfIntType groupIDs = new ArrayOfIntType();
        groupIDs.getInt().add(81);              // which group you will send

        WebpowerSoapAPI API = new WebpowerSoapAPI();
        WebpowerSoapAPIPort service = API.getWebpowerSoapAPIPort();


        boolean result = service.sendSingleMailing(
                login,              //login
                campaignID,         //campain
                mailingID,          //which mailing to send
                recipientID         //which email do you want to send to
        );


        if (result) {
            System.out.println("send successfully");
        } else {
            System.out.println("Error:" + result);
        }
    }
}
