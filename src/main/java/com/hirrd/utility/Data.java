package com.hirrd.utility;

public class Data {

    public static String getMessageBody(String OTP, String name) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>OTP Verification Success</title>\n" +
                "  <style>\n" +
                "    body {\n" +
                "      font-family: Arial, sans-serif;\n" +
                "      background-color: #f4f4f4;\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "    }\n" +
                "    .email-container {\n" +
                "      max-width: 600px;\n" +
                "      margin: 20px auto;\n" +
                "      background-color: #ffffff;\n" +
                "      padding: 20px;\n" +
                "      border-radius: 10px;\n" +
                "      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\n" +
                "      border-top: 8px solid #28a745;\n" +
                "    }\n" +
                "    .header {\n" +
                "      text-align: center;\n" +
                "      padding: 20px;\n" +
                "      background-color: #28a745;\n" +
                "      color: #ffffff;\n" +
                "      border-radius: 10px 10px 0 0;\n" +
                "    }\n" +
                "    .header h1 {\n" +
                "      font-size: 24px;\n" +
                "      margin: 0;\n" +
                "    }\n" +
                "    .otp {\n" +
                "      font-size: 24px;\n" +
                "      font-weight: bold;\n" +
                "      color: #28a745;\n" +
                "      text-align: center;\n" +
                "      margin: 20px 0;\n" +
                "    }\n" +
                "    .name {\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "    .content {\n" +
                "      font-size: 16px;\n" +
                "      color: #333333;\n" +
                "      line-height: 1.6;\n" +
                "    }\n" +
                "    .footer {\n" +
                "      margin-top: 20px;\n" +
                "      text-align: center;\n" +
                "      font-size: 12px;\n" +
                "      color: #888888;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"email-container\">\n" +
                "    <div class=\"header\">\n" +
                "      <h1>Your OTP Code</h1>\n" +
                "    </div>\n" +
                "    <div class=\"content\">\n" +
                "      <p class=\"name\">Hello " + name +"</p>\n" +
                "      <p>We Have received a request to verify your email address. Your OTP code is:</p>\n" +
                "      <div class=\"otp\">" + OTP + "</div>\n" +
                "      <p>This OTP code is valid for 10 minutes. Please do not share it with anyone.</p>\n" +
                "      <p>Thank you for using our service!</p>\n" +
                "    </div>\n" +
                "    <div class=\"footer\">\n" +
//                "      <p>If you have any questions, contact us at support@example.com.</p>\n" +
                "      <p>© 2025 Hirrd. All rights reserved.</p>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
