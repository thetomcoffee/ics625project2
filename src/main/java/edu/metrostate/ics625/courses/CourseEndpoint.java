

package edu.metrostate.ics625.courses;

import edu.metrostate.ics625.courses.generated.ActionStatusType;
import edu.metrostate.ics625.courses.generated.AddCourseRequest;
import edu.metrostate.ics625.courses.generated.AddCourseResponse;
import edu.metrostate.ics625.courses.generated.GetCourseRequest;
import edu.metrostate.ics625.courses.generated.GetCourseResponse;
import edu.metrostate.ics625.courses.generated.CourseType;

import edu.metrostate.ics625.courses.entity.Course;
import edu.metrostate.ics625.courses.entity.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author Tom Coffee
 */
@Endpoint
public class CourseEndpoint {
    
    public static final String NS = "http://metrostate.edu/ics625";
    
    @Autowired
    private CourseService service;
    
    
    @PayloadRoot(namespace=NS, localPart="addCourseRequest")
    @ResponsePayload
    public AddCourseResponse addStudent(@RequestPayload AddCourseRequest req){
        String number = req.getNumber();
        String title = req.getTitle();
        boolean offered = req.isOffered();
        service.add(number, title, offered);
        AddCourseResponse res = new AddCourseResponse();
        res.setValue(ActionStatusType.SUCCESS);
        System.out.println("Added");
        return res;
    }
    

    
    @PayloadRoot(namespace=NS, localPart="getCourseRequest")
    @ResponsePayload
    public GetCourseResponse getCourses(@RequestPayload GetCourseRequest rep){
        List<Course> courses = service.getAll();
        System.out.println("course count = " + courses.size());
        GetCourseResponse res = new GetCourseResponse();
        List<CourseType> list = res.getCourse();
        courses.forEach(c->{
            CourseType ct = new CourseType();
            ct.setId(c.getId());
            ct.setNumber(c.getNumber());
            ct.setTitle(c.getTitle());
            ct.setOffered(c.getOffered());
            list.add(ct);
        });
      
        return res;
    }

}
