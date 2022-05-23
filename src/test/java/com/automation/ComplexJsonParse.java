package com.automation;
import com.files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    
    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.CoursePrice());        
    
        int count = js.getInt("courses.size()");
        System.out.println(count);
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        String title = js.get("courses[0].title");
        System.out.println(title);
        
        for(int i=0;i<count;i++)
        {
            String courseTitles=js.get("courses["+i+"].title");
            System.out.println(js.get("courses["+i+"].price").toString());
            
            System.out.println(courseTitles);
            
        }
        //Print no of copies sold by RPA Course
         
       System.out.println("Print no of copies sold by RPA Course");
       
       for(int i=0;i<count;i++)
       {
            String courseTitles=js.get("courses["+i+"].title");
            if(courseTitles.equalsIgnoreCase("RPA"))
            {
                int copies=js.get("courses["+i+"].copies");
                System.out.println(copies);
                break;
            }
          
            
       }
    }

}
