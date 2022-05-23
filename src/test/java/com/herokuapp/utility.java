package com.herokuapp;

public class utility {
    
    public static String createPayload(String firstname, String lastname,
    int totalprice, Boolean depositpaid, String checkin, String checkout,
    String additionalneed) {
        
        return  String.format("""
                {
                    \"firstname\" : \"%s\",
                    \"lastname\" : \"%s\",
                    \"totalprice\" : %d,
                    \"depositpaid\" : %b,
                    \"bookingdates\" : {
                        \"checkin\" : \"%s\",
                        \"checkout\" : \"%s\"
                    },
                    \"additionalneeds\" : \"%s\"
                }
            """, firstname,lastname,totalprice,depositpaid,checkin,checkout,
                additionalneed);

    }

    public static void assertResponse(String response) {
        // TO DO         
    }
}
